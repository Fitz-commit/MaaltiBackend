package Testing;

import java.math.BigInteger;

public class Youtuber {

    String name;
    String description;
    BigInteger subcount;

    public Youtuber(String name, String description, BigInteger subcount) {
        this.name = name;
        this.description = description;
        this.subcount = subcount;
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
