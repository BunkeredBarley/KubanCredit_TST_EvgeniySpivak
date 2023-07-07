CREATE TABLE tasks (
    id serial PRIMARY KEY,
    title varchar(256) NOT NULL,
    description text,
    get_time timestamp NOT NULL,
    status varchar(128) NOT NULL,
    performer int
)