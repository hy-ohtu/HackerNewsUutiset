/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hackernewsuutiset;

import com.google.gson.Gson;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

/**
 *
 * @author santeri
 */
class Title {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

public class HackerPaivanUutisetTest {
    Gson gson;
    HackerPaivanUutiset uutiset;

    
    @Before
    public void setUp() {
          gson = new Gson();
          uutiset = new HackerPaivanUutiset();
          uutiset.setUrl("http://localhost:8080");
    }
    
    @Test
    public void suosituinUutinenPalauttaaSuosituimman(){
        String suosituimmat = HTTPClient.callURL("http://localhost:8080/v0/topstories.json");
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL("http://localhost:8080/v0/item/" + suosituin + ".json?print=pretty");
        Title title = gson.fromJson(vastaus, Title.class);
        assertTrue(uutiset.haeSuosituinUutinen().contains(title.getTitle()));
    }
    
    @Test
    public void viimeisinUutinenPalauttaaViimeisimman(){
        String suosituimmat = HTTPClient.callURL("http://localhost:8080/v0/newstories.json");
        suosituimmat = suosituimmat.replace("[", "");
        suosituimmat = suosituimmat.replace("]", "");
        String[] array = suosituimmat.split(",");
        int suosituin = Integer.parseInt(array[0]);
        String vastaus = HTTPClient.callURL("http://localhost:8080/v0/item/" + suosituin + ".json?print=pretty");
        Title title = gson.fromJson(vastaus, Title.class);
        assertTrue(uutiset.haeViimeisinUutinen().contains(title.getTitle()));
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
