alter table wallets.wallet
    add column if not exists public_key varchar(100);

alter table wallets.wallet
    add column if not exists private_key varchar(100);

