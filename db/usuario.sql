create database Bicicletas;

use Bicicletas;

<<<<<<< HEAD
alter table Usuario(id bigint not null auto_increment, nome varchar(256) not null, login varchar(20) not null unique, senha varchar(64) not null, papel varchar(10), primary key (id));
=======
--caso vc já tenha a tabela criada, comente o comando abaixo e use o comentado
create table Usuario(id bigint not null auto_increment, nome varchar(30) not null, login varchar(20) not null unique, senha varchar(64) not null, papel varchar(10), cidade null varchar(30), primary key (id));
-- alter table Usuario add cidade null varchar(30);

create table Locacao((id bigint not null auto_increment, cliente varchar(30) not null, locadora varchar(20) not null, data varchar(10) not null, primary key (id));
>>>>>>> 5e21b8406daa8dd3d104a8c637e2e6705e6772ad

--insere user admin
insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');
<<<<<<< HEAD
insert into Usuario(nome, login, senha, papel) values ('Sabrina', 'sabs', 'sabs', 'CLIENTE');
insert into Usuario(nome, login, senha, papel, cidade) values ('Locadora', 'local', 'local', 'LOCADORA', 'Sao carlos');
=======

--insere user locadora
insert into Usuario(nome, login, senha, papel) values ('LocadoraTeste', 'locadora@test', 'locadora', 'LOCADORA', 'São Carlos');

--insere user cliente
insert into Usuario(nome, login, senha, papel) values ('ClienteTeste', 'cliente@test', 'user', 'CLIENTE');
>>>>>>> 5e21b8406daa8dd3d104a8c637e2e6705e6772ad
