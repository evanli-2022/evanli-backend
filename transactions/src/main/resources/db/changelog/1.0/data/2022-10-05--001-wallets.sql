insert into transactions.wallet (user_id, w_type, title, amount) VALUES
    (1, 'PRIVATE', 'Личный кошелёк', 100),-- !user1
    (2, 'PRIVATE', 'Личный кошелёк', 100),-- !user2
    (3, 'CORPORATE', 'Корпоративный кошелёк HR', 100),-- !org1
    (3, 'PRIVATE', 'Личный кошелёк', 100),-- !org1
    (4, 'CORPORATE', 'Корпоративный кошелёк админа', 100);-- !org2