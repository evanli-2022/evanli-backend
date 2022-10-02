create table if not exists users.user (
    id serial PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    roles json,
    fullname VARCHAR(255),
    positionn VARCHAR(255),
    created_at TIMESTAMP
);
