create table if not exists wallets.transaction (
    id serial PRIMARY KEY,
    from_wallet_id int,
    from_user_id int,
    to_wallet_id int,
    to_user_id int,
    amount int,
    comment VARCHAR(255)
);
