package com.example.dto.repos;

import com.example.dto.model.X;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Xrepo {

    private List<X> xList;

    @PostConstruct
    public void init(){
        xList = new ArrayList<>();
    }
    public List<X> findAll(){
        return xList;
    }
//    public boolean save(X x){
//        return xList.add(x);
//    }

    public int save(X x){
        return xList.add(x)?10:0;
    }
}
