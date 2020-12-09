create database Bicicletas;

use Bicicletas;

--caso vc já tenha a tabela criada, comente o comando abaixo e use o comentado
create table Usuario(id bigint not null auto_increment, nome varchar(30) not null, login varchar(20) not null unique, senha varchar(64) not null, papel varchar(10), cidade null varchar(30), primary key (id));
-- alter table Usuario add cidade null varchar(30);

create table Locacao((id bigint not null auto_increment, cliente varchar(30) not null, locadora varchar(20) not null, data varchar(10) not null, primary key (id));

--insere user admin
insert into Usuario(nome, login, senha, papel) values ('Administrador', 'admin', 'admin', 'ADMIN');

--insere user locadora
insert into Usuario(nome, login, senha, papel) values ('LocadoraTeste', 'locadora@test', 'locadora', 'LOCADORA', 'São Carlos');

--insere user cliente
insert into Usuario(nome, login, senha, papel) values ('ClienteTeste', 'cliente@test', 'user', 'CLIENTE');
