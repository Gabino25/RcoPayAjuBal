ALTER TABLE APPS.XXRCO_PAY_AJU_BZA_PROJ DROP PRIMARY KEY CASCADE;

DROP TABLE APPS.XXRCO_PAY_AJU_BZA_PROJ CASCADE CONSTRAINTS;

CREATE TABLE APPS.XXRCO_PAY_AJU_BZA_PROJ
(
  ID                        NUMBER              NOT NULL,
  ANIO                      NUMBER              NOT NULL,
  NUMERO_MES                NUMBER              NOT NULL,
  MES                       VARCHAR2(100 BYTE)  NOT NULL,
  GRUPO_NOMINA              VARCHAR2(200 BYTE)  NOT NULL,
  PROYECTO                  VARCHAR2(200 BYTE)  NOT NULL,
  REGISTRO_PATRONAL         VARCHAR2(300 BYTE)  NOT NULL,
  CALC_CUOTA_SS_ER_INF      NUMBER              DEFAULT 0,
  CALC_CUOTA_SS_ER_RET      NUMBER              DEFAULT 0,
  CALC_CUOTA_SS_ER_STA      NUMBER              DEFAULT 0,
  D002IMSS                  NUMBER              DEFAULT 0,
  D002IMSS_STA              NUMBER              DEFAULT 0,
  CREATED_BY                NUMBER              NOT NULL,
  CREATION_DATE             DATE                NOT NULL,
  LAST_UPDATED_BY           NUMBER              NOT NULL,
  LAST_UPDATE_DATE          DATE                NOT NULL,
  LAST_UPDATE_LOGIN         NUMBER              NOT NULL,
  CONSTRAINT XXRCO_PAY_AJU_BZA_PROJ_PK PRIMARY KEY(ID),
  CONSTRAINT XXRCO_PAY_AJU_BZA_PROJ_U1 UNIQUE (ANIO, NUMERO_MES, GRUPO_NOMINA,PROYECTO)
);

ALTER TABLE APPS.XXRCO_PAY_AJU_BZA_PROJ ADD CUOTA_PATRONAL NUMBER DEFAULT 0;



