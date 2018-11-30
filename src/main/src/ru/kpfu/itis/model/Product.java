package ru.kpfu.itis.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String picUrl;

}
