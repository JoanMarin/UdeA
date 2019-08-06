package com.udea.lab2arquitectura.modelo;

import com.udea.lab2arquitectura.modelo.Matricula;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-21T02:30:44")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Integer> codigo;
    public static volatile SingularAttribute<Materia, String> aula;
    public static volatile SingularAttribute<Materia, String> horario;
    public static volatile SingularAttribute<Materia, String> profesor;
    public static volatile CollectionAttribute<Materia, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Materia, Integer> cupos;
    public static volatile SingularAttribute<Materia, String> nombre;

}