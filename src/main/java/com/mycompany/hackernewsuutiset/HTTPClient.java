
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
		InputStreamReader in = null;
		try {
			URLConnection urlConn = createUrlConnection(URLString);
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
		in.close();
		} catch (Exception e) {
			throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
		return sb.toString();
	}

    private static URLConnection createUrlConnection(String URLString) throws IOException, MalformedURLException {
        URL url = new URL(URLString);
        URLConnection urlConn = url.openConnection();
        urlConn.setReadTimeout(60 * 1000);
        return urlConn;
    }
}
