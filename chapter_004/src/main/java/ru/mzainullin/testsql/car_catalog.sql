CREATE TABLE car (
  id serial NOT NULL,
  car_name varchar(255),
  car_body int references car_body(id),
  transmission int references transmission(id),
  engine int references engine(id)
);

CREATE TABLE car_body (
  id serial NOT NULL,
  name varchar(255)
);

CREATE TABLE engine (
  id serial NOT NULL,
  name varchar(255)
);

CREATE TABLE transmission (
  id serial NOT NULL,
  name varchar(255)
);

--1. Вывести список всех машин и все привязанные к ним детали.
select c.car_name, b.name, t.name, e.name from car as c 
left outer join car_body as b on c.id = b.id
left outer join transmission as t on c.id = t.id
left outer join engine as e on c.id = e.id;

--2. Вывести отдельно детали, которые не используются в машине,
--кузова, двигатели, коробки передач.

select c.car_name, b.name, t.name, e.name from car as c 
left outer join car_body as b on c.id = null
left outer join transmission as t on c.id = null
left outer join engine as e on e.id = c.id where e.id is null;
-- Не смог вывести. 