package com.laphub.laphub_backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private BigDecimal price;
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String specification;

    @Column(nullable = false)
    private int releaseYear;


    @Enumerated(EnumType.STRING)
    private LaptopLabel label;

    @Enumerated(EnumType.STRING)
    private LaptopBrand brand;

    private boolean isNewRelease=false;

    private int likeCount=0;

    @Column(columnDefinition = "TEXT")
    private String link;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
}
