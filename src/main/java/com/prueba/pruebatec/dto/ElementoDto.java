package com.prueba.pruebatec.dto;

import io.micrometer.common.lang.NonNull;

public class ElementoDto {


@NonNull
private String descripcion;
@NonNull
private String categoria;
@NonNull
private String titulo; 
  
   public ElementoDto() {
}
    public ElementoDto( @NonNull String titulo, @NonNull String categoria, @NonNull String descripcion) {
       this.titulo = titulo;
       this.descripcion = descripcion;
       this.categoria = categoria;
}
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {this.titulo = titulo;}
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