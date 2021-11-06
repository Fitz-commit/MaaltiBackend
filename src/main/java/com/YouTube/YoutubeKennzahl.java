package com.YouTube;

import com.google.api.services.youtube.model.Video;
import com.google.api.services.youtube.model.VideoListResponse;

import javax.swing.text.NumberFormatter;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.ListIterator;

public class YoutubeKennzahl{

    private static Comparator COMMENT_COMP = new CommentComparator();
    private static Comparator VIEW_COMP = new ViewComparator();
    private static Comparator DISLIKE_COMP = new DislikeComparator();
    private static Comparator LIKE_COMP = new LikeComparator();


    private BigInteger totalviews = BigInteger.valueOf(0);
    private BigInteger totalcomments = BigInteger.valueOf(0);
    private BigInteger totallikes = BigInteger.valueOf(0);
    private BigInteger totaldislikes = BigInteger.valueOf(0);
    private BigInteger averageviews = BigInteger.valueOf(0);
    private BigInteger averagecomments = BigInteger.valueOf(0);
    private BigInteger averagelikes= BigInteger.valueOf(0);
    private BigInteger averagedislikes= BigInteger.valueOf(0);
    private Video mostcomments;
    private Video mostlikes;
    private Video mostdislikes;
    private Video mostviews;
    private Double maxpostreach;
    private Double minpostreach;
    private Double engagmentrate;
    private Double applausrate;

    private int itemcount;
    private VideoListResponse videos;


    public YoutubeKennzahl(int itemcount, VideoListResponse videos, BigInteger subcount) {
        this.itemcount=itemcount;
        this.videos = videos.clone();

        kennzahlenBasis(this.videos);
        berechneKennzahlen(this.itemcount);
        berechneApplausrate(subcount);
        berechneEngagmentrate(subcount);
        berechneReichweite(subcount,this.videos);
        berechneSpikes(this.videos);
    }


    private static class DislikeComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            BigInteger c1 = ((Video)o1).getStatistics().getDislikeCount();
            BigInteger c2 = ((Video)o2).getStatistics().getDislikeCount();

            if(c1 == null || c2 ==null){
                c1 = BigInteger.valueOf(0);
                c2 = BigInteger.valueOf(0);
            }

            return c1.compareTo(c2);
        }
    }

    private static class LikeComparator implements Comparator{
        public int compare(Object o1, Object o2) {

            BigInteger c1 = ((Video)o1).getStatistics().getLikeCount();

            BigInteger c2 = ((Video)o2).getStatistics().getLikeCount();

            if(c1 == null || c2 ==null){
                c1 = BigInteger.valueOf(0);
                c2 = BigInteger.valueOf(0);
            }
            return c1.compareTo(c2);
        }
    }

    private static class CommentComparator implements Comparator{
        public int compare(Object o1, Object o2) {
            BigInteger c1 = ((Video)o1).getStatistics().getCommentCount();
            BigInteger c2 = ((Video)o2).getStatistics().getCommentCount();

            if(c1 == null || c2 ==null){
                c1 = BigInteger.valueOf(0);
                c2 = BigInteger.valueOf(0);
            }

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

    private void berechneReichweite(BigInteger subcount, VideoListResponse videos ){
        videos.getItems().sort(VIEW_COMP);
        double subscriber = subcount.doubleValue();
        double lastelement = videos.getItems().get(videos.getItems().size()-1).getStatistics().getViewCount().doubleValue();
        this.maxpostreach = (lastelement/subscriber)*100;

        double firstelement = videos.getItems().get(0).getStatistics().getViewCount().doubleValue();
        this.minpostreach = (firstelement/subscriber)*100;

        this.maxpostreach=Math.round(this.maxpostreach*100.0)/100.0;
        this.minpostreach= Math.round(this.minpostreach*100.0)/100.0;

    }

    private void berechneKennzahlen(int itemcount){
        averageviews = totalviews.divide(BigInteger.valueOf(itemcount));
        averagecomments = totalcomments.divide(BigInteger.valueOf((itemcount)));
        averagelikes =totallikes.divide(BigInteger.valueOf(itemcount));
        averagedislikes =totaldislikes.divide(BigInteger.valueOf((itemcount)));
    }

    private void kennzahlenBasis(VideoListResponse videos){
        int counter=0;

        for(ListIterator<Video> VideoIterator = videos.getItems().listIterator(); VideoIterator.hasNext(); ){
            totalviews =totalviews.add(videos.getItems().get(counter).getStatistics().getViewCount());

            try {
                totalcomments = totalcomments.add(videos.getItems().get(counter).getStatistics().getCommentCount());
            }catch (NullPointerException n){
                totallikes = totallikes.add(BigInteger.valueOf(0));
                itemcount = itemcount-1;
            }
            try {
                totallikes = totallikes.add(videos.getItems().get(counter).getStatistics().getLikeCount());
            }catch (NullPointerException n){
                totallikes = totallikes.add(BigInteger.valueOf(0));
                itemcount = itemcount-1;
            }

            try {
                totaldislikes =totaldislikes.add(videos.getItems().get(counter).getStatistics().getDislikeCount());
            } catch (NullPointerException n){
                totaldislikes = totaldislikes.add(BigInteger.valueOf(0));
                itemcount = itemcount-1;
            }

            counter++;
            VideoIterator.next();
        }

    }

    private void berechneEngagmentrate(BigInteger subcount){
        BigInteger entgagment = totallikes.add(totalcomments.add(totaldislikes));

        this.engagmentrate = (entgagment.doubleValue()/subcount.doubleValue())*100;

        this.engagmentrate = Math.round(this.engagmentrate*100.0)/100.0;

    }

    private void berechneApplausrate(BigInteger subcount){
        this.applausrate= (totallikes.doubleValue() / subcount.doubleValue())*100 ;

        this.applausrate= Math.round(this.applausrate*100.0)/100.0;
    }

    private void berechneSpikes( VideoListResponse videos){
        videos.getItems().sort(COMMENT_COMP);
        this.mostcomments = videos.getItems().get(videos.getItems().size()-1);

        videos.getItems().sort(VIEW_COMP);
        this.mostviews= videos.getItems().get(videos.getItems().size()-1);

        videos.getItems().sort(DISLIKE_COMP);
        this.mostdislikes= videos.getItems().get(videos.getItems().size()-1);

        videos.getItems().sort(LIKE_COMP);
        this.mostlikes= videos.getItems().get(videos.getItems().size()-1);
    }

    public Video getMostcomments() {
        return mostcomments;
    }

    public Video getMostlikes() {
        return mostlikes;
    }

    public Video getMostdislikes() {
        return mostdislikes;
    }

    public Video getMostviews() {
        return mostviews;
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


