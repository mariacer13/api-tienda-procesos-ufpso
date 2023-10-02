package com.api.ufpso.tienda.controller;

import com.api.ufpso.tienda.model.Categoria;
import com.api.ufpso.tienda.service.CategoriaService;
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
    @GetMapping("categorias/{id_cate}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id_cate)
    {
        return ResponseEntity.ok(categoriaService.getCategoriaById(id_cate));
    }
    //----------------------------------------------------------

    //EndPoint POST para "Enviar valores"
    @PostMapping("categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria)
    {
        return new ResponseEntity<>(categoriaService.createCategoria(categoria), HttpStatus.CREATED);
    }
    //----------------------------------------------------------

    //EndPoint PUT para "Actualizar por ID"
    @PutMapping("categorias/{id_cate}")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Long id_cate)
    {
        return new ResponseEntity<>(categoriaService.updateCategoria(categoria, id_cate), HttpStatus.OK);
    }
    //----------------------------------------------------------

    //EndPoint DELETE para "Borrar por ID"
    @DeleteMapping("categorias/{id_cate}")
    public ResponseEntity<String> delete(@PathVariable Long id_cate)
    {
        return new ResponseEntity(categoriaService.deleteCategoria(id_cate), HttpStatus.NO_CONTENT);
    }
    //----------------------------------------------------------

    //EndPoint GET para "Listar ALL"
    @GetMapping("categorias")
    public ResponseEntity<List<Categoria>> getCategoriaAll()
    {
        return ResponseEntity.ok(categoriaService.getCategoriaAll());
    }
    //----------------------------------------------------------
}
