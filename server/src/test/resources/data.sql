-- initial testing data
INSERT INTO app_user (id, ext_id, user_name) VALUES (1, 'test-ext-id-01', 'u1');
INSERT INTO app_user (id, ext_id, user_name) VALUES (2, 'test-ext-id-02', 'u2');
INSERT INTO app_user (id, ext_id, user_name) VALUES (3, 'test-ext-id-03', 'u3');
INSERT INTO app_user (id, ext_id, user_name) VALUES (4, 'test-ext-id-04', 'u4');

INSERT INTO scheme (name, owner_id) VALUES ('testing_scheme1', 1);
INSERT INTO scheme (name, owner_id) VALUES ('testing_scheme2', 2);

INSERT INTO backer (id, backed_scheme_id, is_owner) VALUES (1, 1, 1);
INSERT INTO backer (id, backed_scheme_id, is_owner) VALUES (2, 2, 1);


INSERT INTO joiner (id, joined_scheme_id) VALUES (2, 1);
INSERT INTO joiner (id, joined_scheme_id) VALUES (3, 1);
INSERT INTO joiner (id, joined_scheme_id) VALUES (4, 1);



