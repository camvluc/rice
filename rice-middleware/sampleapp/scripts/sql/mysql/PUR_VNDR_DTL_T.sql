--
-- Copyright 2005-2015 The Kuali Foundation
--
-- Licensed under the Educational Community License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
--
-- http://www.opensource.org/licenses/ecl2.php
--
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--

TRUNCATE TABLE PUR_VNDR_DTL_T
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_RSTRC_IND,VNDR_SOLD_TO_ASND_ID,VNDR_SOLD_TO_GNRTD_ID,VNDR_SOLD_TO_NM)
  VALUES ('Y','Y','8C3AE2E0-2002-9057-8962-D5D6D7A812ED',5,'N','N',0,1000,'ABC CLEANING SERVICES','Y','00N30','N','N',0,1003,'BASIC CORP ACTIVE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RSTRC_IND,VNDR_URL_ADDR)
  VALUES ('Y','Y','4F0DAAFD-0B35-7BB5-29A2-CFDA1E8C48E7',2,'N',0,'002254837',1001,'KUALI UNIVERSITY','Y','00N30','N','www.kualiu.edu')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','816BAE71-0927-BD01-F723-579D57218250',3,'N',0,'334558446',1002,'MK CORPORATION ACTIVE','Y','00N30','PD','DE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_IND)
  VALUES ('Y','Y','3A186BC5-6746-BF6D-4FBD-575E0D615039',1,'N',0,1003,'BASIC CORP ACTIVE','Y','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','5E35E734-51D4-6FE7-99CF-556006EDEBFF',2,'N',0,'778888665',1004,'DEBARRED VENDOR','Y','20D10','AL','DE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','9E1B372B-5E6E-AFD6-BE8C-152D65A59D57',2,'N',0,'888777666',1005,'RESTRICTED LEGAL SERVICES VENDOR','Y','05D10',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6162502038','This company sells restricted material','PD','SP')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID)
  VALUES ('Y','Y','60F4D993-1D5B-A1CD-72A1-2F530DDE76AC',1,'N',0,1006,'MULTIPLE COLLECTION CORP','Y',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','423118FC-0C84-7DAC-796D-59E00A229418',2,'N',0,1007,'FOREIGN VENDOR NO TAX NUMBER','Y','20D15')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_IND)
  VALUES ('Y','Y','215DAF14-BB56-9800-10DC-9371EFABB15F',1,'Y',0,1008,'SMITH, SALLY','Y','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','4B37D9AA-9DB9-82F8-00DD-27D187F8FA48',2,'N',0,1009,'FOREIGN VENDOR WITH TAX NUMBER','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','D927E612-A6CD-5482-003A-611B6628C7BC',2,'N',0,1010,'BASIC VENDOR ESTATE/TRUST','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('Y','Y','EB5FC2CE-488C-1780-252F-916E7FF3ADA2',2,'N',0,1011,'FOREIGN VENDOR RESTRICTED','Y',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','Need to review what we are buying')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('Y','Y','C9DB706E-A1E9-A8F0-BE8F-3EF1F0DE516A',1,'N',0,1012,'Direct Coffee','Y',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','Restricted due to use of coffee beans.')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','F29FF3AA-320E-8F26-3AB9-C7E92975208C',1,'Y',0,1013,'JONES, JONATHAN','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','C245A5E6-D737-5A67-337D-5E097B1D85C4',2,'Y',0,1014,'SMITH, MARILYN','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_INACTV_REAS_CD,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('Y','N','04CAD2EF-CD67-1B27-A2C9-EAF0502A3E8A',2,'N',0,1015,'ME','EXPRESS SHIPPING','Y',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','review')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RSTRC_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','E8645B46-5551-CE00-1A46-B929C566A000',3,'N','N','N',0,1016,'PHYSIK INSTRUMENT L.P.','Y','00N15','N','CL','DE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('Y','Y','0B1F2232-AA65-D669-2758-31FB9D039F03',2,'N',0,1017,'FOREIGN PARTNERSHIP -CCS','Y','00N30',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','testing restricted')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','B2CD3E46-F13F-4A2E-E775-5975B2C50CA8',2,'Y','Y',0,1018,'SOLEPROPRIETORMULTIPLE, CASKEY','Y','00N30')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_INACTV_REAS_CD,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('Y','N','96769D4E-649A-633C-101E-A1C10FF73BA6',2,'N',0,1019,'OB','INACTIVE PO VENDOR','Y','00N30',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','Out of business')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','3656161F-B608-D039-F07B-8490049BFDCD',2,'N','Y','Y',0,'002206183',1020,'EASTMAN KODAK','Y','00N30','Y','AL','OR')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_INACTV_REAS_CD,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','N','5CCF04BE-322C-4434-CAB6-A0B84917E25B',2,'N','Y',0,1021,'OB',10,'ROBBINS AUTO PARTS','Y','00N20','N',STR_TO_DATE( '20070508000000', '%Y%m%d%H%i%s' ),'Y','6276904397','review for compliance','PA','DE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_RMT_NM,VNDR_RSTRC_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','6D6FB51B-2630-C48C-DF27-817EBFB63EB8',7,'N','Y','Y',0,2003,100,'BOB THE BUILDER','Y','00N10','Y','Bob Builder','N','PA','DE','bobthebuilder.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','96F2B6AB-5CF1-2668-4C11-6176F3031F29',3,'N',0,2005,'ACCOUNTING CONSULTANTS','Y','10D10','AL','SP','www.accountingconsultants.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM,VNDR_RSTRC_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','AFE10E62-4822-4C66-C257-F9631F3CFF73',6,'N','Y',0,2013,100,'BESCO WATER TREATMENT INC','Y','00N30','Besco Water Treatment Inc','N','AL','OR','bescowater.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_RMT_NM,VNDR_RSTRC_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','80DBE3B2-8E4B-A904-B40D-CF20B6AD3DFB',2,'N','Y','Y',0,2021,25,'COFFEE CUP CAFE','Y','00N07','Y','Coffee Cup','N','PA','SP','coffeecup.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_RMT_NM,VNDR_RSTRC_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','6150CAC3-74E7-0F8E-B541-712A4B0FCADE',3,'N','N','N',0,'253695874',2023,2000,'GRAINGER','Y','00N07','Y','W.W. Grainger','N','CL','OR','www.grainger.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_MIN_ORD_AMT,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','79886BEC-7DC7-2EF3-713D-A47510731D4C',7,'N','Y',0,2025,1000,'CERN- FOREIGN','Y','00N30','PA','CI','cern.physics.su')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_PRPYMT_IND,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD,VNDR_URL_ADDR)
  VALUES ('Y','Y','AF8CCD38-1A3A-086D-0DFD-4183D13A401B',3,'N','Y',0,'123456789',3005,'GOLDEN GENIE CORPORATION','Y','00N30','N','AL','SP','www.goldengenie.com')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CCRD_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD)
  VALUES ('N','Y','8FFE7896-8093-7D85-0203-486C10E20BD2',1,'N','Y',0,'102769940',4005,'Barnes & Noble.com LLC','Y','00N30','PA')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','F6E3294B-F214-B292-5B9B-0F9DD63DEE43',1,'N',0,'624007902',4006,'Dell Inc','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','BFBACD1B-7BD8-9575-3F66-E6766F83DE77',1,'N',0,4007,'USA Scientific','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','01AC4A17-3D10-93D0-9AE2-957B0E2C9CD3',1,'N',0,4008,'Qiagen','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','9BAD367D-551F-E8FC-7985-1D0E5C4697DA',2,'N',0,4009,'Pierce Biotechnology','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','76A39DEA-7DCD-0CC5-FFBC-ED2F68055B72',1,'N',0,4010,'Perkin Elmer Life Sciences','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','0AE91484-B516-9126-16E7-B07B059EA4D8',1,'N',0,4011,'Fisher Scientific','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','5E04DB71-05E5-94BE-6B6D-509477E9C853',1,'N',0,4012,'Grainger','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('N','Y','830E6114760CC23CE0404F8189D82CFD',1,'N',0,4105,'Foreign DV Vendor','Y','00N05')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('N','Y','830E61147605C23CE0404F8189D82CFD',1,'Y',0,4106,'Smith, Iggy - Employee as Vendor','Y','00N30')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','830E61147606C23CE0404F8189D82CFD',2,'Y',0,4107,'Back Up Withholding, DV Vendor','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','830E61147609C23CE0404F8189D82CFD',1,'N',0,4108,'Back-Up Withholding PO Vendor','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_RSTRC_DT,VNDR_RSTRC_IND,VNDR_RSTRC_PRSN_ID,VNDR_RSTRC_REAS_TXT)
  VALUES ('N','Y','830E61147607C23CE0404F8189D82CFD',1,'N',0,4109,'DV Vendor Restricted','Y',STR_TO_DATE( '20100324000000', '%Y%m%d%H%i%s' ),'Y','4161901639','Avoid appearance of conflict of interest')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E6114760AC23CE0404F8189D82CFD',2,'N',0,4110,'PO Vendor with Multiple Names','Y','00N30','Cascade Plaza LLC')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E61147611C23CE0404F8189D82CFD',2,'N',0,4111,'PO Vendor - Employee-Independent Contractor','Y','00N30','Donald M Bazley')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E6114760DC23CE0404F8189D82CFD',2,'N',0,4112,'PO Vendor Hotel Owned by Parent Company','Y','00N30','East Palo Alto Development LLC')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E6114760EC23CE0404F8189D82CFD',3,'N',0,4113,'PO Vendor - Sold-To Company','Y','00N30','Cayuga Press Inc')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM,VNDR_SOLD_TO_ASND_ID,VNDR_SOLD_TO_GNRTD_ID,VNDR_SOLD_TO_NM)
  VALUES ('N','Y','830E6114760FC23CE0404F8189D82CFD',2,'N',0,4114,'PO Vendor - Sold to Another Company','Y','00N30','Cayuga Press',0,4113,'Sold-To Company')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','830E61147610C23CE0404F8189D82CFD',1,'N',0,4115,'Participant Vendor','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('N','Y','830E6114760BC23CE0404F8189D82CFD',1,'N',0,4116,'Revolving Fund Vendor','Y')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E61147608C23CE0404F8189D82CFD',1,'N',0,4117,'Foreign PO Vendor','Y','00N30','Wong Feng')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E61147612C23CE0404F8189D82CFD',1,'N',0,4118,'High Volume PO Vendor','Y','00N30','Dell Marketing')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_RMT_NM)
  VALUES ('N','Y','830E61147613C23CE0404F8189D82CFD',1,'N',0,4119,'Cap Asset PO Vendor','Y','00N30','VWR International')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','1CCB3086-B04C-DCDC-17E9-B123715BB336',2,'N',1,1001,'VETERINARY COLLEGE','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','EFCEAF10-D034-49AD-AB99-72814E4D897D',1,'N',1,1002,'DIVISION OF MARILYN CORPORATION','N','10D1T')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','96B206C4-603D-8DF4-5B25-0A3FC06E4A51',1,'N',1,1006,'SAMMY\'S SURPLUS STORE','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','D19CB8D7-889D-295E-A10E-F173EC45FB04',1,'N',1,1010,'DIVISION 1 OF PO BASIC','N','20D10')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','A027AC8A-F566-613E-C28B-12F5E4A80EAD',2,'N',1,1014,'DIVISION 1 OF MARILYN SMITH','N','10D11')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','94DC51F6-1F30-09C2-5A10-F348534BA121',2,'N',1,1018,'SOLEPROPRIETOR CASKY FIRST DIV','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','9FAC6250-9FAB-5DA7-6EDC-AD024296D8E5',1,'N',1,1020,'EASTMAN COPIERS','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','45C13FFB-864C-876D-CCFE-2A4B1A4A9946',2,'N',2,1001,'ART MUSEUM','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_DUNS_NBR,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','802DFB16-35E6-57ED-0C39-65EB3FD768D2',1,'N',2,'999999999',1010,'DIVISION 2 OF PO BASIC','N','20D1T','CL','DE')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD)
  VALUES ('Y','Y','E82E033F-5A67-F55C-5DCF-9759295A7685',2,'Y',2,1014,'SMITH, HOLLY','N','00N30')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','9128933F-50DD-4C46-8B93-2EDD97C9DBB9',1,'N',2,1018,'SOLE PROP CASKEY AUTO GLASS','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','878B782E-0B76-CF16-07AD-8317593CA4A7',1,'N',2,1020,'EASTMAN DIGITAL','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND)
  VALUES ('Y','Y','A7643F27-2469-CF71-99DD-E0620CBBDAE6',1,'N',3,1010,'B2B CONTRACT VENDOR','N')
/
INSERT INTO PUR_VNDR_DTL_T (COLLECT_TAX_IND,DOBJ_MAINT_CD_ACTV_IND,OBJ_ID,VER_NBR,VNDR_1ST_LST_NM_IND,VNDR_CNFM_IND,VNDR_DTL_ASND_ID,VNDR_HDR_GNRTD_ID,VNDR_NM,VNDR_PARENT_IND,VNDR_PMT_TERM_CD,VNDR_SHP_PMT_TERM_CD,VNDR_SHP_TTL_CD)
  VALUES ('Y','Y','91231B7E-3430-6E5D-9655-706DECF945BC',1,'N','Y',3,1014,'DIVISION 3 OF MARILYN SMITH','N','00N33','CL','DE')
/
