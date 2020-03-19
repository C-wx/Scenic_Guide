package guide.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Explain    富文本上传组件返回的json实体类
 */
public class NkUploader implements Serializable {

    public static final String SUCCESS = "000";
    public static final String ERROR = "001";

    private String code;
    private String message;
    private Map<String, Object> item = new HashMap<>();

    public NkUploader ok(String url) {
        NkUploader json = new NkUploader();
        json.setCode(SUCCESS);
        json.setMessage(message);
        item.put("url", url);
        json.setItem(item);
        return json;
    }

    public NkUploader err(String message) {
        NkUploader json = new NkUploader();
        json.setCode(ERROR);
        json.setMessage(message);
        return json;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getItem() {
        return item;
    }

    public void setItem(Map<String, Object> item) {
        this.item = item;
    }
}
