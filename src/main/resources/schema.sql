insert into users (id, username, password)
values (1, 'username1', '$2a$12$RSRxtNgbwgm2ICq1abMEjuoVXKrNeLyj0Uei846u1n7OOBUjW0yNa');
insert into users (id, username, password)
values (2, 'username1', '$2a$12$RSRxtNgbwgm2ICq1abMEjuoVXKrNeLyj0Uei846u1n7OOBUjW0yNa');
insert into users (id, username, password)
values (3, 'username1', '$2a$12$RSRxtNgbwgm2ICq1abMEjuoVXKrNeLyj0Uei846u1n7OOBUjW0yNa');

insert into cards (id, user_id, balance, number, password)
values (1, 1, 100, 999999999, 'password');
insert into cards (id, user_id, balance, number, password)
values (1, 2, 200, 999999998, 'password');
insert into cards (id, user_id, balance, number, password)
values (1, 3, 500, 999999997, 'password');
