package com.example.dto.services;

import com.example.dto.model.Model;
import com.example.dto.model.X;
import com.example.dto.model.Y;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelService {
    private final Xservice xservice;
    private final Yservice yservice;

    @Autowired
    public ModelService(Xservice xservice, Yservice yservice) {
        this.xservice = xservice;
        this.yservice = yservice;
    }
    public boolean divide(Model model){
        int resx = xservice.save(new X(model.getX()));
        if (resx == 10){
            return yservice.save(new Y(resx * model.getY()));
        }else{
            return false;
        }
    }
}
