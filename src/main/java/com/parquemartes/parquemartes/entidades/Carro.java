/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parquemartes.parquemartes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Juan
 */

@Entity
@Table(name="carro")
public class Carro {
    
    @Id
    @Column(name="placa")
    private String placa;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="entrada")
    private String entrada;
    
    @Column(name="salida")
    private String salida;
    
    @Column(name="pago")
    private int pago;
    
    @Column(name="estado")
    private boolean estado;

    public Carro() {
    }

    public Carro(String placa, String nombre, String entrada, String salida, int pago, boolean estado) {
        this.placa = placa;
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.pago = pago;
        this.estado = estado;
    }

    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
}
