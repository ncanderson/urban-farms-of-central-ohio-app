-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- Insert contact preferences
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name, contact_preference_type_description) VALUES (1, 'Home', );
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name, contact_preference_type_description) VALUES (2, 'Work', );
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name, contact_preference_type_description) VALUES (3, 'Mobile', );
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name, contact_preference_type_description) VALUES (4, 'Other', );

-- Insert User types
INSERT INTO user_type (user_type_id, user_type_name, user_type_description) VALUES (1, 'Admin', );
INSERT INTO user_type (user_type_id, user_type_name, user_type_description) VALUES (2, 'Buyer', );
INSERT INTO user_type (user_type_id, user_type_name, user_type_description) VALUES (3, 'Farmer', );

-- Insert Sale types
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (1, 'Sale - Restaurant', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (2, 'Sale - Wholesale', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (3, 'Sale - CSA', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (4, 'Sale - Farmers Market', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (5, 'Donation', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (6, 'Farm Stand', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (7, 'Compost', );
INSERT INTO sale_type (sale_type_id, sale_type_name, sale_type_description) VALUES (8, 'Other', );

-- Insert Invoice Status
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (1, 'Pending', );
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (2, 'Review', );
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (3, 'Confirm', );
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (4, 'Approved', );
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (5, 'Paid', );
INSERT INTO invoice_status (invoice_status_id, invoice_status_name, invoice_status_description) VALUES (6, 'Delivered', );

-- *****************************************************************************
-- 								SEED DATA
-- *****************************************************************************

INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (1,'Finale','7842 Vel, Rd.','fermentum metus.','Detroit','MI','20221','Nam interdum enim non nisi. Aenean eget metus. In','(997) 637-3374','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus.','true','Lorem ipsum dolor sit');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (2,'Lavasoft','Ap #857-6443 Sit Street','tristique aliquet.','Rockford','IL','96953','sit amet, faucibus ut, nulla. Cras','(805) 278-4309','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','true','Lorem ipsum dolor');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (3,'Google','Ap #265-4324 Pulvinar Ave','consectetuer euismod','Aurora','CO','48745','non lorem vitae odio sagittis semper. Nam tempor diam dictum','(483) 303-3362','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','true','Lorem ipsum dolor sit amet,');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (4,'Google','342-8167 Nulla Street','mauris erat','Hattiesburg','MS','72365','felis.','(623) 504-7742','Lorem','true','Lorem ipsum');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (5,'Chami','392-4440 Tellus Rd.','neque sed','Fort Smith','AR','71196','urna. Nunc quis arcu','(229) 857-1815','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam','true','Lorem ipsum dolor');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (6,'Cakewalk','479-5059 Dolor Road','justo eu','Hartford','CT','90844','convallis est, vitae sodales nisi','(451) 411-5583','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor.','true','Lorem');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (7,'Apple Systems','802-4731 Mauris Av.','ullamcorper eu,','Little Rock','AR','71852','ante bibendum ullamcorper. Duis','(428) 388-6185','Lorem ipsum dolor','true','Lorem ipsum');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (8,'Chami','P.O. Box 772, 2051 Nec Ave','sodales. Mauris','Fresno','CA','90647','Nam nulla magna, malesuada vel, convallis in, cursus et, eros.','(550) 631-9892','Lorem ipsum dolor sit amet, consectetuer','true','Lorem ipsum dolor');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (9,'Lycos','1765 Egestas Rd.','eu erat','Augusta','ME','60042','nulla vulputate dui, nec tempus','(286) 101-4113','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','true','Lorem ipsum dolor sit amet,');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description) VALUES (10,'Google','P.O. Box 482, 8641 Sagittis Avenue','eleifend vitae,','Little Rock','AR','71153','erat. Vivamus nisi.','(212) 584-5167','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing','true','Lorem ipsum dolor sit amet,');


COMMIT;