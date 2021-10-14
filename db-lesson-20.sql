CREATE TABLE IF NOT EXISTS public.occupations
(
	id bigserial PRIMARY KEY,
	name text NOT NULL,
	description text
);

CREATE TABLE IF NOT EXISTS public.cities
(
	id bigserial PRIMARY KEY,
	country text NOT NULL,
	city text NOT NULL,
	code text UNIQUE
);

CREATE TABLE IF NOT EXISTS public.addresses
(
	id bigserial PRIMARY KEY,
	city_id bigint NOT NULL,
	street text,
	building text,
	appartment text,
	CONSTRAINT fk_city FOREIGN KEY(city_id) REFERENCES cities(id)
);

CREATE TABLE IF NOT EXISTS public.schools
(
	school_number integer,
	short_name text,
	CONSTRAINT pk_schools_num_name PRIMARY KEY(school_number, short_name)
);

ALTER TABLE public.schools DROP CONSTRAINT pk_schools_num_name;
ALTER TABLE schools ADD COLUMN id bigserial PRIMARY KEY;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigserial PRIMARY KEY,
    login text COLLATE pg_catalog."default" NOT NULL,
    firstname text COLLATE pg_catalog."default",
    lastname text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_login_unique UNIQUE (login)
)

ALTER TABLE public.users ADD COLUMN address_id bigint;
ALTER TABLE public.users ADD CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES public.addresses(id);

ALTER TABLE public.users ADD COLUMN occupation_id bigint;
ALTER TABLE public.users ADD CONSTRAINT fk_occupation_id FOREIGN KEY (occupation_id) REFERENCES public.occupations(id);

CREATE TABLE IF NOT EXISTS public.users_to_schools
(
    user_id bigint,
    school_id bigint,
    CONSTRAINT user_school_unique UNIQUE (user_id, school_id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES public.users(id),
	CONSTRAINT fk_school_id FOREIGN KEY (school_id) REFERENCES public.schools(id)
);


INSERT INTO cities (country, city, code) VALUES ('BLR', 'Minsk', '220000');
INSERT INTO cities (country, city, code) VALUES ('BLR', 'Brest', '220011');
INSERT INTO cities (country, city, code) VALUES ('BLR', 'Vitebsk', '220022');
INSERT INTO cities (country, city, code) VALUES ('BLR', 'Grodno', '220033');
INSERT INTO cities (country, city, code) VALUES ('BLR', 'Gomel', '220044');
INSERT INTO cities (country, city, code) VALUES ('BLR', 'Mogilev', '220055');

INSERT INTO addresses (city_id, street, building, appartment) VALUES (3, 'A1', '51', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (3, 'A2', '52', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (4, 'A3', '53', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (4, 'A4', '54', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (5, 'A5', '55', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (5, 'A6', '56', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (6, 'A7', '57', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (6, 'A8', '58', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (7, 'A9', '59', '12');
INSERT INTO addresses (city_id, street, building, appartment) VALUES (7, 'A0', '50', '12');

INSERT INTO occupations (name, description) VALUES ('occupation-1', 'description-occup-1');
INSERT INTO occupations (name, description) VALUES ('occupation-2', 'description-occup-2');
INSERT INTO occupations (name, description) VALUES ('occupation-3', 'description-occup-3');

INSERT INTO schools (school_number, short_name) VALUES (51, 'tmp-school-name-1');
INSERT INTO schools (school_number, short_name) VALUES (62, 'tmp-school-name-2');
INSERT INTO schools (school_number, short_name) VALUES (73, 'tmp-school-name-3');

INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-1', 'f-n-1', 'l-n-1', 'pwd-1', 1, 1);
INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-2', 'f-n-2', 'l-n-2', 'pwd-2', 2, 2);
INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-3', 'f-n-3', 'l-n-3', 'pwd-3', 3, 3);
INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-4', 'f-n-4', 'l-n-4', 'pwd-4', 4, 1);
INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-5', 'f-n-5', 'l-n-5', 'pwd-5', 5, 2);
INSERT INTO users (login, firstname, lastname, password, address_id, occupation_id) VALUES ('login-6', 'f-n-6', 'l-n-6', 'pwd-6', 6, 3);

INSERT INTO users_to_schools (user_id, school_id) VALUES (11, 1);
INSERT INTO users_to_schools (user_id, school_id) VALUES (12, 2);
INSERT INTO users_to_schools (user_id, school_id) VALUES (13, 3);
INSERT INTO users_to_schools (user_id, school_id) VALUES (14, 1);
INSERT INTO users_to_schools (user_id, school_id) VALUES (15, 2);
INSERT INTO users_to_schools (user_id, school_id) VALUES (16, 3);
INSERT INTO users_to_schools (user_id, school_id) VALUES (11, 2);
INSERT INTO users_to_schools (user_id, school_id) VALUES (12, 3);
INSERT INTO users_to_schools (user_id, school_id) VALUES (13, 1);

-- database custom ENUM approach
CREATE TABLE IF NOT EXISTS public.coutries
(
	country text PRIMARY KEY;
);