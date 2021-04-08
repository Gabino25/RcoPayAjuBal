/*===========================================================================+
 |   Copyright (c) 2001, 2005 Oracle Corporation, Redwood Shores, CA, USA    |
 |                         All rights reserved.                              |
 +===========================================================================+
 |  HISTORY                                                                  |
 +===========================================================================*/
package xxrco.oracle.apps.pay.balanza.webui;

import java.sql.SQLException;

import oracle.apps.fnd.common.VersionInfo;
import oracle.apps.fnd.framework.OAException;
import oracle.apps.fnd.framework.webui.OAControllerImpl;
import oracle.apps.fnd.framework.webui.OAPageContext;
import oracle.apps.fnd.framework.webui.OAWebBeanConstants;
import oracle.apps.fnd.framework.webui.beans.OAWebBean;
import oracle.apps.fnd.framework.webui.beans.form.OAFormValueBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;
import oracle.apps.fnd.framework.webui.beans.table.OAColumnBean;

import xxrco.oracle.apps.pay.balanza.server.BalanzaAMImpl;

/**
 * Controller for ...
 */
public class AjustesBalanzaProjCO extends OAControllerImpl
{
  public static final String RCS_ID="$Header$";
  public static final boolean RCS_ID_RECORDED =
        VersionInfo.recordClassVersion(RCS_ID, "%packagename%");

  /**
   * Layout and page setup logic for a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processRequest(pageContext, webBean);
    OAAdvancedTableBean xxRcoPayAjuBzaProjVORNBean =  (OAAdvancedTableBean)webBean.findChildRecursive("XxRcoPayAjuBzaProjVORN");
    OAMessageTextInputBean textInputBean = null; 
    OAColumnBean oaColumnBean = null; 
    String[] arrTextInputs ={"CalcCuotaSsErInf","CalcCuotaSsErRet","CalcCuotaSsErSta","D002imss","D002imssSta","CuotaPatronal"};
    String[] arrColumns ={"CalcCuotaSsErInfCol","CalcCuotaSsErRetCol","CalcCuotaSsErStaCol","D002imssCol","D002imssStaCol","CuotaPatronalCol"};
      if(null!=xxRcoPayAjuBzaProjVORNBean){
          for(int i=0;i<arrTextInputs.length;i++){
              textInputBean = (OAMessageTextInputBean)xxRcoPayAjuBzaProjVORNBean.findChildRecursive(arrTextInputs[i]);
              if(null!=textInputBean){
                 textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
              }
          }
          
           for(int i=0;i<arrColumns.length;i++){
           oaColumnBean = (OAColumnBean)xxRcoPayAjuBzaProjVORNBean.findChildRecursive(arrColumns[i]); 
           if(null!=oaColumnBean){
              oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
           }
           }
       }
      
  }

  /**
   * Procedure to handle form submissions for form elements in
   * a region.
   * @param pageContext the current OA page context
   * @param webBean the web bean corresponding to the region
   */
  public void processFormRequest(OAPageContext pageContext, OAWebBean webBean)
  {
    super.processFormRequest(pageContext, webBean);
    String strEventParam = pageContext.getParameter(this.EVENT_PARAM); 
    System.out.println("strEventParam:"+strEventParam);  
    OAMessageTextInputBean textInputBean = null; 
    OAMessageChoiceBean  messageChoiceBean = null; 
    OAMessageLovInputBean  messageLovInputBean = null; 
    OAFormValueBean  oAFormValueBean = null;
    String strAnio = null; 
    String strGrupoNomina = null; 
    String strMes = null; 
    oracle.jbo.domain.Number numAnio=null;
    oracle.jbo.domain.Number numMes=null;
    BalanzaAMImpl balanzaAMImpl = (BalanzaAMImpl)pageContext.getApplicationModule(webBean); 
    
      if("guardarCambiosEvt".equals(strEventParam)){
          balanzaAMImpl.getOADBTransaction().commit();
          /*pageContext.forwardImmediatelyToCurrentPage(null, false, null);*/
          throw new OAException("Se Guardaron los cambios",OAException.INFORMATION);        
      }
    
      if("consultarEvt".equals(strEventParam)){
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio1");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strAnio = messageLovInputBean.getText(pageContext); 
              try {
                  numAnio = new oracle.jbo.domain.Number(strAnio);
              } catch (SQLException e) {
                  System.out.println("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode());
                  throw new OAException("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode(),OAException.ERROR); 
              }
          }
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina1");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strGrupoNomina = messageLovInputBean.getText(pageContext); 
          }
         
          
          oAFormValueBean = (OAFormValueBean)webBean.findChildRecursive("MesFV");
          if(null!=oAFormValueBean&&null!=oAFormValueBean.getValue(pageContext)){
              strMes = (String)oAFormValueBean.getValue(pageContext);
              try {
                  numMes = new oracle.jbo.domain.Number(strMes);
              } catch (SQLException e) {
                  System.out.println("SQLException en covertir el mes:"+strMes+", "+e.getErrorCode());
                  throw new OAException("SQLException en covertir el mes:"+strMes+", "+e.getErrorCode(),OAException.ERROR); 
              }
          }
         
          balanzaAMImpl.consultarInfoProjects(numAnio
                                     ,strGrupoNomina
                                     ,numMes
                                     );
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              messageLovInputBean.setValue(pageContext,"");
              messageLovInputBean.setText(pageContext,"");
          }
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              messageLovInputBean.setValue(pageContext,"");
              messageLovInputBean.setText(pageContext,"");
          }                           
          throw new OAException("Se Consulto la Informacion",OAException.INFORMATION);                           
        
      }
      
      if ("poblarEvt".equals(strEventParam)){
            textInputBean = (OAMessageTextInputBean)webBean.findChildRecursive("Anio");
            if(null!=textInputBean&&null!=textInputBean.getValue(pageContext)){
                strAnio = textInputBean.getValue(pageContext).toString(); 
            }
            messageChoiceBean = (OAMessageChoiceBean)webBean.findChildRecursive("GrupoNomina");
            if(null!=messageChoiceBean&&null!=messageChoiceBean.getText(pageContext)){
                strGrupoNomina = messageChoiceBean.getText(pageContext).toString(); 
                strGrupoNomina = messageChoiceBean.getSelectionText(pageContext).toString(); 
                System.out.println(messageChoiceBean.getSelectionText(pageContext));
            }
          try {
              numAnio = new oracle.jbo.domain.Number(strAnio);
          } catch (SQLException e) {
              System.out.println("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode());
              throw new OAException("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode(),OAException.ERROR); 
          }
          balanzaAMImpl.poblarAnioProjects(numAnio
                                          ,strGrupoNomina
                                          );
          balanzaAMImpl.consultarInfoProjects(numAnio
                                    ,strGrupoNomina
                                    );                                      
      }
      
      if("borrarEvt".equals(strEventParam)){
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strAnio = messageLovInputBean.getText(pageContext); 
              try {
                numAnio = new oracle.jbo.domain.Number(strAnio);
              } catch (SQLException e) {
                System.out.println("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode());
                throw new OAException("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode(),OAException.ERROR); 
              }
          }
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strGrupoNomina = messageLovInputBean.getText(pageContext); 
          }
         
          if(null==numAnio&&null==strGrupoNomina){
              throw new OAException("No se ha elegido ningun parametro",OAException.ERROR);
          }
         
          balanzaAMImpl.borrarAjustesProjects(numAnio
                                             ,strGrupoNomina
                                             );
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              messageLovInputBean.setValue(pageContext,"");
              messageLovInputBean.setText(pageContext,"");
          }
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              messageLovInputBean.setValue(pageContext,"");
              messageLovInputBean.setText(pageContext,"");
          }
          /* pageContext.forwardImmediatelyToCurrentPage(null, false, null); */
           balanzaAMImpl.initPOPSProjects(); 
          throw new OAException("Se Borraron los ajustes",OAException.INFORMATION);                             
      }
      
  }

}
