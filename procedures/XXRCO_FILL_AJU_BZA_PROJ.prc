CREATE OR REPLACE PROCEDURE APPS.XXRCO_FILL_AJU_BZA_PROJ(PSO_ERRMSG       OUT VARCHAR2
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
 
 
   CURSOR cur_rp_proj(cur_grupo_nomina varchar2) IS
       select lookup_code
        ,meaning
        ,substr(meaning,0,length(meaning)-3) registro_patronal
        ,description
        ,tag proyecto
    from fnd_lookup_values
   where lookup_type = 'XXRCO_HR_REG_PAT_PROYECTO'
     and language = 'ESA'
     and description like '%'||cur_grupo_nomina||'%'
     order by registro_patronal desc; 
     
  MesInfoRec    getMesInfo%ROWTYPE;
  rp_proj_rec   cur_rp_proj%ROWTYPE;
 
BEGIN 

   OPEN getMesInfo;
   LOOP
      FETCH getMesInfo INTO MesInfoRec;
      EXIT WHEN getMesInfo%NOTFOUND;
      
        OPEN cur_rp_proj(PSI_GRUPO_NOMINA);
         LOOP
            FETCH cur_rp_proj INTO rp_proj_rec;
            EXIT WHEN cur_rp_proj%NOTFOUND;
            
             INSERT INTO XXRCO_PAY_AJU_BZA_PROJ (ID
                                             ,ANIO
                                             ,NUMERO_MES
                                             ,MES
                                             ,GRUPO_NOMINA
                                             ,PROYECTO
                                             ,REGISTRO_PATRONAL
                                             ,CREATED_BY         
                                             ,CREATION_DATE      
                                             ,LAST_UPDATED_BY    
                                             ,LAST_UPDATE_DATE   
                                             ,LAST_UPDATE_LOGIN  
                                             )
                                           VALUES(
                                                   XXRCO_PAY_AJU_BZA_PROJ_S.NEXTVAL
                                                  ,PNI_ANIO
                                                  ,MesInfoRec.numero_mes
                                                  ,MesInfoRec.mes
                                                  ,PSI_GRUPO_NOMINA
                                                  ,rp_proj_rec.proyecto
                                                  ,rp_proj_rec.registro_patronal
                                                 ,nvl(FND_GLOBAL.user_id,-1)
                                                 ,SYSDATE 
                                                 ,nvl(FND_GLOBAL.user_id,-1)
                                                 ,SYSDATE 
                                                 ,nvl(FND_GLOBAL.login_id,-1)
                                                 ); 
          commit; 
            
         END LOOP;
         CLOSE cur_rp_proj;
          
   END LOOP;
   CLOSE getMesInfo;
   
 
EXCEPTION WHEN OTHERS THEN 
  PSO_ERRMSG := 'EXCEPTION XXRCO_FILL_AJU_BZA_PROJ:'||sqlerrm||','||sqlcode;   
END XXRCO_FILL_AJU_BZA_PROJ; 
/

