# LoginAppProject


Login App Is Working Fine using H2 Database you can create Useer Table using 

```
create table user
(
	id varchar2(20) primary key,
	name varchar2(40) not null,
	password varchar2(40) not null,
	contact varchar2(40) not null,
	role varchar2(40) default 'ROLE_USER' not null
);
```


Before login Output Will Look Like 

![Before Login](https://preview.ibb.co/dtA1k5/image.png)

After Login the Output will look like

![After Login](https://preview.ibb.co/m6rfdQ/image.png)

