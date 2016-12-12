INSERT INTO item_harvest_details(item_id, harvest_quantity, harvest_date, item_price) VALUES(34, 10, '12/11/2016 09:34:00', '4.25');


SQL Statement to update harvest details quantity.

BEGIN;
UPDATE item_harvest_details SET harvest_quantity = 0;
COMMIT;


 SELECT item_harvest_details_id, harvest_quantity, item_price FROM item_harvest_details WHERE harvest_quantity > 0;


SELECT item_id, item_price, max(harvest_date) as maxDate
FROM item_harvest_details
WHERE item_id = 5;

SELECT item_price, max(harvest_date) as max_date
FROM item_harvest_details
WHERE item_id = 5
GROUP BY item_price
LIMIT 1;