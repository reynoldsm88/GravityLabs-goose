package com.gravity.goose.extractors

import java.time.ZonedDateTime

import org.jsoup.nodes.Element

class DefaultPublishDateExtractor extends JavaTimeExtractor {
    /**
      * Given the specified {@link Element}, extract @param <T>
      *
      * @param rootElement passed in from the { @link com.jimplush.goose.ContentExtractor} after the article has been parsed
      * @return an instance of type <code>T</code>
      */
    override def extract( rootElement : Element ) : ZonedDateTime = {

        // A few different ways to get a date.
        //        def bestPubDate = pubSelectors.flatMap (extractCandidate (rootElement, _) ).reduceOption (minDate)
        //
        //        def bestModDate = modSelectors.flatMap (extractCandidate (rootElement, _) ).reduceOption (minDate)
        //
        //        // Return the oldest 'published' date, or else the oldest 'modified' date, or null if none.
        //        bestPubDate.orElse (bestModDate).getOrElse (null)

        ZonedDateTime.now()

    }
}
