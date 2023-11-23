package com.prueba.pruebatec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.pruebatec.entity.Elemento;
import com.prueba.pruebatec.repository.ElementoRepository;

@Service
@Transactional
public class ElementoService {

    @Autowired
    ElementoRepository elementoRepository;

public List<Elemento> list(){

return elementoRepository.findAll();
}

public Optional<Elemento> getOne(int id){
    return elementoRepository.findById(id);

}

public Optional<Elemento> getByCategoria(String categoria){
    return elementoRepository.findByCategoria(categoria);
}

public Optional<Elemento> getByTitulo(String titulo){
    return elementoRepository.findByTitulo(titulo);
}
public Optional<Elemento> getByDescripcion(String descripcion){
    return elementoRepository.findByDescripcion(descripcion);
}
 

public void save (Elemento elemento){
    elementoRepository.save(elemento);
}
public void delete (int id){
    elementoRepository.deleteById(id);
}

public boolean existsById (int id){
   return elementoRepository.existsById(id);

}

public boolean existsByCategoria (String categoria){
   return elementoRepository.existsByCategoria(categoria);

}
public boolean existsByTitulo (String titulo){
   return elementoRepository.existsByTitulo(titulo);

}

}
