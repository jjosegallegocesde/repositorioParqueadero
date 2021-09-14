/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parquemartes.parquemartes.servicios;

import com.parquemartes.parquemartes.entidades.Carro;
import com.parquemartes.parquemartes.entidades.Parqueadero;
import com.parquemartes.parquemartes.repositorios.Carrorepositorio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan
 */

@Service
public class CarroServicio {
    
    @Autowired
    private Carrorepositorio carrorepositorio;
    
    @Autowired
    private ParqueaderoServicio parqueaderoServicio;
    
    @Transactional
    public Carro ingresarCarro(Carro carroInfo)throws Exception{
        
        //INFORMACION QUE SE GENERA EN EL SISTEMA
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        String entrada=formato.format(fecha);
        String salida=entrada;
        int pago=0;
        
        try{
            
            //1. ACtualizar la info de parqueadero porque lelog un carro nuevo
            //cupos disponibles se rebajan y los reservados se aumentan
            Parqueadero parqueadero=parqueaderoServicio.obtenerInformacion(160);
            int cuposDisponibles=parqueadero.getCupos_disponibles();
            int cuposreservados=parqueadero.getCupos_reservados();
            parqueadero.setCupos_disponibles(cuposDisponibles-1);
            parqueadero.setCupos_reservados(cuposreservados+1);
            parqueaderoServicio.editarInformacion(160, parqueadero);
            
            
            //2. Cargar en el carro que envia el cliente la informacion
            //que se genera en el sistema
            carroInfo.setEntrada(entrada);
            carroInfo.setSalida(salida);
            carroInfo.setPago(pago);
            
            System.out.println(carroInfo.getPlaca());
            System.out.println(carroInfo.getNombre());
            System.out.println(carroInfo.getEntrada());
            System.out.println(carroInfo.getSalida());
            System.out.println(carroInfo.getPago());
            
            return carrorepositorio.save(carroInfo);
            
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }  
        
        
    }
    
    
    public Carro registrarSalida(String placa)throws Exception{
        
        //INFORMACION QUE SE GENERA EN EL SISTEMA
        Date salida = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechSalida=formato.format(salida);
        
        try{
            
            //1. Consultar la fecha de entrada del carro
            Optional<Carro> datosCarro=carrorepositorio.findById(placa);
            String fechaEntrada=datosCarro.get().getEntrada();
            Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
            
            //2. Calcular el cobro 
            long tiempoDiferencia=salida.getTime()-entrada.getTime();
            TimeUnit unidadTiempo=TimeUnit.MINUTES;
            long tiempoEnparqueadero=unidadTiempo.convert(tiempoDiferencia, TimeUnit.MILLISECONDS);
            int valorPago=(int)tiempoEnparqueadero*100;
            
            //3. Crear un objeto de tipo carro
            Carro carro=datosCarro.get();
            carro.setSalida(fechSalida);
            carro.setPago(valorPago);
            carrorepositorio.save(carro);
            
            return carro;
            
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }  
        
    }
    
    
}
