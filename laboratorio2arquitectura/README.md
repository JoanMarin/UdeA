# laboratorio2arquitectura

Pasos para poder iniciar el proyecto

## 1) Crear Base de datos MySQL: laboratorio2arquitectura
## 2) Editar el nombre de jdbc:mysql a "jdbc:mysql://localhost:3306/laboratorio2arquitectura"
## 3) Si tienes configurado MySQL con usuario root y contraseña root, no hay problema, de lo contrario modificar el archivo src/main/webapp/WEB-INF/glassfish-resources.xml y estblecer en el campo value de User, el usuario con el que fue creada la base de datos y en el campo value de Password, la respectiva contraseña del usuario, si no tiene contraseña dejarla vacia.
## 4) Ejecutar el siguiente comando SQL, en el jdbc:mysql de la base de datos creada.

CREATE
TABLE   estudiante (
identificacion BIGINT NOT NULL,
nombres CHAR(20) NOT NULL,
apellidos CHAR(20) NOT NULL,
fecha_nacacimiento DATE NOT NULL,
direccion CHAR(30),
telefono CHAR(30),
email CHAR(30) NOT NULL,
programa CHAR(30) NOT NULL,
foto LONGBLOB,
PRIMARY KEY (identificacion)
);

CREATE
TABLE   materia (
codigo CHAR(15) NOT NULL,
nombre CHAR(40) NOT NULL,
profesor CHAR(40) NOT NULL,
aula CHAR(20) NOT NULL,
horario CHAR(20) NOT NULL,
cupos INT NOT NULL DEFAULT 0,
PRIMARY KEY (codigo)
);

CREATE
TABLE   semestre (
codigo CHAR(10) NOT NULL,
fecha_inicio DATE NOT NULL,
fecha_final DATE NOT NULL,
PRIMARY KEY (codigo)
);

CREATE
TABLE   matricula (
estudiante_id BIGINT NOT NULL,
materia_id CHAR(15) NOT NULL,
semestre_id CHAR(10) NOT NULL,
PRIMARY KEY (estudiante_id,materia_id,semestre_id)
);

ALTER TABLE matricula 
ADD CONSTRAINT estudiante_id_fk 
FOREIGN KEY (estudiante_id) 
REFERENCES estudiante (identificacion) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION;

ALTER TABLE matricula 
ADD CONSTRAINT materia_id_fk 
FOREIGN KEY (materia_id) 
REFERENCES materia (codigo) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION;

ALTER TABLE matricula 
ADD CONSTRAINT semestre_id_fk 
FOREIGN KEY (semestre_id) 
REFERENCES semestre (codigo) 
ON DELETE NO ACTION 
ON UPDATE NO ACTION;

## 5) Open project en netbeans
## 6) Como es un proyecto maven, lo mas posible es que no se tenga las dependencias descargadas, por lo que se debe dar click derecho al proyecto y dar click en "Resolve Project Problems" (Tener algo de paciencia, la descarga de las dependencias puede ser algo demorada)
## 7) "Clean an build" al proyecto
## 8) "Run" al proyecto
