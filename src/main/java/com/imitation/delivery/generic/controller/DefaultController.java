package com.imitation.delivery.generic.controller;

import com.imitation.delivery.generic.Model;
import com.imitation.delivery.generic.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public class DefaultController <T extends Model, S extends DefaultService<T, ?>> {


    @Autowired
    public S service;

    @PostMapping("/create")
    public T save(@RequestBody T entity) {
        return service.save(entity);
    }

    @GetMapping("/getAll")
    public Collection<T> get() {
        return service.findAll();
    }

    @GetMapping("/get/{id}")
    public T get(@PathVariable Long id) {
        return service.findOne(id);
    }

    @PutMapping("/update")
    public T update(@RequestBody T entity) {
        return service.save(entity);
    }

}
