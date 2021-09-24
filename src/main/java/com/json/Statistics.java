
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
    "viewCount",
    "subscriberCount",
    "hiddenSubscriberCount",
    "videoCount"
})
@Generated("jsonschema2pojo")
public class Statistics {

    @JsonProperty("viewCount")
    private String viewCount;
    @JsonProperty("subscriberCount")
    private String subscriberCount;
    @JsonProperty("hiddenSubscriberCount")
    private Boolean hiddenSubscriberCount;
    @JsonProperty("videoCount")
    private String videoCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Statistics() {
    }

    /**
     * 
     * @param videoCount
     * @param subscriberCount
     * @param viewCount
     * @param hiddenSubscriberCount
     */
    public Statistics(String viewCount, String subscriberCount, Boolean hiddenSubscriberCount, String videoCount) {
        super();
        this.viewCount = viewCount;
        this.subscriberCount = subscriberCount;
        this.hiddenSubscriberCount = hiddenSubscriberCount;
        this.videoCount = videoCount;
    }

    @JsonProperty("viewCount")
    public String getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("subscriberCount")
    public String getSubscriberCount() {
        return subscriberCount;
    }

    @JsonProperty("subscriberCount")
    public void setSubscriberCount(String subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    @JsonProperty("hiddenSubscriberCount")
    public Boolean getHiddenSubscriberCount() {
        return hiddenSubscriberCount;
    }

    @JsonProperty("hiddenSubscriberCount")
    public void setHiddenSubscriberCount(Boolean hiddenSubscriberCount) {
        this.hiddenSubscriberCount = hiddenSubscriberCount;
    }

    @JsonProperty("videoCount")
    public String getVideoCount() {
        return videoCount;
    }

    @JsonProperty("videoCount")
    public void setVideoCount(String videoCount) {
        this.videoCount = videoCount;
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
        sb.append(Statistics.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("viewCount");
        sb.append('=');
        sb.append(((this.viewCount == null)?"<null>":this.viewCount));
        sb.append(',');
        sb.append("subscriberCount");
        sb.append('=');
        sb.append(((this.subscriberCount == null)?"<null>":this.subscriberCount));
        sb.append(',');
        sb.append("hiddenSubscriberCount");
        sb.append('=');
        sb.append(((this.hiddenSubscriberCount == null)?"<null>":this.hiddenSubscriberCount));
        sb.append(',');
        sb.append("videoCount");
        sb.append('=');
        sb.append(((this.videoCount == null)?"<null>":this.videoCount));
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
        result = ((result* 31)+((this.videoCount == null)? 0 :this.videoCount.hashCode()));
        result = ((result* 31)+((this.viewCount == null)? 0 :this.viewCount.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.hiddenSubscriberCount == null)? 0 :this.hiddenSubscriberCount.hashCode()));
        result = ((result* 31)+((this.subscriberCount == null)? 0 :this.subscriberCount.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Statistics) == false) {
            return false;
        }
        Statistics rhs = ((Statistics) other);
        return ((((((this.videoCount == rhs.videoCount)||((this.videoCount!= null)&&this.videoCount.equals(rhs.videoCount)))&&((this.viewCount == rhs.viewCount)||((this.viewCount!= null)&&this.viewCount.equals(rhs.viewCount))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.hiddenSubscriberCount == rhs.hiddenSubscriberCount)||((this.hiddenSubscriberCount!= null)&&this.hiddenSubscriberCount.equals(rhs.hiddenSubscriberCount))))&&((this.subscriberCount == rhs.subscriberCount)||((this.subscriberCount!= null)&&this.subscriberCount.equals(rhs.subscriberCount))));
    }

}
