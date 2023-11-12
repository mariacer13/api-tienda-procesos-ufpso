package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.exception.NotFoundException;
import com.api.ufpso.tienda.model.Articulo;
import com.api.ufpso.tienda.repository.CategoriaRepository;
import com.api.ufpso.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ufpso.tienda.model.Categoria;

import java.util.List;
import java.util.Optional;

@Service
// Método para el SERVICIO
public class CategoriaService
{
    @Autowired
    //Instancia del REPOSITORIO
    private CategoriaRepository categoriaRepository;

    //----------------------------------------------------------

    //Servicio para "LISTAR categoria por ID"
    public Categoria getCategoriaById(Long idCategory)
    {
        Optional<Categoria> categoria=categoriaRepository.findById(idCategory);
        if(categoria.isEmpty()){
            throw new NotFoundException(Constants.CATEGORY_NOT_FOUND.getMessage());

        }
        return categoria.get();
    }
    //----------------------------------------------------------

    //Servicio para "CREAR categoria"
    public Categoria createCategoria(Categoria categoriaReq)
    {
        return categoriaRepository.save(categoriaReq);
    }
    //----------------------------------------------------------

    //Servicio para "EDITAR categoria"
    public Categoria updateCategoria(Long idCategory)
    {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategory);
        if(categoria.isEmpty())
        {
            throw new NotFoundException(Constants.CATEGORY_NOT_FOUND.getMessage());
        }

        return categoriaRepository.save(categoria.get());
    }
    //----------------------------------------------------------

    //Servicio para "ELIMINAR categoria por ID"
    public boolean deleteCategoria(Long idCategory)
    {
        Optional<Categoria> categoria = categoriaRepository.findById(idCategory);
        if(categoria.isEmpty())
        {
            throw new NotFoundException(Constants.CATEGORY_NOT_FOUND.getMessage());
        }
        categoriaRepository.delete(categoria.get());
        return true;
    }
    //----------------------------------------------------------

    //Servicio para "LISTAR ALL"
    public List<Categoria> getCategoriaAll()
    {
        return (List<Categoria>) categoriaRepository.findAll();
    }
}
