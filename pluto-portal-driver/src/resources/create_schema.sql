--
-- Copyright 2004,2005 The Apache Software Foundation
-- Licensed  under the  Apache License,  Version 2.0  (the "License");
-- you may not use  this file  except in  compliance with the License.
-- You may obtain a copy of the License at
--
--   http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed  under the  License is distributed on an "AS IS" BASIS,
-- WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
-- implied.
--
-- See the License for the specific language governing permissions and
-- limitations under the License.

--
-- SQL Script for the Pluto Portal Driver Schema
--

CREATE SCHEMA pluto_portal_driver;

-- SET SCHEMA pluto_portal_driver;

--
-- Global Portal Tables
--

CREATE TABLE pluto_portal_driver.version (
  major_version INTEGER NOT NULL,
  minor_version INTEGER NOT NULL,
  release       INTEGER NOT NULL,
  constraint version_pk primary key (major_version, minor_version, release)
);

CREATE TABLE pluto_portal_driver.portlet_app (
  portlet_app_id INTEGER      NOT NULL generated always as identity (start with 1, increment by 1),
  app_context    VARCHAR(250) NOT NULL,
  deploy_date    TIMESTAMP             DEFAULT CURRENT_TIMESTAMP,
  constraint portlet_app_pk primary key (portlet_app_id),
  constraint app_context_unique unique (app_context)
);

CREATE TABLE pluto_portal_driver.portlet (
	portlet_id     INTEGER NOT NULL generated always as identity (start with 1, increment by 1),
	portlet_app_id INTEGER NOT NULL,
	portlet_name   VARCHAR(75) NOT NULL,
	mod_date       TIMESTAMP default CURRENT_TIMESTAMP,
	constraint portlet_pk primary key (portlet_id),
	constraint portlet_fk foreign key (portlet_app_id) references pluto_portal_driver.portlet_app(portlet_app_id)
);

--
-- Portlet Preferences
--
CREATE TABLE pluto_portal_driver.preference (
	preference_id    INTEGER     NOT NULL generated always as identity  (start with 1, increment by 1),
	portlet_id       INTEGER     NOT NULL,
	preference_name  VARCHAR(75) NOT NULL,
	description      VARCHAR(250),
	read_only        CHAR(1)              DEFAULT 'N',
	auth_user        VARCHAR(75),
	mod_date         TIMESTAMP            DEFAULT current_timestamp,
	constraint preference_pk primary key (preference_id),
	constraint preference_fk foreign key (portlet_id) references pluto_portal_driver.portlet(portlet_id)
);

CREATE INDEX pluto_portal_driver.preference_auth_user_ndx on preference(auth_user);

CREATE TABLE pluto_portal_driver.preference_value (
	preference_id    INTEGER NOT NULL,
	preference_value VARCHAR(250),
	mod_date         TIMESTAMP default CURRENT_TIMESTAMP,
	constraint preference_value_pk primary key  (preference_id, preference_value),
	constraint preference_value_fk foreign key (preference_id) references pluto_portal_driver.preference(preference_id)
);

-- User information attribute names as defined in PLT.D of the JSR-168 spec
CREATE TABLE pluto_portal_driver.user_info_attribute (
	user_info_attribute_id INTEGER      NOT NULL generated always as identity (start with 1, increment by 1),
	attribute_name         VARCHAR(75),
	mod_date               TIMESTAMP    default CURRENT_TIMESTAMP,
	constraint user_info_attribute_pk primary key (user_info_attribute_id)
);

-- Holds user information attribute values as defined in PLT.17 of the JSR-168 spec
CREATE TABLE pluto_portal_driver.user_info_attribute_value (
	user_info_attribute_id INTEGER NOT NULL,
	auth_user              VARCHAR(75),
	attribute_value        VARCHAR(250),
	mod_date               TIMESTAMP default CURRENT_TIMESTAMP,
	constraint user_info_attribute_value_pk primary key (user_info_attribute_id, auth_user),
	constraint user_info_attribute_value_fk foreign key (user_info_attribute_id) references pluto_portal_driver.user_info_attribute(user_info_attribute_id)
);

CREATE INDEX pluto_portal_driver.user_info_attribute_auth_user_ndx on user_info_attribute_value(auth_user);

--View that holds all the portlet app data.
--Use this with a where clause to get data for a
--particular portlet app or portlet.
CREATE VIEW pluto_portal_driver.portlet_app_view
	   (portlet_app_id, app_context, portlet_id,
	    portlet_name,  preference_name, preference_value,
		read_only) as
       SELECT pa.portlet_app_id, pa.app_context, p.portlet_id,
              p.portlet_name, pr.preference_name, pv.preference_value,
              pr.read_only
	     FROM pluto_portal_driver.preference pr, pluto_portal_driver.preference_value pv,
	          pluto_portal_driver.portlet p, pluto_portal_driver.portlet_app pa
	    WHERE pr.preference_id=pv.preference_id
	      AND pr.portlet_id=p.portlet_id
	      AND p.portlet_app_id=pa.portlet_app_id;
