create table if not exists wallets.transaction (
    id serial PRIMARY KEY,
    from_user_id int,
    to_user_id int,
    amount numeric,
    hash varchar(100),
    status varchar(50),
    comment VARCHAR(255)
);
