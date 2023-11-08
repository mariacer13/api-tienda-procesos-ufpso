package com.api.ufpso.tienda.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "firstname is REQUIRED")
    @Size(max = 255, message = "firstname max 255 characters")
    private String firstName;

    @NotNull(message = "lastname is REQUIRED")
    @Size(max = 255, message = "lastname max 255 characters")
    private String lastname;

    @NotNull(message = "document is REQUIRED")
    @Size(min = 5, max = 15, message = "document min 5 and max 15 characters")
    private String document;
    private String phone;

    @NotNull(message = "email is REQUIRED")
    @Email(message = "email not valid")
    private String email;


    @NotNull(message = "password is REQUIRED")
    @Size(min = 8, max = 15, message = "password min 8 and max 15 characters")
    private String password;

    @JsonIgnore //Cuando genere una respuesta, ignore lo siguiente
    @OneToMany(mappedBy = "user")
    List<Address> addressList;
}