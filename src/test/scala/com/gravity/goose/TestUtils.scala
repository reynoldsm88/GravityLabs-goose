package com.gravity.goose

import com.gravity.goose.extractors.AdditionalDataExtractor
import junit.framework.Assert._
import org.jsoup.nodes.Element

/**
  * Created by Jim Plush
  * User: jim
  * Date: 8/19/11
  */

object TestUtils {

    val staticHtmlDir = "/com/gravity/goose/statichtml/"
    private val NL = '\n';
    private val TAB = "\t\t";
    val articleReport = new StringBuilder( "=======================::. ARTICLE REPORT .::======================\n" );

    val DEFAULT_CONFIG : ExtractorContext = ExtractorContext()

    object additionalExt extends AdditionalDataExtractor {
        override def extract( rootElement : Element ) = {
            println()
            println( "ADDITIONAL DATA EXTRACTOR CALLED" )
            println()
            Map( "test" -> "success" )
        }
    }

    val ADDITIONAL_DATA_CONFIG = ExtractorContext().copy( additionalDataExtractor = additionalExt )

    /**
      * returns an article object from a crawl
      */
    def getArticle( url : String, rawHTML : String = null )( implicit context : ExtractorContext ) : Article = {
        val goose = new Goose( context )
        val article = goose.extractContent( url, rawHTML )
        //    goose.shutdownNetwork()
        article
    }

    def runArticleAssertions( article : Article, expectedTitle : String = null, expectedStart : String = null, expectedDescription : String = null,
                              expectedKeywords : String = null ) : Unit = {
        articleReport.append( "URL:      " ).append( TAB ).append( article.finalUrl ).append( NL )
        articleReport.append( "TITLE:    " ).append( TAB ).append( article.title ).append( NL )
        articleReport.append( "CONTENT:  " ).append( TAB ).append( article.cleanedArticleText.replace( "\n", "    " ) ).append( NL )
        articleReport.append( "METAKW:   " ).append( TAB ).append( article.metaKeywords ).append( NL )
        articleReport.append( "METADESC: " ).append( TAB ).append( article.metaDescription ).append( NL )
        articleReport.append( "DOMAIN:   " ).append( TAB ).append( article.domain ).append( NL )
        articleReport.append( "LINKHASH: " ).append( TAB ).append( article.linkhash ).append( NL )
        articleReport.append( "MOVIES:   " ).append( TAB ).append( article.movies ).append( NL )
        articleReport.append( "TAGS:     " ).append( TAB ).append( article.tags ).append( NL )
        articleReport.append( "PUBDATE:  " ).append( TAB ).append( article.publishDate ).append( NL )

        assertNotNull( "Resulting article was NULL!", article )

        if ( expectedTitle != null ) {
            val title : String = article.title
            assertNotNull( "Title was NULL!", title )
            assertEquals( "Expected title was not returned!", expectedTitle, title )
        }
        if ( expectedStart != null ) {
            val articleText : String = article.cleanedArticleText
            assertNotNull( "Resulting article text was NULL!", articleText )
            assertTrue( "Article text was not as long as expected beginning!", expectedStart.length <= articleText.length )
            val actual : String = articleText.substring( 0, expectedStart.length )
            assertEquals( "The beginning of the article text was not as expected!", expectedStart, actual )
        }
        if ( expectedDescription != null ) {
            val description : String = article.metaDescription
            assertNotNull( "Meta Description was NULL!", description )
            assertEquals( "Meta Description was not as expected!", expectedDescription, description )
        }
        if ( expectedKeywords != null ) {
            val keywords : String = article.metaDescription
            assertNotNull( "Meta Keywords was NULL!", keywords )
            assertEquals( "Meta Keywords was not as expected!", expectedKeywords, keywords )
        }
    }

    def printReport( ) {
        println( articleReport )
    }
}