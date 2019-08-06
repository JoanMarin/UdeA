package com.udea.laboratorio2arquitectura;

import com.udea.laboratorio2arquitectura.Matricula;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2016-11-23T18:14:30")
@StaticMetamodel(Semestre.class)
public class Semestre_ { 

    public static volatile SingularAttribute<Semestre, String> codigo;
    public static volatile SingularAttribute<Semestre, Date> fechaInicio;
    public static volatile SingularAttribute<Semestre, Date> fechaFinal;
    public static volatile ListAttribute<Semestre, Matricula> matriculaList;

}