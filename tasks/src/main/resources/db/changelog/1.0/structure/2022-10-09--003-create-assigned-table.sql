create table if not exists tasks.assigned (
    id serial PRIMARY KEY,
    task_id int,
    user_id int,
    status int
);
