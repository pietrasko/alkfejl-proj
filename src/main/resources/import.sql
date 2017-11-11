insert into users(username, name, password, role) values('QP', 'jozsi','1234','USER');
insert into users(username, name, password, role) values('PQ', 'bela','12345','USER');

insert into admin(name, role, password) values('adminka','ADMIN','q');

insert into task(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(1,1,false, false, 'meg kell csinalni', current_timestamp);
insert into task(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(1,2,false, false, 'Bela  csinalnd mög', current_timestamp);