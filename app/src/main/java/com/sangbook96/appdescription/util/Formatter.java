package com.sangbook96.appdescription.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    public static String formatDateToString(String format_date)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat output = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = null;
        try {
            d = sdf.parse(format_date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedTime = output.format(d);
        return formattedTime;
    }

}
