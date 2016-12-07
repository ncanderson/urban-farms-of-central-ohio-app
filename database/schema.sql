-- *************************************************************************************************
-- This script creates all of the database objects (tables, sequences, etc) for the database
-- *************************************************************************************************

BEGIN;

CREATE TABLE buyer_information (
  buyer_id serial PRIMARY KEY,
  buyer_name varchar(80) NOT NULL,    -- Name of the buyer
  address1 varchar(50) NULL,      	  -- Address first line
  address2 varchar(50) NULL,      	  -- Address second line
  city varchar(20) NULL,     
  state_code varchar(2) NULL,
  zipcode varchar (10) NULL,
  delivery_times varchar(100) NULL,	  -- Text field for delivery times
  contact_phone varchar(15) NULL,	  -- 10 digit phone number without special characters
  notes varchar (250) NULL, 		  -- Optional notes field
  is_active boolean NOT NULL,		  -- True for active buyers
  description varchar(150) NULL,  	  -- Description of buyer
  apply_large_order_discount boolean NOT NULL,  -- Boolean to determain if buyer gets discount for orders >$150
  discount decimal(3,2) NULL constraint chk_buyer_information_discount check (discount between 0 and 1) 		  -- Discount value stored as X.XX ie 50% is stored as 0.50
);

CREATE TABLE credentials (
  credentials_id serial PRIMARY KEY,
  password varchar(30) NOT NULL,
  salt varchar(200) NOT NULL
);

CREATE TABLE contact_preference_type (
  contact_preference_type_id serial PRIMARY KEY,
  contact_preference_type_name varchar(6) NOT NULL,
  contact_preference_type_description varchar(150) NULL
);

CREATE TABLE sale_type (
  sale_type_id serial PRIMARY KEY,
  sale_type_name varchar(25) NOT NULL,
  sale_type_description varchar(150) NULL
);

CREATE TABLE invoice_status (
  invoice_status_id serial PRIMARY KEY,
  invoice_status_name varchar(25) NOT NULL,
  invoice_status_description varchar(150) NULL
);

-- all users have a type 1) admin, 2) farmer, 3) buyer
CREATE TABLE users (
  user_id serial PRIMARY KEY,
  email varchar(100) NOT NULL, -- email is username 
  user_type integer NOT NULL,
  buyer_id integer NULL REFERENCES buyer_information,
  credentials_id integer NOT NULL REFERENCES credentials,
  first_name varchar(80) NOT NULL,
  last_name varchar(80) NOT NULL,
  contact_preference_type_id integer NULL REFERENCES contact_preference_type,
  user_phone_number varchar(15) NULL,
  is_global_admin boolean NOT NULL,
  is_admin boolean NOT NULL,
  is_active boolean NOT NULL
);

CREATE TABLE item (
  item_id serial PRIMARY KEY,
  item_type varchar(25) NOT NULL,
  item_variety varchar(25) NULL,
  item_image_id varchar(50) NULL,
  item_description varchar(150) NULL
);

CREATE TABLE item_price (
  item_price_id serial PRIMARY KEY,
  item_id integer NOT NULL,
  date_added timestamp NOT NULL,
  sale_type_id integer NOT NULL,
  item_price money NOT NULL
);

CREATE TABLE invoice (
  invoice_id serial PRIMARY KEY,
  invoice_date timestamp NOT NULL,
  user_id integer NOT NULL REFERENCES users,
  buyer_id integer NOT NULL REFERENCES buyer_information,
  sale_type_id integer NOT NULL,
  invoice_status_id integer NOT NULL REFERENCES invoice_status
);

CREATE TABLE item_harvest_details (
  item_harvest_details_id serial PRIMARY KEY,
  item_id integer NOT NULL REFERENCES item,
  harvest_quantity integer NOT NULL,
  item_price_id integer NULL REFERENCES item_price,
  harvest_image_id varchar(25) NULL,
  average_size_of_item varchar(100) NULL,
  harvest_details_comments varchar(150) NULL,
  harvest_date timestamp NOT NULL
);

CREATE TABLE invoice_item (
  invoice_item_id serial PRIMARY KEY,
  invoice_id integer NOT NULL REFERENCES invoice,
  invoice_quantity integer NOT NULL,
  item_harvest_details_id integer NOT NULL REFERENCES item_harvest_details,
  item_price_id integer NOT NULL REFERENCES item_price,
  invoice_date timestamp NOT NULL
  );


COMMIT;