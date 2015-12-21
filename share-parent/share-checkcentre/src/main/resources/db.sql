drop table if exists t_loginer;
create table if not exists t_loginer(
	id_						int(11) primary key auto_increment,
	user_name_				varchar(10) not null,
	password_				varchar(60) not null
);

insert into t_loginer (user_name_, password_) values ('admin', '202cb962ac59075b964b07152d234b70');