/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parquemartes.parquemartes.servicios;

import com.parquemartes.parquemartes.entidades.Parqueadero;
import com.parquemartes.parquemartes.repositorios.ParqueoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan
 */

@Service
public class ParqueaderoServicio {
    
    @Autowired
    private ParqueoRepositorio parqueoRepositorio;
    
    @Transactional
    public Parqueadero obtenerInformacion(int id) throws Exception{
        
        try{
            Optional<Parqueadero> infoParqueadero=parqueoRepositorio.findById(id);
            return infoParqueadero.get();
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }  
    }
    
    @Transactional
    public Parqueadero editarInformacion(int id, Parqueadero parquederoInfo)throws Exception{
        
        try{
            
            //Buscar el parqueadero a editar
            Optional<Parqueadero> parqueaderoBuscado=parqueoRepositorio.findById(id);
            
            //Si llego la info del parqueadero
            Parqueadero nuevoparqueadero=parqueaderoBuscado.get();
            
            //cargar los nuevos datos del aprqueadero
        nuevoparqueadero=parqueoRepositorio.save(parquederoInfo);
            return nuevoparqueadero;
            
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
        
    }
    
}
