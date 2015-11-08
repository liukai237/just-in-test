package com.magalan;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Kai on 11/8/15.
 */
@RestController
public class MainController {
    @RequestMapping(value = "/test", produces = "application/json")
    public boolean test(@RequestBody String json) {
        System.out.println(json);
        System.out.println("==>" + JsonPathMap.with(json).search("$.projectName"));
        return true;
    }
}
