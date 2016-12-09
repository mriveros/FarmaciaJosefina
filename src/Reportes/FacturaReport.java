/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;


import Clases.FacturaTablaPJ;
import Clases.FacturacionPJ;
import java.util.ArrayList;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Reymundo Tenorio
 */
public class FacturaReport implements JRDataSource{

    private List<FacturacionPJ> p = new ArrayList<FacturacionPJ>();
    private List<FacturaTablaPJ> p1 = new ArrayList<FacturaTablaPJ>();
    private int iterator= 0;
   private int iterator1= -1;
    @Override
    public boolean next() throws JRException {
       // return ++iterator1 < p1.size(); 
        return ++iterator1 < p1.size() ;
        
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor = null;
        
        if("ID".equals(jrf.getName()))
        {
         valor = String.valueOf(p.get(iterator).getID());
        }
          if("NombreProd".equals(jrf.getName()))
        {
//            String Prod;
//            Prod = p1.get(iterator1).getNombreProducto();
//             StringTokenizer NombProd = new StringTokenizer(Prod, "/");
//                   while(NombProd.hasMoreTokens()){
//                    valor =NombProd.nextToken();
//                   }
        valor = p1.get(iterator1).getNombreProducto();
        }
            if("Unids".equals(jrf.getName()))
        {
//          String Unids;
//            Unids = p1.get(iterator1).getUnids();
//             StringTokenizer NombProd = new StringTokenizer(Unids, "/");
//                   while(NombProd.hasMoreTokens()){
//                    valor =NombProd.nextToken();
//                   }
            
            
            valor = String.valueOf(p1.get(iterator1).getUnids());
        }
            if("PV".equals(jrf.getName()))
        {
            
//            String PV;
//            PV = p1.get(iterator1).getPV();
//             StringTokenizer NombProd = new StringTokenizer(PV, "/");
//                   while(NombProd.hasMoreTokens()){
//                    valor =NombProd.nextToken();
//                   }
            
            
       valor = String.valueOf(p1.get(iterator1).getPV());
        }
            if("TotalF".equals(jrf.getName()))
        {
            
//             String TF;
//            TF = p1.get(iterator1).getTotalF();
//             StringTokenizer NombProd = new StringTokenizer(TF, "/");
//                   while(NombProd.hasMoreTokens()){
//                    valor =NombProd.nextToken();
//                   }
            
         valor = String.valueOf(p1.get(iterator1).getTotalF());
        }
            if("NombreVen".equals(jrf.getName()))
        {
         valor = p.get(iterator).getVendedor();
        }
            if("NombreClien".equals(jrf.getName()))
        {
         valor = p.get(iterator).getNombreCliente();
        }
            if("IVA".equals(jrf.getName()))
        {
         valor = p.get(iterator).getIVA();
        }
           if("Cajero".equals(jrf.getName()))
        {
         valor = p.get(iterator).getCajero();
        }
            if("TipoFactura".equals(jrf.getName()))
        {
         valor = p.get(iterator).getTipoFactura();
        }
            if("Total".equals(jrf.getName()))
        {
         valor = String.valueOf(p.get(iterator).getTotal());
        }
              if("SubTotal".equals(jrf.getName()))
        {
         valor = String.valueOf(p.get(iterator).getSubTotal());
        }
                if("Descuento".equals(jrf.getName()))
        {
         valor = p.get(iterator).getDescuento();
        }
                  if("TipoPago".equals(jrf.getName()))
        {
         valor = p.get(iterator).getTipoPago();
        }
                   if("TipoMoneda".equals(jrf.getName()))
        {
         valor = p.get(iterator).getTipoMoneda();
        }
                     if("TipoCambio".equals(jrf.getName()))
        {
         valor =String.valueOf( p.get(iterator).getTipoCambio());
        }
                       if("Recibido".equals(jrf.getName()))
        {
         valor = String.valueOf(p.get(iterator).getRecibido());
        }
                         if("Cambio".equals(jrf.getName()))
        {
         valor =String.valueOf( p.get(iterator).getCambio());
        }
          
              
              
        return valor;
    }
    
    public void addValor(FacturacionPJ A)
    {
        this.p.add(A);
    }
    
    public void addValor1(FacturaTablaPJ A)
    {
        this.p1.add(A);
    }
}
