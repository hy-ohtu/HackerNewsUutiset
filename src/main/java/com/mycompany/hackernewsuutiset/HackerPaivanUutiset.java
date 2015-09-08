
package com.mycompany.hackernewsuutiset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.mycompany.paivanuutiset.PaivanUutiset;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HackerPaivanUutiset implements PaivanUutiset {
    
    private static Gson gson = new Gson();
    private static String newStoriesUrl = "https://hacker-news.firebaseio.com/v0/newstories.json";
    private static String topStoriesUrl = "https://hacker-news.firebaseio.com/v0/topstories.json";

    @Override
    public String haeSuosituinUutinen() {
        Uutinen uutinen = getNewsStoryByFirstItemInJsonFile(topStoriesUrl);
        return "Suosituin uutinen on " + uutinen.toString();
    }

    @Override
    public String haeViimeisinUutinen() {
        Uutinen uutinen = getNewsStoryByFirstItemInJsonFile(newStoriesUrl);
        return "Viimeisin uutinen on " + uutinen.toString();
    }

    private Uutinen getNewsStoryByFirstItemInJsonFile(final String url) throws JsonSyntaxException, NumberFormatException {
        String jsonList = HTTPClient.callURL(url);
        int newsItemId = getFirstIntegerInJsonList(jsonList);
        System.out.println("");
        return getNewsStoryById(newsItemId);
    }

    private int getFirstIntegerInJsonList(final String jsonList) throws NumberFormatException {
        String[] array = parseJsonList(jsonList);
        return Integer.parseInt(array[0]);
    }

    private String[] parseJsonList(String jsonString) {
        jsonString = jsonString.replace("[", "");
        jsonString = jsonString.replace("]", "");
        System.out.println("");
        return jsonString.split(",");
    }
    
    private Uutinen getNewsStoryById(final int newsId) throws JsonSyntaxException {
        final String url = getNewsStoryUrl(newsId);
        String vastaus = HTTPClient.callURL(url);
        System.out.println("");
        return gson.fromJson(vastaus, Uutinen.class);
    }

    private String getNewsStoryUrl(final int newsId) {
        return "https://hacker-news.firebaseio.com/v0/item/" + newsId + ".json?print=pretty";
    }
}
