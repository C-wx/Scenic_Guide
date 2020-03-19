package guide.bean;

public class Navigation {
    private Integer id;

    private Integer startid;

    private Integer endid;

    private String route;

    private String img;

    private String startName;   //起点名称

    private String endName;     //终点名称

    private String type;        //操作类型

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStartid() {
        return startid;
    }

    public void setStartid(Integer startid) {
        this.startid = startid;
    }

    public Integer getEndid() {
        return endid;
    }

    public void setEndid(Integer endid) {
        this.endid = endid;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route == null ? null : route.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getStartName() {
        return startName;
    }

    public void setStartName(String startName) {
        this.startName = startName;
    }

    public String getEndName() {
        return endName;
    }

    public void setEndName(String endName) {
        this.endName = endName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}