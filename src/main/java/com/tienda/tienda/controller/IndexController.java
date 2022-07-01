
package com.tienda.tienda.controller;

import com.tienda.tienda.dao.ClienteDao;
import com.tienda.tienda.domain.Cliente;
import com.tienda.tienda.service.ClienteService;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class IndexController {
@Autowired
private ClienteService clienteService;

    @GetMapping("/")
    public String inicio(Model model) {

        log.info("Ahora se usa Arquitectura MVC");
       /* String mensaje = "Estamos en la semana 4, saludos";
        model.addAttribute("texto", mensaje);// agrega en la propiedad texto("${}") del index el texto ingresado
        
        Cliente cliente = new Cliente("Diego", "Diaz", "diegoadm119@hotmail.com", "8713-0708");
        model.addAttribute("cliente", cliente);
        
       Cliente cliente2 = new Cliente("Juan", "Lopez", "diegoadm119@hotmail.com", "8713-0708");
       Cliente cliente3 = new Cliente("Pedro", "Mora", "diegoadm119@hotmail.com", "8713-0708");
        var clientes = Arrays.asList(cliente, cliente2, cliente3);
        //*var clientes = Arrays.asList(); */
       var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "index";
    }
    
    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente){
        return"modificarCliente";
    }
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/";
    }
    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model){
        cliente= clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return"modificarCliente";
    }
    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
