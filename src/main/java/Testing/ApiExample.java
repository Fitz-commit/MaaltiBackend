package Testing;



import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.services.youtube.model.ChannelSnippet;
import com.google.api.services.youtube.model.ChannelStatistics;

import java.io.IOException;
import java.security.GeneralSecurityException;


public class ApiExample {

    private static final String DEVELOPER_KEY = "AIzaSyCTrsSbAW-oOXcaQG7KUR2zuImmjaLVi9o";
    private static final String APPLICATION_NAME = "Maalti";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static YouTube getService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new YouTube.Builder(httpTransport, JSON_FACTORY, null)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static Youtuber doThing() throws GeneralSecurityException, IOException {
        YouTube youtubeService = ApiExample.getService();
        YouTube.Channels.List request = youtubeService.channels()
                .list("snippet,contentDetails,statistics");
        ChannelListResponse response = request.setKey(DEVELOPER_KEY)
                .setForUsername("Gronkh")
                .execute();


        ChannelSnippet snippet = response.getItems().get(0).getSnippet();
        ChannelStatistics statistics = response.getItems().get(0).getStatistics();

        //UCYJ61XIK64sp6ZFFS8sctxw

        Youtuber abc = new Youtuber(snippet.getTitle(), snippet.getDescription(),statistics.getSubscriberCount());
        return abc;
    }
}