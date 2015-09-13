
package com.mycompany.hackernewsuutiset;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.paivanuutiset.PaivanUutiset;

import java.lang.reflect.Array;
import java.util.Arrays;

public class HackerPaivanUutiset implements PaivanUutiset {
    
    private static Gson gson = new Gson();

    @Override
    public String haeSuosituinUutinen() {
        String suosituimmat = HTTPClient.callURL("https://hacker-news.firebaseio.com/v0/topstories.json");
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL("https://hacker-news.firebaseio.com/v0/item/" + suosituin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        System.out.println("");
	 System.out.println("");
 System.out.println("");
 System.out.println("");
	
 return "Suosituin uutinen on " + uutinen.toString();
    }

    @Override
    public String haeViimeisinUutinen() {
        String uusimmat = HTTPClient.callURL("https://hacker-news.firebaseio.com/v0/newstories.json");
        uusimmat = uusimmat.replace("[", "");
        uusimmat = uusimmat.replace("]", "");
        String[] array = uusimmat.split(",");
        int viimeisin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL("https://hacker-news.firebaseio.com/v0/item/" + viimeisin + ".json?print=pretty");
        Uutinen uutinen = gson.fromJson(vastaus, Uutinen.class);
        return "Viimeisin uutinen on " + uutinen.toString();
    }
    
}
