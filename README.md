# LoginAppProject


Login App Is Working Fine using H2 Database you can create Useer Table using 



create table user
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	password varchar2(40) not null,
	contact varchar2(40) not null,
	role varchar2(40) default 'ROLE_USER' not null
);

