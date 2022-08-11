
package com.tienda.tienda.controller;

import com.tienda.tienda.dao.ClienteDao;
import com.tienda.tienda.domain.Cliente;
import com.tienda.tienda.service.ArticuloService;
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
private ArticuloService articuloService;

    @GetMapping("/")
    public String inicio(Model model) {

        log.info("Ahora se usa Arquitectura MVC");
       
       var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        return "index";
    }
    
    
}
