package com.gravity.goose

import org.junit.Assert._
import org.junit.{Ignore, Test}

/**
  * Created by Jim Plush
  * User: jim
  * Date: 8/16/11
  * This class hits live websites and is only run manually, not part of the tests lifecycle
  */

@Ignore
class GoldSitesTestIT {

    implicit val context : ExtractorContext = ExtractorContext()

    @Test
    def testArticleElementedArticle( ) { // to verify issue #56 is resolved
        val url = "http://www.repubblica.it/economia/2012/05/12/news/giovani_anziani_asili_nido_e_soldi_per_il_sud_ecco_il_progetto_del_governo_per_l_equit-34962952/"
        val content = "UN PIANO per l'equità e la crescita destinato in primo luogo al Sud. L'ha varato ieri il Consiglio dei ministri."
        val title = "Giovani, anziani, asili nido e soldi per il Sud ecco il progetto del governo per l'equità "
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article, expectedTitle = title, expectedStart = content )
        TestUtils.printReport()
    }

    @Test
    def techCrunch( ) {
        val url = "http://techcrunch.com/2011/08/13/2005-zuckerberg-didnt-want-to-take-over-the-world/"
        val content = "The Huffington Post has come across this fascinating five-minute interview"
        val image = "http://tctechcrunch2011.files.wordpress.com/2011/08/screen-shot-2011-08-13-at-6-43-20-pm1.png?w=640"
        val title = "2005 Zuckerberg Didn’t Want To Take Over The World"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article, expectedTitle = title, expectedStart = content )
        TestUtils.printReport()
    }


    @Test
    def cnn( ) {
        val url = "http://www.cnn.com/2010/POLITICS/08/13/democrats.social.security/index.html"
        val article = TestUtils.getArticle( url )
        val title = "Democrats to use Social Security against GOP this fall"
        val content = "Washington (CNN) -- Democrats pledged "
        val image = "http://i.cdn.turner.com/cnn/2010/POLITICS/08/13/democrats.social.security/story.kaine.gi.jpg"
        TestUtils.runArticleAssertions( article = article, expectedTitle = title, expectedStart = content )
        TestUtils.printReport()
    }

    @Test
    def cnn2( ) {
        val url = "http://www.cnn.com/2011/POLITICS/10/06/tea.party.left/index.html?hpt=hp_t1"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Washington (CNN) -- Wall Street should have seen it coming. After all, market forces were at work." )
        TestUtils.printReport()
    }

    @Test
    def businessWeek( ) {
        val url : String = "http://www.businessweek.com/magazine/content/10_34/b4192066630779.htm"
        val article : Article = TestUtils.getArticle( url )
        val title = "Olivia Munn: Queen of the Uncool"
        val content = "Six years ago, Olivia Munn arrived in Hollywood with fading ambitions of making it as a sports reporter and set about deploying"
        val image = "http://images.businessweek.com/mz/10/34/370/1034_mz_66popmunnessa.jpg"
        TestUtils.runArticleAssertions( article = article, expectedTitle = title, expectedStart = content )
    }


    @Test
    def businessWeek2( ) {
        val url : String = "http://www.businessweek.com/magazine/content/10_34/b4192048613870.htm"
        val article : Article = TestUtils.getArticle( url )
        val content = "There's discord on Wall Street: Strategists at major American investment banks see a"
        val image = "http://images.businessweek.com/mz/covers/current_120x160.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )

    }

    @Test
    def businessWeek3( ) {
        val url : String = "http://www.businessinsider.com/ben-and-jerrys-schweddy-balls-one-million-moms-american-family-association-boycott-2011-9"
        val article : Article = TestUtils.getArticle( url )
        //    if (article == null) println("NULL ARTICLE!") else println("TEXT: \n" + article.cleanedArticleText)
        val content = "Not everyone's a fan of Ben & Jerry's new \"Schweddy Balls\" -- the Saturday Night Live-inspired flavor it rolled out a few weeks ago"
        val image = "http://static7.businessinsider.com/image/4e68c8c36bb3f7d80a000016/conservative-moms-are-now-calling-for-a-boycott-of-ben-and-jerrys-schweddy-balls-flavor.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )

    }

    @Test
    def desertNews( ) {
        val url = "http://www.deseretnews.com/article/705388385/High-school-basketball-Top-Utah-prospects-representing-well.html"
        val article = TestUtils.getArticle( url )
        val content = "Utah isn't known nationally for producing top basketball talent"
        TestUtils.runArticleAssertions( article, expectedStart = content )

    }

    @Test
    def foxNews( ) {
        val url : String = "http://www.foxnews.com/politics/2010/08/14/russias-nuclear-help-iran-stirs-questions-improved-relations/"
        val article = TestUtils.getArticle( url )
        val content = "Russia's announcement that it will help Iran get nuclear fuel is raising questions"
        val image = "http://a57.foxnews.com/static/managed/img/Politics/396/223/startsign.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )

    }

    @Test
    def foxNews2( ) {
        val url : String = "http://www.foxnews.com/politics/2011/10/06/obama-defends-528-million-federal-loan-to-bankrupt-solyndra/"
        val article = TestUtils.getArticle( url )
        val content = "The director of the controversial loan program that cleared the way for a $535"
        val image = "http://a57.foxnews.com/static/managed/img/Politics/396/223/silver_jonathan.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
    }

    @Test
    def msnbc( ) {
        val url : String = "http://bottomline.msnbc.msn.com/_news/2011/10/06/8190264-even-without-jobs-apple-still-shines-analysts-say"
        val article = TestUtils.getArticle( url )
        val content = "The death of technology titan Steve Jobs, co-founder and former CEO of Apple"
        val image = "http://msnbcmedia.msn.com/j/MSNBC/Components/Photo/_new/tz-biz-11106-applefuture-108p.nv_auth_landscape.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
    }


    @Test
    def laTimes( ) {
        val url : String = "http://www.latimes.com/business/la-fi-jobs-legacy-hiltzik-20111006,0,5186643.column"
        val article = TestUtils.getArticle( url )
        val content = "Everyone knows Steve Jobs pulled off one of the outstanding corporate turnarounds in U.S. history"
        val image = "http://www.latimes.com/media/photo/2011-10/65235661.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
        TestUtils.printReport()

    }

    @Test
    def aolNews( ) {

        val url : String = "http://www.aolnews.com/nation/article/the-few-the-proud-the-marines-getting-a-makeover/19592478"
        val article = TestUtils.getArticle( url )
        val content = "WASHINGTON (Aug. 13) -- Declaring \"the maritime soul of the Marine Corps\" is"
        val image = "http://o.aolcdn.com/photo-hub/news_gallery/6/8/680919/1281734929876.JPEG"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
    }

    @Test
    def wallStreetJournal( ) {

        val url : String = "http://online.wsj.com/article/SB10001424052748704532204575397061414483040.html"
        val article = TestUtils.getArticle( url )
        val content = "The Obama administration has paid out less than a third of the nearly $230 billion"
        val image = "http://s.wsj.net/public/resources/images/OB-JO759_0814st_A_20100814143158.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
    }

    @Test
    def usaToday( ) {

        val url : String = "http://content.usatoday.com/communities/thehuddle/post/2010/08/brett-favre-practices-set-to-speak-about-return-to-minnesota-vikings/1"
        val article = TestUtils.getArticle( url )
        val content = "Brett Favre couldn't get away from the"
        val image = "http://i.usatoday.net/communitymanager/_photos/the-huddle/2010/08/18/favrespeaksx-inset-community.jpg"
        TestUtils.runArticleAssertions( article = article, expectedStart = content )
    }

    @Test
    def usaToday2( ) {

        val url : String = "http://content.usatoday.com/communities/driveon/post/2010/08/gm-finally-files-for-ipo/1"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "General Motors just filed with the Securities and Exchange ",
                                        )
    }

    @Test
    def usaToday3( ) {

        val url : String = "http://www.usatoday.com/money/perfi/funds/story/2011-10-05/3q-mutual-fund-report/50674776/1"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Timothy McIntosh, a Tampa financial planner, has always been able to soothe his customers after a rough patch in the " +
                                                        "stock market. Until now." )
        TestUtils.printReport()
    }


    @Test
    def espn( ) {

        val url : String = "http://sports.espn.go.com/espn/commentary/news/story?id=5461430"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "If you believe what college football coaches have said about sports" )
    }

    @Test
    def washingtonpost( ) {

        val url : String = "http://www.washingtonpost.com/wp-dyn/content/article/2010/12/08/AR2010120803185.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "The Supreme Court sounded " )
    }

    @Test
    def gizmodo( ) {

        val url : String = "http://gizmodo.com/5833746/what-if-the-earthquake-had-hit-manhattan"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Today's 5.9 magnitude earthquake was felt throughout the Mid-Atlantic" )
    }

    @Test
    def engadget( ) {

        val url : String = "http://www.engadget.com/2010/08/18/verizon-fios-set-top-boxes-getting-a-new-hd-guide-external-stor/"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Streaming and downloading TV content to mobiles is nice",
                                        )
    }

    @Test
    def time( ) {

        val url : String = "http://www.time.com/time/health/article/0,8599,2011497,00.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "This month, the federal government released" )
    }

    @Test
    def time2( ) {

        val url : String = "http://newsfeed.time.com/2011/08/24/washington-monument-closes-to-repair-earthquake-induced-crack/"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Despite what the jeers of jaded Californians might suggest" )
    }

    @Test
    def time404( ) {

        val url : String = "http://newsfeed.time.com/2011/08/24/washington-monument-closes-to-repair-earthquake-induced-FOO-BAR/"
        val article = TestUtils.getArticle( url )

        assertNull( "Article title should be null for a 404 url!", article.title )
    }

    @Test
    def tulsaWorld( ) {

        val url : String = "http://www.tulsaworld.com/site/articlepath.aspx?articleid=20111118_61_A16_Opposi344152&rss_lnk=7"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Opposition to a proposal to remove certain personal data" )

    }


    @Test
    def cnet( ) {

        val url : String = "http://news.cnet.com/8301-30686_3-20014053-266.html?tag=topStories1"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "The phone company is adding bells and whistles to",
                                        )
    }

    @Test
    def wired( ) {

        val url : String = "http://www.wired.com/epicenter/2011/10/steve-jobs-disability/"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "When I heard that Steve Jobs had passed away, I was boarding a train from New York to Philadelphia to visit my son.",
                                        )
    }

    @Test
    def msn( ) {

        val url : String = "http://lifestyle.msn.com/your-life/your-money-today/article.aspx?cp-documentid=31244150"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "\"Head to the supermarket an hour before closing time. Some stores mark down ",
                                        )
        TestUtils.printReport()
    }

    @Test
    def ap( ) {

        val url : String = "http://hosted2.ap.org/APDEFAULT/bbd825583c8542898e6fa7d440b9febc/Article_2011-10-06-Kids-Concussions/id-6cb44517aaec4303936fa07d5490dce6"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "(AP) — The number of athletic children going to hospitals with concussions is up 60 percent in the past decade",
                                        )
        TestUtils.printReport()
    }


    @Test
    def yahoo( ) {

        val url : String = "http://news.yahoo.com/apple-says-steve-jobs-resigning-ceo-224628633.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "SAN FRANCISCO (AP) — Steve Jobs, the mind behind the iPhone" )
    }

    @Test
    def abcnews( ) {

        val url : String = "http://abcnews.go.com/Technology/steve-jobs-fire-company/story?id=14683754"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Steve Jobs was just 30 years old, wildly successful, fabulously wealthy and a global celebrity. And then it all came " +
                                                        "crashing down.",
                                        )
    }

    @Test
    def businessInsider( ) {

        val url : String = "http://www.businessinsider.com/closing-bell-september-20-2011-9"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "And now we're looking at two down days in a" )
        TestUtils.printReport()
    }

    @Test
    def financialTimes( ) {

        val url : String = "http://www.ft.com/intl/cms/s/2/4e268022-e472-11e0-92a3-00144feabdc0.htm"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Hewlett-Packard shares jumped nearly 7 per" )
        TestUtils.printReport()
    }

    @Test
    def huffpoBusiness( ) {

        val url : String = "http://www.huffingtonpost.com/david-macaray/labor-union-membership_b_973038.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "For men and women who plan on entering the job" )
        TestUtils.printReport()
    }

    @Test
    def huffpo( ) {

        val url : String = "http://www.huffingtonpost.com/2011/10/06/alabama-workers-immigration-law_n_997793.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "MONTGOMERY, Ala. -- Alabama's strict new immigration law may be backfiring." )
        TestUtils.printReport()
    }


    @Test
    def huffpoBusiness2( ) {

        val url : String = "http://www.huffingtonpost.com/2011/09/21/us-sees-challenges-in-s_n_974724.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "WASHINGTON (Reuters) - The government is continuing an aggressive drive to hold accountable" )
        TestUtils.printReport()
    }

    @Test
    def nyTimes1( ) {
        context.copy( browserUserAgent = "grvGoose" )
        val url : String = "http://www.nytimes.com/2011/09/20/arts/design/preserving-the-american-folk-art-museums-place-in-new-york.html?_r=1&ref=arts"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Please. Someone, everyone, do something to save the American Folk Art Museum from dissolution and dispersa",
                                        )
        TestUtils.printReport()
    }

    @Test
    def nyTimes2( ) {

        context.copy( browserUserAgent = "grvGoose" )
        val url : String = "http://www.nytimes.com/2011/10/07/health/07prostate.html?_r=1&hp"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Healthy men should no longer receive a P.S.A. blood test to screen for prostate cancer because the test does not save " +
                                                        "lives",
                                        )
        TestUtils.printReport()
    }


    @Test
    def gooseRequestParameters( ) {

        context.copy( browserUserAgent = "grvGoose" )
        val url : String = "http://jimplush.com/public/uploads/goosetest.php"
        val article = TestUtils.getArticle( url )
        println( article.rawHtml )

    }


    @Test
    def cnbc( ) {


        val url : String = "http://www.cnbc.com/id/44613978"
        val article = TestUtils.getArticle( url )

        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Some traders found Wednesday's Fed statement to be a bit gloomier than expected." )
        TestUtils.printReport()
    }

    @Test
    def cnbc3( ) {


        val url : String = "http://www.cnbc.com//id/44608735"
        val article = TestUtils.getArticle( url )

        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "Existing home sales rose more than expected in August to the fastest annual",
                                        )
        TestUtils.printReport()
    }


    //  @Test
    //  def cnbc2() {
    //    // commented out while this issue is resolve: https://github.com/jhy/jsoup/issues/130
    //    
    //    val url: String = "http://www.cnbc.com/id/44614459"
    //    val article = TestUtils.getArticle(url)
    //    println(article.cleanedArticleText)
    //    TestUtils.runArticleAssertions(article = article,
    //      expectedStart = "Some traders found Wednesday's Fed statement to be a bit gloomier than expected.",
    //      )
    //    TestUtils.printReport()
    //  }

    @Test
    def yahooFinance( ) {
        val url = "http://finance.yahoo.com/news/Mulling-Meg-Whitman-HP-apf-4116866737.html?x=0"

        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "SAN FRANCISCO (AP) -- As trial balloons go" )
        TestUtils.printReport()
    }


    @Test
    def time3( ) {
        val url = "http://www.time.com/time/magazine/article/0,9171,804054,00.html"

        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "The hemline could no longer be held. With wartime controls on",
                                        )
        TestUtils.printReport()
    }


    @Test
    def yahooFinance2( ) {
        val url = "http://finance.yahoo.com/news/Stocks-plunge-after-Fed-apf-3386772167.html?x=0"

        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "NEW YORK (AP) -- The Federal Reserve did what investors",
                                        )
        TestUtils.printReport()
    }

    @Test
    def businessinsider( ) {
        val url = "http://www.businessinsider.com/meanwhile-developments-in-greece-2011-9"

        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "As everyone in the world was transfixed on the Fed",
                                        )
        TestUtils.printReport()
    }

    @Test
    def businessinsider2( ) {
        val url = "http://www.businessinsider.com/goldman-on-the-fed-announcement-2011-9"

        val article = TestUtils.getArticle( url )

        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "From Goldman on the FOMC operation twist announcement",
                                        )
        TestUtils.printReport()
    }


    @Test
    def politico( ) {

        val url : String = "http://www.politico.com/news/stories/1010/43352.html"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "If the newest Census Bureau estimates stay close to form",
                                        )
    }

    @Test
    def buzznetImages( ) {

        val url : String = "http://newageamazon.buzznet.com/user/journal/17025056/doubt-gives-hope-new-album/"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "We've had so many false hopes with the new No Doubt CD.",
                                        )
    }

    @Test
    def timeImages( ) {

        val url : String = "http://swampland.time.com/2012/01/09/hecklers-and-hostile-crowds-stymie-santorum-in-new-hampshire/"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "It was a scene fit for a front-runner: an overflow crowd spilling out the doors of a Rockwellian" )
    }

    @Test
    def cnnMoneyImages( ) {

        val url : String = "http://money.cnn.com/2012/01/09/pf/suze_orman_prepaid_card/index.htm?iid=HP_LN"
        val article = TestUtils.getArticle( url )
        TestUtils.runArticleAssertions( article = article,
                                        expectedStart = "NEW YORK (CNNMoney) -- CNBC's outspoken financial adviser, Suze" )
    }

}