create database Bicicletas;

use Bicicletas;

create table Locadora (id bigint not null auto_increment, nome varchar(30)
not null, cidade varchar(20) not null, email varchar(20) not null, senha varchar(10) not null, primary key (id));

create table Cliente (id bigint not null auto_increment, nome varchar(30)
not null, email varchar(20) not null, senha varchar(10) not null, primary key (id));
