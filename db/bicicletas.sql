create database Bicicletas;

use Bicicletas;

create table Usuario(id bigint not null auto_increment, nome varchar(30) not null, login varchar(100) not null unique, senha varchar(64) not null, papel varchar(20), cidade varchar(30) null, primary key (id));

create table Locacao(id bigint not null auto_increment, cliente varchar(30) not null, locadora varchar(20) not null, data varchar(10) not null, primary key (id));

insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');
insert into Usuario(nome, login, senha, papel) values ('Ariane', 'ari', 'ari', 'CLIENTE');
insert into Usuario(nome, login, senha, papel) values ('Sabrina', 'sabs', 'sabs', 'CLIENTE');
insert into Usuario(nome, login, senha, papel) values ('Thais', 'thais', 'thais', 'CLIENTE');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora A', 'locadoraA@teste.com', 'testea', 'LOCADORA', 'Sao Carlos');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora B', 'locadoraB@teste.com', 'testeb', 'LOCADORA', 'Sao Carlos');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora C', 'locadoraC@teste.com', 'testec', 'LOCADORA', 'Araraquara');
