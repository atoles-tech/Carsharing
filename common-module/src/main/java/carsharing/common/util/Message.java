package carsharing.common.util;

import java.io.Serializable;

public class Message implements Serializable {

    private Object obj;
    private MessageType type;

    public Message(Object obj, MessageType type){
        this.obj = obj;
        this.type = type;
    }

    public Object getData() {
        return obj;
    }

    public MessageType getType() {
        return type;
    }
}
