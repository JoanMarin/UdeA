package com.udea.laboratorio2arquitectura;

import com.udea.laboratorio2arquitectura.Matricula;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-23T18:14:30")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> apellidos;
    public static volatile SingularAttribute<Estudiante, byte[]> foto;
    public static volatile SingularAttribute<Estudiante, Date> fechaNacimiento;
    public static volatile SingularAttribute<Estudiante, String> direccion;
    public static volatile ListAttribute<Estudiante, Matricula> matriculaList;
    public static volatile SingularAttribute<Estudiante, String> programa;
    public static volatile SingularAttribute<Estudiante, Long> identificacion;
    public static volatile SingularAttribute<Estudiante, String> telefono;
    public static volatile SingularAttribute<Estudiante, String> email;
    public static volatile SingularAttribute<Estudiante, String> nombres;

}