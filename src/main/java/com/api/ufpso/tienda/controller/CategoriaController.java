package com.api.ufpso.tienda.controller;

import com.api.ufpso.tienda.model.Categoria;
import com.api.ufpso.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("categorias/{id_cate}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id_cate){
        return ResponseEntity.ok(categoriaService.getCategoriaById(id_cate));
    }

    @PostMapping("categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria user){

        return new ResponseEntity<>(categoriaService.createCategoria(user), HttpStatus.CREATED);
    }

    @DeleteMapping("categorias/{id_cate}")
    public ResponseEntity<String> delete(@PathVariable Long id_cate){
        return new ResponseEntity(categoriaService.deleteCategoria(id_cate), HttpStatus.NO_CONTENT);
    }
}
