package com.YouTube;

import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.math.BigInteger;
import java.util.ListIterator;

public class YoutubeKennzahl {


    private BigInteger totalviews = BigInteger.valueOf(0);
    private BigInteger totalcomments = BigInteger.valueOf(0);
    private BigInteger totallikes = BigInteger.valueOf(0);
    private BigInteger totaldislikes = BigInteger.valueOf(0);
    private BigInteger averageviews = BigInteger.valueOf(0);
    private BigInteger averagecomments = BigInteger.valueOf(0);
    private BigInteger averagelikes= BigInteger.valueOf(0);
    private BigInteger averagedislikes= BigInteger.valueOf(0);



    public void berechneKennzahlen(int itemcount){ //TODO Kennzahlen in eigene Klasse
        averageviews = totalviews.divide(BigInteger.valueOf(itemcount));
        averagecomments = totalcomments.divide(BigInteger.valueOf((itemcount)));
        averagelikes =totallikes.divide(BigInteger.valueOf(itemcount));
        averagedislikes =totaldislikes.divide(BigInteger.valueOf((itemcount)));
    }

    public BigInteger getTotalviews() {
        return totalviews;
    }

    public BigInteger getTotalcomments() {
        return totalcomments;
    }

    public BigInteger getTotallikes() {
        return totallikes;
    }

    public BigInteger getTotaldislikes() {
        return totaldislikes;
    }

    public BigInteger getAverageviews() {
        return averageviews;
    }

    public BigInteger getAveragecomments() {
        return averagecomments;
    }

    public BigInteger getAveragelikes() {
        return averagelikes;
    }

    public BigInteger getAveragedislikes() {
        return averagedislikes;
    }

    public void kennzahlenBasis(VideoListResponse videos){
        int counter=0;

        for(ListIterator<Video> VideoIterator = videos.getItems().listIterator(); VideoIterator.hasNext(); ){
            totalviews =totalviews.add(videos.getItems().get(counter).getStatistics().getViewCount());
            totalcomments =totalcomments.add(videos.getItems().get(counter).getStatistics().getCommentCount());
            totallikes= totallikes.add(videos.getItems().get(counter).getStatistics().getLikeCount());
            totaldislikes =totaldislikes.add(videos.getItems().get(counter).getStatistics().getDislikeCount());
            counter++;
            VideoIterator.next();
        }


    }




}


