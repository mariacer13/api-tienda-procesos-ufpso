package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.repository.CategoriaRepository;
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
        return categoriaRepository.findById(idCategory).orElse(null);
    }
    //----------------------------------------------------------

    //Servicio para "CREAR categoria"
    public Categoria createCategoria(Categoria categoriaReq)
    {
        return categoriaRepository.save(categoriaReq);
    }
    //----------------------------------------------------------

    //Servicio para "EDITAR categoria"
    public Categoria updateCategoria(Categoria categoriaReq, Long idCategory)
    {
        Optional<Categoria> categoriaBd = categoriaRepository.findById(idCategory);
        if(categoriaBd.isEmpty())
        {
            return null;
        }
        categoriaBd.get().setNameCategory(categoriaReq.getNameCategory());
        return categoriaRepository.save(categoriaBd.get());
    }
    //----------------------------------------------------------

    //Servicio para "ELIMINAR categoria por ID"
    public boolean deleteCategoria(Long idCategory)
    {
        Optional<Categoria> categoriaBd = categoriaRepository.findById(idCategory);
        if(categoriaBd.isEmpty())
        {
            return false;
        }
        categoriaRepository.delete(categoriaBd.get());
        return true;
    }
    //----------------------------------------------------------

    //Servicio para "LISTAR ALL"
    public List<Categoria> getCategoriaAll()
    {
        return (List<Categoria>) categoriaRepository.findAll();
    }
}
