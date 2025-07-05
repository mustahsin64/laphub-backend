package com.laphub.laphub_backend.controller;


import com.laphub.laphub_backend.model.Laptop;
import com.laphub.laphub_backend.model.LaptopBrand;
import com.laphub.laphub_backend.model.LaptopLabel;
import com.laphub.laphub_backend.service.LaptopService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("api/laptops")
public class LaptopController {

    private final LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public String ping(){
        return "Ping Ok";
    }

    @GetMapping
    public List<Laptop> getAll(){
        return service.getAllLaptops();
    }

    @GetMapping("/{id}")
    public Laptop getById(@PathVariable String id){
        return service.getLaptopById(id);
    }

    @PostMapping
    public Laptop create(@RequestBody Laptop laptop){
        return service.createLaptop(laptop);
    }

    @PutMapping("/{id}")
    public Laptop update(@PathVariable String id, @RequestBody Laptop laptop){
        return service.updateLaptop(id, laptop);
    }

    @GetMapping("/filter")
    public List<Laptop> filterLaptops(
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) LaptopLabel label,
            @RequestParam(required = false) LaptopBrand brand,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice
    ) {
        return service.filterLaptops(releaseYear, label, brand, minPrice, maxPrice);
    }

    @DeleteMapping
    public void delete(@PathVariable String id){
        service.deleteLaptop(id);
    }

}





























