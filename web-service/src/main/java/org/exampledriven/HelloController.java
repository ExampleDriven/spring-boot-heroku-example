package org.exampledriven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/")
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    WorkerConfig workerConfig;

    @GetMapping
    public String hello() {
        logger.debug("Hello web was called");
        return "Message from worker (" + workerConfig.getURL() +") is : " + restTemplate.getForObject(workerConfig.getURL(), String.class, "");
    }

}
