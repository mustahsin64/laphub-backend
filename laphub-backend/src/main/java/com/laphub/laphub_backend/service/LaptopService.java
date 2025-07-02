package com.laphub.laphub_backend.service;

import com.laphub.laphub_backend.model.Laptop;
import com.laphub.laphub_backend.repository.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository repository;

    public LaptopService(LaptopRepository repository) {
        this.repository = repository;
    }

    public List<Laptop> getAllLaptops() {
        return repository.findAll();
    }

    public Laptop getLaptopById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public Laptop createLaptop(Laptop laptop){
        return repository.save(laptop);
    }

    public Laptop updateLaptop(String id, Laptop updated){
        Laptop existing = repository.findById(id).orElseThrow();
        existing.setName(updated.getName());
        existing.setBrand(updated.getBrand());
        existing.setPrice(updated.getPrice());
        existing.setImageUrl(updated.getImageUrl());
        existing.setDescription(updated.getDescription());
        return repository.save(existing);
    }

    public void deleteLaptop(String id) {
        repository.deleteById(id);
    }

}


































