--delete-testsuite.sql
--deletes testsuite data from container schema
--The assumption is that all of the tables are empty
-- before running this script.

set schema container;

--delete preferences
delete from preference_value where preference_id between 1 and 6;
delete from preference where preference_id between 1 and 6;
--delete portlets
delete from portlet where portlet_id in (1,2);
--delete testsuite portlet app
delete from portlet_app where portlet_app_id=1;

