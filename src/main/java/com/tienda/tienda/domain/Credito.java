package com.tienda.tienda.domain;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "credito")
public class Credito implements Serializable{
   
    private static final long serialversionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")

    private long idCredito;
    private double limite;
    
    public Credito(){
    
}

    public Credito(double limite) {
        this.limite = limite;
    }
}
