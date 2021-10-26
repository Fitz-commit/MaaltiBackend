package com.YouTube;

import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.ListIterator;

public class YoutubeKennzahl{

    private static Comparator COMMENT_COMP = new CommentComparator();
    private static Comparator VIEW_COMP = new ViewComparator();

    private BigInteger totalviews = BigInteger.valueOf(0);
    private BigInteger totalcomments = BigInteger.valueOf(0);
    private BigInteger totallikes = BigInteger.valueOf(0);
    private BigInteger totaldislikes = BigInteger.valueOf(0);
    private BigInteger averageviews = BigInteger.valueOf(0);
    private BigInteger averagecomments = BigInteger.valueOf(0);
    private BigInteger averagelikes= BigInteger.valueOf(0);
    private BigInteger averagedislikes= BigInteger.valueOf(0);
    private String commentspike =null ; //TODO nötig?
    private String viewspike = null;
    private Double maxpostreach;
    private Double minpostreach;
    private Double engagmentrate;
    private Double applausrate;


    private static class CommentComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            BigInteger c1 = ((Video)o1).getStatistics().getCommentCount();
            BigInteger c2 = ((Video)o2).getStatistics().getCommentCount();
            return c1.compareTo(c2);
        }
    }

    private static class ViewComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            BigInteger c1 = ((Video)o1).getStatistics().getViewCount();
            BigInteger c2 = ((Video)o2).getStatistics().getViewCount();
            return c1.compareTo(c2);
        }
    }

    public void berechneReichweite(BigInteger subcount, VideoListResponse videos ){
        videos.getItems().sort(VIEW_COMP);
        double subscriber = subcount.doubleValue();
        double lastelement = videos.getItems().get(videos.getItems().size()-1).getStatistics().getViewCount().doubleValue();
        this.maxpostreach = (lastelement/subscriber)*100;

        double firstelement = videos.getItems().get(0).getStatistics().getViewCount().doubleValue();
        this.minpostreach = (firstelement/subscriber)*100;


    }

    public void berechneKennzahlen(int itemcount){
        averageviews = totalviews.divide(BigInteger.valueOf(itemcount));
        averagecomments = totalcomments.divide(BigInteger.valueOf((itemcount)));
        averagelikes =totallikes.divide(BigInteger.valueOf(itemcount));
        averagedislikes =totaldislikes.divide(BigInteger.valueOf((itemcount)));
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

    public void berechneEngagmentrate(BigInteger subcount){
        BigInteger entgagment = subcount.add(totallikes.add(totalcomments.add(totaldislikes)));

        this.engagmentrate = (entgagment.divide(subcount).doubleValue())*100;

    }

    public void berechneApplausrate(BigInteger subcount){
        this.applausrate= totallikes.divide(subcount).doubleValue();

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

    public static Comparator getCommentComp() {
        return COMMENT_COMP;
    }

    public Double getMaxpostreach() {
        return maxpostreach;
    }

    public Double getMinpostreach() {
        return minpostreach;
    }

    public Double getEngagmentrate() {
        return engagmentrate;
    }

    public Double getApplausrate() {
        return applausrate;
    }
}


