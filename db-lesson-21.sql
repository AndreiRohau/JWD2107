WITH
filtered_cities AS (SELECT id FROM cities c WHERE LOWER(c.city) = 'minsk'),
filtered_addresses AS (SELECT id FROM addresses a WHERE a.city_id IN (SELECT * FROM filtered_cities)),
filtered_result AS (SELECT login, address_id FROM users u WHERE u.address_id IN (SELECT * FROM filtered_addresses))
SELECT * FROM filtered_result;

SELECT * FROM users u
JOIN addresses a ON u.address_id = a.id
JOIN cities c ON a.city_id = c.id
WHERE LOWER(c.city) = 'minsk';

SELECT * FROM cities c ORDER BY c.country, c.city ASC;

SELECT o.id, o.name, count(o.id) FROM users u
JOIN occupations o ON o.id = u.occupation_id
GROUP BY o.id
HAVING o.id = 2;

SELECT * FROM users u
ORDER BY lastname, firstname ASC
LIMIT 3 OFFSET 0;

WITH all_products(
SELECT pc.name as name, pc.price as price, pc.description as description FROM pcs pc
UNION
SELECT p.name as name, p.price as price, p. description as description FROM phones p)
SELECT * FROM all_products ORDER BY name ASC
LIMIT 50 OFFSET 0;
--UNION ALL collect (sum up) data with duplicates

SELECT id FROM products --0,1,2,3,4,5,5,6,7,8,9,
INTERSECT
SELECT id FROM products p WHERE p.type='PC'; -- 1,2,3,4,5,5,10,11,12
--result INTERSECT
-- 1,2,3,4,5
--result INTERSECT ALL ... including duplicates
-- 1,2,3,4,5,5

SELECT id FROM products --0,1,2,3,4,5,5,6,7,8,9,
EXCEPT
SELECT id FROM products p WHERE p.type='PC'; -- 1,2,3,4,5,5,10,11,12
--result
--0,6,7,8,9,

create or replace FUNCTION public.f_user_logins()
  returns TABLE (login   text)
AS
$func$
  SELECT login
  FROM public.users;
$func$
LANGUAGE sql;

select *
from f_user_logins();