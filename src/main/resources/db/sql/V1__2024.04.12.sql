DROP TABLE IF EXISTS categories_t;
DROP TABLE IF EXISTS brands_t;
DROP TABLE IF EXISTS items_t;

CREATE TABLE categories_t
(
    id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE brands_t
(
    id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL
);

CREATE TABLE items_t
(
    id SERIAL PRIMARY KEY,
    model varchar(50) NOT NULL,
    amount int NOT NULL CHECK ( amount >= 0 ),
    size varchar(4) NOT NULL,
    color varchar(10) NOT NULL,
    brand_id int references brands_t(id),
    category_id int references categories_t(id)
);
