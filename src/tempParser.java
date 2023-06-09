//wow this class sucks
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class tempParser {
    public static ArrayList<String> animeList;
    public static ArrayList<String> animeList2;
    public static ArrayList<String> animePicture;
    public static ArrayList<Integer> animeIDList;
    public static ArrayList<String> wordList;
    public static ArrayList<String> quotesList;

    public tempParser() {
        this.animeList = new ArrayList<String>();
        this.animeList2 = new ArrayList<String>();
        this.animePicture = new ArrayList<String>();
        this.animeIDList = new ArrayList<Integer>();
        this.wordList = new ArrayList<String>();
        this.quotesList = new ArrayList<String>();
    }

    public static void plswork() {
        String endpoint = "https://api.myanimelist.net/v2/anime/ranking?ranking_type=all&limit=500";
        String url = endpoint;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().header("X-MAL-CLIENT-ID", "0db950674f429006c3ee9393aae7cb43").uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        JSONObject jsonObj = new JSONObject(urlResponse);

        JSONArray jsonArr = jsonObj.getJSONArray("data");
        for (int i = 0; i < jsonArr.length(); i++) {
            JSONObject animeObj = jsonArr.getJSONObject(i);
            JSONObject nodeObject = animeObj.getJSONObject("node");
            String animeTitle = nodeObject.getString("title");
            JSONObject pictureObject = nodeObject.getJSONObject("main_picture");
            String pictureLink = pictureObject.getString("large");
            int animeID = nodeObject.getInt("id");

            String endpoint2 = "https://api.myanimelist.net/v2/anime/" + animeID + "?fields=id,title,main_picture,alternative_titles,,pictures";
            String url2 = endpoint2;
            String urlResponse2 = "";
            try {
                URI myUri = URI.create(url2); // creates a URI object from the url string
                HttpRequest request = HttpRequest.newBuilder().header("X-MAL-CLIENT-ID", "b200a682d5914597f44531e947b9a442").uri(myUri).build();
                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                urlResponse2 = response.body();
//                System.out.println(urlResponse2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            JSONObject jsonObj2 = new JSONObject(urlResponse2);
            JSONArray jsonArr2 = jsonObj2.getJSONArray("pictures");
            JSONObject altTitles = jsonObj2.getJSONObject("alternative_titles");

//            String animeTitle = jsonObj2.getString("title");
            animeTitle += " / " + altTitles.getString("en");
            animeList.add(animeTitle);

            if (selectPicture(i) == 5000) {
                animePicture.add(pictureLink);
//                System.out.println(pictureLink);
            }   else    {
                JSONObject morePictures = jsonArr2.getJSONObject(selectPicture(i));
//                System.out.println(morePictures);
                animePicture.add(morePictures.getString("large"));
            }
        }
    }

    private static int selectPicture(int pic) {
        if (pic == 0) {
            return 4;
        }
        if (pic == 1) {
            return 8;
        }
        if (pic == 2) {
            return 1;
        }
        if (pic == 3) {
            return 5;
        }
        if (pic == 4) {
            return 1;
        }
        if (pic == 9) {
            return 0;
        }
        if (pic == 17) {
            return 2;
        }
        if (pic == 18) {
            return 0;
        }
        if (pic == 19) {
            return 2;
        }
        if (pic == 21) {
            return 3;
        }
        if (pic == 25) {
            return 1;
        }
        if (pic == 26) {
            return 1;
        }
        if (pic == 28) {
            return 5;
        }
        if (pic == 32) {
            return 1;
        }
        if (pic == 37) {
            return 1;
        }
        if (pic == 39) {
            return 1;
        }
        if (pic == 40) {
            return 1;
        }
        if (pic == 41) {
            return 9;
        }
        if (pic == 43) {
            return 0;
        }
        if (pic == 47) {
            return 1;
        }
        if (pic == 52) {
            return 1;
        }
        if (pic == 55) {
            return 0;
        }
        if (pic == 56) {
            return 3;
        }
        if (pic == 57) {
            return 1;
        }
        if (pic == 63) {
            return 2;
        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }
//        if (pic == 0) {
//            return 4;
//        }

        return 5000;
    }

    public static void plswork2() {
        String endpoint = "https://random-word-api.vercel.app/api?words=500";
        String url = endpoint;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
//            System.out.println(urlResponse);
            JSONArray jsonArr = new JSONArray(urlResponse);
            for (int i = 0; i < jsonArr.length(); i++) {
                wordList.add(jsonArr.get(i).toString());
            }
//            System.out.println(wordList.get((int) Math.random() * wordList.size()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void plswork3() {
        for (int i = 0; i < 30; i++) {
            String endpoint = "https://kyoko.rei.my.id/api/quotes.php";
            String url = endpoint;
            String urlResponse = "";
            try {
                URI myUri = URI.create(url); // creates a URI object from the url string
                HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                urlResponse = response.body();
//                System.out.println(urlResponse);
                JSONObject jsonObj = new JSONObject(urlResponse);
                JSONArray jsonArr = jsonObj.getJSONArray("apiResult");
                JSONObject jsonObj2 = jsonArr.getJSONObject(0);
//            System.out.println(jsonObj2);
                quotesList.add(jsonObj2.getString("english"));
//                System.out.println(quotesList.get(0));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
