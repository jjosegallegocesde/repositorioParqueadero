/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parquemartes.parquemartes.controladores;

import com.parquemartes.parquemartes.entidades.Carro;
import com.parquemartes.parquemartes.servicios.CarroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("IS/v1/carros")
public class CarroControlador {
    
    @Autowired
    private CarroServicio carroServicio;
    
    @PostMapping("")
    public ResponseEntity<?> RegistrarIngresoCarro(@RequestBody Carro carro){
        
        try{
            
             return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carroServicio.ingresarCarro(carro));
            
        }catch(Exception error){
            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error:intenta nuevamente}");
            
        }
        
    }
    
    @PutMapping("/{placa}")
    public ResponseEntity<?> RegistrarSalidaCarro(@PathVariable String placa){
        
        try{
            
             return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carroServicio.registrarSalida(placa));
            
        }catch(Exception error){
            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error:intenta nuevamente}");
            
        }
        
    }
    
    
    
}
