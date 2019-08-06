package com.udea.lab2arquitectura.modelo;

import com.udea.lab2arquitectura.modelo.Matricula;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-21T02:30:44")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> apellidos;
    public static volatile SingularAttribute<Estudiante, Date> fechaNac;
    public static volatile SingularAttribute<Estudiante, byte[]> foto;
    public static volatile SingularAttribute<Estudiante, String> direccion;
    public static volatile SingularAttribute<Estudiante, String> programa;
    public static volatile SingularAttribute<Estudiante, Integer> identificacion;
    public static volatile CollectionAttribute<Estudiante, Matricula> matriculaCollection;
    public static volatile SingularAttribute<Estudiante, String> telefono;
    public static volatile SingularAttribute<Estudiante, String> email;
    public static volatile SingularAttribute<Estudiante, String> nombres;

}