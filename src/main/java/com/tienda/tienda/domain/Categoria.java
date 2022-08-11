package com.tienda.tienda.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    
    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@Column(name="id_credito")*/
    private Long idCategoria;
    private String descripcion;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(Long idCategoria, String descripcion, boolean activo) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.activo = activo;
    }
   
    
}
