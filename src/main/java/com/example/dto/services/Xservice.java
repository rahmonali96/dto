package com.example.dto.services;

import com.example.dto.model.X;
import com.example.dto.repos.Xrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Xservice {
    private final Xrepo xrepo;

    @Autowired
    public Xservice(Xrepo xrepo) {
        this.xrepo = xrepo;
    }
    public List<X> findAll(){
        return xrepo.findAll();
    }
    public int save(X x){
        return xrepo.save(x);
    }
}
