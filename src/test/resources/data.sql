-- INSERT CLIENTS
insert into clients (id, login, email, password, user_name) values (1, 'JohnLogin', 'warton@gmail.com', '123', 'John');
insert into clients (id, login, email, password, user_name) values (2, 'MikeLogin', 'lanister@gmail.com','123', 'Mike');
insert into clients (id, login, email, password, user_name) values (3, 'SteveLogin', 'Reeves@gmail.com','123', 'Steve');
insert into clients (id, login, email, password, user_name) values (4, 'RonaldLogin', 'connor@gmail.com','123', 'Ronald');
insert into clients (id, login, email, password, user_name) values (5, 'JimLogin', 'Sal@gmail.com','123', 'Jim');
insert into clients (id, login, email, password, user_name) values (6, 'PeterLogin', 'henley@gmail.com','123', 'Peter');
insert into clients (id, login, email, password, user_name) values (7, 'RichardLogin', 'carson@gmail.com','123', 'Richard');
insert into clients (id, login, email, password, user_name) values (8, 'HonorLogin', 'miles@gmail.com','123', 'Honor');
insert into clients (id, login, email, password, user_name) values (9, 'TonyLogin', 'roggers@gmail.com','123', 'Tony');

-- INSERT FRIENDS
insert into friends (client_id, friend_id) values (1, 2);
insert into friends (client_id, friend_id) values (1, 3);
insert into friends (client_id, friend_id) values (1, 5);
insert into friends (client_id, friend_id) values (2, 1);
insert into friends (client_id, friend_id) values (2, 4);
insert into friends (client_id, friend_id) values (2, 7);
insert into friends (client_id, friend_id) values (3, 9);
insert into friends (client_id, friend_id) values (3, 8);
insert into friends (client_id, friend_id) values (3, 5);
insert into friends (client_id, friend_id) values (3, 1);