insert into Project (id, name, created_By,  created_Date, last_Modified_By, last_Modified_Date) values (10001L, 'Inbox', 'noPlanB', '2019-09-12', 'noPlanB', '2019-09-12');
insert into Project (id, name, created_By, created_Date, last_Modified_By, last_Modified_Date) values (10002L, 'Running', 'Cho Cho', '2019-09-12', 'caung', '2019-09-12');
insert into Project (id, name, created_By, created_Date, last_Modified_By, last_Modified_Date) values (10003L, 'Spring JPA', 'noPlanB', '2019-09-12', 'noPlanB', '2019-09-12');

insert into Task (id, name, project_id, created_By,  created_Date, last_Modified_By, last_Modified_Date) values (20001L, '5km Run', 10002L, 'noPlanB', '2019-09-12', 'noPlanB', '2019-09-12');
insert into Task (id, name, project_id, created_By,  created_Date, last_Modified_By, last_Modified_Date) values (20002L, '10km Run', 10002L, 'Cho Cho', '2019-09-12', 'caung', '2019-09-12');
insert into Task (id, name, project_id, created_By,  created_Date, last_Modified_By, last_Modified_Date) values (20003L, 'Task 1', 10003L, 'noPlanB', '2019-09-12', 'noPlanB', '2019-09-12');
insert into Task (id, name, project_id, created_By,  created_Date, last_Modified_By, last_Modified_Date) values (20004L, 'Task 2', 10003L, 'noPlanB', '2019-09-12', 'noPlanB', '2019-09-12');

INSERT INTO Role(name) VALUES('ROLE_USER');
INSERT INTO Role(name) VALUES('ROLE_ADMIN');