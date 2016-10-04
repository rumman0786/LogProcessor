import java.util.Comparator;

/**
 * Created by rumman on 10/4/16.
 */
public class Log {
    int hour;
    private int serverTime;
    private int httpGetFrequency;
    private int httpPostFrequency;

    public Log() {
        this.serverTime = 0;
        this.httpGetFrequency = 0;
        this.httpPostFrequency= 0;
    }
        public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getServerTime() {
        return serverTime;
    }

    public void setServerTime(int serverTime) {
        this.serverTime = serverTime;
    }

    public int getHttpGetFrequency() {
        return httpGetFrequency;
    }

    public void setGetFrequency(int getFrequency) {
        this.httpGetFrequency = getFrequency;
    }

    public int getHttpPostFrequency() {
        return httpPostFrequency;
    }

    public void setPostFrequency(int postFrequency) {
        this.httpPostFrequency= postFrequency;
    }

    @Override
    public String toString() {
        return "Hour:" + hour +
                "\t ServerTime:" + serverTime +"ms"+
                "\t HTTPGetFrequency:" + httpGetFrequency +
                "\t HTTPPostFrequency:" + httpPostFrequency ;
    }
}
