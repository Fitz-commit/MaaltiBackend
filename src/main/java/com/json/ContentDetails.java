
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
    "relatedPlaylists"
})
@Generated("jsonschema2pojo")
public class ContentDetails {

    @JsonProperty("relatedPlaylists")
    private RelatedPlaylists relatedPlaylists;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ContentDetails() {
    }

    /**
     * 
     * @param relatedPlaylists
     */
    public ContentDetails(RelatedPlaylists relatedPlaylists) {
        super();
        this.relatedPlaylists = relatedPlaylists;
    }

    @JsonProperty("relatedPlaylists")
    public RelatedPlaylists getRelatedPlaylists() {
        return relatedPlaylists;
    }

    @JsonProperty("relatedPlaylists")
    public void setRelatedPlaylists(RelatedPlaylists relatedPlaylists) {
        this.relatedPlaylists = relatedPlaylists;
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
        sb.append(ContentDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("relatedPlaylists");
        sb.append('=');
        sb.append(((this.relatedPlaylists == null)?"<null>":this.relatedPlaylists));
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
        result = ((result* 31)+((this.relatedPlaylists == null)? 0 :this.relatedPlaylists.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ContentDetails) == false) {
            return false;
        }
        ContentDetails rhs = ((ContentDetails) other);
        return (((this.relatedPlaylists == rhs.relatedPlaylists)||((this.relatedPlaylists!= null)&&this.relatedPlaylists.equals(rhs.relatedPlaylists)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
