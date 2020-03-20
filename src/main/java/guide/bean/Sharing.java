package guide.bean;

import java.util.Date;
import java.util.List;

public class Sharing {
    private Integer id;

    private Integer attractionid;

    private String wxid;

    private String content;

    private Date publishtime;

    private User user;  //发布者

    private List<Image> imageList;  //评论图片列表

    private Attraction attraction;  //发布源

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttractionid() {
        return attractionid;
    }

    public void setAttractionid(Integer attractionid) {
        this.attractionid = attractionid;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid == null ? null : wxid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }
}