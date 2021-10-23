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
    private String creationdate;
    private String creatorid;
    private String customURL;
    private BigInteger viewcount;
    private BigInteger videocount;
    private BigInteger subcount;
    private boolean madeforkids;
    private List<String> topics;
    private VideoListResponse videos;
    private YoutubeKennzahl kennzahlen;
    private int itemcount ;



    public Youtuber(String name, String profilbild, String creatorid, String description) {
        this.name = name;
        this.profilbild = profilbild;
        this.creatorid = creatorid;
        this.description = description;
    }

    public Youtuber(String name, String description, String country, String profilbild, String creationdate, String creatorid, String customURL, BigInteger viewcount, BigInteger videocount, BigInteger subcount, boolean madeforkids, List<String> topics) {
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

    public String getCreationdate() {
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

    public String getCountry() {
        return country;
    }

    public VideoListResponse getVideos() {
        return videos;
    }

    public YoutubeKennzahl getKennzahlen() {
        return kennzahlen;
    }

    public void setVideos(VideoListResponse videos) {
        this.videos = videos;
        itemcount = this.videos.getItems().size();
        kennzahlen.kennzahlenBasis(videos);
        kennzahlen.berechneKennzahlen(itemcount);
    }

}
