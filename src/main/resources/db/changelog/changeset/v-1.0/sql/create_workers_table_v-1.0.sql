CREATE TABLE workers (
    id serial PRIMARY KEY,
    name varchar(256) NOT NULL,
    position varchar(512) NOT NULL,
    avatar text
)