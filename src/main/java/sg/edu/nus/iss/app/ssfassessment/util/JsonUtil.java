package sg.edu.nus.iss.app.ssfassessment.util;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class JsonUtil {
    public static String notFoundJson(String orderId) {
        JsonObject jObj = Json.createObjectBuilder()
                .add("message", "Order %s not found".formatted(orderId))
                .build();
        return jObj.toString();
    }
}
