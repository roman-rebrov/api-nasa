package app;

import com.fasterxml.jackson.annotation.JsonProperty;

class NasaModel {
    private String date;
    private String explanation;
    private String copyright;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;


    public NasaModel(
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("copyright") String copyright,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.url = url;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return url;
    }
}
