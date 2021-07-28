package interview.hackerrank;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArticleTitles {

    static class Response {
        List<Data> data;

        public Response() {
        }

        public Response(List<Data> data) {
            this.data = data;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    static class Data {
        String title;

        public Data() {
        }

        public Data(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static List<String> getArticleTitles(String author) throws IOException {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String spec = "https://jsonmock.hackerrank.com/api/articles?author=" + author + "&page=" + i;
            URL url = new URL(spec);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("Content-Type", "application/json");
            InputStream is = connection.getInputStream();
            Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
            Response response = new Gson().fromJson(reader, Response.class);
            if (response.data.size() == 0) break;
            response.data.stream().map(data -> data.title).forEach(result::add);
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) throws IOException {
        getArticleTitles("epaga").forEach(System.out::println);
    }
}
