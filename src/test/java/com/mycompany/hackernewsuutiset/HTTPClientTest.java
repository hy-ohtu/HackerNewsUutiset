/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hackernewsuutiset;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import javax.naming.spi.DirStateFactory.Result;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Rule;

/**
 *
 * @author Jesse
 */
public class HTTPClientTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(18089);

    @Before
    public void init() {
        stubFor(get(urlEqualTo("/test.txt")).willReturn(
                aResponse().withStatus(200).withHeader("Content-Type", "text/plain").withBody("Hello test")));
        stubFor(get(urlEqualTo("/empty.txt")).willReturn(
                aResponse().withStatus(200).withHeader("Content-Type", "text/plain").withBody("")));
    }

    @Test
    public void ok() throws Exception {
        String actual = HTTPClient.callURL("http://localhost:18089/test.txt");
        String expected = "Hello test";
        assertThat(actual, is(expected));
    }

    @Test
    public void okEmpty() throws Exception {
        String actual = HTTPClient.callURL("http://localhost:18089/empty.txt");
        String expected = "";
        assertThat(actual, is(expected));
    }

    @Test(expected = RuntimeException.class)
    public void notFound() throws Exception {
        HTTPClient.callURL("http://localhost:18089/ImaginaryPath");
    }

}
