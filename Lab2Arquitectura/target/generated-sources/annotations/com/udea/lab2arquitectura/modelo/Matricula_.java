package com.udea.lab2arquitectura.modelo;

import com.udea.lab2arquitectura.modelo.Estudiante;
import com.udea.lab2arquitectura.modelo.Materia;
import com.udea.lab2arquitectura.modelo.MatriculaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-21T02:30:44")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Estudiante> estudiante;
    public static volatile SingularAttribute<Matricula, MatriculaPK> matriculaPK;
    public static volatile SingularAttribute<Matricula, Materia> materia;

}