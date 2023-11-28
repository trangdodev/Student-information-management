package Common;

import java.io.Serializable;
public class Response_Rating implements Serializable {

    public String type;
    public Object data;

    public Response_Rating(String type, Object data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}

