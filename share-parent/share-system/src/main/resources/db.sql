drop table if exists t_data_dictionary;
create table if not exists t_data_dictionary(
	id_          int(11) primary key auto_increment,
	key_		 varchar(255) not null,
	value_       varchar(255) not null
);