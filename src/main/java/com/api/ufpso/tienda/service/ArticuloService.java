package com.api.ufpso.tienda.service;

import com.api.ufpso.tienda.exception.NotFoundException;
import com.api.ufpso.tienda.repository.ArticuloRepository;
import com.api.ufpso.tienda.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.ufpso.tienda.model.Articulo;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.Optional;
import java.util.List;
@Service
public class ArticuloService {
    @Autowired
    private ArticuloRepository articuloRepository;

    // metodo listar articulos por ID
    public Articulo getArticuloById(Long id){
        if(id == null){
            throw new NotFoundException(Constants.ARTICLE_IS_NULL.getMessage());
        }
        Optional<Articulo> articulo=articuloRepository.findById(id);
        if(articulo.isEmpty()){
            throw new NotFoundException(Constants.ARTICLE_NOT_FOUND.getMessage());

        }
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
            throw new NotFoundException(Constants.ARTICLE_NOT_FOUND.getMessage());
        }
        articuloRepository.delete(articuloBd.get());
        return true;
    }

    // metodo para actualizar articulos
    public Articulo updateArticulo(Articulo articuloReq, Long id){
        Optional<Articulo> articuloBd=articuloRepository.findById(id);
        if(articuloBd.isEmpty()){
            throw new NotFoundException(Constants.ARTICLE_NOT_FOUND.getMessage());
        }
        articuloBd.get().setName(articuloReq.getName());
        articuloBd.get().setPrice(articuloReq.getPrice());
        articuloBd.get().setDescription(articuloReq.getDescription());
        articuloBd.get().setStock(articuloReq.getStock());

        
        return articuloRepository.save(articuloBd.get());

    }

    // metodo para listar todos los articulos

    public List<Articulo> findAllArticulos(){
        return (List<Articulo>) articuloRepository.findAll();
    }

}
