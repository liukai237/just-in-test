package com.magalan.nexus;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

/**
 * Created by Kai on 2016/5/16.
 */
public class GAVBuilder {
    private static final String DEFAULT_REPOSITORY = "central-proxy";
    private static final String DEFAULT_VERSION = "LATEST";

    /**
     * Required
     **/
    private String groupId;
    private String artifactId;

    /**
     * Defaulted
     **/
    private String version;
    private String repository;

    /**
     * Optional
     **/
    private String packaging;
    private String classifier;
    private String extension;

    private GAVBuilder() {
    }

    public GAVBuilder(String groupId, String artifactId) {
        String msg = " should not be empty!";
        if (Strings.isNullOrEmpty(groupId)) {
            throw new IllegalArgumentException("groupId" + msg);
        }
        if (Strings.isNullOrEmpty(artifactId)) {
            throw new IllegalArgumentException("artifactId" + msg);
        }

        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public GAV get() {
        this.version = Optional.fromNullable(version).or(DEFAULT_VERSION);
        this.repository = Optional.fromNullable(repository).or(DEFAULT_REPOSITORY);
        GAV gav = new GAV(groupId, artifactId, version, repository);
        gav.setPackaging(packaging);
        gav.setClassifier(classifier);
        gav.setExtension(extension);
        return gav;
    }

    public GAVBuilder setVersion(String version) {
        this.version = version;
        return this;
    }

    public GAVBuilder setRepository(String repository) {
        this.repository = repository;
        return this;
    }

    public GAVBuilder setClassifier(String classifier) {
        this.classifier = classifier;
        return this;
    }

    public GAVBuilder setPackaging(String packaging) {
        this.packaging = packaging;
        return this;
    }

    public GAVBuilder setExtension(String extension) {
        this.extension = extension;
        return this;
    }
}
