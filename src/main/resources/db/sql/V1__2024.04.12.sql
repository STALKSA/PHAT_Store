DROP TABLE IF EXISTS items_t;
DROP TABLE IF EXISTS brands_t;
DROP TABLE IF EXISTS categories_t;

CREATE TABLE categories_t
(
    id   SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL UNIQUE
);

CREATE TABLE brands_t
(
    id   SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL UNIQUE
);

CREATE TABLE items_t
(
    id          SERIAL PRIMARY KEY,
    model       varchar(200) NOT NULL,
    amount      int         NOT NULL CHECK ( amount >= 0 ),
    size        varchar(4)  NOT NULL,
    color       varchar(10) NOT NULL,
    sex         varchar(6)  NOT NULL,
    price       int         NOT NULL CHECK ( price > 0 ),
    brand_id    int         NOT NULL references brands_t (id),
    category_id int         NOT NULL references categories_t (id)
);
