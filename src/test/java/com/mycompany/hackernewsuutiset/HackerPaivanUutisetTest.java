package com.mycompany.hackernewsuutiset;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;

public class HackerPaivanUutisetTest {

    private HackerPaivanUutiset uutiset;
    private String wiremockUrl = "http://localhost:8089/";
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);
    
    @Before
    public void setup() {
        this.uutiset = new HackerPaivanUutiset();
        stubFor(get(urlEqualTo("/haku"))
            .willReturn(aResponse()
                .withStatus(200)
                .withBody("[4444]")));
        String yksittainenURL = "/4444.json?print=pretty";
        stubFor(get(urlEqualTo(yksittainenURL))
            .willReturn(aResponse()
                .withStatus(200)
                .withBody("{\n" +
                "  \"by\" : \"python_kiss\",\n" +
                "  \"descendants\" : 0,\n" +
                "  \"id\" : 1001,\n" +
                "  \"score\" : 3,\n" +
                "  \"time\" : 1172396128,\n" +
                "  \"title\" : \"Wireless: India's Hot, China's Not\",\n" +
                "  \"type\" : \"story\",\n" +
                "  \"url\" : \"http://www.redherring.com/Article.aspx?a=21355\"\n" +
                "}"))); 
        this.uutiset.setSuosituimmatURL(wiremockUrl + "haku");
        this.uutiset.setViimeisinURL(wiremockUrl + "haku");
        this.uutiset.setYksittainenURL(wiremockUrl);
    }
    
    @Test
    public void testHaeSuosituinUutinen() {
        assertThat(this.uutiset.haeSuosituinUutinen(), CoreMatchers.containsString("Suosituin"));
    }

    @Test
    public void testHaeViimeisinUutinen() {
        assertThat(this.uutiset.haeViimeisinUutinen(), CoreMatchers.containsString("Viimeisin"));
    }
    
}
