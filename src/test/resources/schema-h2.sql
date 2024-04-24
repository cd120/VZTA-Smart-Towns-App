drop table if exists trail_table;
create table if not exists trail_table
(
    trail_id    BIGINT       NOT NULL AUTO_INCREMENT primary key,
    name        varchar(45)  NOT NULL,
    location    varchar(45)  NOT NULL,
    description varchar(500) NOT NULL
    ) engine = InnoDB;