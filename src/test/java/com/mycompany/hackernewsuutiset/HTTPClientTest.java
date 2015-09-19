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
    
    @Test(expected=RuntimeException.class)
    public void virheellinenUrlAiheuttaaExceptionin(){
        client.callURL("https://hacker-news.firebeio.com/v0/topstories.json");
    }
    
    @Test
    public void oikeaOsoitePalauttaaString(){
        assertThat(client.callURL("https://hacker-news.firebaseio.com/v0/topstories.json"),instanceOf(String.class));
    }
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
