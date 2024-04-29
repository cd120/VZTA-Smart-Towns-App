insert into roles_table (role_id, name)
values
    (1, 'ADMIN'),
    (2, 'USER');

-- add default admin account
insert into user_table (username, password, enabled)
values ('admin', 'admin', false);

insert into users_roles (username, role_id)
values ('admin', 1);

INSERT INTO medal_types (medal_name, medal_description) VALUES ('mockBronze', 'fake bronze first medal');
INSERT INTO medal_types (medal_name, medal_description) VALUES ('mockSilver', 'fake silver second medal');