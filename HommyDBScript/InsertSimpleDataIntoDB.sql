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

INSERT INTO "DESO"."USERS" (ID, USERNAME, PASSWORD, EMAIL) VALUES ('1', 'deso', 'deso', 'desislav.hristov@gmail.com')
INSERT INTO "DESO"."USERS" (ID, USERNAME, PASSWORD, EMAIL) VALUES ('2', 'dimana', 'dimana', 'dimana.dimova@gmail.com')


INSERT INTO "DESO"."EVENTS" (ID, EVENTNAME, DESCRIPTION) VALUES ('1', 'LEAVE HOME', 'This events is trigger when you leave home.')
INSERT INTO "DESO"."EVENTS" (ID, EVENTNAME, DESCRIPTION) VALUES ('2', 'COME HOME', 'This events is trigger when you are coming back home.')


INSERT INTO "DESO"."DEVICES" (ID, DEVICENAME, COMMUNICATIONPROTOCOL) VALUES ('1', 'fridge', 'HTTPS')
INSERT INTO "DESO"."DEVICES" (ID, DEVICENAME, COMMUNICATIONPROTOCOL) VALUES ('2', 'TV', 'HTTPS')


INSERT INTO "DESO"."ACTIONS" (ID, ACTION) VALUES ('1', 'TURN ON')
INSERT INTO "DESO"."ACTIONS" (ID, ACTION) VALUES ('2', 'TURN OFF')
INSERT INTO "DESO"."ACTIONS" (ID, ACTION) VALUES ('3', 'CHANGE CHANEL')
INSERT INTO "DESO"."ACTIONS" (ID, ACTION) VALUES ('4', 'PLAY MUSIC')
INSERT INTO "DESO"."ACTIONS" (ID, ACTION) VALUES ('5', 'STOP MUSIC')



INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('1', '1', '1')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('2', '1', '2')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('3', '2', '3')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('4', '2', '4')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('5', '2', '5')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('6', '2', '1')
INSERT INTO "DESO"."DEVICEACTIONS" (ID, DEVICEID, ACTIONID) VALUES ('7', '2', '2')






