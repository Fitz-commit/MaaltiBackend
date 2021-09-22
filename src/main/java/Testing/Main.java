package Testing;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://api.instagram.com/oauth/authorize" +
                    "  ?client_id=594821241888095" +
                    "  &redirect_uri=https://insta-test-maalti.herokuapp.com/auth/" +
                    "  &scope=user_profile,user_media" +
                    "  &response_type=code"));
        }

        String urlStr = "https://insta-test-maalti.herokuapp.com/auth/?code=AQDSEvAP0_x2ygPdafU3i-XK_1ZRCZYlwdY93sZLHDTh0Mr7RW2grpv-N5vof-1dNFUyOsPNXDEFyYWg8LDaIoKDP_zSdGIX9x2n2PQ3ObOgH28NIk8MrdfehsnVLwJcscCly9Oreu1R9bKDw1CfWukHaA6eLCYJbf5TIT1A32WxppyLfjJHLu-oHqljZCIXipQvTelxwvsCt9zECCfIBmsN6i6WQewBL48zD8j-dxLGZQ#_";
        URL url = new URL(urlStr);
        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
        System.out.println((url.getQuery()));
        url = uri.toURL();
    }
}
