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
@Table(name="parqueadero")
public class Parqueadero {
    
    @Id
    @Column(name="id")
    private int id;
    
    @Column(name="cupos_totales")
    private int cupos_totales;
    
    @Column(name="cupos_disponibles")
    private int cupos_disponibles;
    
    @Column(name="cupos_reservados")
    private int cupos_reservados;

    public Parqueadero() {
    }

    public Parqueadero(int id, int cupos_totales, int cupos_disponibles, int cupos_reservados) {
        this.id = id;
        this.cupos_totales = cupos_totales;
        this.cupos_disponibles = cupos_disponibles;
        this.cupos_reservados = cupos_reservados;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCupos_totales() {
        return cupos_totales;
    }

    public void setCupos_totales(int cupos_totales) {
        this.cupos_totales = cupos_totales;
    }

    public int getCupos_disponibles() {
        return cupos_disponibles;
    }

    public void setCupos_disponibles(int cupos_disponibles) {
        this.cupos_disponibles = cupos_disponibles;
    }

    public int getCupos_reservados() {
        return cupos_reservados;
    }

    public void setCupos_reservados(int cupos_reservados) {
        this.cupos_reservados = cupos_reservados;
    }
    
    
    
    
    
    
    
    
}
