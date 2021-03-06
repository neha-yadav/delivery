package com.imitation.delivery.generic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;


public class DefaultService<T , R extends JpaRepository<T, Long>> {

    @Autowired
    public R repository;

    public T save(T entity) {
        repository.save(entity);
        return entity;
    }

    public List<T> saveAll(List<T> entities) {
        repository.saveAll(entities);
        return entities;
    }

    public Collection<T> findAll() {
        return repository.findAll();
    }

    public T findOne(Long id) {
        return repository.findById(id).get();
    }



}
