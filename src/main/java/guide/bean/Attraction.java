package guide.bean;

import java.util.List;

public class Attraction {
    private Integer id;

    private String title;

    private String brief;

    private String detail;

    private String location;

    private String imglocation;

    private Integer punchnum;

    private Integer currentnum;

    private List<Image> imageList;      //图片列表

    private List<Sharing> sharingList;  //当前景点下的说说

    private String type;  //操作类型

    private Boolean hidden;   //是否显示

    private Boolean like;       //是否已收藏

    private Boolean punch;      //是否已打卡

    /**
     * 显示框位置
     */
    private String frameTop;
    private String frameLeft;
    /**
     * 显示点位置
     */
    private String pointLeft;
    private String pointTop;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getImglocation() {
        return imglocation;
    }

    public void setImglocation(String imglocation) {
        this.imglocation = imglocation == null ? null : imglocation.trim();
    }

    public Integer getPunchnum() {
        return punchnum;
    }

    public void setPunchnum(Integer punchnum) {
        this.punchnum = punchnum;
    }

    public Integer getCurrentnum() {
        return currentnum;
    }

    public void setCurrentnum(Integer currentnum) {
        this.currentnum = currentnum;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public String getFrameTop() {
        return frameTop;
    }

    public void setFrameTop(String frameTop) {
        this.frameTop = frameTop;
    }

    public String getFrameLeft() {
        return frameLeft;
    }

    public void setFrameLeft(String frameLeft) {
        this.frameLeft = frameLeft;
    }

    public String getPointLeft() {
        return pointLeft;
    }

    public void setPointLeft(String pointLeft) {
        this.pointLeft = pointLeft;
    }

    public String getPointTop() {
        return pointTop;
    }

    public void setPointTop(String pointTop) {
        this.pointTop = pointTop;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public Boolean getPunch() {
        return punch;
    }

    public void setPunch(Boolean punch) {
        this.punch = punch;
    }

    public List<Sharing> getSharingList() {
        return sharingList;
    }

    public void setSharingList(List<Sharing> sharingList) {
        this.sharingList = sharingList;
    }
}