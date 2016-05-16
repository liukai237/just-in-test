package com.magalan.nexus;

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
        if (isNullOrEmpty(groupId)) {
            throw new IllegalArgumentException("groupId" + msg);
        }
        if (isNullOrEmpty(artifactId)) {
            throw new IllegalArgumentException("artifactId" + msg);
        }

        this.groupId = groupId;
        this.artifactId = artifactId;
    }

    public GAV get() {
        this.version = isNullOrEmpty(version) ? DEFAULT_VERSION : version;
        this.repository = isNullOrEmpty(repository) ? DEFAULT_REPOSITORY : repository;
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

    public GAVBuilder setArtifactId(String artifactId) {
        this.artifactId = artifactId;
        return this;
    }

    public GAVBuilder setClassifier(String packaging) {
        this.packaging = packaging;
        return this;
    }

    public GAVBuilder setPackageing(String classifier) {
        this.classifier = classifier;
        return this;
    }

    public GAVBuilder setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    //TODO replace it with guava api
    private boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }
}
