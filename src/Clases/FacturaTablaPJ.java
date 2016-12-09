/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Reymundo Tenorio
 */
public class FacturaTablaPJ {

  
    private String NombreProducto;
    private String PV;
    private String Unids;
    private String TotalF;

    public FacturaTablaPJ() {
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getPV() {
        return PV;
    }

    public void setPV(String PV) {
        this.PV = PV;
    }

    public String getUnids() {
        return Unids;
    }

    public void setUnids(String Unids) {
        this.Unids = Unids;
    }

    public String getTotalF() {
        return TotalF;
    }

    public void setTotalF(String TotalF) {
        this.TotalF = TotalF;
    }

    public FacturaTablaPJ(String NombreProducto, String PV, String Unids, String TotalF) {
        this.NombreProducto = NombreProducto;
        this.PV = PV;
        this.Unids = Unids;
        this.TotalF = TotalF;
    }


   
    
    

}

