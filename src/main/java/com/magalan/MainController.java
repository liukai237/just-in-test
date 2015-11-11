package com.magalan;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Kai on 11/8/15.
 */
@RestController
public class MainController {
    @RequestMapping(value = "/test", produces = "application/json")
    public boolean test(@RequestBody String json) {
        System.out.println(json);
        try {
            System.out.println("==>" + JsonPathMap.with(json).getStr("$.projectName"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
