package ru.akuzin.ugonamnet;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

    private static List<CloneFactory.Ugon> list;

    private static Document getPage(String param) throws IOException {
        String url = "http://ugonamnet.ru/avtoUgon/allUgons" + param;
        return Jsoup.parse(new URL(url), 3000);
    }

    //return date from string - 22.04
    //22.04
    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static String getDateFromString(String stringDate) throws Exception {
        Matcher matcher = pattern.matcher(stringDate);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new Exception("Can't extract date from string!");
    }
    private static void printRowValues(Element values) {
        for (Element td : values.select("td")) {
            System.out.print(td.text() + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Date\t\t\tTitle\t\tNumber\t\tColor\t\tAddress");
        int cntPage = 1; //for debug
        for (int i=0; i< cntPage; i++) {
            Document page = getPage((i==0)?"":"?p="+(i+1));
            Element ugonsList = page.select("div[class=ugons_list]").first();
            Elements rows = ugonsList.select("div[class^=news_item]");
            for (Element row : rows) {
                String dateString = row.select("div[class=news_date]").text() + " " + row.select("div[class=news_time]").text();
                String titleString = row.select("div[class=ugon_title] a").text();
                Elements number = row.select("div[class=entry_nomer]");
                String numberString = number.select("span[class=span]").text() + " " + number.select("span[class=region]").text();
                String colorString = row.select("div[class=ugon_color]").text().trim();
                String addressString = row.select("div[class=ugon_place]").text().trim();
                System.out.println(dateString + "\t" + titleString + "\t\t" + numberString +
                        "\t\t" + colorString + "\t\t" + addressString);
            }
        }
    }

    public static List<CloneFactory.Ugon> getList() {
        return list;
    }
}
