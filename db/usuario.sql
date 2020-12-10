create database Bicicletas;

use Bicicletas;

alter table Usuario(id bigint not null auto_increment, nome varchar(256) not null, login varchar(20) not null unique, senha varchar(64) not null, papel varchar(10), primary key (id));

insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');
insert into Usuario(nome, login, senha, papel) values ('Sabrina', 'sabs', 'sabs', 'CLIENTE');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora', 'local', 'local', 'LOCADORA', 'Sao carlos');
