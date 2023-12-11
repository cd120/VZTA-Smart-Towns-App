drop table if exists user_table;
drop table if exists user_checkpoints;
drop table if exists checkpoint_table;
drop table if exists trail_checkpoint;
drop table if exists trail_table;
drop table if exists roles_table;
drop table if exists users_roles;
drop table if exists medal_types;
drop table if exists medal_users;

create table if not exists user_table
(
    username VARCHAR(50)  NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled  boolean      NOT NULL,
    email    VARCHAR(50),
    address  VARCHAR(500),
    address2 VARCHAR(500),
    city     VARCHAR(50),
    zipCode  VARCHAR(500)
) engine = InnoDB;

create table if not exists user_checkpoints
(
    id            BIGINT      NOT NULL AUTO_INCREMENT primary key,
    username      VARCHAR(50) not null,
    checkpoint_id BIGINT      not null
) engine = InnoDB;

create table if not exists checkpoint_table
(
    checkpoint_id BIGINT      NOT NULL AUTO_INCREMENT primary key,
    name          varchar(45) NOT NULL,
    latitude      DOUBLE      NOT NULL,
    longitude     DOUBLE      NOT NULL,
    description   varchar(500)

) engine = InnoDB;

create table if not exists trail_checkpoint
(
    id            BIGINT NOT NULL AUTO_INCREMENT primary key,
    trail_id      BIGINT NOT NULL,
    checkpoint_id BIGINT NOT NULL
) engine = InnoDB;

create table if not exists trail_table
(
    trail_id    BIGINT       NOT NULL AUTO_INCREMENT primary key,
    name        varchar(45)  NOT NULL,
    location    varchar(45)  NOT NULL,
    description varchar(500) NOT NULL
) engine = InnoDB;

create table if not exists roles_table
(
    role_id BIGINT      NOT NULL,
    name    VARCHAR(45) NOT NULL
) engine = InnoDB;

create table if not exists users_roles
(
    id       BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    role_id  BIGINT      NOT NULL
) engine = InnoDB;

create view if not exists user_authorities as
select u.username as username, CONCAT("ROLE_", r.name) as authority
from user_table u
         inner join users_roles ur on u.username = ur.username
         inner join roles_table r on ur.role_id = r.role_id;


create table if not exists medals_users
    (
    id              BIGINT      NOT NULL AUTO_INCREMENT primary key,
    username        VARCHAR(50) NOT NULL,
    checkpoint_id   BIGINT      NOT NULL

    ) engine = InnoDB;

--Adding Medals table
create table if not exists medal_types (

    medal_name              VARCHAR(20)     NOT NULL PRIMARY KEY,
    medal_description       VARCHAR(255)    NOT NULL

    )   engine = InnoDB;

--Creating Medal_users table
create table if not exists medal_users (

    id              BIGINT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username        VARCHAR(50)     NOT NULL,
    medal_name      VARCHAR(20)     NOT NULL

    ) engine = InnoDB;
