package com.laphub.laphub_backend.controller;


import com.laphub.laphub_backend.model.Laptop;
import com.laphub.laphub_backend.service.LaptopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/laptops")
public class LaptopController {

    private final LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
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

    public void delete(@PathVariable String id){
        service.deleteLaptop(id);
    }

}





























