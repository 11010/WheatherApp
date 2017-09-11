package bodor.com.wheatherapp.helper;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class Helper {
    static String stream = null;
    public Helper(){}

    public String getHttpData(String urlString){
        try {
            URL url  = new URL(urlString);
            HttpURLConnection httpURLConnection = null;
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (httpURLConnection.getResponseCode()==200){
                    BufferedReader r = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = r.readLine())!=null){
                        stringBuilder.append(line);
                        stream = stringBuilder.toString();
                        httpURLConnection.disconnect();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return  stream;
    }

}
