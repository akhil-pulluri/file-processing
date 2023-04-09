package com.file.processor.controller;

import com.file.processor.service.SyncFileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/sync")
public class SyncFileProcessor {

    @Autowired
    @Qualifier("SyncFileProcessingService")
    private SyncFileProcessingService syncFileProcessingService;

    @RequestMapping(value = "/processFile", method = RequestMethod.POST)
    public String syncFileProcess(@RequestParam("file") MultipartFile file) throws IOException {
        return syncFileProcessingService.processFile(file);
    }
}
