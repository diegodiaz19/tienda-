
package com.tienda.tienda.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")

public class Cliente implements Serializable {
    
    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idCliente; //* Esto es diferente porque Hibernate lo transforma en id_cliente / siempre se pone en mayuscula oara que lo transforme en minuscula
    String nombre;
    String apellidos;
    String correo;
    String telefono;
    
    public Cliente(){
        
    }
    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
}
