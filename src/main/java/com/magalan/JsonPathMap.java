package com.magalan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;

/**
 * Created by Kai on 11/8/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPathMap extends LinkedHashMap {
    private String jsonStr;

    private static ObjectMapper OBJECTMAPPER;

    private JsonPathMap() {
    }

    public static JsonPathMap with(String json) throws IOException {
        OBJECTMAPPER = new ObjectMapper();
        JsonPathMap map = OBJECTMAPPER.readValue(json, JsonPathMap.class);
        StringWriter writer = new StringWriter();
        OBJECTMAPPER.writeValue(writer, map);
        map.setJsonStr(writer.toString());
        writer.close();
        return map;
    }

    public String getStr(String jsonPath) {
        return JsonPath.read(jsonStr, jsonPath).toString();
    }

    public Integer getInt(String jsonPath) {
        return JsonPath.read(jsonStr, jsonPath);
    }

    boolean isPathExist(String jsonPath) {
        boolean isExist = true;
        try{
            JsonPath.read(this.jsonStr, jsonPath);
        } catch(PathNotFoundException e) {
            isExist = false;
        }
        return isExist;
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}
