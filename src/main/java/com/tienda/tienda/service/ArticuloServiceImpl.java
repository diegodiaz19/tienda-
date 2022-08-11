package com.tienda.tienda.service;
import com.tienda.tienda.dao.ArticuloDao;
import com.tienda.tienda.domain.Articulo;
import com.tienda.tienda.service.ArticuloService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService{
@Autowired
private ArticuloDao articuloDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activo) { // activo = false
        var lista = (List<Articulo>)articuloDao.findAll(); //count = 4
        
        if(activo){
            lista.removeIf(e -> !e.isActivo()); //elimina el activo o elemento en 0
        }
        
       return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }
    
}

