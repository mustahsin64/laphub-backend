package com.laphub.laphub_backend.service;

import com.laphub.laphub_backend.model.Laptop;
import com.laphub.laphub_backend.model.LaptopBrand;
import com.laphub.laphub_backend.model.LaptopLabel;
import com.laphub.laphub_backend.repository.LaptopRepository;
import com.laphub.laphub_backend.specification.LaptopSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
        existing.setSpecification(updated.getSpecification());
        existing.setReleaseYear(updated.getReleaseYear());
        existing.setLabel(updated.getLabel());
        existing.setLink(updated.getLink());
        existing.setNewRelease(updated.isNewRelease());
        existing.setLikeCount(updated.getLikeCount());

        return repository.save(existing);
    }

    public List<Laptop> filterLaptops(Integer releaseYear, LaptopLabel label, LaptopBrand brand, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Laptop> spec = LaptopSpecification.filterBy(releaseYear, label, brand, minPrice, maxPrice);
        return repository.findAll(spec);
    }

    public void deleteLaptop(String id) {
        repository.deleteById(id);
    }
}