package com.example.dto.controller;

import com.example.dto.services.DataService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequestMapping("/download")
public class ReportController {
    private final DataService dataService;

    @Autowired
    public ReportController(DataService dataService) {
        this.dataService = dataService;
    }

    @SneakyThrows
    @GetMapping
    public ResponseEntity<Resource> download(){
        File file = dataService.report();
        InputStreamResource in = new InputStreamResource(new FileInputStream(file));
        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.xls");
        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(in);
    }

}
