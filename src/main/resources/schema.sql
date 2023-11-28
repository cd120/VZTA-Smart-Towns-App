drop table if exists user_table;
drop table if exists user_checkpoints;
drop table if exists checkpoint_table;
drop table if exists trail_checkpoint;
drop table if exists trail_table;
drop table if exists roles_table;
drop table if exists users_roles;

create table if not exists user_table
(

) engine = InnoDB;

create table if not exists user_checkpoints
(

) engine = InnoDB;

create table if not exists checkpoint_table
(
    checkpoint_id BIGINT      NOT NULL AUTO_INCREMENT primary key,
    trail_id      BIGINT      NOT NULL,
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

) engine = InnoDB;

create table if not exists users_roles
(

) engine = InnoDB;

# create view if not exists user_authorities as
# select u.username as username, CONCAT("ROLE_", r.name) as authority
# from user_table u
#          inner join users_roles ur on u.username = ur.username
#          inner join roles_table r on ur.role_id = r.role_id;

