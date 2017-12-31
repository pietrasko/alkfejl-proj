insert into users(username, name, password, role) values('QP', 'jozsi','1234','USER');
insert into users(username, name, password, role) values('PQ', 'bela','12345','USER');
insert into users(username, name, password, role) values('Q', 'telka','ggg','USER');

insert into admins(username, role, password) values('adminka','ADMIN','q');
insert into admins(username, role, password) values('Ad','ADMIN','p');

insert into registers(username, code) values('QP', 'AAAAAAAAAAA');
insert into registers(username, code) values('PQ', 'BBBBBBBBBBB');
insert into registers(username, code) values('Q', 'CCCCCCCCCCC');

insert into tasks(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(1,1,false, false, 'meg kell csinalni', current_timestamp);
insert into tasks(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(1,2,false, false, 'Bela  csinalnd mög', current_timestamp);
insert into tasks(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(1,3,false, false, 'meg kell csinalni', current_timestamp);
insert into tasks(admin_id, user_id, completed, completion_confirmed, task_description, deadline) values(2,2,false, false, 'Bela  csinalnd mög', current_timestamp);