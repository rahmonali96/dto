package com.example.dto.controller;

import com.example.dto.model.Model;
import com.example.dto.model.X;
import com.example.dto.model.Y;
import com.example.dto.services.ModelService;
import com.example.dto.services.Xservice;
import com.example.dto.services.Yservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;
    private final Xservice xservice;
    private final Yservice yservice;

    public ModelController(ModelService modelService, Xservice xservice, Yservice yservice) {
        this.modelService = modelService;
        this.xservice = xservice;
        this.yservice = yservice;
    }

    @PostMapping
    public boolean model(@RequestBody Model model){
        return modelService.divide(model);
    }
    @GetMapping("/allx")
    public List<X> allx(){
        return xservice.findAll();
    }
    @GetMapping("/ally")
    public List<Y> ally(){
        return yservice.findAll();
    }

}
