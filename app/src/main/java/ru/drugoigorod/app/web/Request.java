package ru.drugoigorod.app.web;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request {

    private final String url;

    public Request(String url) {
        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException("url is empty");
        }
        this.url = url;
    }

    public String request() throws RequestException {
        String result = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.setInstanceFollowRedirects(true);
            connection.connect();
            int code = connection.getResponseCode();
            if (code == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    stringBuilder.append(inputLine);
                }
                in.close();
                result = stringBuilder.toString();
            } else {
                throw new RequestException();
            }
        } catch (MalformedURLException e) {
            throw new RequestException(e);
        } catch (IOException e) {
            throw new RequestException(e);
        }
        return result;
    }

    public class RequestException extends Exception {

        public RequestException() {
            super();
        }

        public RequestException(Throwable e) {
            super(e);
        }

    }

}
