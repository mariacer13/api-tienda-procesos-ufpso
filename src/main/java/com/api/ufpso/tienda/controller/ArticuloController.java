package com.api.ufpso.tienda.controller;

import com.api.ufpso.tienda.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.api.ufpso.tienda.model.Articulo;

@RestController
public class ArticuloController {
    @Autowired

    // instancia del servicio
    private ArticuloService articuloService;

    //endpoint GET para "obtener por ID"
    @GetMapping("articulos/{id}")
    public ResponseEntity<Articulo> getAriculoById(@PathVariable Long id){
        return ResponseEntity.ok(articuloService.getArticuloById(id));
    }

    // endpoint POST para "enviar valores"
    @PostMapping("articulos")
    public ResponseEntity<Articulo> create(@RequestBody Articulo articulo){
        return new ResponseEntity<>(articuloService.createArticulo(articulo), HttpStatus.CREATED);
    }

    // endpoint DELETE para "borrar por ID"
    @DeleteMapping("articulos/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity(articuloService.deleteArticulo(id), HttpStatus.NO_CONTENT);
    }



}
