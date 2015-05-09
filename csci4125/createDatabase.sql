/* Steven Tardo and Philip Williams
   This script creates the tables
   required for the WorkforceIS database. */


create table person (
	per_id varchar(5),
	name varchar(20) not null,
	street varchar(30),
	city varchar(20),
	state varchar(2),
	zip_code varchar(5),
	email varchar(30),
	gender varchar(1),
	home_phone varchar(12),
	cell_phone varchar(12),
	work_phone varchar(12),
	primary key (per_id)
	);

create table company (
	comp_id varchar(5),
	street varchar(30),
	city varchar(20),
	state varchar(2),
	zip_code varchar(5),
	website varchar(30),
	name varchar(20),
	primary key (comp_id)
	);

create table speciality (
	comp_id varchar(5),
	spec_id varchar(5),
	description varchar(30),
	primary key (comp_id, spec_id),
	foreign key (comp_id) references company
		on delete cascade
	);

create table job_profile (
	pos_code varchar(5),
	title varchar(20),
	description varchar(30),
	primary key (pos_code)
	);

create table knowledge_skill (
	ks_code varchar(5),
	title varchar(20),
	description varchar(30),
	lvl varchar(2),
	primary key (ks_code)
	);

create table course (
	c_code varchar(5),
	title varchar(20),
	description varchar(30),
	lvl varchar(2),
	status varchar(1),
	retail_price numeric(5,2),
	primary key (c_code)
	);

create table job (
	job_code varchar(5),
	pos_code varchar(5),
	type varchar(2),
	pay_rate numeric(9,2),
	pay_type varchar(2),
	comp_id varchar(5),
	primary key (job_code),
	foreign key (pos_code) references job_profile
		on delete cascade,
	foreign key (comp_id) references company
		on delete cascade
	);

create table project (
	proj_id varchar(5),
	title varchar(20),
	director varchar(5),
	budget_code varchar(5),
	start_date date,
	end_date date,
	comp_id varchar(5),
	primary key (proj_id),
	foreign key (director) references person(per_id)
		on delete set null,
	foreign key (comp_id) references company
		on delete cascade
	);

create table job_project (
	job_code varchar(5),
	proj_id varchar(5),
	primary key (job_code, proj_id),
	foreign key (job_code) references job
		on delete cascade,
	foreign key (proj_id) references project
		on delete cascade
	);

create table works (
	per_id varchar(5),
	job_code varchar(5),
	primary key (per_id, job_code),
	foreign key (per_id) references person
		on delete cascade,
	foreign key (job_code) references job
		on delete cascade
	);

create table requires (
	pos_code varchar(5),
	ks_code varchar(5),
	primary key (pos_code, ks_code),
	foreign key (pos_code) references job_profile
		on delete cascade,
	foreign key (ks_code) references knowledge_skill
		on delete cascade
	);

create table person_skill (
	per_id varchar(5),
	ks_code varchar(5),
	primary key (per_id, ks_code),
	foreign key (per_id) references person
		on delete cascade,
	foreign key (ks_code) references knowledge_skill
		on delete cascade
	);

create table course_set (
	c_code varchar(5),
	ks_code varchar(5),
	primary key (c_code, ks_code),
	foreign key (c_code) references course
		on delete cascade,
	foreign key (ks_code) references knowledge_skill
		on delete cascade
	);

create table section (
	c_code varchar(5),
	sec_number varchar(3),
	complete_date date,
	offered_by varchar(1),
	format varchar(3),
	price numeric(5, 2),
	primary key (c_code, sec_number),
	foreign key (c_code) references course
		on delete cascade
	);

create table takes (
	per_id varchar(5),
	c_code varchar(5),
	sec_number varchar(3),
	primary key (per_id, c_code, sec_number),
	foreign key (per_id) references person
		on delete cascade,
	foreign key (c_code, sec_number) references section
		on delete cascade
	);
	
create table CourseSet (
	csetID numeric(8,0),
	c_code1 varchar(6),
	c_code2 varchar(6),
	c_code3 varchar(6),
	setSize numeric(2,0),
	primary key (csetID)
	);
	
CREATE SEQUENCE CourseSet_seq
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 999999
	NOCYCLE;