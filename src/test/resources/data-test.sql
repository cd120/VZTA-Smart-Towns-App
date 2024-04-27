-- insert into roles_table (role_id, name)
-- values
--     (1, 'ADMIN'),
--     (2, 'USER');
--
-- -- add default admin account
-- insert into user_table (username, password, enabled)
-- values ('admin', '$2a$12$zKMHlbOC7UXOLCdq5ZibC.ANCzcxgpoGbode97Dc2Fi1zakG2fP6O', true);
--
-- insert into users_roles (username, role_id)
-- values ('admin', 1);

INSERT INTO medal_types (medal_name, medal_description) VALUES ('mockBronze', 'fake bronze first medal');
INSERT INTO medal_types (medal_name, medal_description) VALUES ('mockSilver', 'fake silver second medal');