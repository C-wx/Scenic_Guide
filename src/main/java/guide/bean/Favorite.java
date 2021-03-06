package guide.bean;

public class Favorite {
    private Integer id;

    private String wxid;

    private Integer attractionid;

    private Attraction attraction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }

    public Integer getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Integer attractionid) {
        this.attractionid = attractionid;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}