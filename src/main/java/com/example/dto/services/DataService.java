package com.example.dto.services;

import com.example.dto.model.User;
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
import java.util.List;

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
        List<User> users = dataRepo.findAll();
        for (int i = 0; i < users.size(); i++) {
            Row r = sheet.createRow(i+6);
            r.createCell(4).setCellValue(users.get(i).getId());
            r.createCell(5).setCellValue(users.get(i).getName());
            r.createCell(6).setCellValue(users.get(i).getPhone());
        }

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
