package guide.bean;

public class User {
    private Integer id;

    private String wxid;

    private String wxname;

    private String wxavatar;

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

    public String getWxname() {
        return wxname;
    }

    public void setWxname(String wxname) {
        this.wxname = wxname == null ? null : wxname.trim();
    }

    public String getWxavatar() {
        return wxavatar;
    }

    public void setWxavatar(String wxavatar) {
        this.wxavatar = wxavatar == null ? null : wxavatar.trim();
    }
}