CREATE TABLE IF NOT EXISTS products(
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	description TEXT,
	score FLOAT,
	title VARCHAR(255),
	ubication VARCHAR(255),
	category_id SERIAL NOT NULL,
	city_id SERIAL NOT NULL,
	feature_id SERIAL NOT NULL
	);

ALTER TABLE products
ADD COLUMN feature_id SERIAL NOT NULL

ALTER TABLE products
DROP COLUMN feature
	
CREATE TABLE IF NOT EXISTS categories(
	id SERIAL NOT NULL PRIMARY KEY,
	description VARCHAR(255),
	title VARCHAR(255),
	url_image VARCHAR(255)
	);
	
CREATE TABLE IF NOT EXISTS cities(
	id SERIAL NOT NULL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	country VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS features(
	id SERIAL NOT NULL PRIMARY KEY,
	description VARCHAR(255),
	title VARCHAR(255)
	);
	
CREATE TABLE IF NOT EXISTS product_has_feature(
	product_id SERIAL NOT NULL,
	feature_id SERIAL NOT NULL,
	FOREIGN KEY (product_id) REFERENCES product(id),
	FOREIGN KEY (feature_id) REFERENCES features(id)
);

CREATE TABLE IF NOT EXISTS images(
	id SERIAL NOT NULL PRIMARY KEY,
	url_image VARCHAR(255));

ALTER TABLE images
ADD COLUMN product_id SERIAL NOT NULL;

ALTER TABLE images
ADD FOREIGN KEY (product_id) REFERENCES products(id);


CREATE TABLE IF NOT EXISTS reservations(
	id SERIAL NOT NULL PRIMARY KEY,
	check_in DATE NOT NULL,
	check_out DATE NOT NULL,
	reservation_time TIME NOT NULL
);

ALTER TABLE products
ADD FOREIGN KEY (category_id) REFERENCES categories(id);

ALTER TABLE products
ADD FOREIGN KEY (city_id) REFERENCES cities(id);

ALTER TABLE products
ADD FOREIGN KEY (feature_id) REFERENCES features(id);
