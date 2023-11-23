package com.prueba.pruebatec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private String descripcion;
    private String categoria;
    

public Elemento(){
    
}


public Elemento(String titulo, String descripcion, String categoria) {
    this.titulo = titulo;
    this.descripcion = descripcion;
    this.categoria = categoria;
}


public int getId() {
    return id;
}


public void setId(int id) {
    this.id = id;
}


public String getTitulo() {
    return titulo;
}


public void setTitulo(String titulo) {
    this.titulo = titulo;
}


public String getDescripcion() {
    return descripcion;
}


public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}


public String getCategoria() {
    return categoria;
}


public void setCategoria(String categoria) {
    this.categoria = categoria;
}







}

