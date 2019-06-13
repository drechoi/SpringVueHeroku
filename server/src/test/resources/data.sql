-- initial testing data
INSERT INTO app_user (extId) VALUES ('test-ext-id-01');

INSERT INTO scheme (name, owner_id) VALUES ('testing_scheme', 1);
INSERT INTO backer (id, backed_scheme_id, is_owner) VALUES (1, 1, 1);
