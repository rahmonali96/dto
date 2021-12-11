package com.example.dto.repos;

import com.example.dto.model.X;
import com.example.dto.model.Y;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Repository
public class YRepo {

    private List<Y> yList;

    @PostConstruct
    public void init(){
        yList = new ArrayList<>();
    }
    public List<Y> findAll(){
        return yList;
    }
    public boolean save(Y y){
        return yList.add(y);
    }
}
