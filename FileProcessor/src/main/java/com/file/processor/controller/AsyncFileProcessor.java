package com.file.processor.controller;

import com.file.processor.service.AsyncFileProcessingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Log4j2
@RestController
@RequestMapping("/async")
public class AsyncFileProcessor {
    @Autowired
    @Qualifier("AsyncFileProcessingService")
    private AsyncFileProcessingService asyncFileProcessingService;

    @RequestMapping(value = "/processFile", method = RequestMethod.POST)
    public String asyncFileProcess(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException, ExecutionException {
        log.info("File processing Started");
        Future<String> future = asyncFileProcessingService.processFile(file);
        log.info("File processing InProgress");
        while(!future.isDone());
        log.info("File processing Completed");
        return future.get();
    }
}
