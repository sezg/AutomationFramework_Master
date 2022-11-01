package com.envision.automation.framework.utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    public JSONObject mainJsonObj;

    public JSONObject getMainJsonObject() {
        return mainJsonObj;
    }

    public void loadTestDataFile(String fileName) throws IOException, ParseException {
        File jsonFile = new File(
                System.getProperty("user.dir")
                        + "/src/test/resources/testData/"+fileName);

        JSONParser parser = new JSONParser();
        Object jsonFileObject = parser.parse(new FileReader(jsonFile));
        this.mainJsonObj = (JSONObject) jsonFileObject;

    }

    public JSONObject getJsonObject(JSONObject jsonObject, String jsonObjectName) {
        return (JSONObject) jsonObject.get(jsonObjectName);
    }

    public String getJsonObjectValue(JSONObject jsonObject, String key) {
        return jsonObject.get(key).toString();
    }





    public static void main(String[] args) throws IOException, ParseException {
        JsonUtils jsonUtils = new JsonUtils();
        jsonUtils.loadTestDataFile("testData.json");

        JSONObject loginData = jsonUtils.getJsonObject(jsonUtils.mainJsonObj, "loginData");
        String userName = jsonUtils.getJsonObjectValue(loginData, "username");
        String passWord = jsonUtils.getJsonObjectValue(loginData, "password");

        System.out.println(userName +"="+ passWord);
    }
}
