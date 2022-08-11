package com.tienda.tienda.service;

import com.tienda.tienda.dao.CategoriaDao;
import com.tienda.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{
@Autowired
private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activo) { // activo = false
        var lista = (List<Categoria>)categoriaDao.findAll(); //count = 4
        
        if(activo){
            lista.removeIf(e -> !e.isActivo()); //elimina el activo o elemento en 0
        }
        
       return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}

