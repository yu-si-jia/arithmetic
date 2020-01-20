package arit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(getBeforeByHourTime(18));
    }

    public static String getBeforeByHourTime(int ihour){
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }
}
