import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Input {

    static JSONParser parser = new JSONParser();


    public static JSONObject getJSONObject() throws Exception{
        JSONObject object = (JSONObject)parser.parse(new FileReader("src/test/resources/InputInfo"));
        return object;
    }

    static String site;
    static String login;
    static String password;
    static String nameUser;
    static String outputFileChrome;
    static String outputFileFireFox;
    static String outputFileIE;

    static {
        try {
            site = (String)getJSONObject().get("site");
            login = (String)getJSONObject().get("login");
            password = (String)getJSONObject().get("password");
            nameUser = (String)getJSONObject().get("nameUser");
            outputFileChrome = (String)getJSONObject().get("outputFileChrome");
            outputFileFireFox = (String)getJSONObject().get("outputFileFireFox");
            outputFileIE = (String)getJSONObject().get("outputFileIE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public static void main(String[] args) throws Exception {
//        JSONParser parser = new JSONParser();
//        obj = (JSONObject)parser.parse(new FileReader("src/test/resources/InputInfo"));
//        login = (String)obj.get("login");
//        site = (String)obj.get("site");
//        //System.out.println(site);
//        password = (String)obj.get("password");
//
//    }
   // public Input








//    static String site = "https://www.shop.by/";
//    static String login = "295408091";
//    static String password = "testuser1";


}
