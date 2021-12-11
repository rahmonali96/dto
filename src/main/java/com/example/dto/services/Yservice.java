package com.example.dto.services;

import com.example.dto.model.X;
import com.example.dto.model.Y;
import com.example.dto.repos.Xrepo;
import com.example.dto.repos.YRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Yservice {
    private final YRepo yRepo;

    @Autowired
    public Yservice(YRepo yRepo) {
        this.yRepo = yRepo;
    }

    public List<Y> findAll(){
        return yRepo.findAll();
    }
    public boolean save(Y y){
        return yRepo.save(y);
    }
}
