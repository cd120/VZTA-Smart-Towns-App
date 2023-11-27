drop table if exists user_table;
drop table if exists user_checkpoints;
drop table if exists checkpoint_table;
drop table if exists trail_checkpoint;
drop table if exists trail_table;
drop table if exists roles_table;
drop table if exists users_roles;

create table if not exists user_table (
    id       bigint auto_increment primary key,
    username varchar(50)  not null primary key,
    password varchar(500) not null,
) engine = InnoDB;

create table if not exists user_checkpoints (

) engine = InnoDB;

create table if not exists checkpoint_table (

) engine = InnoDB;

create table if not exists trail_checkpoint (

) engine = InnoDB;

create table if not exists trail_table (

) engine = InnoDB;

create table if not exists roles_table (
    role_id int(11)     NOT NULL AUTO_INCREMENT primary key,
    name    varchar(45) NOT NULL
) engine = InnoDB;

create table if not exists users_roles (
    id       bigint auto_increment primary key,
    username varchar(50) NOT NULL,
    role_id  int(11)     NOT NULL
) engine = InnoDB;

create view if not exists user_authorities as
select u.username as username, CONCAT("ROLE_", r.name) as authority
from user_table u
         inner join users_roles ur on u.username = ur.username
         inner join roles r on ur.role_id = r.role_id;

