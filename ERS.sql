drop schema if exists ers_db cascade;
CREATE SCHEMA ers_db;
set schema 'ers_db';

create table ers_user_roles (ers_user_role_id serial primary key , user_role text);
create table ers_users (ers_users_id serial primary key, ers_username text unique, ers_password text, user_first_name text, user_last_name text, user_email text unique, user_role_id int references ers_user_roles (ers_user_role_id));
create table ers_reimbursement (reimb_id serial primary key, reimb_amount integer, reimb_submitted timestamp, reimb_resolved timestamp, reimb_description text, reimb_receipt bytea, reimb_author int references ers_users(ers_users_id), reimb_resolver int references ers_users(ers_users_id), reimb_status text, reimb_type text);


insert into ers_user_roles (user_role) values ('manager');
insert into ers_user_roles (user_role) values ('employee');
insert into ers_user_roles (user_role) values ('employee');
insert into ers_user_roles (user_role) values ('employee');


insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (1000,2,'pending','food');
insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (500,2,'pending','travel');
insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (300,2,'approved','food');
insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (250,3,'approved','Lodging');
insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (150,3,'declined','travel');
insert into ers_reimbursement (reimb_amount, reimb_author, reimb_status, reimb_type) values (100,4,'declined','Lodging');


