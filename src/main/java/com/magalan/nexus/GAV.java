package com.magalan.nexus;

/**
 * Created by Kai on 2016/5/16.
 */
public class GAV {
    public static final String DEFAULT_NEXUS = "http://repository.sonatype.org";
    public static final String DEFAULT_MOUNT_POINT = "/service/local/artifact/maven/redirect";

    private String groupId;
    private String artifactId;
    private String version;
    private String repository;

    private String packaging;
    private String classifier;
    private String extension;

    public GAV(String groupId, String artifactId, String version, String repository) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.repository = repository;
    }

    public String getRedirectUrl() {
        String base = "?r=%s&g=%s&a=%s&v=%s";
        String formated = String.format(base, this.repository, this.groupId, this.artifactId, this.version);
        if (!isNullOrEmpty(packaging)) {
            formated += "&p=" + packaging;
        }
        if (!isNullOrEmpty(classifier)) {
            formated += "&c=" + classifier;
        }
        if (!isNullOrEmpty(extension)) {
            formated += "&e=" + extension;
        }
        return formated;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    //TODO replace it with guava api
    private boolean isNullOrEmpty(String str) {
        return str == null || str.equals("");
    }
}
