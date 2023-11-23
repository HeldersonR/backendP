package com.prueba.pruebatec.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.pruebatec.dto.ElementoDto;
import com.prueba.pruebatec.dto.Mensaje;
import com.prueba.pruebatec.entity.Elemento;
import com.prueba.pruebatec.service.ElementoService;

import io.micrometer.common.util.StringUtils;

@RestController
@RequestMapping("elemento")
@CrossOrigin("origins = {\"http://localhost:4200\"}")

public class ElementoController {
    
 @Autowired
    ElementoService elementoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Elemento>> list(){
        List<Elemento> list = elementoService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
@GetMapping("/detail/{id}")
    public ResponseEntity<Elemento> getById(@PathVariable("id") int id){
        if(!elementoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Elemento elemento = elementoService.getOne(id).get();
        return new ResponseEntity(elemento, HttpStatus.OK);
    }

    @GetMapping("/detailcategory/{categoria}")
    public ResponseEntity<Elemento> getByCategoria(@PathVariable("categoria") String categoria){
        if(!elementoService.existsByCategoria(categoria))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Elemento elemento = elementoService.getByCategoria(categoria).get();
        return new ResponseEntity(elemento, HttpStatus.OK);
    }
    
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ElementoDto elementoDto){
        if(StringUtils.isBlank(elementoDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(elementoDto.getCategoria()))
            return new ResponseEntity(new Mensaje("La categoria es obligatoria"), HttpStatus.BAD_REQUEST);
        if(elementoService.existsByTitulo(elementoDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el titulo ya existe"), HttpStatus.BAD_REQUEST);
        Elemento elemento = new Elemento(elementoDto.getTitulo(), elementoDto.getCategoria(),elementoDto.getDescripcion());
        elementoService.save(elemento);
        return new ResponseEntity(new Mensaje("elemento creado"), HttpStatus.OK);
    }

 @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ElementoDto elementoDto){
        if(!elementoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        if(elementoService.existsByTitulo(elementoDto.getTitulo()) && elementoService.getByTitulo(elementoDto.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("ese titulo ya existe"), HttpStatus.BAD_REQUEST);
         if(StringUtils.isBlank(elementoDto.getTitulo()))
            return new ResponseEntity(new Mensaje("el titulo es obligatorio"), HttpStatus.BAD_REQUEST);
            if(StringUtils.isBlank(elementoDto.getCategoria()))
            return new ResponseEntity(new Mensaje("La categoria es obligatoria"), HttpStatus.BAD_REQUEST);
        
        Elemento elemento = elementoService.getOne(id).get();
        elemento.setTitulo(elementoDto.getTitulo());
        elemento.setDescripcion(elementoDto.getDescripcion());
        elemento.setCategoria(elementoDto.getCategoria());
        elementoService.save(elemento);
        return new ResponseEntity(new Mensaje("elemento actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!elementoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        elementoService.delete(id);
        return new ResponseEntity(new Mensaje("elemento eliminado"), HttpStatus.OK);
    }




}
