CREATE TABLE comments
(
  id serial NOT NULL,
  description text,
  item_id integer,
  CONSTRAINT comments_pkey PRIMARY KEY (id),
  CONSTRAINT comments_item_id_fkey FOREIGN KEY (item_id)
      REFERENCES items (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE type
(
  id serial NOT NULL,
  name character varying(200),
  CONSTRAINT type_pkey PRIMARY KEY (id)
);



--1. Написать запрос получение всех продуктов с типом "СЫР"
SELECT p.name, t.name FROM product p INNER JOIN type t ON p.type_id = t.id WHERE t.name='cheese_products';

--2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as p where p.name='%zabava%';

-- вставил новые данные
insert into product(name, expired_date, price) values ('Просроченный продукт', '2018-09-09', '1.00');

--3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product as p where p.expired_date>'2018-08-31';

--4.Написать запрос, который вывод самый дорогой продукт.
select MAX(price) FROM product;

--5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(*) from product where type_id=4;

--6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as p where p.type_id in (1, 7);

-- добавил новую колонку count_products и вставил данные для разных id. От 1 до 7
UPDATE product SET count_product = 25 WHERE id =7;

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук. 
SELECT name, count_product FROM product GROUP BY id HAVING count_product < 10;

--8. Вывести все продукты и их тип.
select p.name, t.name, p.expired_date, p.price from product as p inner join type as t on p.type_id = t.id;