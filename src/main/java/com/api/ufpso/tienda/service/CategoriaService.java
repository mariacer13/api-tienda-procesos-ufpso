package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ufpso.tienda.model.Categoria;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria createCategoria(Categoria categoriaReq){
        return categoriaRepository.save(categoriaReq);
    }

    public Categoria getCategoriaById(Long id_cate){
        return categoriaRepository.findById(id_cate).get();
    }

    public boolean deleteCategoria(Long id_cate){
        Optional<Categoria> userBd=categoriaRepository.findById(id_cate);
        if(userBd.isEmpty()){
            return false;
        }
        categoriaRepository.delete(userBd.get());
        return true;
    }
}
