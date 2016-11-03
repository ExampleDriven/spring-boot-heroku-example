package org.exampledriven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping
    public String hello() {
        logger.debug("Hello worker called");
        return "Hello from worker";
    }

}
