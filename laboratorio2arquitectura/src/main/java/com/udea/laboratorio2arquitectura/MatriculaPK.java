/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.laboratorio2arquitectura;

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
    private long estudianteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "materia_id")
    private String materiaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "semestre_id")
    private String semestreId;

    public MatriculaPK() {
    }

    public MatriculaPK(long estudianteId, String materiaId, String semestreId) {
        this.estudianteId = estudianteId;
        this.materiaId = materiaId;
        this.semestreId = semestreId;
    }

    public long getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public String getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(String materiaId) {
        this.materiaId = materiaId;
    }

    public String getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(String semestreId) {
        this.semestreId = semestreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) estudianteId;
        hash += (materiaId != null ? materiaId.hashCode() : 0);
        hash += (semestreId != null ? semestreId.hashCode() : 0);
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
        if ((this.materiaId == null && other.materiaId != null) || (this.materiaId != null && !this.materiaId.equals(other.materiaId))) {
            return false;
        }
        if ((this.semestreId == null && other.semestreId != null) || (this.semestreId != null && !this.semestreId.equals(other.semestreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.laboratorio2arquitectura.MatriculaPK[ estudianteId=" + estudianteId + ", materiaId=" + materiaId + ", semestreId=" + semestreId + " ]";
    }
    
}
