-- build-container.sql
-- Builds database structures affiliated with portlet container

--drop schema container;
create schema container;

set schema container;

--drop in reverse order to avoid constraint issues
drop table user_info_attribute_value;
drop table user_info_attribute;
drop view portlet_app_view;
drop table preference_value;
drop table preference;	
drop table portlet;
drop table portlet_app;

-- Holds portlet app data including context
create table portlet_app (
	portlet_app_id integer not null generated always as identity 
	(start with 1, increment by 1),
	app_context varchar(250) not null,
	mod_date timestamp default current_timestamp,
	constraint portlet_app_pk primary key (portlet_app_id),
	constraint app_context_unique unique (app_context)	
	);

-- Holds portlet names
create table portlet (
	portlet_id integer not null generated always as identity 
	(start with 1, increment by 1),
	portlet_app_id integer not null, 
	portlet_name varchar(75) not null,
	mod_date timestamp default current_timestamp,
	constraint portlet_pk primary key (portlet_id),
	constraint portlet_fk foreign key (portlet_app_id) 
	references portlet_app(portlet_app_id)
	);

-- Holds portlet preference names and read_only values
create table preference (
	preference_id integer not null generated always as identity 
	(start with 1, increment by 1),
	portlet_id integer not null, 
	preference_name varchar(75) not null,
	description varchar(250), --used in resource bundle (see PLT.14.3.1)
	read_only char(1) default 'N',
	auth_user varchar(75), --authenticated user
	mod_date timestamp default current_timestamp,
	constraint preference_pk primary key (preference_id),
	constraint preference_fk foreign key (portlet_id) 
		references portlet(portlet_id)
	);

drop index preference_auth_user_ndx;
create index preference_auth_user_ndx on preference(auth_user);

-- Holds portlet preferences values
create table preference_value (
	preference_id integer not null,
	preference_value varchar(250),
	mod_date timestamp default current_timestamp,
	constraint preference_value_pk primary key 
		(preference_id, preference_value),	
	constraint preference_value_fk foreign key (preference_id) 
		references preference(preference_id)
	);

-- User information attribute names as defined in PLT.D of the JSR-168 spec
create table user_info_attribute (
	user_info_attribute_id integer not null generated always as identity 
	(start with 1, increment by 1),
	attribute_name varchar(75),
	mod_date timestamp default current_timestamp,
	constraint user_info_attribute_pk primary key 
		(user_info_attribute_id)	
	);

-- Holds user information attribute values as defined in PLT.17 of the JSR-168 spec
create table user_info_attribute_value (
	user_info_attribute_id integer not null,
	auth_user varchar(75), --authenticated user
	attribute_value varchar(250),
	mod_date timestamp default current_timestamp,
	constraint user_info_attribute_value_pk primary key 
		(user_info_attribute_id, auth_user),	
	constraint user_info_attribute_value_fk foreign key (user_info_attribute_id) 
		references user_info_attribute(user_info_attribute_id)
	);

drop index user_info_attribute_auth_user_ndx;
create index user_info_attribute_auth_user_ndx on user_info_attribute_value(auth_user);

--View that holds all the portlet app data.
--Use this with a where clause to get data for a 
--particular portlet app or portlet.
 create view portlet_app_view 
	(portlet_app_id, app_context,
		portlet_id, portlet_name,
		preference_name, preference_value, 
		read_only) as
	select
		pa.portlet_app_id, 	
		pa.app_context, 	
		p.portlet_id, 
		p.portlet_name, 
		pr.preference_name, 
		pv.preference_value,
		pr.read_only
	from preference pr, preference_value pv, 
	portlet p, portlet_app pa
	where pr.preference_id=pv.preference_id
	and pr.portlet_id=p.portlet_id
	and p.portlet_app_id=pa.portlet_app_id;
	

	