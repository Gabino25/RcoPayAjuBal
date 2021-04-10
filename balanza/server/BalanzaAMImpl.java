package xxrco.oracle.apps.pay.balanza.server;

import java.sql.SQLException;

import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;
import oracle.apps.fnd.framework.server.OADBTransaction;

import oracle.jbo.domain.Number;

import oracle.jdbc.OracleCallableStatement;
import java.sql.Types;
import oracle.apps.fnd.framework.OAException;

import oracle.jbo.RowSetIterator;

import xxrco.oracle.apps.pay.balanza.pop.AnioProjectsVOImpl;
import xxrco.oracle.apps.pay.balanza.pop.AnioProjectsVORowImpl;
import xxrco.oracle.apps.pay.balanza.pop.AnioVOImpl;
import xxrco.oracle.apps.pay.balanza.pop.AnioVORowImpl;
import xxrco.oracle.apps.pay.balanza.pop.GrupoNominaProjectsVOImpl;
import xxrco.oracle.apps.pay.balanza.pop.GrupoNominaProjectsVORowImpl;
import xxrco.oracle.apps.pay.balanza.pop.GrupoNominaVOImpl;
import xxrco.oracle.apps.pay.balanza.pop.GrupoNominaVORowImpl;
import xxrco.oracle.apps.pay.balanza.pop.MesProjectsVOImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class BalanzaAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public BalanzaAMImpl() {
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("xxrco.oracle.apps.pay.balanza.server", /* package name */
      "BalanzaAMLocal" /* Configuration Name */);
    }

    /**Container's getter for XxRcoPayjaustesBalanzaVO1
     */
    public XxRcoPayjaustesBalanzaVOImpl getXxRcoPayjaustesBalanzaVO1() {
        return (XxRcoPayjaustesBalanzaVOImpl)findViewObject("XxRcoPayjaustesBalanzaVO1");
    }

    
    public void poblarAnio(oracle.jbo.domain.Number  pNumAnio
                          ,String pGrupoNomina
                          ) {
        
        System.out.println("pNumAnio:"+pNumAnio); 
        System.out.println("pGrupoNomina:"+pGrupoNomina); 
        String retval = null; 
        String strCallableStmt = " BEGIN \n" + 
                                 "  APPS.XXRCO_FILL_AJUSTES_BALANZA ( PSO_ERRMSG         => :1\n" + 
                                 "                                  , PSO_ERRCOD         => :2\n" + 
                                 "                                  , PNI_ANIO           => :3\n" + 
                                 "                                  , PSI_GRUPO_NOMINA   => :4 "+
                                 "                                  );\n" + 
                                 " END; \n";
        OADBTransaction oadbtransaction = (OADBTransaction)getTransaction();
        OracleCallableStatement oraclecallablestatement =  (OracleCallableStatement)oadbtransaction.createCallableStatement(strCallableStmt, 1);
        try {
            oraclecallablestatement.registerOutParameter(1,Types.VARCHAR);
            oraclecallablestatement.registerOutParameter(2,Types.VARCHAR);
            oraclecallablestatement.setDouble(3,pNumAnio.doubleValue());
            oraclecallablestatement.setString(4,pGrupoNomina);
            oraclecallablestatement.execute();
        }catch (SQLException e) {
            System.out.println("SQLException en el metodo poblarAnio:"+e.getErrorCode());
            throw new OAException("SQLException en el metodo poblarAnio:"+e.getErrorCode(),OAException.ERROR); 
        }
    }

    public void consultarInfo(Number numAnio
                            , String strGrupoNomina) {
     
        XxRcoPayjaustesBalanzaVOImpl  xxRcoPayjaustesBalanzaVOImpl = getXxRcoPayjaustesBalanzaVO1();   
        if(null!=xxRcoPayjaustesBalanzaVOImpl){
            xxRcoPayjaustesBalanzaVOImpl.filter(numAnio
                                               ,strGrupoNomina
                                               ); 
        }
    }

    public void borrarAjustes(Number numAnio
                            , String strGrupoNomina) {
        XxRcoPayjaustesBalanzaVOImpl  xxRcoPayjaustesBalanzaVOImpl = getXxRcoPayjaustesBalanzaVO1();   
        XxRcoPayjaustesBalanzaVORowImpl  xxRcoPayjaustesBalanzaVORowImpl = null; 
        if(null!=xxRcoPayjaustesBalanzaVOImpl){
            xxRcoPayjaustesBalanzaVOImpl.filter(numAnio
                                               ,strGrupoNomina
                                               ); 
           RowSetIterator iterator =  xxRcoPayjaustesBalanzaVOImpl.createRowSetIterator("");
           while(iterator.hasNext()){
              xxRcoPayjaustesBalanzaVORowImpl = (XxRcoPayjaustesBalanzaVORowImpl)iterator.next();
              xxRcoPayjaustesBalanzaVORowImpl.remove();
           }
            iterator.closeRowSetIterator();
           this.getOADBTransaction().commit();
           xxRcoPayjaustesBalanzaVOImpl.filter(numAnio
                                               ,strGrupoNomina
                                               ); 
        }                       
    }

    /**Container's getter for AnioVO1
     */
    public AnioVOImpl getAnioVO1() {
        return (AnioVOImpl)findViewObject("AnioVO1");
    }

    /**Container's getter for GrupoNominaVO1
     */
    public GrupoNominaVOImpl getGrupoNominaVO1() {
        return (GrupoNominaVOImpl)findViewObject("GrupoNominaVO1");
    }

    public void initPOPS() {
        AnioVOImpl anioVOImpl =  getAnioVO1(); 
        AnioVORowImpl anioVORowImpl = null; 
        anioVOImpl.setWhereClause("1=1");
        anioVOImpl.executeQuery();
        RowSetIterator iterator = anioVOImpl.createRowSetIterator("");  
        while(iterator.hasNext()){
            anioVORowImpl = (AnioVORowImpl)iterator.next();
            System.out.println("anioVORowImpl.getMeaning():"+anioVORowImpl.getMeaning());
        }
        iterator.closeRowSetIterator();
        GrupoNominaVOImpl  grupoNominaVOImpl = getGrupoNominaVO1(); 
        GrupoNominaVORowImpl  grupoNominaVORowImpl = null; 
        grupoNominaVOImpl.setWhereClause("1=1");
        grupoNominaVOImpl.executeQuery();
        iterator = grupoNominaVOImpl.createRowSetIterator("");  
        while(iterator.hasNext()){
            grupoNominaVORowImpl = (GrupoNominaVORowImpl)iterator.next();
            System.out.println("grupoNominaVORowImpl.getMeaning():"+grupoNominaVORowImpl.getMeaning());
        }
        iterator.closeRowSetIterator();
    }

    public void poblarAnioProjects(Number pNumAnio, String pGrupoNomina) {
        System.out.println("pNumAnio:"+pNumAnio); 
        System.out.println("pGrupoNomina:"+pGrupoNomina); 
        String retval = null; 
        String strCallableStmt = " BEGIN \n" + 
                                 "  APPS.XXRCO_FILL_AJU_BZA_PROJ( PSO_ERRMSG         => :1\n" + 
                                 "                              , PSO_ERRCOD         => :2\n" + 
                                 "                              , PNI_ANIO           => :3\n" + 
                                 "                              , PSI_GRUPO_NOMINA   => :4 "+
                                 "                              );\n" + 
                                 " END; \n";
        OADBTransaction oadbtransaction = (OADBTransaction)getTransaction();
        OracleCallableStatement oraclecallablestatement =  (OracleCallableStatement)oadbtransaction.createCallableStatement(strCallableStmt, 1);
        try {
            oraclecallablestatement.registerOutParameter(1,Types.VARCHAR);
            oraclecallablestatement.registerOutParameter(2,Types.VARCHAR);
            oraclecallablestatement.setDouble(3,pNumAnio.doubleValue());
            oraclecallablestatement.setString(4,pGrupoNomina);
            oraclecallablestatement.execute();
        }catch (SQLException e) {
            System.out.println("SQLException en el metodo poblarAnioProjects:"+e.getErrorCode());
            throw new OAException("SQLException en el metodo poblarAnioProjects:"+e.getErrorCode(),OAException.ERROR); 
        }
    }

    /**Container's getter for XxRcoPayAjuBzaProjVO1
     */
    public XxRcoPayAjuBzaProjVOImpl getXxRcoPayAjuBzaProjVO1() {
        return (XxRcoPayAjuBzaProjVOImpl)findViewObject("XxRcoPayAjuBzaProjVO1");
    }

    public void consultarInfoProjects(Number numAnio, String strGrupoNomina) {
        XxRcoPayAjuBzaProjVOImpl xxRcoPayAjuBzaProjVOImpl = getXxRcoPayAjuBzaProjVO1();
        if(null!=xxRcoPayAjuBzaProjVOImpl){
            xxRcoPayAjuBzaProjVOImpl.filter(numAnio,strGrupoNomina);
        }
    }

    /**Container's getter for AnioProjectsVO1
     */
    public AnioProjectsVOImpl getAnioProjectsVO1() {
        return (AnioProjectsVOImpl)findViewObject("AnioProjectsVO1");
    }

    /**Container's getter for GrupoNominaProjectsVO1
     */
    public GrupoNominaProjectsVOImpl getGrupoNominaProjectsVO1() {
        return (GrupoNominaProjectsVOImpl)findViewObject("GrupoNominaProjectsVO1");
    }

    /**Container's getter for MesProjectsVO1
     */
    public MesProjectsVOImpl getMesProjectsVO1() {
        return (MesProjectsVOImpl)findViewObject("MesProjectsVO1");
    }

    public void consultarInfoProjects(Number numAnio, String strGrupoNomina, 
                                      Number numMes) {
        XxRcoPayAjuBzaProjVOImpl xxRcoPayAjuBzaProjVOImpl = getXxRcoPayAjuBzaProjVO1();
        if(null!=xxRcoPayAjuBzaProjVOImpl){
            xxRcoPayAjuBzaProjVOImpl.filter(numAnio,strGrupoNomina,numMes);
        }
    }

    public void borrarAjustesProjects(Number numAnio, String strGrupoNomina) {
        XxRcoPayAjuBzaProjVOImpl xxRcoPayAjuBzaProjVOImpl = getXxRcoPayAjuBzaProjVO1();
        XxRcoPayAjuBzaProjVORowImpl xxRcoPayAjuBzaProjVORowImpl = null; 
        if(null!=xxRcoPayAjuBzaProjVOImpl){
            xxRcoPayAjuBzaProjVOImpl.filter(numAnio,strGrupoNomina);
        }
        RowSetIterator iter = xxRcoPayAjuBzaProjVOImpl.createRowSetIterator(null);
        while(iter.hasNext()){
            xxRcoPayAjuBzaProjVORowImpl = (XxRcoPayAjuBzaProjVORowImpl)iter.next();
            xxRcoPayAjuBzaProjVORowImpl.remove();
        }
        iter.closeRowSetIterator();
        this.getOADBTransaction().commit();
        xxRcoPayAjuBzaProjVOImpl.filter(numAnio,strGrupoNomina);
    }

    public void initPOPSProjects() {
    
        AnioProjectsVOImpl anioProjectsVOImpl =  getAnioProjectsVO1(); 
        AnioProjectsVORowImpl anioVOProjectsRowImpl = null; 
        anioProjectsVOImpl.setWhereClause("1=1");
        anioProjectsVOImpl.executeQuery();
        RowSetIterator iterator = anioProjectsVOImpl.createRowSetIterator("");  
        while(iterator.hasNext()){
            anioVOProjectsRowImpl = (AnioProjectsVORowImpl)iterator.next();
            System.out.println("anioProjectsVORowImpl.getMeaning():"+anioVOProjectsRowImpl.getMeaning());
        }
        iterator.closeRowSetIterator();
        
        GrupoNominaProjectsVOImpl  grupoNominaProjectsVOImpl = getGrupoNominaProjectsVO1(); 
        GrupoNominaProjectsVORowImpl  grupoNominaProjectsVORowImpl = null; 
        grupoNominaProjectsVOImpl.setWhereClause("1=1");
        grupoNominaProjectsVOImpl.executeQuery();
        iterator = grupoNominaProjectsVOImpl.createRowSetIterator("");  
        while(iterator.hasNext()){
            grupoNominaProjectsVORowImpl = (GrupoNominaProjectsVORowImpl)iterator.next();
            System.out.println("grupoNominaProjectsVORowImpl.getMeaning():"+grupoNominaProjectsVORowImpl.getMeaning());
        }
        iterator.closeRowSetIterator();
    
    }

    /**Container's getter for XxRcoPayAjuBzaProjRaVO1
     */
    public XxRcoPayAjuBzaProjRaVOImpl getXxRcoPayAjuBzaProjRaVO1() {
        return (XxRcoPayAjuBzaProjRaVOImpl)findViewObject("XxRcoPayAjuBzaProjRaVO1");
    }

    public void PayAjuBzaProjRa() {
     System.out.println("Entra BalanzaAMImpl.PayAjuBzaProjRa");
     XxRcoPayAjuBzaProjRaVOImpl  xxRcoPayAjuBzaProjRaVOImpl = getXxRcoPayAjuBzaProjRaVO1();
     XxRcoPayAjuBzaProjRaVORowImpl  xxRcoPayAjuBzaProjRaVORowImpl = null; 
     if(!xxRcoPayAjuBzaProjRaVOImpl.isPreparedForExecution()){
         xxRcoPayAjuBzaProjRaVOImpl.executeQuery();
     }
     xxRcoPayAjuBzaProjRaVOImpl.last();
     xxRcoPayAjuBzaProjRaVOImpl.next();   
     xxRcoPayAjuBzaProjRaVORowImpl = (XxRcoPayAjuBzaProjRaVORowImpl)xxRcoPayAjuBzaProjRaVOImpl.createRow();
     xxRcoPayAjuBzaProjRaVORowImpl.setNewRowState(xxRcoPayAjuBzaProjRaVORowImpl.STATUS_INITIALIZED);
     xxRcoPayAjuBzaProjRaVOImpl.insertRow(xxRcoPayAjuBzaProjRaVORowImpl);
     System.out.println("Sale BalanzaAMImpl.PayAjuBzaProjRa");
    }
    
}
