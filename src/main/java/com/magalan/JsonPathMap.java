package com.magalan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;

/**
 * Created by Kai on 11/8/15.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPathMap<K, V> extends LinkedHashMap<K, V> {
    private String jsonStr;

    private static ObjectMapper OBJECTMAPPER;

    private JsonPathMap() {
    }

    public static JsonPathMap with(String json) {
        OBJECTMAPPER = new ObjectMapper();
        JsonPathMap<String, Object> map = null;
        try {
            map = OBJECTMAPPER.readValue(json, JsonPathMap.class);
            StringWriter str = new StringWriter();
            OBJECTMAPPER.writeValue(str, map);
            map.setJsonStr(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public String search(String jsonPath) {
        return JsonPath.read(jsonStr, jsonPath).toString();
    }

    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }
}
