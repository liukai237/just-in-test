package com.magalan.nexus;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GAVBuilderTest {
    @Test
    public void should_get_a_correct_gav_when_params_are_full() {
        String g = "org.apache.ivy";
        String a = "apache-ivy";
        String v = "2.2.0";
        String r = "forge";
        String p = "zip"; // the same packing in pom.xml
        String c = "bin";
        String e = "tar.gz"; // packaging would be ignored if it's not empty

        GAV gav = new GAVBuilder(g, a)
                .setVersion(v)
                .setRepository(r)
                .setPackaging(p)
                .setClassifier(c)
                .setExtension(e)
                .get();
        assertThat(gav.getGroupId(), is(g));
        assertThat(gav.getArtifactId(), is(a));
        assertThat(gav.getVersion(), is(v));
        assertThat(gav.getRepository(), is(r));
        assertThat(gav.getPackaging(), is(p));
        assertThat(gav.getClassifier(), is(c));
        assertThat(gav.getExtension(), is(e));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throws_an_exception_when_groupId_is_null() {
        new GAVBuilder(null, "foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throws_an_exception_when_artifactId_is_empty() {
        new GAVBuilder("foo", "");
    }
}