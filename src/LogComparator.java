import java.util.Comparator;

/**
 * Created by rumman on 10/4/16.
 */
public class LogComparator implements Comparator<Log>{
    public int compare(Log log1, Log log2) {
        if (log1.getServerTime() == log2.getServerTime() ) {
            if(log1.getHttpPostFrequency() == log2.getHttpPostFrequency()){

                if(log1.getHttpGetFrequency() == log2.getHttpGetFrequency()){
                    return 0;
                }else if (log1.getHttpGetFrequency() < log2.getHttpGetFrequency()){
                    return 1;
                }else{
                    return -1;
                }

            }else if (log1.getHttpPostFrequency() < log2.getHttpPostFrequency()  ){
                return 1;
            }else{
                return -1;
            }

        }else if (log1.getServerTime() < log2.getServerTime() ){
            return 1;
        }else{
            return -1;
        }
    }
}
