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
INSERT INTO invoice_status (invoice_status_id, invoice_status_name) VALUES (7, 'Archived');

COMMIT;