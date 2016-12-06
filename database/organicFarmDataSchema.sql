DROP TABLE IF EXISTS credentials;
DROP TABLE IF EXISTS contact_preference_type;
DROP TABLE IF EXISTS user_type;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS buyer_information;
DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS sale_type;
DROP TABLE IF EXISTS invoice_harvest_details;
DROP TABLE IF EXISTS item_price;
DROP TABLE IF EXISTS harvest_details;
DROP TABLE IF EXISTS item;

CREATE TABLE buyer_information (
  buyer_id serial PRIMARY KEY,
  buyer_name varchar(80) NOT NULL,    -- Name of the buyer
  address1 varchar(50) NULL,      	  -- Address first line
  address2 varchar(50) NULL,      	  -- Address second line
  city varchar(20) NULL,     
  state_code varchar(2) NULL,
  zipcode varchar (10) NULL,
  delivery_times varchar(100) NULL,	  -- Text field for delivery times
  contact_phone varchar(10) NULL,	  -- 10 digit phone number without special characters
  notes varchar (250) NULL, 		  -- Optional notes field
  is_active boolean NOT NULL,		  -- True for active buyers
  description varchar(150) NULL,  -- Description of buyer
  CONSTRAINT pk_buyer_information_buyer_id PRIMARY KEY (buyer_id)
);

CREATE TABLE credentials (
  credentials_id serial PRIMARY KEY,
  password varchar(25) NOT NULL,
);

CREATE TABLE contact_preference_type (
  contact_preference_type_id serial PRIMARY KEY,
  contact_preference_type_name varchar(6) NOT NULL,
  contact_preference_type_description varchar(150) NULL,
);

CREATE TABLE user_type (
  user_type_id serial PRIMARY KEY,
  user_type_name varchar(15) NOT NULL,
  user_type_description varchar(150) NULL,
);

CREATE TABLE sale_type (
  sale_type_id serial PRIMARY KEY,
  sale_type_name varchar(25) NOT NULL,
  sale_type_description varchar(150) NULL,
);

CREATE TABLE invoice_status (
  invoice_status_id serial PRIMARY KEY,
  invoice_status_name varchar(25) NOT NULL,
  invoice_status_description varchar(150) NULL,
);

CREATE TABLE user (
  user_id serial PRIMARY KEY,
  email varchar(100) NOT NULL, -- email is username 
  user_type_id integer(2) NOT NULL REFERENCES user_type,
  buyer_id integer(10) NULL REFERENCES buyer_information,
  credentials_id integer(10) NOT NULL REFERENCES credentials,
  first_name varchar(80) NOT NULL,
  last_name varchar(80) NOT NULL,
  contact_preference_type_id integer(2) NULL REFERENCES contact_preference_type,
  user_phone_number varchar(10) NULL,
  is_global_admin boolean NOT NULL,
  is_admin boolean NOT NULL,
  is_active boolean NOT NULL,
);

CREATE TABLE item (
  item_id serial PRIMARY KEY,
  item_type varchar(25) NOT NULL,
  item_variety varchar(25) NULL,
  item_image_id varchar(50) NULL,
  item_description varchar(150) NULL,
);

CREATE TABLE item_price (
  item_price_id serial PRIMARY KEY,
  item_id integer(10) NOT NULL,
  date_added date NOT NULL,
  sale_type_id integer(3) NOT NULL,
  item_price money NOT NULL,
);

CREATE TABLE invoice_item (
  invoice_item_id serial PRIMARY KEY,
  invoice_id integer(10) NOT NULL REFERENCES invoice,
  invoice_quantity integer(5) NOT NULL,
  item_harvest_details_id integer(2) NOT NULL REFERENCES harvest_details,
  item_price_id integer(3) NOT NULL REFERENCES item_price,
  );

CREATE TABLE invoice (
  invoice_id serial PRIMARY KEY,
  invoice_date date NOT NULL,
  user_id integer(10) NOT NULL REFERENCES user,
  buyer_id integer(10) NOT NULL REFERENCES buyer_information,
  sale_type_id integer(3) NOT NULL,
  invoice_status_id integer(3) NOT NULL REFERENCES invoice_status
);

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