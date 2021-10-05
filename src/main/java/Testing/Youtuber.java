package Testing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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


    public Youtuber(String name, String description, String country, String profilbild, int creationdate, String creatorid, String customURL, BigInteger viewcount, BigInteger videocount, BigInteger subcount, boolean madeforkids, List topics) {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getSubcount() {
        return subcount;
    }

    public void setSubcount(BigInteger subcount) {
        this.subcount = subcount;
    }
}
