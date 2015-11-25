package com.magalan.utils;

import com.magalan.utils.JXPathUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kai on 11/24/15.
 */
public class JXPathUtilTest {
    @Test
    public void testJXPathUtilSuccess() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("foo", "bar");
        assertEquals(JXPathUtil.getValue(map, "foo"), "bar");
        assertEquals(JXPathUtil.getStrValue(map, "foo"), "bar");

        Map<String, String> map2 = new HashMap<>();
        map2.put("foo", "bar");
        assertEquals(JXPathUtil.getValue(map2, "foo"), "bar");
        assertEquals(JXPathUtil.getStrValue(map2, "foo"), "bar");
    }
}
