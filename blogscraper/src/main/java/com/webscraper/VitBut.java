package com.webscraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Class for scrapping the links from Vitalik Buterin's blog.
 */
public class VitBut {
    private String url;
    private Document doc;
    private Elements links;

    public VitBut() {
        this.url = "https://vitalik.ca/";
        try {
            this.doc = Jsoup.connect(url).get();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Warning! VitBut has IOException");
        }
        this.links = doc.select("a[href]");
    }

    @Override
    public String toString() {
        for (Element link : links) {
            System.out.println("Links: " + link.attr("abs:href"));
        }
        return "DONE Vitalik Buterin";
    }
}