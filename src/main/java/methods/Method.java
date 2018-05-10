package methods;

import com.jayway.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;

import static com.jayway.restassured.RestAssured.get;

public class Method {
    public JSONObject getMethod(String path){
        Response resp = get(path);
        JSONObject jsonResponse = null;
        try {
            jsonResponse = new JSONObject(resp.asString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
