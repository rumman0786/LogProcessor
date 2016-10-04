/**
 * Created by rumman on 10/4/16.
 */
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class LogParser {
    public static void main(String [] args){
        LogParser logParser = new LogParser();
        String input_uri  = logParser.getURL();
        String file_location = "./resources/sample.log";
        Log [] logArray = new Log[24];
        for(int i = 0 ; i < logArray.length; i++){
            logArray[i] = new Log();
            logArray[i].setHour(i);
        }
        logParser.readFile(logParser, file_location, input_uri, logArray);
        logParser.printStats(logArray);
    }


    public void readFile(LogParser logParser,String file_location, String input_uri,Log [] logArray) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file_location));
            String line = br.readLine();
            while (line != null) {
                if(line.contains("DEBUG - URI")){
                    String [] fragments = line.split(" ");
                    int responseTimeIndex = fragments.length - 1;
                    int httpMethodIndex = fragments.length - 2;
                    int URIIndex = fragments.length - 3;
    //                    int dateIndex = 0;
                    int timeIndex = 1;

    //                    String date = fragments[dateIndex];
                    String time = fragments[timeIndex].substring(0,8);
                    String uri = fragments[URIIndex].substring(5,fragments[URIIndex].length()-2);
                    String httpMethod = fragments[httpMethodIndex].substring(0, 1);
                    String responseTime = fragments[responseTimeIndex].substring(5,fragments[responseTimeIndex].length()-2);

                    if(uri.equals(input_uri)){
                        int index = Integer.parseInt(time.substring(0,2));
                        if(httpMethod.equals("G")){
                            logArray[index].setGetFrequency(logArray[index].getHttpGetFrequency() + 1);
                        }else{
                            // Must be POST
                            logArray[index].setPostFrequency(logArray[index].getHttpPostFrequency() + 1);
                        }
                        logArray[index].setServerTime(logArray[index].getServerTime() + Integer.parseInt(responseTime));
                    }
                }
                line = br.readLine();
            }
            //Appropriate Exception Handling
        }catch (FileNotFoundException fe){
            fe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public String getURL() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter a URL pattern below:\n");
        String input_uri  = in.nextLine();
        return input_uri;
    }

    public void printStats(Log [] logArray) {
        LogComparator logComparator = new LogComparator();
        Arrays.sort(logArray, logComparator);
        for(int i = 0 ; i < logArray.length ; i++){
            System.out.println(logArray[i]);
        }
    }
}
