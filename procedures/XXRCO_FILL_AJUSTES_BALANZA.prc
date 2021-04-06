CREATE OR REPLACE PROCEDURE APPS.XXRCO_FILL_AJUSTES_BALANZA(PSO_ERRMSG       OUT VARCHAR2
                                                      ,PSO_ERRCOD       OUT VARCHAR2
                                                      ,PNI_ANIO         IN  NUMBER 
                                                      ,PSI_GRUPO_NOMINA IN  VARCHAR2
                                                      ) IS
   CURSOR getMesInfo IS
 select 1 numero_mes,'Enero' mes from dual 
 union  select 2 numero_mes,'Febrero' mes from dual   
 union  select 3 numero_mes,'Marzo' mes from dual   
 union  select 4 numero_mes,'Abril' mes from dual   
 union  select 5 numero_mes,'Mayo' mes from dual   
 union  select 6 numero_mes,'Junio' mes from dual   
 union  select 7 numero_mes,'Julio' mes from dual   
 union  select 8 numero_mes,'Agosto' mes from dual   
 union  select 9 numero_mes,'Septiembre' mes from dual   
 union  select 10 numero_mes,'Octubre' mes from dual   
 union  select 11 numero_mes,'Noviembre' mes from dual   
 union  select 12 numero_mes,'Diciembre' mes from dual; 
 
 MesInfoRec getMesInfo%ROWTYPE;
BEGIN 

   OPEN getMesInfo;
   LOOP
      FETCH getMesInfo INTO MesInfoRec;
      EXIT WHEN getMesInfo%NOTFOUND;
      
      INSERT INTO XXRCO_PAY_AJUSTES_BALANZA (ID
                                            ,ANIO
                                            ,NUMERO_MES
                                            ,MES
                                            ,GRUPO_NOMINA
                                            ,CREATED_BY         
                                            ,CREATION_DATE      
                                            ,LAST_UPDATED_BY    
                                            ,LAST_UPDATE_DATE   
                                            ,LAST_UPDATE_LOGIN  
                                             )
                                       VALUES(
                                              XXRCO_PAY_AJUSTES_BALANZA_S.NEXTVAL
                                              ,PNI_ANIO
                                              ,MesInfoRec.numero_mes
                                              ,MesInfoRec.mes
                                              ,PSI_GRUPO_NOMINA
                                             ,nvl(FND_GLOBAL.user_id,-1)
                                             ,SYSDATE 
                                             ,nvl(FND_GLOBAL.user_id,-1)
                                             ,SYSDATE 
                                             ,nvl(FND_GLOBAL.login_id,-1)
                                             ); 
      commit; 
   END LOOP;
   CLOSE getMesInfo;
   
 
EXCEPTION WHEN OTHERS THEN 
  PSO_ERRMSG := 'EXCEPTION XXRCO_FILL_AJUSTES_BALANZA:'||sqlerrm||','||sqlcode;   
END XXRCO_FILL_AJUSTES_BALANZA; 
/

