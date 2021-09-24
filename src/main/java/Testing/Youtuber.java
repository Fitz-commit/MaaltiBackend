package Testing;

public class Youtuber {

    String name;
    String description;
    String subcount;

    public Youtuber(String name, String description, String subcount) {
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

    public String getSubcount() {
        return subcount;
    }

    public void setSubcount(String subcount) {
        this.subcount = subcount;
    }
}
