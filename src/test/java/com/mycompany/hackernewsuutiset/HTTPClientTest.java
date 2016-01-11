package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import org.hamcrest.CoreMatchers;
import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;

public class HTTPClientTest {
    
    private String wiremockUrl = "http://localhost:8089/";
    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);
    
    @Test
    public void isValidTest() throws IOException {
        URLConnection connection = Mockito.mock(URLConnection.class);
        Mockito.when(connection.getInputStream()).thenReturn(Mockito.mock(InputStream.class));
        assertTrue(HTTPClient.isValid(connection));
        assertFalse(HTTPClient.isValid(null));
    }
    
    @Test
    public void openConnectionTest() throws Exception {
        stubFor(get(urlEqualTo("/con"))
            .willReturn(aResponse()
                .withStatus(200)));
        URLConnection connection = HTTPClient.openConnection(wiremockUrl + "/con");
        assertEquals(wiremockUrl + "/con", connection.getURL().toString());
    }
    
    @Test
    public void readConnectionTest() throws Exception {
        BufferedReader readerMock = Mockito.mock(BufferedReader.class);
        Mockito.when(readerMock.read()).thenReturn(79, 89, -1);
        StringBuilder buffer = new StringBuilder();
        HTTPClient.readConnection(readerMock, buffer);
        assertEquals("OY", buffer.toString());
    }
    
    @Test
    public void readURLTest() throws Exception {
        stubFor(get(urlEqualTo("/read"))
            .willReturn(aResponse()
                .withStatus(200)
                .withBody("samutamm")));
        assertThat(HTTPClient.callURL(wiremockUrl + "read"), CoreMatchers.containsString("samutamm"));
    }
}