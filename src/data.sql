insert into roles_table (role_id, name)
values
    (1, 'ADMIN'),
    (2, 'USER');

-- add default admin account
insert into user_table (username, password, enabled)
values ('admin', '$2a$12$zKMHlbOC7UXOLCdq5ZibC.ANCzcxgpoGbode97Dc2Fi1zakG2fP6O', true);

insert into users_roles (username, role_id)
values ('admin', 1);

--Inserting Medal Types into medal_types
INSERT INTO medal_types (medal_name, medal_description) VALUES ('BRONZE - 20 Checkpoints', 'Well done, you''ve earned your first medal! the Bronze Medal is a testament to your commendable efforts and notable achievement! ');
INSERT INTO medal_types (medal_name, medal_description) VALUES ('SILVER - 40 Checkpoints', 'Congratulations on the Silver Medal! Your dedication and exceptional skill shine through, marking a standout accomplishment.');
INSERT INTO medal_types (medal_name, medal_description) VALUES ('GOLD - 60 Checkpoints', 'Exceptional! You''ve clinched the Gold Medal, a symbol of your outstanding achievement, unwavering dedication, and mastery in your pursuit.');

--Inserting default medals into medal_users table for users based on number of checkpoints collected
INSERT INTO medal_users (username, medal_name) VALUES ('admin', 'BRONZE - 20 Checkpoints');
INSERT INTO medal_users (username, medal_name) VALUES ('admin', 'SILVER - 40 Checkpoints');
INSERT INTO medal_users (username, medal_name) VALUES ('admin', 'GOLD - 60 Checkpoints');

