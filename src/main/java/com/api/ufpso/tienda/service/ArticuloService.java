package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ufpso.tienda.model.Articulo;

import java.util.Optional;

@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    // metodo listar articulos por ID
    public Articulo getArticuloById(Long id){

        return articuloRepository.findById(id).get();
    }
    // metodo para crear articulos
    public Articulo createArticulo(Articulo articuloReq){

        return articuloRepository.save(articuloReq);
    }

    //metodo para eliminar articulos
    public boolean deleteArticulo(Long id){
        Optional<Articulo> articuloBd=articuloRepository.findById(id);
        if(articuloBd.isEmpty()){
            return false;
        }
        articuloRepository.delete(articuloBd.get());
        return true;
    }

}
