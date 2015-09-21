package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class HTTPClient {

    public static String callURL(String URLString) {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            in = connect(URLString, in, sb);
            in.close();
        } catch (Exception e) {
            throw new RuntimeException("Virhe hakiessa osoitteesta: " + URLString, e);
        }
        return sb.toString();
    }

    public static InputStreamReader connect(String URLString, InputStreamReader in, StringBuilder sb) throws IOException, MalformedURLException {
        URLConnection urlConn;
        URL url = new URL(URLString);
        urlConn = url.openConnection();
        if (urlConn != null) {
            urlConn.setReadTimeout(60 * 1000);
        }
        if (urlConn != null && urlConn.getInputStream() != null) {
            in = new InputStreamReader(urlConn.getInputStream(),
                    Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
        return in;
    }
}
