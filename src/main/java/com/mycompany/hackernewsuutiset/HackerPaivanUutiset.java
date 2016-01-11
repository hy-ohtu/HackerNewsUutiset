
package com.mycompany.hackernewsuutiset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.paivanuutiset.PaivanUutiset;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HackerPaivanUutiset implements PaivanUutiset {
    
    private static Gson gson = new Gson();
    private String suosituimmatURL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private String viimeisinURL = "https://hacker-news.firebaseio.com/v0/newstories.json";
    private String yksittainenURL = "https://hacker-news.firebaseio.com/v0/item/";
    
    @Override
    public String haeSuosituinUutinen() {
        String suosituimmat = HTTPClient.callURL(suosituimmatURL);
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL(yksittainenURL + suosituin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        return "Suosituin uutinen on " + uutinen.toString();
    }

    @Override
    public String haeViimeisinUutinen() {
        String uusimmat = HTTPClient.callURL(viimeisinURL);
        uusimmat = uusimmat.replace("[", "");
        uusimmat = uusimmat.replace("]", "");
        String[] array = uusimmat.split(",");
        int viimeisin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL(yksittainenURL + viimeisin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        return "Viimeisin uutinen on " + uutinen.toString();
    }

    public String getSuosituimmatURL() {
        return suosituimmatURL;
    }

    public String getViimeisinURL() {
        return viimeisinURL;
    }

    public void setSuosituimmatURL(String suosituimmatURL) {
        this.suosituimmatURL = suosituimmatURL;
    }

    public void setViimeisinURL(String viimeisinURL) {
        this.viimeisinURL = viimeisinURL;
    }

    public void setYksittainenURL(String yksittainenURL) {
        this.yksittainenURL = yksittainenURL;
    }

    public String getYksittainenURL() {
        return yksittainenURL;
    }
}
