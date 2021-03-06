ALTER TABLE APPS.XXRCO_PAY_AJUSTES_BALANZA DROP PRIMARY KEY CASCADE;

DROP TABLE APPS.XXRCO_PAY_AJUSTES_BALANZA CASCADE CONSTRAINTS;

CREATE TABLE APPS.XXRCO_PAY_AJUSTES_BALANZA
(
  ID                        NUMBER              NOT NULL,
  ANIO                      NUMBER              NOT NULL,
  NUMERO_MES                NUMBER              NOT NULL,
  MES                       VARCHAR2(100 BYTE)  NOT NULL,
  GRUPO_NOMINA              VARCHAR2(200 BYTE),
  CUOTA_PATRONAL            NUMBER              DEFAULT 0,
  CALC_CUOTA_SS_ER_INF      NUMBER              DEFAULT 0,
  CALC_CUOTA_SS_ER_RET      NUMBER              DEFAULT 0,
  CALC_CUOTA_SS_ER_STA      NUMBER              DEFAULT 0,
  AJU_IMSS_DEDUCIBLE        NUMBER              DEFAULT 0,
  AJU_IMSS_NO_DEDUCIBLE     NUMBER              DEFAULT 0,
  CANC_FA_PERIODO_ANTERIOR  NUMBER              DEFAULT 0,
  CANC_FA                   NUMBER              DEFAULT 0,
  CANC_SYR                  NUMBER              DEFAULT 0,
  CANC_PROV_PRIM_VAC        NUMBER              DEFAULT 0,
  CANC_PROV_AGUINALDO       NUMBER              DEFAULT 0,
  CANC_UTILES_ESCOLARES     NUMBER              DEFAULT 0,
  CREATED_BY                NUMBER              NOT NULL,
  CREATION_DATE             DATE                NOT NULL,
  LAST_UPDATED_BY           NUMBER              NOT NULL,
  LAST_UPDATE_DATE          DATE                NOT NULL,
  LAST_UPDATE_LOGIN         NUMBER              NOT NULL,
  AJUSTE_ISN                NUMBER              DEFAULT 0,
  AJUSTE_LENTES             NUMBER              DEFAULT 0,
  CONSTRAINT XXRCO_PAY_AJUSTES_BALANZA_PK PRIMARY KEY(ID),
  CONSTRAINT XXRCO_PAY_AJUSTES_BALANZA_U1 UNIQUE (ANIO, NUMERO_MES, GRUPO_NOMINA)
);





