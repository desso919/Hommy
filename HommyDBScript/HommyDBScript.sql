#############################################################################
#############################################################################
####                                                                     ####
####                                                                     ####
####              HOMMY DATABASE SQL SCRIPT                              ####
####                                                                     ####
####                                                                     ####
#############################################################################
#############################################################################

--###############################  CREATE TABLE USERS  ###############################
CREATE TABLE USERS
(
  ID NUMBER NOT NULL 
, USERNAME VARCHAR2(200) NOT NULL 
, PASSWORD VARCHAR2(200) NOT NULL 
, EMAIL VARCHAR2(200) NOT NULL 
, CONSTRAINT USERS1_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE TABLE EVENTS  ###############################
CREATE TABLE EVENTS 
(
  ID NUMBER NOT NULL 
, EVENTNAME VARCHAR2(300) NOT NULL 
, DESCRIPTION VARCHAR2(400) 
, CONSTRAINT EVENTS_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE TABLE DEVICES  ###############################
CREATE TABLE DEVICES 
(
  ID NUMBER NOT NULL 
, DEVICENAME VARCHAR2(200) NOT NULL 
, COMMUNICATIONPROTOCOL VARCHAR2(200) NOT NULL 
, CONSTRAINT DEVICES_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE TABLE ACTIONS  ###############################
CREATE TABLE ACTIONS 
(
  ID NUMBER NOT NULL 
, ACTION VARCHAR2(200) NOT NULL 
, CONSTRAINT ACTIONS_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE TABLE DEVICEACTIONS  ###############################
CREATE TABLE DEVICEACTIONS 
(
  ID NUMBER NOT NULL 
, DEVICEID NUMBER NOT NULL 
, ACTIONID NUMBER NOT NULL 
, CONSTRAINT DEVICEACTIONS_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE INDEXES FOR DEVICEACTIONS TABLE ###############################
CREATE INDEX ACTIONID_INDEX ON DEVICEACTIONS (ACTIONID);
CREATE INDEX DEVICEID_INDEX ON DEVICEACTIONS (DEVICEID);


--###############################  ADD CONSTRAINTS FOR DEVICEACTIONS TABLE ###############################
ALTER TABLE DEVICEACTIONS
ADD CONSTRAINT ACTIONID_FK FOREIGN KEY
(
  ACTIONID 
)
REFERENCES ACTIONS
(
  ID 
)
ENABLE;

ALTER TABLE DEVICEACTIONS
ADD CONSTRAINT DEVICEID_FK FOREIGN KEY
(
  DEVICEID 
)
REFERENCES DEVICES
(
  ID 
)
ENABLE;

--###############################  CREATE TABLE RULES  ###############################
CREATE TABLE RULES 
(
  ID NUMBER NOT NULL 
, USERID NUMBER NOT NULL 
, EVENTID NUMBER NOT NULL 
, DEVICEID NUMBER NOT NULL 
, ACTIONID NUMBER NOT NULL 
, RULENAME VARCHAR2(200) NOT NULL 
, EXECUTIONORDER NUMBER NOT NULL 
, CONSTRAINT RULES_PK PRIMARY KEY 
  (
    ID 
  )
  ENABLE 
);

--###############################  CREATE INDEXES FOR RULES TABLE ###############################
CREATE INDEX RULES_ACTIONID_INDEX ON RULES (ACTIONID);
CREATE INDEX RULES_DEVICEID_INDEX ON RULES (DEVICEID);
CREATE INDEX RULES_EVENTID_INDEX ON RULES (EVENTID);


--###############################  ADD CONSTRAINTS FOR DEVICEACTIONS TABLE ###############################
ALTER TABLE RULES
ADD CONSTRAINT RULES_ACTIONID_FK FOREIGN KEY
(
  ACTIONID 
)
REFERENCES ACTIONS
(
  ID 
)
ENABLE;

ALTER TABLE RULES
ADD CONSTRAINT RULES_DEVICEID_FK FOREIGN KEY
(
  DEVICEID 
)
REFERENCES DEVICES
(
  ID 
)
ENABLE;

ALTER TABLE RULES
ADD CONSTRAINT RULES_EVENTID_FK FOREIGN KEY
(
  EVENTID 
)
REFERENCES EVENTS
(
  ID 
)
ENABLE;

ALTER TABLE RULES
ADD CONSTRAINT RULES_USERID_FK FOREIGN KEY
(
  USERID 
)
REFERENCES USERS
(
  ID 
)
ENABLE;




