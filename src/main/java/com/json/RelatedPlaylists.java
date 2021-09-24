
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
    "likes",
    "uploads"
})
@Generated("jsonschema2pojo")
public class RelatedPlaylists {

    @JsonProperty("likes")
    private String likes;
    @JsonProperty("uploads")
    private String uploads;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RelatedPlaylists() {
    }

    /**
     * 
     * @param likes
     * @param uploads
     */
    public RelatedPlaylists(String likes, String uploads) {
        super();
        this.likes = likes;
        this.uploads = uploads;
    }

    @JsonProperty("likes")
    public String getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(String likes) {
        this.likes = likes;
    }

    @JsonProperty("uploads")
    public String getUploads() {
        return uploads;
    }

    @JsonProperty("uploads")
    public void setUploads(String uploads) {
        this.uploads = uploads;
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
        sb.append(RelatedPlaylists.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("uploads");
        sb.append('=');
        sb.append(((this.uploads == null)?"<null>":this.uploads));
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.likes == null)? 0 :this.likes.hashCode()));
        result = ((result* 31)+((this.uploads == null)? 0 :this.uploads.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof RelatedPlaylists) == false) {
            return false;
        }
        RelatedPlaylists rhs = ((RelatedPlaylists) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&((this.likes == rhs.likes)||((this.likes!= null)&&this.likes.equals(rhs.likes))))&&((this.uploads == rhs.uploads)||((this.uploads!= null)&&this.uploads.equals(rhs.uploads))));
    }

}
