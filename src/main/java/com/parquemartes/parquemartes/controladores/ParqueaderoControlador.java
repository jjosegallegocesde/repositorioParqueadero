/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parquemartes.parquemartes.controladores;

import com.parquemartes.parquemartes.entidades.Parqueadero;
import com.parquemartes.parquemartes.servicios.ParqueaderoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Juan
 */

@RestController
@CrossOrigin(origins="*")
@RequestMapping("IS/v1/parqueaderos")
public class ParqueaderoControlador {
    
    @Autowired
    private ParqueaderoServicio parqueaderoServicio;
    
    @GetMapping("/{id}")
    public ResponseEntity<?> consultarInformacion(@PathVariable int id){
        
        try{
            
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(parqueaderoServicio.obtenerInformacion(id));
            
        }catch(Exception error){
            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error:intenta nuevamente}");
            
        }
        
    }
    
    @PutMapping
    public ResponseEntity<?> editarInformacion(@PathVariable int id, @RequestBody Parqueadero parqueadero){
        
        try{
            
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(parqueaderoServicio.editarInformacion(id, parqueadero));
            
        }catch(Exception error){
            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error:intenta nuevamente}");
            
        }
        
        
    }
    
}
