package com.udea.laboratorio2arquitectura;

import com.udea.laboratorio2arquitectura.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-23T18:14:30")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, String> codigo;
    public static volatile SingularAttribute<Materia, String> aula;
    public static volatile SingularAttribute<Materia, String> horario;
    public static volatile ListAttribute<Materia, Matricula> matriculaList;
    public static volatile SingularAttribute<Materia, String> profesor;
    public static volatile SingularAttribute<Materia, Integer> cupos;
    public static volatile SingularAttribute<Materia, String> nombre;

}