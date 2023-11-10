package com.api.ufpso.tienda.controller;

import com.api.ufpso.tienda.model.Categoria;
import com.api.ufpso.tienda.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController
{
    @Autowired
    //Instancia del REPOSITORIO
    private CategoriaService categoriaService;
    //----------------------------------------------------------

    //EndPoint GET para "Obtener por ID"
    @GetMapping("categorias/{idCategory}")
    public ResponseEntity getCategoriaById(@PathVariable Long idCategory)

    {
        return ResponseEntity.ok(categoriaService.getCategoriaById(idCategory));
    }
    //----------------------------------------------------------

    //EndPoint POST para "Enviar valores"
    @PostMapping("categorias/{idCategory}")
    public ResponseEntity create(@Valid @RequestBody Categoria categoria, @PathVariable Long id)
    {
        return new ResponseEntity<>(categoriaService.createCategoria(categoria, id), HttpStatus.CREATED);
    }
    //----------------------------------------------------------

    //EndPoint PUT para "Actualizar por ID"
    @PutMapping("categorias/{idCategory}")
    public ResponseEntity update( @PathVariable Long idCategory)
    {
        return ResponseEntity.ok(categoriaService.updateCategoria(idCategory));
    }
    //----------------------------------------------------------

    //EndPoint DELETE para "Borrar por ID"
    @DeleteMapping("categorias/{idCategory}")
    public ResponseEntity<String> delete(@PathVariable Long idCategory)
    {
        return new ResponseEntity(categoriaService.deleteCategoria(idCategory), HttpStatus.NO_CONTENT);
    }
    //----------------------------------------------------------

    //EndPoint GET para "Listar ALL"
    @GetMapping("categorias")
    public ResponseEntity getCategoriaAll()
    {
        return ResponseEntity.ok(categoriaService.getCategoriaAll());
    }
    //----------------------------------------------------------
}
