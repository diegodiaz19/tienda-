
package com.tienda.tienda.service;

import com.tienda.tienda.dao.ClienteDao;
import com.tienda.tienda.dao.CreditoDao;
import com.tienda.tienda.domain.Cliente;
import com.tienda.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService{
@Autowired
private ClienteDao clienteDao;

@Autowired
private CreditoDao creditoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
       return (List<Cliente>)clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {// idCliente = 0 ..... credito {idCredito = 0, limite = 5000}
        Credito credito = cliente.getCredito();//credito {idCredito = 0, limite = 5000}
        credito = creditoDao.save(credito);//credito {idCredito = 5, limite = 5000}
        cliente.setCredito(credito);// idCliente = 0 ..... credito {idCredito = 5, limite = 5000}
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
       
    }
    
}
