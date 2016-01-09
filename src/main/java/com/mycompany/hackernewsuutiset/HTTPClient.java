
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
			urlConn = openConnection(URLString);
			if (isValid(urlConn)) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
                                readConnection(bufferedReader, sb);
			}
                        in.close();
		} catch (Exception e) {
			throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
		return sb.toString();
	}

    private static boolean isValid(URLConnection urlConn) throws IOException {
        return urlConn != null && urlConn.getInputStream() != null;
    }

    private static URLConnection openConnection(String URLString) throws IOException, MalformedURLException {
        URLConnection urlConn;
        URL url = new URL(URLString);
        urlConn = url.openConnection();
        System.out.println("merde");
        if (urlConn != null)
            urlConn.setReadTimeout(60 * 1000);
        return urlConn;
    }

    private static void readConnection(BufferedReader bufferedReader, StringBuilder sb) throws IOException {
        if (bufferedReader != null) {
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            bufferedReader.close();
        }
    }
}
