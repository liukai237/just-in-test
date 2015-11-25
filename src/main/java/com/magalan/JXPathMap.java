package com.magalan;

import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.xml.DocumentContainer;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Kai on 11/19/15.
 */
public class JXPathMap {
    private JXPathContext context;

    public JXPathMap start() throws URISyntaxException {
        context = JXPathContext.newContext(this);
        context.setLenient(true);
        return this;
    }

    public String getStr(String xpath) {
        return (String)context.getValue(xpath);
    }
}
