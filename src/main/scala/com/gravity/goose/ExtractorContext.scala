package com.gravity.goose

import java.time.ZonedDateTime

import com.gravity.goose.extractors.{AdditionalDataExtractor, ContentExtractor, DefaultPublishDateExtractor, Extractor, PublishDateExtractor, StandardContentExtractor}
import com.gravity.goose.network.{AbstractHtmlFetcher, HtmlFetcher}
import org.jsoup.nodes.Element

import scala.beans.BeanProperty


case class ExtractorContext( @BeanProperty
                             localStoragePath : String = "/tmp/goose",
                             @BeanProperty
                             minBytesForImages : Int = 4500,
                             @BeanProperty
                             enableImageFetching : Boolean = false,
                             @BeanProperty
                             imagemagickConvertPath : String = "/opt/local/bin/convert",
                             @BeanProperty
                             imagemagickIdentifyPath : String = "/opt/local/bin/identify",
                             @BeanProperty
                             connectionTimeout : Int = 10000,
                             @BeanProperty
                             socketTimeout : Int = 10000,
                             @BeanProperty
                             browserUserAgent : String = "Mozilla/5.0 (X11; U; Linux x86_64; de; rv:1.9.2.8) Gecko/20100723 Ubuntu/10.04 (lucid) Firefox/3.6.8",
                             contentExtractor : ContentExtractor = StandardContentExtractor,
                             publishDateExtractor : Extractor[ ZonedDateTime ] = new DefaultPublishDateExtractor,
                             additionalDataExtractor : AdditionalDataExtractor = new AdditionalDataExtractor,
                             htmlFetcher : AbstractHtmlFetcher = HtmlFetcher ) {


    val publishDateExtractor_ : PublishDateExtractor = new PublishDateExtractor {

        import PublishDateExtractor._

        def extractCandidate( rootElement : Element, selector : String ) : Seq[ java.util.Date ] = {
            import scala.collection.JavaConverters._

            try {
                rootElement.select( selector ).asScala.flatMap( item => safeParseISO8601Date( item.attr( "content" ) ) )
            }
            catch {
                case e : Exception =>
                    Nil
            }
        }

        final val pubSelectors = Seq( "meta[property~=article:published_time]" )
        final val modSelectors = Seq( "meta[property~=article:modified_time]", "meta[property~=og:updated_time]" )

        def extract( rootElement : Element ) : java.util.Date = {
            // A few different ways to get a date.
            def bestPubDate = pubSelectors.flatMap( extractCandidate( rootElement, _ ) ).reduceOption( minDate )

            def bestModDate = modSelectors.flatMap( extractCandidate( rootElement, _ ) ).reduceOption( minDate )

            // Return the oldest 'published' date, or else the oldest 'modified' date, or null if none.
            bestPubDate.orElse( bestModDate ).orNull
        }
    }

}