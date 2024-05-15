create table estudiantes(
id int (11) not null auto_increment primary key,
nombres varchar (100),
apellidos varchar(100),
seminario varchar (100),
fecha_inscripcion varchar (100)
);

insert into estudiantes (nombres,apellidos,seminario,fecha_inscripcion) values ("Grover","Eduardo","Esteganografia","2024-05-02");
insert into estudiantes (nombres,apellidos,seminario,fecha_inscripcion) values ("zoyla","Vaca","Criptografia","2024-05-07");
insert into estudiantes (nombres,apellidos,seminario,fecha_inscripcion) values ("Aquiles","Castro","hacking web","2024-05-10");
