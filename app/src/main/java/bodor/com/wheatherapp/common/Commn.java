package bodor.com.wheatherapp.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/11 0011.
 */

public class Commn {
//    api.openweathermap.org/data/2.5/weather?lat=35&lon=139
    public static String API_KEY = "1bdc0c2569b008a8de6826d6ed41d9cb";
    public static String API_LINK = "api.openweathermap.org/data/2.5/weather";


    public static String apiNeedRequest(String lat,String lon){
        StringBuilder stringBuilder = new StringBuilder(API_LINK);
        stringBuilder.append(String.format("?lat=s%&lon=s%&APPID=s%&units=metric",lat,lon,API_KEY));
        return stringBuilder.toString();
    }

    public static String unixTimeStampToDateTimes(double unixTimeStamp){
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        date.setTime((long) (unixTimeStamp*1000));
        return dateFormat.format(date);
    }

    public static String getImage(String icon){
        return String.format("http://openweathermap.org/img/w/s%.png",icon);
    }

    public static String getDataNow(){
        DateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy HH:MM");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
