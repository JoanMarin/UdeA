package com.udea.laboratorio2arquitectura;

import com.udea.laboratorio2arquitectura.Estudiante;
import com.udea.laboratorio2arquitectura.Materia;
import com.udea.laboratorio2arquitectura.MatriculaPK;
import com.udea.laboratorio2arquitectura.Semestre;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-23T18:14:30")
@StaticMetamodel(Matricula.class)
public class Matricula_ { 

    public static volatile SingularAttribute<Matricula, Estudiante> estudiante;
    public static volatile SingularAttribute<Matricula, MatriculaPK> matriculaPK;
    public static volatile SingularAttribute<Matricula, Materia> materia;
    public static volatile SingularAttribute<Matricula, Semestre> semestre;

}