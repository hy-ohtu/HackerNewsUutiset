package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

public class HTTPClient {

    private String URLString;
    private URL url;

    public HTTPClient(String URLString) {
        this.URLString = URLString;
        try {
            url = new URL(URLString);
        } catch (Exception e) {
            throw new RuntimeException("Virhe hakiessa osoitteesta: " + URLString, e);
        }

    }

    public String get() {
        try {
            return getDataFrom(ulrConnection());
    
        } catch (Exception e) {
            throw new RuntimeException("Virhe hakiessa osoitteesta: " + URLString, e);
        }
    }

    protected String getDataFrom(URLConnection urlConn) throws IOException {
        InputStreamReader in = new InputStreamReader(urlConn.getInputStream(),
                                                     Charset.defaultCharset());
        BufferedReader bufferedReader = new BufferedReader(in);
        
        String result = readBytesAsString(bufferedReader);
        
        bufferedReader.close();
        in.close();
        
        return result;
    }

    protected String readBytesAsString(BufferedReader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        int cp;
        while ((cp = bufferedReader.read()) != -1) {
            sb.append((char) cp);
        }
        
        return sb.toString();
    }

    protected URLConnection ulrConnection() throws IOException, RuntimeException {
        URLConnection urlConn = url.openConnection();

        if (urlConn == null || urlConn.getInputStream() == null) {
            throw new RuntimeException("Virhe hakiessa osoitteesta: " + URLString);
        }
        
        urlConn.setReadTimeout(60 * 1000);
        
        return urlConn;
    }
}
