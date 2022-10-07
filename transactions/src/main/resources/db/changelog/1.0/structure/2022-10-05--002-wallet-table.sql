create table if not exists transactions.wallet (
    id serial PRIMARY KEY,
    user_id int,
    kind int,
    title VARCHAR(255),
    amount int
);
