package com.magalan.utils;

import org.apache.commons.io.IOUtils;
import org.apache.commons.jxpath.JXPathContext;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Kai on 11/23/15.
 */
public class JXPathUtil {
    private static JXPathContext context;

    private JXPathUtil() {}

    public static Object getValue(Object obj, String xpath) throws IOException {
        return getContext(obj).getValue(xpath);
    }

    public static String getStrValue(Object obj, String xpath) throws IOException {
        return (String) getContext(obj).getValue(xpath);
    }

    private static JXPathContext getContext(Object obj) {
        context = JXPathContext.newContext(obj);
        context.setLenient(true);
        return context;
    }
}
