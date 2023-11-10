package com.api.ufpso.tienda.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "streetAddress REQUIRED")
    @Size(max = 255, message = "streetAddress max 255 characters")
    private String streetAddress;

    @NotNull(message = "city is REQUIRED")
    @Size(max =  255, message = "city max 255 characters")
    private String city;

    @NotNull(message = "state is REQUIRED")
    @Size(max =  100, message = "state max 100 characters")
    private String state;

    @NotNull(message = "state is REQUIRED")
    @Size(max =  10, message = "postalCode max 10 characters")
    private String postalCode;
    private Boolean status = Boolean.TRUE;

    @ManyToOne()
    @JoinColumn(name="id_user", referencedColumnName = "id")
    private User user;
}