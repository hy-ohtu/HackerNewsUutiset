
package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


public class HTTPClient {
    public static String callURL(String URLString) {
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		try {
                    URL url = new URL(URLString);
                    urlConn = url.openConnection();
                    read(urlConn, sb);
		} catch (Exception e) {
                    throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
		return sb.toString();
	}

    private static void read(URLConnection urlConn, StringBuilder sb) throws IOException {
        if (urlConn != null && urlConn.getInputStream() != null) {
            urlConn.setReadTimeout(60 * 1000);
            InputStreamReader in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            BufferedReader bufferedReader = new BufferedReader(in);
            if (bufferedReader != null) {
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
        }
    }
    
}
