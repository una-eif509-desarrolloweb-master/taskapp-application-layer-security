/*
 * Universidad Nacional de Costa Rica  2020
 *
 * mike@guzmanalan.com
 */

INSERT INTO public.priority (label) VALUES ('High');
INSERT INTO public.priority (label) VALUES ('Medium');
INSERT INTO public.priority (label) VALUES ('Low');

INSERT INTO public.privilege (name) VALUES ('READ_PRIVILEGE');
INSERT INTO public.privilege (name) VALUES ('WRITE_PRIVILEGE');

INSERT INTO public.role (name) VALUES ('ROLE_ADMIN');
INSERT INTO public.role (name) VALUES ('ROLE_USER');

INSERT INTO public.role_privilege (id_role, id_privilege) VALUES (1, 2);
INSERT INTO public.role_privilege (id_role, id_privilege) VALUES (2, 1);

INSERT INTO public.users (createdate, email, enabled, firstname, lastname, password, tokenexpired, username)
VALUES ('2020-09-04 22:14:02.000000', 'admin@mikeguzman.info', true, 'Maikol', 'Guzman',
        '$2a$10$nQLncZ5XKsCD5R6c16me1O8CtfzL0Y4qljE0KMPQkRd2.grz41fsS', false, 'admin');

INSERT INTO public.user_role (id_user, id_role) VALUES (1, 1);