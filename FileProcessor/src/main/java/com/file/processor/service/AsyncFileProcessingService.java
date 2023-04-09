package com.file.processor.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Log4j2
@Service("AsyncFileProcessingService")
public class AsyncFileProcessingService extends FileProcessingService{

    @Async("asyncExecutor")
    public Future<String> processFile(MultipartFile file) throws IOException, InterruptedException {
        log.info("Thread going to sleep");
        Thread.sleep(3000);
        log.info("Thread out of sleep");
        String response = parseFile(file);
        return CompletableFuture.completedFuture(response);
    }
}
