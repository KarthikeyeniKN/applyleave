create table apply_pass(id number(10),name varchar(30)unique not null,department varchar(20)not null,year number(5)not null,
rollno varchar(10)unique not null,
email varchar(30)unique not null,leave_date date not null,purpose varchar(30)not null,phone_no number(20),status varchar(10) default 'pending',
created_date date);

select * from apply_pass;
create sequence apply_pass_sno_seq
start with 1 increment by 1;




create table admin_login(id number(10) primary key,name varchar2(40)not null,password varchar2(20)not null,email varchar2(40)unique not null);
insert into admin_login values (1,'admin','admin','karthikeyeni1997@gmail.com');

select * from admin_login;



create table student_login(id number(10) primary key,name varchar2(40)not null,password varchar2(20)not null,email varchar2(40)unique not null);
insert into student_login values(1,'karthi','karthi','karthikeyeni1997@gmail.com');
insert into student_login values(2,'arvind','arvind','arvind.hariharan@chainsys.com');
insert into student_login values(3,'ajay','ajay','ajaykumar.anandakumar@chainsys.com');

select * from student_login;


