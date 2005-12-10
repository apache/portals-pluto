--insert-testsuite.sql
--inserts testsuite data into container schema
--The assumption is that all of the tables are empty
-- before running this script.

set schema container;
insert into portlet_app (app_context) 
	values ('/testsuite');
--TestPortlet1	
insert into portlet (portlet_app_id, portlet_name) 
	values (1, 'TestPortlet1');
insert into preference(portlet_id, preference_name, auth_user) 
	values (1, 'dummyName', 'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (1, 'dummyValue');
insert into preference(portlet_id, preference_name, auth_user) 
	values (1, 'dummyName2', 'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (2, 'dummyValue2');
insert into preference(portlet_id, preference_name, read_only, auth_user) 
	values (1, 'readonly', 'Y', 'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (3, 'readonly');
--TestPortlet2	
insert into portlet (portlet_app_id, portlet_name) 
	values (1, 'TestPortlet2');
insert into preference(portlet_id, preference_name, auth_user) 
	values (2, 'dummyName', 'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (4, 'dummyValue');
insert into preference(portlet_id, preference_name, auth_user) 
	values (2, 'dummyName2',  'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (5, 'dummyValue2');
insert into preference(portlet_id, preference_name, read_only, auth_user) 
	values (2, 'readonly', 'Y',  'ANONYMOUS');
insert into preference_value(preference_id, preference_value) 
	values (6, 'readonly');
	
