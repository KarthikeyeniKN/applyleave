create table student_login(id number(10)primary key,name varchar2(40)not null,password varchar2(20)not null,
rollno number(10) unique not null,year number(10) not null,department varchar2(20) not null,email varchar2(40)unique not null);

create sequence student_login_id_seq
start with 1 increment by 1;

select * from student_login;


create table admin_login(id number(10) primary key,name varchar2(40)not null,password varchar2(20)not null,email varchar2(40)unique not null);
insert into admin_login values (1,'admin','admin','karthikeyeni1997@gmail.com');

select * from admin_login;


create table apply_pass(id number(10)primary key,name varchar(30)not null,department varchar(20)not null,year number(5)not null,
rollno number(10) not null,
email varchar(30)not null,leave_date date not null,purpose varchar(30)not null,phone_no number(20),status varchar(10) default 'pending',
created_date date);


create sequence apply_pass_id_seq
start with 1 increment by 1;


select * from apply_pass;











