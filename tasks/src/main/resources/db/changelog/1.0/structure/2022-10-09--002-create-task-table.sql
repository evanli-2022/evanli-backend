create table if not exists tasks.task (
    id serial PRIMARY KEY,
    author_id int,
    title VARCHAR(255),
    content text,
    award numeric
);
