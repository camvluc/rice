INSERT INTO KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND)
VALUES ('KRSAP100030', UUID(), '1', '46', 'KR-SAP', 'View Note / Attachment Travel Document', 'Applies to travel document', 'Y');
/
INSERT INTO KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL)
VALUES ('KRSAP13300', UUID(), '1', 'KRSAP100030', '9', '13', 'TravelDocument');
/
INSERT INTO KRIM_ROLE_PERM_T (ROLE_PERM_ID, OBJ_ID, VER_NBR, ROLE_ID, PERM_ID, ACTV_IND)
VALUES ('KRSAP13002', UUID(), '1', 'KRSAP10004', 'KRSAP100030', 'Y');
/
INSERT INTO KRIM_PERM_T (PERM_ID, OBJ_ID, VER_NBR, PERM_TMPL_ID, NMSPC_CD, NM, DESC_TXT, ACTV_IND)
VALUES ('KRSAP100031', UUID(), '1', '46', 'KR-SAP', 'View Note / Attachment Travel Document Attachment', 'Applies to travel document attachments', 'Y');
/
INSERT INTO KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL)
VALUES ('KRSAP13400', UUID(), '1', 'KRSAP100031', '9', '13', 'TravelDocument');
/
INSERT INTO KRIM_PERM_ATTR_DATA_T (ATTR_DATA_ID, OBJ_ID, VER_NBR, PERM_ID, KIM_TYP_ID, KIM_ATTR_DEFN_ID, ATTR_VAL)
VALUES ('KRSAP13401', UUID(), '1', 'KRSAP100031', '9', '9', 'OTH');
/
