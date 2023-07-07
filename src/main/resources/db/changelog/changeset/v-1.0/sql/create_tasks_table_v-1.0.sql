CREATE TABLE tasks (
    id serial PRIMARY KEY,
    title varchar(256) NOT NULL,
    description text,
    get_time timestamptz NOT NULL,
    status varchar(128) NOT NULL
)