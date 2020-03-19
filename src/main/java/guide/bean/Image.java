package guide.bean;

public class Image {
    private Integer id;

    private Integer attracttionid;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttracttionid() {
        return attracttionid;
    }

    public void setAttracttionid(Integer attracttionid) {
        this.attracttionid = attracttionid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}