package csci4401.mc;

import java.io.Serializable;

public interface RemoteMessage extends Serializable {
    /**
     * @return the unique string identifier of the source
     */
    public String getSource();

    /**
     * @return content of the message
     */
    public Serializable getContent();
}
