insert into roles_table (role_id, name)
values
    (1, 'ADMIN'),
    (2, 'USER');

-- add default admin account
insert into user_table (username, password, enabled)
values ('admin', '$2a$12$zKMHlbOC7UXOLCdq5ZibC.ANCzcxgpoGbode97Dc2Fi1zakG2fP6O', true);

insert into users_roles (username, role_id)
values ('admin', 1);

--Inserting Medal Types
INSERT INTO medal_types (name) VALUES ('BRONZE');
INSERT INTO medal_types (name) VALUES ('SILVER');
INSERT INTO medal_types (name) VALUES ('GOLD');
INSERT INTO medal_types (name) VALUES ('NONE');

--Inserting default medals to users based on number of checkpoints collected
INSERT INTO medals_users (role_id, checkpoints_sum, medal_type_id) VALUES (1,20,1);
INSERT INTO medals_users (role_id, checkpoints_sum, medal_type_id) VALUES (1,40,2);
INSERT INTO medals_users (role_id, checkpoints_sum, medal_type_id) VALUES (1,60,3);

