package javaGui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;

public class SchoolMenu {
    public static String[] getMenu() throws IOException {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DATE);

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int idx = 0;
        if (hour > 19 || hour < 8)
            idx = 0;
        else if (hour >= 8 || hour <14)
            idx = 1;
        else
            idx = 2;
        String time[] = {"breakfast", "lunch", "dinner"};

        String url = "http://school.gyo6.net/gbsw/food/"+year+"/"+month+"/"+day+"/"+time[idx];
        Document doc = Jsoup.parse(new URL(url).openStream(), "utf-8", url);
        System.out.println(url);
        Element el1 = doc.getElementsByTag("td").get(2);



        String[] menus = el1.text().split(" ");
        return menus;
    }
}
