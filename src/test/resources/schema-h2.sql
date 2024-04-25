drop table if exists medal_types;

create table if not exists medal_types (

    medal_name              VARCHAR(30)     NOT NULL PRIMARY KEY,
    medal_description       VARCHAR(255)

    )
