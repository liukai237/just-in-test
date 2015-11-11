package com.magalan;

import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertFalse;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Kai on 11/11/15.
 */
public class JsonPathMapTest {
    private JsonPathMap jsonPathMap;

    private String json = "{\"projectName\": \"CCLOUD\",\n" +
            "    \"buildNumber\": 1,\n" +
            "    \"jobName\": {\n" +
            "        \"actions\": {\n" +
            "            \"param\": \"value\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    @Before
    public void setUp() throws IOException {
        jsonPathMap = JsonPathMap.with(json);
    }

    @Test
    public void testIsPathExistWithExistedPathReturnTrue() {
        assertTrue(jsonPathMap.isPathExist("$.jobName.actions"));
    }

    @Test
    public void testIsPathExistWithValidPathReturnFalse() {
        assertFalse(jsonPathMap.isPathExist("validPath"));
    }

    @Test
    public void testGetStrSuccess() {
        assertEquals("CCLOUD", jsonPathMap.getStr("$.projectName"));
    }

    @Test
    public void testGetIntSuccess() {
        assertTrue(jsonPathMap.getInt("$.buildNumber") == 1);
    }

}
