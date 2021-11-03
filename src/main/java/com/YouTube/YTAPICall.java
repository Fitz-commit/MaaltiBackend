package com.YouTube;



import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.*;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;


public class YTAPICall {

    private static final String DEVELOPER_KEY = "AIzaSyCTrsSbAW-oOXcaQG7KUR2zuImmjaLVi9o";
    private static final String APPLICATION_NAME = "Maalti";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    private static YouTube youtubeService;
    private static YouTube.Channels.List request;
    private static YouTube.Search.List searchrequest;


    static {
        try {
            youtubeService = YTAPICall.getService();
            request = youtubeService.channels().list("snippet,topicDetails,statistics,status");
            searchrequest = youtubeService.search().list("snippet");
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static Youtuber channelListUsername(String Username) throws GeneralSecurityException, IOException {
        ChannelListResponse response = request.setKey(DEVELOPER_KEY)
                .setForUsername(Username)
                .execute();

        return initializeYoutuber(response);
    }

    public static Youtuber channelListID(String ID) throws IOException, GeneralSecurityException {
        ChannelListResponse response = request.setKey(DEVELOPER_KEY)
                .setId(ID)
                .execute();

        Youtuber InitializedYoutuber = initializeYoutuber(response);
        InitializedYoutuber.setVideos(searchVideos(InitializedYoutuber, "date"));


        return InitializedYoutuber;
    }

    public static Youtuber channelListID(String ID, String order) throws IOException, GeneralSecurityException {
        ChannelListResponse response = request.setKey(DEVELOPER_KEY)
                .setId(ID)
                .execute();

        Youtuber InitializedYoutuber = initializeYoutuber(response);
        InitializedYoutuber.setVideos(searchVideos(InitializedYoutuber, order));//TODO Theoretisch kann man doch die Videos direkt beim initlisieren mituafnehmen oder?


        return InitializedYoutuber;
    }

    public static List<Youtuber> searchChannel(String Username) throws GeneralSecurityException, IOException {
        SearchListResponse response = searchrequest.setMaxResults(50L)
                .setKey(DEVELOPER_KEY)
                .setQ(Username) //TODO Region Parameter hinzufügen
                .setType("channel")
                .setOrder("relevance")
                .execute();

        int counter = 0;
        List<Youtuber> youtuberpreview = new ArrayList<>();
        for(ListIterator<SearchResult> iter = response.getItems().listIterator(); iter.hasNext(); ){

            SearchResultSnippet snippet = response.getItems().get(counter).getSnippet();

            youtuberpreview.add(new Youtuber(snippet.getTitle(),  snippet.getThumbnails().getHigh().getUrl() , snippet.getChannelId(), snippet.getDescription()));


            counter= counter +1;
            iter.next();
        }

        return youtuberpreview;

    }

    public static List<Youtuber> searchChannel(String Username, String country) throws GeneralSecurityException, IOException {
        SearchListResponse response = searchrequest.setMaxResults(50L)
                .setKey(DEVELOPER_KEY)
                .setQ(Username)
                .setRegionCode(country)
                .setType("channel")
                .setOrder("relevance")
                .execute();

        int counter = 0;
        List<Youtuber> youtuberpreview = new ArrayList<>();
        for(ListIterator<SearchResult> iter = response.getItems().listIterator(); iter.hasNext(); ){

            SearchResultSnippet snippet = response.getItems().get(counter).getSnippet();

            youtuberpreview.add(new Youtuber(snippet.getTitle(),  snippet.getThumbnails().getDefault().getUrl() , snippet.getChannelId(), snippet.getDescription()));


            counter= counter +1;
            iter.next();
        }

        return youtuberpreview;

    }



    public static VideoListResponse searchVideos(Youtuber youtuber, String Order) throws IOException, GeneralSecurityException {
        SearchListResponse response = searchrequest.setMaxResults(50l)
                .setKey(DEVELOPER_KEY)
                .setChannelId(youtuber.getCreatorid())
                .setType("video")
                .setOrder(Order)
                .execute();

        String videoid= "";
        int counter = 0;

        for(ListIterator<SearchResult> iter = response.getItems().listIterator(); iter.hasNext(); ){

            videoid = videoid + response.getItems().get(counter).getId().getVideoId() +",";



            counter= counter +1;
            iter.next();

        }

        videoid = videoid.substring(0, videoid.length()-1);

        return getVideoData(videoid);

    }

    public static VideoListResponse getVideoData(String videoid) throws IOException, GeneralSecurityException {
        YouTube.Videos.List request = youtubeService.videos()
                .list("snippet,contentDetails,statistics");
        VideoListResponse response = request.setKey(DEVELOPER_KEY)
                .setMaxResults(50l)
                .setId(videoid)
                .execute();
        return response;
    }



    public static Youtuber initializeYoutuber(ChannelListResponse response){

        ChannelSnippet snippet = response.getItems().get(0).getSnippet();
        ChannelTopicDetails details = response.getItems().get(0).getTopicDetails(); //List wird erwartet
        ChannelStatistics statistics = response.getItems().get(0).getStatistics();
        ChannelStatus status = response.getItems().get(0).getStatus();

        String name = snippet.getTitle();
        String description = snippet.getDescription();
        String country = snippet.getCountry();
        String profilbild = snippet.getThumbnails().getMaxres().getUrl();
        String creationdate = snippet.getPublishedAt().toString();
        String id = response.getItems().get(0).getId();
        String customURL = snippet.getCustomUrl();
        BigInteger viewcount = statistics.getViewCount();
        BigInteger videocount = statistics.getVideoCount();
        BigInteger subcount = statistics.getSubscriberCount();
        Boolean ismadeforkids = status.getMadeForKids();
        List<String> topics = details.getTopicCategories();

        return new Youtuber(name, description, country,profilbild,creationdate,id,customURL,viewcount,videocount,subcount,ismadeforkids,topics);
    }

}