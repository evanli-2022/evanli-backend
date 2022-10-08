create table if not exists wallets.wallet (
    id serial PRIMARY KEY,
    user_id int,
    kind int,
    title VARCHAR(255)
);
