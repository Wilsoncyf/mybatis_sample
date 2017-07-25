CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `cnname` varchar(50) NOT NULL,
  `birthday` varchar(20) NOT NULL,
  `sex` smallint(6) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table t_student (
	id bigint primary key auto_increment not null,
    cnname varchar(60) not null,
    sex smallint not null,
	note varchar(500)
) engine=innodb default charset utf8;

create table t_student_selfcard (
	id bigint primary key auto_increment not null,
    student_id bigint not null,
    native varchar(60) not null,
	issue_date date not null,
    end_date date not null,
	note varchar(500)
) engine=innodb default charset utf8;

create table t_student_lecture (
	id bigint primary key auto_increment not null,
    student_id bigint not null,
    lecture_id bigint not null,
	grade double(10,2) not null,
	note varchar(500)
) engine=innodb default charset utf8;

create table t_lecture (
	id bigint primary key auto_increment not null,
    lecture_name varchar(100) not null,
	note varchar(500)
) engine=innodb default charset utf8;

create table t_student_health_female (
	id bigint(20) primary key auto_increment not null,
	student_id bigint(20) not null,
    check_date date not null,
    heart varchar(60) not null,
    liver varchar(60) not null,
    spleen varchar(60) not null,
    lung varchar(60) not null,
    kidney varchar(60) not null,
    uterus varchar(60) not null,
	note varchar(500)
) engine=innodb default charset utf8;

create table t_student_health_male (
	id bigint(20) primary key auto_increment not null,
	student_id bigint(20) not null,
    check_date date not null,
    heart varchar(60) not null,
    liver varchar(60) not null,
    spleen varchar(60) not null,
    lung varchar(60) not null,
    kidney varchar(60) not null,
    prostate varchar(60) not null,
	note varchar(500)
) engine=innodb default charset utf8;