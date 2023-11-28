package studentma;

import java.io.Serializable;

public class RequestSendToServer implements Serializable {

    public String type;
    public Object value;

    public RequestSendToServer(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
