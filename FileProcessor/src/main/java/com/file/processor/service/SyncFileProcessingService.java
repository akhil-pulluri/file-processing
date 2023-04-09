package com.file.processor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("SyncFileProcessingService")
public class SyncFileProcessingService extends FileProcessingService{
    public String processFile(MultipartFile file) throws IOException {
        return parseFile(file);
    }
}
