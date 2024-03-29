INSERT INTO item_harvest_details(item_id, harvest_quantity, harvest_date, item_price) VALUES(34, 10, '12/11/2016 09:34:00', '4.25');


SQL Statement to update harvest details quantity.

BEGIN;
UPDATE item_harvest_details SET harvest_quantity = 0;
COMMIT;

SELECT * FROM item_harvest_details WHERE harvest_quantity > 0;

 SELECT item_harvest_details_id, harvest_quantity, average_size_of_item, item_price FROM item_harvest_details WHERE harvest_quantity > 0;

SELECT item_price, harvest_date
FROM item_harvest_details
WHERE item_id = 5
ORDER BY harvest_date desc
LIMIT 1;

 SELECT * FROM item_harvest_details WHERE harvest_quantity > 0;

 SELECT item_harvest_details_id as ID, item_id as Item, harvest_quantity as Qty, harvest_image_id as Img, average_size_of_item as Size, harvest_availability as Avail, harvest_details_comments as Notes, harvest_date as Date, item_price as Price, harvest_end_date as End, pick_list_comments as Pick, is_bulk, harvest_reconciliation_id as Rec FROM item_harvest_details WHERE harvest_quantity > 0;

SELECT item_id as ID, item_type as TYPE, item_variety as VAR, item_description as DES, is_active as Active FROM item LIMIT 50; 

SELECT user_id as ID, user_type as Type, first_name as FName, last_name as LName, user_phone_number as Phone, buyer_name as Org, users.is_active as Active FROM users INNER JOIN buyer_information ON users.buyer_id = buyer_information.buyer_id;

INSERT INTO item_harvest_details (item_id, harvest_quantity, average_size_of_item, harvest_availability, harvest_details_comments, pick_list_comments, item_price, harvest_end_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?);

UPDATE item_harvest_details SET harvest_quantity = 0 WHERE item_harvest_details_id = 6932;

SELECT * FROM invoice_item WHERE invoice_id = 4;