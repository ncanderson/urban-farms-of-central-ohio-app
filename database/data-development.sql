-- *****************************************************************************
-- This script contains INSERT statements for populating tables with seed data
-- *****************************************************************************

BEGIN;

-- Insert contact preferences
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name) VALUES (1, 'Home');
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name) VALUES (2, 'Work');
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name) VALUES (3, 'Mobile');
INSERT INTO contact_preference_type (contact_preference_type_id, contact_preference_type_name) VALUES (4, 'Other');

-- Insert Sale types
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (1, 'Sale - Restaurant');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (2, 'Sale - Wholesale');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (3, 'Sale - CSA');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (4, 'Sale - Farmers Market');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (5, 'Donation');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (6, 'Farm Stand');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (7, 'Compost');
INSERT INTO sale_type (sale_type_id, sale_type_name) VALUES (8, 'Other');

-- Insert Invoice Status
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (1, 'Pending');
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (2, 'Review');
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (3, 'Confirm');
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (4, 'Approved');
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (5, 'Paid');
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (6, 'Delivered');

-- *****************************************************************************
-- 								SEED DATA
-- *****************************************************************************

-- Insert Buyers
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (1,'Finale','7842 Vel, Rd.','fermentum metus.','Detroit','MI','20221','Nam interdum enim non nisi. Aenean eget metus. In','(997) 637-3374','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus.','true','Lorem ipsum dolor sit', 'true', '0.2');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (2,'Lavasoft','Ap #857-6443 Sit Street','tristique aliquet.','Rockford','IL','96953','sit amet, faucibus ut, nulla. Cras','(805) 278-4309','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','true','Lorem ipsum dolor', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (3,'Google','Ap #265-4324 Pulvinar Ave','consectetuer euismod','Aurora','CO','48745','non lorem vitae odio sagittis semper. Nam tempor diam dictum','(483) 303-3362','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et','true','Lorem ipsum dolor sit amet', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (4,'Google','342-8167 Nulla Street','mauris erat','Hattiesburg','MS','72365','felis.','(623) 504-7742','Lorem','true','Lorem ipsum', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (5,'Chami','392-4440 Tellus Rd.','neque sed','Fort Smith','AR','71196','urna. Nunc quis arcu','(229) 857-1815','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam','true','Lorem ipsum dolor', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (6,'Cakewalk','479-5059 Dolor Road','justo eu','Hartford','CT','90844','convallis est, vitae sodales nisi','(451) 411-5583','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor.','true','Lorem', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (7,'Apple Systems','802-4731 Mauris Av.','ullamcorper eu,','Little Rock','AR','71852','ante bibendum ullamcorper. Duis','(428) 388-6185','Lorem ipsum dolor','true','Lorem ipsum', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (8,'Chami','P.O. Box 772, 2051 Nec Ave','sodales. Mauris','Fresno','CA','90647','Nam nulla magna, malesuada vel, convallis in, cursus et, eros.','(550) 631-9892','Lorem ipsum dolor sit amet, consectetuer','true','Lorem ipsum dolor', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (9,'Lycos','1765 Egestas Rd.','eu erat','Augusta','ME','60042','nulla vulputate dui, nec tempus','(286) 101-4113','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et arcu imperdiet ullamcorper. Duis at lacus. Quisque purus sapien, gravida non,','true','Lorem ipsum dolor sit amet,', 'false', '.1');
INSERT INTO "buyer_information" (buyer_id,buyer_name,address1,address2,city,state_code,zipcode,delivery_times,contact_phone,notes,is_active,description, apply_large_order_discount, discount) VALUES (10,'Google','P.O. Box 482, 8641 Sagittis Avenue','eleifend vitae,','Little Rock','AR','71153','erat. Vivamus nisi.','(212) 584-5167','Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Curabitur sed tortor. Integer aliquam adipiscing','true','Lorem ipsum dolor sit amet,', 'false', '.1');

-- Insert Credentials
INSERT INTO credentials (credentials_id, password) VALUES (1, '1234');
INSERT INTO credentials (credentials_id, password) VALUES (2, '1234');
INSERT INTO credentials (credentials_id, password) VALUES (3, '1234');

-- Insert Development Users
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (1, 'some@admin.com', 1, 1, 'Admin', 'Joe', 'true', 'false', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (2, 'some@farmer.com', 2, 2, 'Farmer', 'Joe', 'false', 'true', 'true');
INSERT INTO users (user_id, email, user_type, credentials_id, first_name, last_name, is_global_admin, is_admin, is_active) VALUES (3, 'some@buyer.com', 3, 3, 'Buyer', 'Joe', 'false', 'false', 'true');

-- Insert Development Items
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (1,'Acorn Squash','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (2,'Arugula','','Field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (3,'Arugula ','Baby','wait until dry'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (4,'Asparagus','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (5,'Baby Swiss Chard','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (6,'Basil ','Green','HT2'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (7,'Basil ','Purple',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (8,'Arugula ','Baby ','Mid-size leaves'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (9,'Beets ','Baby','Multicolored'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (10,'Beets ','Baby - Golden',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (11,'Beets ','Baby - Red',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (12,'Beets ','Chioggia','Largest'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (13,'Beets ','Golden','Largest'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (14,'Beets ','Red','Largest'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (15,'Black beans','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (16,'Arugula ','HT','Largest leaves'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (17,'Broccoli','','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (18,'Butternut Squash','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (19,'Beets - BULK','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (20,'Cabbage ','Green',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (21,'Cabbage ','Red','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (22,'Beets','','Clear out field bed, then harvest from HT if needed'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (23,'Carrots ','Baby','Multicolored'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (24,'Beets ','HT',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (25,'Cauliflower','','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (26,'Chard','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (27,'Cheese Pumpkins','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (28,'Cabbage','','any varieties'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (29,'Cucumbers','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (30,'Delicata Squash','','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (31,'Dill','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (32,'Braising Mix','','Mix of large chard, collards, green kale, mustard'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (33,'Carrots ','Multicolored','Harvest from field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (34,'Eggplant ','Green Thai',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (35,'Eggplant ','Japanese',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (36,'Eggplant','','Any variety'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (37,'Fennel ','baby',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (38,'Flowers','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (39,'Garlic','','in shipping container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (40,'Garlic ','B Grade',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (41,'Carrots ','Multicolored - BULK','Harvest all from field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (42,'Green Beans','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (43,'Herb Starts','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (44,'Kale','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (45,'Carrots','','HT'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (46,'Collards ','HT','1 leaf/plant'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (47,'Eggplant ','Fairy Tale',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (48,'Fennel','','in shipping container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (49,'Leeks','','Harvest 35 leeks'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (50,'Leeks ','baby',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (51,'Garlic Scapes','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (52,'Lettuce ','Baby Green',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (53,'Lettuce ','Baby Red',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (54,'Kale ','Baby','*Red Russian only'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (55,'Lettuce ','Full Size Green',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (56,'Lettuce ','Full Size Red',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (57,'Mizuna','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (58,'Carrots ','HT','Selectively harvest largest HT3'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (59,'Okra','','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (60,'Okra ','Green',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (61,'Okra ','Red',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (62,'Onion ','Red',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (63,'Onion ','Spring',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (64,'Onion ','White',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (65,'Onions','','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (66,'Pac Choi','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (67,'Kale ','Red Russian','Baby size - From field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (68,'Patty Pan Squash','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (69,'Kale ','Green ','1 leaf/plant'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (70,'Peppers ','Bell',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (71,'Peppers ','Green','Already harvested'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (72,'Peppers ','Habaneros',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (73,'Kale ','Lacinato','Field - clear out any available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (74,'Peppers ','Hungarian Hot Wax','Wheatland - all available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (75,'Lettuce','','16 large heads'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (76,'Peppers ','Jalapenos',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (77,'Peppers ','Mini Sweet',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (78,'Lettuce ','Baby','30 heads'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (79,'Peppers ','Shishito','All Available - clear out beds'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (80,'Peppers ','Padron',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (81,'Peppers ','Hot','Already harvested'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (82,'Potatoes','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (83,'Potatoes ','Fingerling',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (84,'Pumpkin','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (85,'Collards','','Field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (86,'Radish - BULK','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (87,'Peppers ','Thai Chile','Already harvested'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (88,'Radish ','Easter Egg - Bulk','All Available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (89,'Radish ','French Breakfast',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (90,'Parsley','','Clear cut plants'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (91,'Peppers ','Sweet',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (92,'Scallions ','Purple',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (93,'Radish ','Easter Egg',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (94,'Spinach ','Baby',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (95,'Spring Garlic','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (96,'Strawberries','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (97,'Summer Squash','','Pick all available- last harvest'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (98,'Peas','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (99,'Radish ','Purple Daikon',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (100,'Swiss Chard','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (101,'Peppers ','Italian Sweet',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (102,'Radish','','Mix of Easter Egg (HT) and Watermelon (field)'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (103,'Kale ','Baby ','3 lbs of RR baby kale kept separate; 10 lbs of RR/Green kale'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (104,'Tomatoes','','In shipping container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (105,'Tomatoes ','B Grade','Paste tomatoes'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (106,'Tomatoes ','Cherry','In Shipping Container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (107,'Tomatoes ','Green','in shipping container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (108,'Tomatoes ','Heirloom','In Shipping Container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (109,'Tomatoes ','Paste','Ripe/slightly underripe'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (110,'Tomatoes ','Slicer','All ripe, slightly underripe'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (111,'Turnip Greens','','harvest only greens from older beds'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (112,'Kale ','Green','Field - clear out any available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (113,'Radish ','Purple Daikon - BULK',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (114,'Turnips','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (115,'Watermelon','','In shipping container'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (116,'Mustard','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (117,'Zucchini','','Pick all available'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (118,'Radish ','Easter Egg ',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (119,'Sage','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (120,'Radish ','Watermelon',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (121,'Radish ','HT',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (122,'Salad ','Baby Mix','Harvest from field - two beds of lettuce'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (123,'Sunchoke','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (124,'Sweet Potato','','Pull all good ones'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (125,'Swiss Chard ','Rainbow','From field'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (126,'Salad Mix ','HT','Mix of medium size HT leaf lettuce, chard, kale, mustard, tat soi'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (127,'Turnips ','Hakurei - BULK',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (128,'Thyme','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (129,'Turnips ','Hakurei','Nicest greens - field turnips'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (130,'Scallions','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (131,'Spinach','',''); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (132,'Swiss Chard ','HT','1-2 leaves first from HT'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (133,'Turnips ','Hakurei ','Largest only (golf ball size)'); 
INSERT INTO item (item_id, item_type, item_variety, item_image_id, item_description) VALUES (134,'Winter Squash','',''); 



COMMIT;