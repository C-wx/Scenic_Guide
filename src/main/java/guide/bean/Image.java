package guide.bean;

public class Image {
    private Integer id;

    private String origintype;

    private Integer originid;

    private String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigintype() {
        return origintype;
    }

    public void setOrigintype(String origintype) {
        this.origintype = origintype == null ? null : origintype.trim();
    }

    public Integer getOriginid() {
        return originid;
    }

    public void setOriginid(Integer originid) {
        this.originid = originid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}