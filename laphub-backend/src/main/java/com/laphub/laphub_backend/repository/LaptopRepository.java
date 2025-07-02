package com.laphub.laphub_backend.repository;

import com.laphub.laphub_backend.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LaptopRepository extends JpaRepository<Laptop,String>, JpaSpecificationExecutor<Laptop> {
}
