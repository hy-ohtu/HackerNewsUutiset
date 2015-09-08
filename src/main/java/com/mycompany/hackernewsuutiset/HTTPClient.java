
package com.mycompany.hackernewsuutiset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;


public class HTTPClient {
    public static String callURL(String URLString) {
		InputStreamReader in = null;
		try {
			URLConnection urlConn = createUrlConnection(URLString);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
                                        String result = readFully(bufferedReader);
					bufferedReader.close();
                                        return result;
				}
			}
		in.close();
                        return "";
		} catch (Exception e) {
			throw new RuntimeException("Virhe hakiessa osoitteesta: "+ URLString, e);
		} 
	}

    private static URLConnection createUrlConnection(String URLString) throws IOException, MalformedURLException {
        URL url = new URL(URLString);
        URLConnection urlConn = url.openConnection();
        urlConn.setReadTimeout(60 * 1000);
        return urlConn;
    }

    private static String readFully(Reader bufferedReader) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = bufferedReader.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
