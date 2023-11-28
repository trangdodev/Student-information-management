
package studentma;

import java.io.Serializable;
public class RequestSendToServer_Rating implements Serializable {

    public String type;
    public String value;
    public String nganh;
    public String hangMuc;

    /// viet du thua 
    public RequestSendToServer_Rating(String type, String value, String nganh,  String hangMuc) {
        this.type = type;
        this.value = value;
        this.nganh = nganh;
        this.hangMuc = hangMuc;
    }

    public RequestSendToServer_Rating(String type, String value) {
        this.type = type;
        this.value = value;
    }
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}