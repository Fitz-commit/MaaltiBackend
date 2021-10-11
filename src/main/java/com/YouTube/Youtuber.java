package com.YouTube;

import com.google.api.services.youtube.model.VideoListResponse;

import java.math.BigInteger;
import java.util.List;
import java.util.ListIterator;

public class Youtuber {

    private String name;
    private String description;
    private String country;
    private String profilbild;
    private int creationdate;
    private String creatorid;
    private String customURL;
    private BigInteger viewcount;
    private BigInteger videocount;
    private BigInteger subcount;
    private boolean madeforkids;
    private List<String> topics;
    private VideoListResponse videos;
    private int itemcount ;
    private BigInteger totalviews;
    private BigInteger totalcomments;
    private BigInteger totallikes;
    private BigInteger totaldislikes;
    private BigInteger averageviews;
    private BigInteger averagecomments;
    private BigInteger averagelikes;
    private BigInteger averagedislikes;


    public Youtuber(String name, String profilbild, String creatorid) {
        this.name = name;
        this.profilbild = profilbild;
        this.creatorid = creatorid;
    }

    public Youtuber(String name, String description, String country, String profilbild, int creationdate, String creatorid, String customURL, BigInteger viewcount, BigInteger videocount, BigInteger subcount, boolean madeforkids, List<String> topics) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.profilbild = profilbild;
        this.creationdate = creationdate;
        this.creatorid = creatorid;
        this.customURL = "https://www.youtube.com/c/" + customURL;
        this.viewcount = viewcount;
        this.videocount = videocount;
        this.subcount = subcount;
        this.madeforkids = madeforkids;
        this.topics = topics;
    }

    public void getKennzahlenBasis(){
        int counter=0;

        for(ListIterator<com.google.api.services.youtube.model.Video> VideoIterator = videos.getItems().listIterator(); VideoIterator.hasNext(); ){
            totalviews.add(videos.getItems().get(counter).getStatistics().getViewCount());
            totalcomments.add(videos.getItems().get(counter).getStatistics().getCommentCount());
            totallikes.add(videos.getItems().get(counter).getStatistics().getLikeCount());
            totaldislikes.add(videos.getItems().get(counter).getStatistics().getDislikeCount());
            counter++;
            VideoIterator.next();
        }

    }

    public void berechneKennzahlen(){
        averageviews.add(totalviews.divide(BigInteger.valueOf(itemcount)));
        averagecomments.add(totalcomments.divide(BigInteger.valueOf((itemcount))));
        averagelikes.add(totallikes.divide(BigInteger.valueOf(itemcount)));
        averagedislikes.add(totaldislikes.divide(BigInteger.valueOf((itemcount))));
    }


    public String getName() {
        return name;
    }


    public String getCreatorid() {
        return creatorid;
    }

    public String getDescription() {
        return description;
    }


    public String getProfilbild() {
        return profilbild;
    }

    public int getCreationdate() {
        return creationdate;
    }

    public String getCustomURL() {
        return customURL;
    }

    public BigInteger getViewcount() {
        return viewcount;
    }

    public BigInteger getVideocount() {
        return videocount;
    }

    public BigInteger getSubcount() {
        return subcount;
    }

    public boolean isMadeforkids() {
        return madeforkids;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setVideos(VideoListResponse videos) {
        this.videos = videos;
    }

}
