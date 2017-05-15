package com.sniffydn.sandbox.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class JSONTester {

    public static void main(String[] args) {
        JSONObject original = new JSONObject("{\"0\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201862\",\"addr\":\"10.1.0.145\",\"user\":\"bkuske\",\"viewing\":\"Table Selection\"},\"1\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201862,1201824,1201736,1201730,1201697\",\"addr\":\"10.1.0.145\",\"user\":\"bkuske\",\"viewing\":\"Table Selection\"},\"2\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201730\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"},\"3\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201730\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Open Tab\"},\"4\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201730\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Open Tab\"},\"5\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201866\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"},\"6\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201866,1201862,1201824,1201736,1201730\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"},\"7\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201697\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"},\"8\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201866\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"},\"9\":{\"bdoClass\":\"OrderMaster\",\"bdoId\":\"1201866,1201862,1201824,1201736,1201730\",\"addr\":\"10.1.0.145\",\"user\":\"dnyffeler\",\"viewing\":\"Table Selection\"}}");

        System.out.println(original.toString(2));

        JSONObject obj = new JSONObject();

        for (int i = 0; i <= 9; i++) {
            JSONObject temp = original.getJSONObject(i + "");
            JSONObject converted = new JSONObject();
            JSONObject convertedChild = new JSONObject();
            convertedChild.put("user", temp.getString("user"));
            convertedChild.put("viewing", temp.getString("viewing"));
            converted.put(temp.getString("bdoId"), convertedChild);
            obj.append(temp.getString("bdoClass"), converted);
        }

        System.out.println("\n\n\n\n" + obj.toString(2));

        obj = new JSONObject();
        Map<String, JSONObject> userClassTypeToObjectMap = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            JSONObject temp = original.getJSONObject(i + "");
            String key = temp.getString("user") + temp.getString("bdoClass") + temp.getString("viewing").replaceAll(Pattern.quote("Clear"), "").trim();
            if (temp.getString("viewing").contains("Clear")) {
                userClassTypeToObjectMap.remove(key);
            } else {
                userClassTypeToObjectMap.put(key, temp);
            }

        }

        Set<String> keys = userClassTypeToObjectMap.keySet();
        for (String key : keys) {
            JSONObject temp = userClassTypeToObjectMap.get(key);
            JSONObject converted = new JSONObject();
            JSONObject convertedChild = new JSONObject();
            convertedChild.put("user", temp.getString("user"));
            convertedChild.put("viewing", temp.getString("viewing"));
            converted.put(temp.getString("bdoId"), convertedChild);
            obj.append(temp.getString("bdoClass"), converted);
        }
        System.out.println("\n\n\n\n" + obj.toString(2));

    }
}
