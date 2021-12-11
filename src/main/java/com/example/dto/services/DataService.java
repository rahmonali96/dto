package com.example.dto.services;

import com.example.dto.repos.DataRepo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class DataService {
    private final DataRepo dataRepo;

    @Autowired
    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public File report(){
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Test");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(dataRepo.findAll().get(0).getName());
        File file = createFile();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;

    }
    private File createFile(){
        return new File("report.xls");
    }
}
