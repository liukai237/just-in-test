package com.magalan;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by Kai on 11/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=0", "spring.profiles.active=test"})
public class MainTest {
    @Value("${server.address}")
    String address;

    @Value("${local.server.port}")
    int port;

    @Autowired
    static TestRestTemplate restTemplate;

    @BeforeClass
    public static void setUp() {
        restTemplate = new TestRestTemplate();
    }

    @Test
    public void testMainControllerSuccess() {
        String url = "http://" + address + ":" + port + "/test";
        String json = "{\"projectName\": \"CCLOUD\",\n" +
                "    \"buildNumber\": 1,\n" +
                "    \"jobName\": {\n" +
                "        \"actions\": {\n" +
                "            \"param\": \"value\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
        ResponseEntity<Boolean> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Boolean.class);
        assertTrue(exchange.getStatusCode().is2xxSuccessful());
    }

}
