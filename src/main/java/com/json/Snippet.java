
package com.json;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "description",
    "customUrl",
    "publishedAt",
    "thumbnails",
    "localized"
})
@Generated("jsonschema2pojo")
public class Snippet {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("customUrl")
    private String customUrl;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("thumbnails")
    private Thumbnails thumbnails;
    @JsonProperty("localized")
    private Localized localized;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Snippet() {
    }

    /**
     * 
     * @param customUrl
     * @param publishedAt
     * @param localized
     * @param description
     * @param title
     * @param thumbnails
     */
    public Snippet(String title, String description, String customUrl, String publishedAt, Thumbnails thumbnails, Localized localized) {
        super();
        this.title = title;
        this.description = description;
        this.customUrl = customUrl;
        this.publishedAt = publishedAt;
        this.thumbnails = thumbnails;
        this.localized = localized;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("customUrl")
    public String getCustomUrl() {
        return customUrl;
    }

    @JsonProperty("customUrl")
    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("thumbnails")
    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    @JsonProperty("thumbnails")
    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    @JsonProperty("localized")
    public Localized getLocalized() {
        return localized;
    }

    @JsonProperty("localized")
    public void setLocalized(Localized localized) {
        this.localized = localized;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Snippet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("customUrl");
        sb.append('=');
        sb.append(((this.customUrl == null)?"<null>":this.customUrl));
        sb.append(',');
        sb.append("publishedAt");
        sb.append('=');
        sb.append(((this.publishedAt == null)?"<null>":this.publishedAt));
        sb.append(',');
        sb.append("thumbnails");
        sb.append('=');
        sb.append(((this.thumbnails == null)?"<null>":this.thumbnails));
        sb.append(',');
        sb.append("localized");
        sb.append('=');
        sb.append(((this.localized == null)?"<null>":this.localized));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.customUrl == null)? 0 :this.customUrl.hashCode()));
        result = ((result* 31)+((this.publishedAt == null)? 0 :this.publishedAt.hashCode()));
        result = ((result* 31)+((this.localized == null)? 0 :this.localized.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.thumbnails == null)? 0 :this.thumbnails.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Snippet) == false) {
            return false;
        }
        Snippet rhs = ((Snippet) other);
        return ((((((((this.customUrl == rhs.customUrl)||((this.customUrl!= null)&&this.customUrl.equals(rhs.customUrl)))&&((this.publishedAt == rhs.publishedAt)||((this.publishedAt!= null)&&this.publishedAt.equals(rhs.publishedAt))))&&((this.localized == rhs.localized)||((this.localized!= null)&&this.localized.equals(rhs.localized))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.thumbnails == rhs.thumbnails)||((this.thumbnails!= null)&&this.thumbnails.equals(rhs.thumbnails))));
    }

}
