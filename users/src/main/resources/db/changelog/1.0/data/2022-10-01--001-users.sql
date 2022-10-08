insert into users.user (username, password, roles, fullname, positionn, created_at) VALUES
    ('admin',  '$2y$10$NcQeI6IeZfK4HgGm.5fsPuUDxFvgYM9cCDLfWXBg/3hsyRtGtVan2', '["ROLE_EMPLOYEE", "ROLE_ADMIN"]', 'Сергей Антонов', 'Администратор', now()),-- !admin
    ('hr',     '$2y$10$TJVK6ff6jFwDW0u0U/1MjO8hKEsYMjYs5XKSd9FmEzw6rcMrqK5AK', '["ROLE_EMPLOYEE", "ROLE_HR"]', 'Анна Сергеева', 'HR менеджер', now()),-- !hr
    ('user1', '$2y$10$1/TbSnlQEs6ZA10xgjMCzO5yoap4CK/E73t2v9i.95pa/vzJGVV4a', '["ROLE_EMPLOYEE"]', 'Иван Иванов', 'Разработчик', now()),-- !user1
    ('user2', '$2y$10$jrlQm93e2C8/.2EVanGaAu6rvHDakKvvwPlrTv3R.k94FbAVVuFfm', '["ROLE_EMPLOYEE"]', 'Пётр Петров', 'Клерк', now()),-- !user2
    ('user3', '$2y$10$Hz2mxnWanvk8ToWsb1bwvekmN2W8o4mfg.0NTFq6NOJwbdW2U6CWS', '["ROLE_EMPLOYEE"]', 'Сидор Сидоров', 'Помощник', now()),-- !user3
    ('user4', '$2y$10$3LPJdswzPGOjGOfwFwOlFuSIy7PbvVQJLAOaWiG8lIU6E0xujRax.', '["ROLE_EMPLOYEE"]', 'Варфоломей Варфоломеев', 'Сантехник', now()),-- !user4
    ('user5', '$2y$10$MtRLQIsiBtApfqpyumwf0OQbwQBKYk065mp1s870AIA7mlrX00KIG', '["ROLE_EMPLOYEE"]', 'Игорь Игорев', 'Водитель', now()),-- !user5
    ('user6', '$2y$10$VPNmrBYUer.UbOzMwOdOOuCuPqARA43yj0YgzYv2x3yXNe4O1C8g.', '["ROLE_EMPLOYEE"]', 'Анатолий Анатолиев', 'Тестировщик', now()),-- !user6
    ('user7', '$2y$10$V.sexDgNAITM/FoKIvdtE.PSQ9Lsfpg8qW0skKzMWlD2f2ZF6qHkO', '["ROLE_EMPLOYEE"]', 'Анна Пушкина', 'Повар', now()),-- !user7
    ('user8', '$2y$10$5YzMlfh7UwVOMmM0d0c7quwU8DJssKc9WisBzUS4qfRl6Xvu0GwlC', '["ROLE_EMPLOYEE"]', 'Катерина Завьялова', 'Менеджер', now()),-- !user8
    ('user9', '$2y$10$X09wLJ9GMVXKWZ.fDdfNBeTsBCnMej41U.PaISp078LNeeQwFfLdC', '["ROLE_EMPLOYEE"]', 'Зульфия Магомедова', 'Дизайнер', now()),-- !user9
    ('user10', '$2y$10$spnfMrfe80qnogts6q6vYe7d/Y8rxZvi.H8Ynzv5OGntJ/32mbQWq', '["ROLE_EMPLOYEE"]', 'Дана Томпсон', 'Советник', now());-- !user10

