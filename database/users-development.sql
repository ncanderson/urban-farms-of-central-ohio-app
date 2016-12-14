-- Insert Development Users
BEGIN;

INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (0, 'some@archive.com', 0, 1, 'Archive', 'User', 'false', 'false', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (1, 'some@admin.com', 0, 1, 'Admin', 'Joe', 'true', 'true', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (2, 'some@farmer.com', 1, 2, 'Farmer', 'Joe', 'false', 'true', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (3, 'some@buyer.com', 2, 3, 'Buyer', 'Joe', 'false', 'false', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (4, 'someother@farmer.com', 1, 2, 'Farmer', 'Jane', 'false', 'false', 'true');

COMMIT;