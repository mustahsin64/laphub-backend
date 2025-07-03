package com.laphub.laphub_backend.specification;

import com.laphub.laphub_backend.model.Laptop;
import com.laphub.laphub_backend.model.LaptopBrand;
import com.laphub.laphub_backend.model.LaptopLabel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class LaptopSpecification {

    public static Specification<Laptop> filterBy(
            Integer releaseYear,
            LaptopLabel label,
            LaptopBrand brand,
            BigDecimal minPrice,
            BigDecimal maxPrice
    ) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (releaseYear != null) {
                predicates.add(cb.equal(root.get("releaseYear"), releaseYear));
            }

            if (label != null) {
                predicates.add(cb.equal(root.get("label"), label));
            }

            if (brand != null) {
                predicates.add(cb.equal(root.get("brand"), brand));
            }

            if (minPrice != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("price"), minPrice));
            }

            if (maxPrice != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("price"), maxPrice));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
