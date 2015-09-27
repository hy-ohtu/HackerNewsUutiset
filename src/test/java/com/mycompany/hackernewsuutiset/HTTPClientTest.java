/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hackernewsuutiset;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

/**
 *
 * @author santeri
 */
public class HTTPClientTest {
    HTTPClient client;
    
    
    @Before
    public void setUp() {
        client = new HTTPClient();
    }
    
    
    @Test
    public void oikeaOsoitePalauttaaString(){
        assertThat(client.callURL("http://localhost:8080/v0/topstories.json"),instanceOf(String.class));
    }
    
}
