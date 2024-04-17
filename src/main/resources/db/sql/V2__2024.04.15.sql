INSERT INTO categories_t (name)
VALUES ('ГОЛОВНЫЕ УБОРЫ'),
       ('ОДЕЖДА'),
       ('ОБУВЬ'),
       ('СУМКИ'),
       ('АКСЕССУАРЫ'),
       ('ТВОРЧЕСТВО');

INSERT INTO brands_t (name)
VALUES ('KANGOL'),
       ('PROCLUB'),
       ('NOVESTA'),
       ('PHAT');

INSERT INTO items_t (model, amount, size, color, brand_id, category_id)
VALUES ('Kangol', 5, 'M', 'ЗЕЛЕНЫЙ', 1, 1),
       ('Kangol', 3, 'L', 'ЗЕЛЕНЫЙ', 1, 1),
       ('Kangol', 17, 'M', 'ЗЕЛЕНЫЙ', 1, 1),
       ('Kangol', 8, 'S', 'БЕЛЫЙ', 1, 1),
       ('Kangol', 10, 'L', 'ЗЕЛЕНЫЙ', 1, 1),
       ('Kangol', 9, 'S', 'БЕЛЫЙ', 1, 1),
       ('Kangol', 13, 'L', 'ЗЕЛЕНЫЙ', 1, 1),
       ('Kangol', 10, 'L', 'БЕЖЕВЫЙ', 1, 1),
       ('Kangol', 5, 'M', 'БЕЛЫЙ', 1, 1),
       ('Kangol', 4, 'M', 'КРАСНЫЙ', 1, 1),
       ('Kangol', 13, 'L', 'БЕЖЕВЫЙ', 1, 1),
       ('Kangol', 3, 'L', 'БЕЖЕВЫЙ', 1, 1),
       ('Kangol', 4, 'L', 'КРАСНЫЙ', 1, 1),
       ('Kangol', 0, 'S', 'ЧЕРНЫЙ', 1, 1),
       ('Kangol', 6, 'L', 'БЕЛЫЙ', 1, 1),
       ('Proclub', 14, 'XL', 'ЗЕЛЕНЫЙ', 2, 2),
       ('Proclub', 10, 'L', 'ЗЕЛЕНЫЙ', 2, 2),
       ('Proclub', 10, 'L', 'ЗЕЛЕНЫЙ', 2, 2),
       ('Proclub', 9, 'M', 'БЕЛЫЙ', 2, 2),
       ('Proclub', 11, 'XS', 'БЕЛЫЙ', 2, 2),
       ('Proclub', 6, 'XS', 'ЧЕРНЫЙ', 2, 2),
       ('Proclub', 6, 'M', 'КРАСНЫЙ', 2, 2),
       ('Proclub', 15, 'XS', 'ЧЕРНЫЙ', 2, 2),
       ('Proclub', 16, 'XL', 'БЕЖЕВЫЙ', 2, 2),
       ('Proclub', 12, 'S', 'КРАСНЫЙ', 2, 2),
       ('Proclub', 1, 'M', 'КРАСНЫЙ', 2, 2),
       ('Proclub', 4, 'XS', 'КРАСНЫЙ', 2, 2),
       ('Proclub', 15, 'XS', 'КРАСНЫЙ', 2, 2),
       ('Proclub', 11, 'M', 'ЧЕРНЫЙ', 2, 2),
       ('Proclub', 4, 'L', 'ЗЕЛЕНЫЙ', 2, 2),
       ('Novesta', 1, '42', 'БЕЛЫЙ', 3, 3),
       ('Novesta', 11, '44', 'ЗЕЛЕНЫЙ', 3, 3),
       ('Novesta', 3, '39', 'КРАСНЫЙ', 3, 3),
       ('Novesta', 3, '40', 'БЕЖЕВЫЙ', 3, 3),
       ('Novesta', 7, '40', 'ЗЕЛЕНЫЙ', 3, 3),
       ('Novesta', 18, '36', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 13, '41', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 0, '42', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 9, '42', 'БЕЛЫЙ', 3, 3),
       ('Novesta', 13, '39', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 14, '41', 'БЕЛЫЙ', 3, 3),
       ('Novesta', 0, '38', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 1, '42', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 7, '41', 'ЧЕРНЫЙ', 3, 3),
       ('Novesta', 17, '41', 'БЕЛЫЙ', 3, 3);
