#############################################################################
#############################################################################
####                                                                     ####
####                                                                     ####
####              HOMMY DATABASE SQL SCRIPT                              ####
####                                                                     ####
####                                                                     ####
#############################################################################
#############################################################################

--###############################  INSERT SIMPLE DATA   ###############################

INSERT INTO "DESO"."USERS" (USERNAME, PASSWORD, EMAIL) VALUES ('deso', 'deso', 'desislav.hristov@gmail.com');
INSERT INTO "DESO"."USERS" (USERNAME, PASSWORD, EMAIL) VALUES ('dimana', 'dimana', 'dimana.dimova@gmail.com');

INSERT INTO "DESO"."EVENTS" (EVENTNAME, DESCRIPTION) VALUES ('LEAVE HOME', 'This events is trigger when you leave home.');
INSERT INTO "DESO"."EVENTS" (EVENTNAME, DESCRIPTION) VALUES ('COME HOME', 'This events is trigger when you are coming back home.');

INSERT INTO "DESO"."DEVICES" (DEVICENAME, COMMUNICATIONPROTOCOL) VALUES ('fridge', 'HTTPS');
INSERT INTO "DESO"."DEVICES" (DEVICENAME, COMMUNICATIONPROTOCOL) VALUES ('TV', 'HTTPS');

INSERT INTO "DESO"."ACTIONS" (ACTION) VALUES ('TURN ON');
INSERT INTO "DESO"."ACTIONS" (ACTION) VALUES ('TURN OFF');
INSERT INTO "DESO"."ACTIONS" (ACTION) VALUES ('CHANGE CHANEL');
INSERT INTO "DESO"."ACTIONS" (ACTION) VALUES ('PLAY MUSIC');
INSERT INTO "DESO"."ACTIONS" (ACTION) VALUES ('STOP MUSIC');

INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('1', '1');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('1', '2');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('2', '3');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('2', '4');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('2', '5');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('2', '1');
INSERT INTO "DESO"."DEVICEACTIONS" (DEVICEID, ACTIONID) VALUES ('2', '2');

INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '1', '1', '2', 'When I leave home', '1');
INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '1', '2', '5', 'When I leave home', '1');
INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '1', '2', '2', 'When I leave home', '2');
INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '2', '1', '1', 'When I am coming home', '1');
INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '2', '2', '1', 'When I am coming home', '1');
INSERT INTO "DESO"."RULES" (USERID, EVENTID, DEVICEID, ACTIONID, RULENAME, EXECUTIONORDER) VALUES ('1', '2', '2', '5', 'When I am coming home', '2');






