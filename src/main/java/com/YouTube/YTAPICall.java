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
import java.util.List;


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

    public static Youtuber channelListID(String ID) throws IOException {
        ChannelListResponse response = request.setKey(DEVELOPER_KEY)
                .setId(ID)
                .execute();

        return initializeYoutuber(response);
    }

    public static void searchChannel(String Username) throws GeneralSecurityException, IOException {
        SearchListResponse response = searchrequest.setMaxResults(25L)
                .setKey(DEVELOPER_KEY)
                .setQ(Username)
                .setType("channel")
                .execute();

    }

    public static void searchVideos(String ID, String Order) throws IOException {
        SearchListResponse response = searchrequest.setMaxResults(50L)
                .setKey(DEVELOPER_KEY)
                .setChannelId(ID)
                .setType("video")
                .setOrder(Order)
                .execute();

    }

    public static Youtuber initializeYoutuber(ChannelListResponse response){

        ChannelSnippet snippet = response.getItems().get(0).getSnippet();
        ChannelTopicDetails details = response.getItems().get(0).getTopicDetails(); //List wird erwartet
        ChannelStatistics statistics = response.getItems().get(0).getStatistics();
        ChannelStatus status = response.getItems().get(0).getStatus();

        String name = snippet.getTitle();
        String description = snippet.getDescription();
        String country = snippet.getCountry();
        String profilbild = snippet.getThumbnails().getMedium().getUrl();
        int creationdate = snippet.getPublishedAt().getTimeZoneShift();
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