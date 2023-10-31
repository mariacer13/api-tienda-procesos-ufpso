package com.api.ufpso.tienda.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name article is required")
    @Size(max = 255, message = "Name article max 255 characters")
    private String name;
    @NotNull(message = "Description is required")
    @Size(max = 400, message = "lastname max 400 characters")
    private String description;
    @NotNull(message = "Price is required")
    @Min(value= 0, message = "price > 0")
    private Double price;
    @NotNull(message = "Stock is required")
    @Min(value= 0, message = "stock >= 0")
    private int stock;
}
