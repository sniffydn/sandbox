package com.sniffydn.sandbox.core;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author dnyffeler
 */
public class TrelloTest {

    private static String trelloUrlPrefix = "https://api.trello.com/1";
    private static String key = "e8d639b63c5780d1d7e2f20ab33253cb";
    private static String token = "6bca0bc0e5e1db0ce9aa80d1466fb5aa6247c0bc0a36c3d8c8d41b85ffa14684";
    private static String trelloUrlSuffix = "?key=" + key + "&token=" + token;
    private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
    private static String idBoard = "53c541f4f7ebdbbc498a5043";//board id
    private static String idList = "53c541f4f7ebdbbc498a5045";//list on the board


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JSONObject card = createCard();
        JSONObject checklist = addChecklist(card);
        addChecklistItem(card, checklist, "Item Text");
    }

    public static JSONObject createCard() {
        Map<String, Object> params = new HashMap<>();
        params.put("key", key);
        params.put("token", token);
        params.put("idList", idList);
        params.put("name", "Test Card " + sdf.format(new Date()));
        params.put("desc", "Description");
        params.put("due", System.currentTimeMillis());

        String url = trelloUrlPrefix + "/cards";
        try {
            HttpRequestWithBody request = Unirest.post(url);
            request.fields(params);
            HttpResponse<String> response = request.asString();
            if (200 == response.getStatus()) {
                JSONObject json = new JSONObject(response.getBody());
                System.out.println(json.toString(2));

                return json;
            } else {
                System.out.println("createCard Url: " + url + " Status:" + response.getStatus());
                System.out.println("     " + response.getBody());
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage() + " " + url);
        }
        return null;
    }

    public static void getBoards() {
        String url = trelloUrlPrefix + "/member/me/boards" + trelloUrlSuffix;
        try {
            GetRequest request = Unirest.get(url);

            HttpResponse<String> response = request.asString();
            if (200 == response.getStatus()) {
                JSONArray json = new JSONArray(response.getBody());

                System.out.println(json.toString(2));
            } else {
                System.out.println("Url: " + url + " Status:" + response.getStatus());
                System.out.println("     " + response.getBody());
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage() + " " + url);
        }
    }

    private static JSONObject addChecklist(JSONObject cardJson) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", key);
        params.put("token", token);
        params.put("idBoard", idBoard);
        params.put("idChecklistSource", "");
        params.put("idCard", cardJson.get("id"));
        params.put("name", "Timeframe");

        String url = trelloUrlPrefix + "/checklists";
        try {
            HttpRequestWithBody request = Unirest.post(url);
            request.fields(params);
            HttpResponse<String> response = request.asString();
            if (200 == response.getStatus()) {
                JSONObject retVal = new JSONObject(response.getBody());
                System.out.println(retVal.toString(2));

                return retVal;
            } else {
                System.out.println("addChecklist Url: " + url + " Status:" + response.getStatus());
                System.out.println("     " + response.getBody());
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage() + " " + url);
        }
        return null;
    }

    private static void addChecklistItem(JSONObject card, JSONObject checklist, String text) {
        Map<String, Object> params = new HashMap<>();
        params.put("key", key);
        params.put("token", token);
        params.put("name", text);

        String url = trelloUrlPrefix + "/cards/" + card.getString("id") + "/checklist/" + checklist.getString("id") + "/checkItem";
        try {
            HttpRequestWithBody request = Unirest.post(url);
            request.fields(params);
            HttpResponse<String> response = request.asString();
            if (200 == response.getStatus()) {
                JSONObject retVal = new JSONObject(response.getBody());
                System.out.println(retVal.toString(2));

            } else {
                System.out.println("addChecklistItem Url: " + url + " Status:" + response.getStatus());
                System.out.println("     " + response.getBody());
            }
        } catch (UnirestException ex) {
            System.out.println(ex.getMessage() + " " + url);
        }
    }
}
