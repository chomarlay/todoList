insert into Project (id, name) values (10001L, 'Inbox');
insert into Project (id, name) values (10002L, 'Running');
insert into Project (id, name) values (10003L, 'Spring JPA');

insert into Task (id, name, project_id) values (20001L, '5km Run', 10002L);
insert into Task (id, name, project_id) values (20002L, '10km Run', 10002L);
insert into Task (id, name, project_id) values (20003L, 'Task 1', 10003L);
insert into Task (id, name, project_id) values (20004L, 'Task 2', 10003L);