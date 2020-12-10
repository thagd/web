create database Bicicletas;

use Bicicletas;

create table Usuario(id bigint not null auto_increment, nome varchar(30) not null, login varchar(30) not null unique, senha varchar(64) not null, papel varchar(20), cidade varchar(30) null, primary key (id));

create table Locacao(id bigint not null auto_increment, cliente varchar(30) not null, locadora varchar(20) not null, data varchar(10) not null, primary key (id));


insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');
insert into Usuario(nome, login, senha, papel) values ('Sabrina', 'sabs', 'sabs', 'CLIENTE');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora', 'local', 'local', 'LOCADORA', 'Sao carlos');
insert into Usuario(nome, login, senha, papel, cidade) values ('LocadoraTeste', 'locadora@test', 'locadora', 'LOCADORA', 'São Carlos');
insert into Usuario(nome, login, senha, papel) values ('ClienteTeste', 'cliente@test', 'user', 'CLIENTE');
