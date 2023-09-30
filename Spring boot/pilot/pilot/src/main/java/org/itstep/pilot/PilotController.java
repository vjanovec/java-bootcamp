package org.itstep.pilot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PilotController {

    @RequestMapping("/")
    public String index() {
        return "I am pilot";
    }
}
