package com.magalan.nexus;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class NexusClient {
    public static final String DEFAULT_NEXUS_WEB_SITE = "http://repository.sonatype.org";
    public static final String REDIRECT_MOUNT_POINT = "/service/local/artifact/maven/redirect";
    public static final String CONTENT_MOUNT_POINT = "/service/local/artifact/maven/content";
    public static final String RESOLVE_MOUNT_POINT = "/service/local/artifact/maven/resolve";

    @Autowired
    private RestTemplate restTemplate;

    public void download(GAV gav) {
        //TODO should using filesystem
        Object forObject = restTemplate.getForObject(DEFAULT_NEXUS_WEB_SITE + REDIRECT_MOUNT_POINT + transfer(gav), Object.class);
        System.out.println();
    }

    public String query(GAV gav) {
        //TODO should add exception handling
        return restTemplate.getForObject(DEFAULT_NEXUS_WEB_SITE + RESOLVE_MOUNT_POINT + transfer(gav), String.class);
    }

    protected String transfer(GAV gav) {
        String template = "?r=%s&g=%s&a=%s&v=%s";
        String formatted = String.format(template, gav.getRepository(), gav.getGroupId(), gav.getArtifactId(), gav.getVersion());

        String packaging = gav.getPackaging();
        if (!Strings.isNullOrEmpty(packaging)) {
            formatted += "&p=" + packaging;
        }

        String classifier = gav.getClassifier();
        if (!Strings.isNullOrEmpty(classifier)) {
            formatted += "&c=" + classifier;
        }

        String extension = gav.getExtension();
        if (!Strings.isNullOrEmpty(extension)) {
            formatted += "&e=" + extension;
        }
        return formatted;
    }
}
