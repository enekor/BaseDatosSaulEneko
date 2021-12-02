drop database if exists Departamentos;
create database if not exists Departamentos;
use Departamentos;

create table if not exists programador(
	id varchar(36) not null,
	nombre varchar(30),
	alta date not null,
	salario double not null,
	primary key (id)
);

create table if not exists proyecto(
	id varchar(36) not null,
	presupuesto double,
	idJefe varchar(36) not null,
	nombre varchar(30) not null,
	inicio date not null,
	fin date not null,
	idRepo varchar(36) not null,
	primary key (id),
	foreign key (idJefe) references programador(id)
);

create table if not exists departamento(
	id varchar(36) not null,
	nombre varchar(30),
	idJefe varchar(36),
	presupuesto double,
	primary key (id),
	foreign key (idJefe) references programador(id)
);

create table if not exists repositorio(
	id varchar(36) not null,
	nombre varchar(30) not null,
	fecha date not null,
	idProyecto varchar(36) not null,
	primary key (id),
	foreign key (idProyecto) references proyecto(id)
);

create table if not exists issue(
	id varchar(36) not null,
	titulo varchar(20) not null,
	texto varchar(150),
	fecha date not null,
	idProyecto varchar(36) not null,
	idRepo varchar(36) not null,
	solucionado boolean,
	primary key (id),
	foreign key (idProyecto) references proyecto(id),
	foreign key (idRepo) references repositorio(id)
	
);

create table if not exists commits(
	id varchar(36) not null,
	titulo varchar(30) not null,
	mensaje varchar(150),
	fecha date not null,
	idRepo varchar(36) not null,
	idProyect varchar(36) not null,
	idAutor varchar(36) not null,
	idIssue varchar(36) not null,
	primary key (id),
	foreign key (idRepo) references repositorio(id),
	foreign key (idProyect) references proyecto(id),
	foreign key (idAutor) references programador(id),
	foreign key (idIssue) references issue(id)
);

create table  if not exists listTermiandos(
	idDepartamento varchar(36) not null,
	idProyect varchar(36) not null,
	foreign key (idDepartamento) references departamento(id),
	foreign key (idProyect) references proyecto(id)
);

create table if not exists listDesarrollo(
	idDepartamento varchar(36) not null,
	idProyecto varchar(36) not null,
	foreign key (idDepartamento) references departamento(id),
	foreign key (idProyecto) references proyecto(id)
);

create table if not exists listJefes(
	idDepartamento varchar(36) not null,
	idProgramador varchar(36) not null,
	foreign key (idDepartamento) references departamento(id),
	foreign key (idProgramador) references programador(id)
);

create table if not exists listProyectos(
	idProyecto varchar(36) not null,
	idProgramador varchar(36) not null,
	foreign key (idProyecto) references proyecto(id),
	foreign key (idProgramador) references programador(id)
);

create table if not exists listCommit(
	idProgramador varchar(36) not null,
	idProyecto varchar(36) not null,
	idCommit varchar(36) not null,
	idRepo varchar(36) not null,
	foreign key (idProgramador) references programador(id),
	foreign key (idProyecto) references proyecto(id),
	foreign key (idCommit) references commits(id),
	foreign key (idRepo) references repositorio(id)
);

create table if not exists listIssue(
	idProgramador varchar(36) not null,
	idIssue varchar(36) not null,
	idRepo varchar(36) not null,
	foreign key (idProgramador) references programador(id),
	foreign key (idIssue) references issue(id),
	foreign key (idRepo) references repositorio(id)
);







































