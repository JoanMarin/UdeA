/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.lab2arquitectura.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author joan
 */
@Embeddable
public class MatriculaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "estudiante_id")
    private int estudianteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "materia_id")
    private int materiaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "semestre")
    private String semestre;

    public MatriculaPK() {
    }

    public MatriculaPK(int estudianteId, int materiaId, String semestre) {
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
        this.semestre = semestre;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(int materiaId) {
        this.materiaId = materiaId;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estudianteId;
        hash += (int) materiaId;
        hash += (semestre != null ? semestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaPK)) {
            return false;
        }
        MatriculaPK other = (MatriculaPK) object;
        if (this.estudianteId != other.estudianteId) {
            return false;
        }
        if (this.materiaId != other.materiaId) {
            return false;
        }
        if ((this.semestre == null && other.semestre != null) || (this.semestre != null && !this.semestre.equals(other.semestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.lab2arquitectura.modelo.MatriculaPK[ estudianteId=" + estudianteId + ", materiaId=" + materiaId + ", semestre=" + semestre + " ]";
    }
    
}
