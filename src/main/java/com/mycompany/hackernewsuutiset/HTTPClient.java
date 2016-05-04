
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
		try {
            URLConnection urlConn = openConnection(URLString);
			if (isValid(urlConn)) {
                InputStreamReader in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
                readConnection(bufferedReader, sb);
                in.close();
            }
		} catch (Exception e) {
			throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
		return sb.toString();
	}

    public static boolean isValid(URLConnection urlConn) throws IOException {
        return urlConn != null && urlConn.getInputStream() != null;
    }

    public static URLConnection openConnection(String URLString) throws IOException, MalformedURLException {
        URL url = new URL(URLString);
        URLConnection urlConn = url.openConnection();
        if (urlConn != null)
            urlConn.setReadTimeout(60 * 1000);
        return urlConn;
    }

    public static void readConnection(BufferedReader bufferedReader, StringBuilder sb) throws IOException {
        if (bufferedReader != null) {
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            bufferedReader.close();
        }
    }
}
