package com.gravity.goose

import org.junit.Assert._
import org.junit.{Ignore, Test}

/**
  * Created by Jim Plush
  * User: jim
  * Date: 8/14/11
  */

class GooseTest {

    @Test
    @Ignore
    def gooseTest( ) {
        val url = "http://techcrunch.com/2011/08/13/2005-zuckerberg-didnt-want-to-take-over-the-world/"
        val goose = new Goose()
        val article = goose.extractContent( url )

        println( "\nFINAL TALLY" )
        println( "\nTEXT: \n" + article.cleanedArticleText )
        println( "\nIMAGE: " + article.topImage.getImageSrc )

        val url2 = "http://www.readwriteweb.com/archives/hewlett-packard_kills_webos_devices_to_save_webos.php"
        val article2 = goose.extractContent( url2 )

        println( "\nFINAL TALLY" )
        println( "\nTEXT: \n" + article2.cleanedArticleText )
        println( "\nIMAGE: " + article2.topImage.getImageSrc )

    }

    @Test
    def badlink( ) {
        val url = "http://nolove888.com/2011/08/13/LINKNOTEXISTS"
        val goose = new Goose()
        val article = goose.extractContent( url )
        assertNull( article.topNode )
    }


}