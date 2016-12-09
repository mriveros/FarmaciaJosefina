/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Reymundo Tenorio
 */
public class FacturacionPJ {

    private int ID;
    private String NombreCliente;
    private String Vendedor;
    private String TipoMoneda;
    private String TipoPago;
    private double Recibido;
    private double Cambio;
    private double TipoCambio;
    private double Total;
    private double SubTotal;
    private String Descuento;
    private String Cajero;
    private double IVA;
    private String TipoFactura;

    public FacturacionPJ(int ID, String NombreCliente, String Vendedor, String TipoMoneda, String TipoPago, double Recibido, double Cambio, double TipoCambio, double Total, double SubTotal, String Descuento, String Cajero, double IVA, String TipoFactura) {
        this.ID = ID;
        this.NombreCliente = NombreCliente;
        this.Vendedor = Vendedor;
        this.TipoMoneda = TipoMoneda;
        this.TipoPago = TipoPago;
        this.Recibido = Recibido;
        this.Cambio = Cambio;
        this.TipoCambio = TipoCambio;
        this.Total = Total;
        this.SubTotal = SubTotal;
        this.Descuento = Descuento;
        this.Cajero = Cajero;
        this.IVA = IVA;
        this.TipoFactura = TipoFactura;
    }

    public String getTipoFactura() {
        return TipoFactura;
    }

    public void setTipoFactura(String TipoFactura) {
        this.TipoFactura = TipoFactura;
    }
    

    public String getCajero() {
        return Cajero;
    }

    public void setCajero(String Cajero) {
        this.Cajero = Cajero;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public FacturacionPJ() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getTipoMoneda() {
        return TipoMoneda;
    }

    public void setTipoMoneda(String TipoMoneda) {
        this.TipoMoneda = TipoMoneda;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getDescuento() {
        return Descuento;
    }

    public void setDescuento(String Descuento) {
        this.Descuento = Descuento;
    }

    public double getRecibido() {
        return Recibido;
    }

    public void setRecibido(double Recibido) {
        this.Recibido = Recibido;
    }

    public double getCambio() {
        return Cambio;
    }

    public void setCambio(double Cambio) {
        this.Cambio = Cambio;
    }

    public double getTipoCambio() {
        return TipoCambio;
    }

    public void setTipoCambio(double TipoCambio) {
        this.TipoCambio = TipoCambio;
    }

   


  
    
    

}

