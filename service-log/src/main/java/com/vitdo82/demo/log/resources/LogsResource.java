package com.vitdo82.demo.log.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LogsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsResource.class);

    @PostMapping("/logs")
    public void log(@RequestBody List<Integer> message) {
        LOGGER.info("{}", message);
    }
}
