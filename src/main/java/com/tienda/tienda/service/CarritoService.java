package com.tienda.tienda.service;


import com.tienda.tienda.domain.Carrito;



public interface CarritoService {
    
    public Carrito getCarrito(Carrito carrito);
    
    public Carrito getCarritoCliente(long idCliente);
    
}
