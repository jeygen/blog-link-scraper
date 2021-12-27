package com.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Class for scrapping the links from Austin Vernon's blog.
 */
public class AustVern {
    private String url;
    private Document doc;
    private Elements links;

    public AustVern() {
        this.url = "https://austinvernon.site/";
        try {
            this.doc = Jsoup.connect(url).get();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Warning! AustVern has IOException");
        }
        this.links = doc.select("a[href]");
    }

    @Override
    public String toString() {
        String s = "";
        for (Element link : links) {
           // System.out.println("Links: " + link.attr("abs:href"));
            s = link.attr("abs:href");
        }
        return s + "\nDONE Austin Vernon";
    }
}