CREATE TYPE transactions.wallet_type AS ENUM ('PRIVATE', 'CORPORATE');

create table if not exists transactions.wallet (
    id serial PRIMARY KEY,
    user_id int,
    w_type transactions.wallet_type,
    title VARCHAR(255),
    amount int
);
