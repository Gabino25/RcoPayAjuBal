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

import oracle.apps.fnd.framework.webui.beans.message.OAMessageChoiceBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageLovInputBean;
import oracle.apps.fnd.framework.webui.beans.message.OAMessageTextInputBean;

import oracle.apps.fnd.framework.webui.beans.table.OAAdvancedTableBean;
import oracle.apps.fnd.framework.webui.beans.table.OAColumnBean;
import oracle.apps.fnd.framework.webui.beans.table.OATableBean;

import oracle.apps.fnd.framework.webui.beans.table.OATotalRowBean;

import xxrco.oracle.apps.pay.balanza.server.BalanzaAMImpl;

/**
 * Controller for ...
 */
public class AjustesBalanzaCO extends OAControllerImpl
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
    
      OAAdvancedTableBean xxRcoPayjaustesBalanzaVORNBean =  (OAAdvancedTableBean)webBean.findChildRecursive("XxRcoPayjaustesBalanzaVORN");
      OAMessageTextInputBean textInputBean = null; 
      OAColumnBean oaColumnBean = null; 
      
      if(null!=xxRcoPayjaustesBalanzaVORNBean){
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CuotaPatronal");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErInf");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErRet");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErSta");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
         textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjuImssDeducible");
         if(null!=textInputBean){
            textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
         }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjuImssNoDeducible");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancFaPeriodoAnterior");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancFa");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancSyr");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancProvPrimVac");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancProvAguinaldo");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancUtilesEscolares");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjusteIsn");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          textInputBean = (OAMessageTextInputBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjusteLentes");
          if(null!=textInputBean){
             textInputBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          
          
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CuotaPatronalCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErInfCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErRetCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CalcCuotaSsErStaCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjuImssDeducibleCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjuImssNoDeducibleCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancFaPeriodoAnteriorCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancFaCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancSyrCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancProvPrimVacCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancProvAguinaldoCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("CancUtilesEscolaresCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjusteIsnCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          oaColumnBean = (OAColumnBean)xxRcoPayjaustesBalanzaVORNBean.findChildRecursive("AjusteLentesCol"); 
          if(null!=oaColumnBean){
             oaColumnBean.setAttributeValue(OAWebBeanConstants.CURRENCY_CODE,"USD");
          }
          
          
      }
      
      BalanzaAMImpl balanzaAMImpl = (BalanzaAMImpl)pageContext.getApplicationModule(webBean); 
      balanzaAMImpl.initPOPS(); 

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
    String strSourceParam = pageContext.getParameter(this.SOURCE_PARAM);
    String strEventParam = pageContext.getParameter(this.EVENT_PARAM); 
    System.out.println("strEventParam:"+strEventParam);  
    OAMessageTextInputBean textInputBean = null; 
    OAMessageChoiceBean  messageChoiceBean = null; 
    OAMessageLovInputBean  messageLovInputBean = null; 
    String strAnio = null; 
    String strGrupoNomina = null; 
   
      
    BalanzaAMImpl balanzaAMImpl = (BalanzaAMImpl)pageContext.getApplicationModule(webBean); 
    
    oracle.jbo.domain.Number numAnio=null;

     
       if("guardarCambiosEvt".equals(strEventParam)){
           balanzaAMImpl.getOADBTransaction().commit();
           /*pageContext.forwardImmediatelyToCurrentPage(null, false, null);*/
           throw new OAException("Se Guardaron los cambios",OAException.INFORMATION);        
       }
     
       if("consultarEvt".equals(strEventParam)){
           messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio1");
           if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
               strAnio = messageLovInputBean.getText(pageContext); 
           }
           messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina1");
           if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
               strGrupoNomina = messageLovInputBean.getText(pageContext); 
           }
           try {
               numAnio = new oracle.jbo.domain.Number(strAnio);
           } catch (SQLException e) {
               System.out.println("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode());
               throw new OAException("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode(),OAException.ERROR); 
           }
           balanzaAMImpl.consultarInfo(numAnio
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
        balanzaAMImpl.poblarAnio(numAnio
                                ,strGrupoNomina
                                );
       balanzaAMImpl.consultarInfo(numAnio
                                 ,strGrupoNomina
                                 );     
          textInputBean = (OAMessageTextInputBean)webBean.findChildRecursive("Anio");
          if(null!=textInputBean&&null!=textInputBean.getValue(pageContext)){
              textInputBean.setValue(pageContext,"");
          }                  
          messageChoiceBean = (OAMessageChoiceBean)webBean.findChildRecursive("GrupoNomina");
          if(null!=messageChoiceBean&&null!=messageChoiceBean.getText(pageContext)){
              messageChoiceBean.setValue(pageContext,"");
              messageChoiceBean.setText(pageContext,"");
          }
          /*pageContext.forwardImmediatelyToCurrentPage(null, false, null);*/
          balanzaAMImpl.initPOPS(); 
          throw new OAException("Se Creo la Informacion",OAException.INFORMATION);                           
       
      }
      
      if("borrarEvt".equals(strEventParam)){
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("Anio11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strAnio = messageLovInputBean.getText(pageContext); 
              
          }
          messageLovInputBean = (OAMessageLovInputBean)webBean.findChildRecursive("GrupoNomina11");
          if(null!=messageLovInputBean&&null!=messageLovInputBean.getText(pageContext)){
              strGrupoNomina = messageLovInputBean.getText(pageContext); 
          }
          try {
            numAnio = new oracle.jbo.domain.Number(strAnio);
          } catch (SQLException e) {
            System.out.println("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode());
            throw new OAException("SQLException en covertir el anio:"+strAnio+", "+e.getErrorCode(),OAException.ERROR); 
          }
          balanzaAMImpl.borrarAjustes(numAnio
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
           balanzaAMImpl.initPOPS(); 
          throw new OAException("Se Borraron los ajustes",OAException.INFORMATION);                             
      }
    
  }

}
