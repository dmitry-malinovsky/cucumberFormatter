package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RestUtils {

    public static String get(String url) throws IOException {
        HttpURLConnection conn = setConnection(url);
        try {
            conn.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty("Accept", "application/json");
        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    public static String post(String url, String json) throws IOException {
        HttpURLConnection conn = setConnection(url);
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes());
        os.flush();

        String response = readResponse(conn);
        conn.disconnect();
        return response;
    }

    private static HttpURLConnection setConnection(String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            return (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String readResponse(HttpURLConnection conn) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return br.readLine();
    }
}
