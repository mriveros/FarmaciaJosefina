/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Reymundo Tenorio
 */
/*
 *  Validador de Número de Cédula Nicaraguense
 *  
 */


public class ValidarCedulaNic {
    private final String LETRAS = "ABCDEFGHJKLMNPQRSTUVWXY";
    
    private String cedula = null;
    
    /**
     * Constructor Validador de Número de Cédula Nicaraguense 
     */
    public ValidarCedulaNic() {
    }

   
 
        public String MostrarMsj(String Cedula){
           
            String tempo = null;
            
          ValidarCedulaNic Cel = new ValidarCedulaNic();
          Cel.setCedula(Cedula);
        tempo = "Cédula a Validar: " + Cel.getCedula() + "\n";
        tempo+= "Prefijo Cédula a Validar: " + Cel.getPrefijoCedula()+ "\n";
        tempo+= "Fecha Cédula a Validar: " + Cel.getFechaCedula()+ "\n";
        tempo+= "Sufijo Cédula a Validar: " + Cel.getSufijoCedula()+ "\n";
        tempo+= "Letra Cédula a Validar: " + Cel.getLetraCedula()+ "\n";
        tempo+= "¿Es Cédula Válida?: " + (Cel.isCedulaValida()?"SI":"NO")+ "\n";
        tempo+= "¿Es Prefijo Válido?: " + (Cel.isPrefijoValido()?"SI":"NO")+ "\n";
        tempo+= "¿Es Fecha Válida?: " + (Cel.isFechaValida()?"SI":"NO")+ "\n";
        tempo+= "¿Es Sufijo Válido?: " + (Cel.isSufijoValido()?"SI":"NO")+ "\n";
        tempo+= "¿Es Letra Válida?: " + (Cel.isLetraValida()?"SI":"NO")+ "\n";
        
        
            
         return tempo;
        
     
    }
        
        public boolean CedulaEsValida(String Cedula){
             ValidarCedulaNic cedula = new ValidarCedulaNic();
              cedula.setCedula(Cedula);
              
              return cedula.isCedulaValida();
        }
    
    /**
     * Retorna true si la cédula es válida
     * false en caso contrario
     * 
     * @return
     */
    public boolean isCedulaValida(){     
        if(!isPrefijoValido())
            return false;
            
        if(!isFechaValida())
            return false;
            
        if(!isSufijoValido())
            return false;
        
        if(!isLetraValida())
            return false;
            
        return true;
    }
    
    /**
     * Retorna true si el prefijo de la cédula es válida
     * false en caso contrario
     * 
     * @return
     */
    public boolean isPrefijoValido(){
        String prefijo = this.getPrefijoCedula();
        
        if(prefijo==null) return false;
        
        Pattern p = Pattern.compile("^[0-9]{3}$");
        Matcher m = p.matcher(prefijo);
        if (!m.find())       
            return false;
        
        return true;
    }
    
    /**
     * Retorna true si la fecha de la cédula es válida
     * false en caso contrario
     * 
     * @return
     */
    public boolean isFechaValida(){
        String fecha = this.getFechaCedula();
        
        if(fecha == null) return false;
        
        Pattern p = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])([0-9]{2})$");
        Matcher m = p.matcher(fecha);
        if (!m.find())
            return false;
            
        return true;
    }
    
    /**
     * Retorna true si el sufijo de la cédula es válida
     * false en caso contrario
     * 
     * @return
     */
    public boolean isSufijoValido(){
        String sufijo = this.getSufijoCedula();
        
        if(sufijo == null) return false;
        
        Pattern p = Pattern.compile("^[0-9]{4}[A-Y]$");
        Matcher m = p.matcher(sufijo);
        if (!m.find())
            return false;
        
        return true;
    }
    
    /**
     * Retorna true si la letra de la cédula es válida
     * false en caso contrario
     * 
     * @return
     */
    public boolean isLetraValida(){
        String letraValida = null;
        String letra = this.getLetraCedula();
        
        if(letra == null) return false;
        
        letraValida = String.valueOf(this.calcularLetra());
        
        return letraValida.equals(letra);
    }
    
    /**
     * Retorna un entero que representa la posición en la cadena LETRAS 
     * de la letra final de una cédula
     * 
     * @return
     */
    public int getPosicionLetra(){
        int posicionLetra = 0;
        String cedulaSinLetra = this.getCedulaSinLetra();
        long numeroSinLetra = 0;
        
        if(cedulaSinLetra == null) return -1;
        
        try{
            numeroSinLetra =  Long.parseLong(cedulaSinLetra);
        }catch(NumberFormatException e){
            return -1;
        }
        
        posicionLetra = (int)(numeroSinLetra - Math.floor((double)numeroSinLetra/23.0) * 23);
        
        return posicionLetra;
    }
    
    /**
     * <p>
     * Calcular la letra al final de la cédula nicaraguense.
     * </p><p>
     * Basado en el trabajo de: Arnoldo Suarez Bonilla - arsubo@yahoo.es
     * </p><p>
     * La letra se calcula con el siguiente algoritmo (yo se los envío en SQL).
     * <p>
     * <pre>
     * declare  @cedula      varchar(20),
     *          &#64;val         numeric(13, 0),
     *          &#64;letra       char(1),
     *          &#64;Letras      varchar(20)
     *          
     *          select @Letras = 'ABCDEFGHJKLMNPQRSTUVWXY'
     *          select @cedula = '0012510750012' --PARTE NUMERICA DE LA CEDULA SIN GUIONES
     *          --CALCULO DE LA LETRA DE LA CEDULA   
     *          select @val = convert(numeric(13, 0), @cedula) - floor(convert(numeric(13, 0), @cedula) / 23) * 23
     *          select @letra = SUBSTRING(@Letras, @val + 1, 1)
     *          select @letra
     * </pre> 
     * @return Letra válida de cédula dada
     */
    public char calcularLetra(){
        int posicionLetra = getPosicionLetra();
        
        if(posicionLetra <0 || posicionLetra >= LETRAS.length())
            return '?';
            
        return LETRAS.charAt(posicionLetra);
    }
    
    /**
     * Fiajr el Número de Cédula
     * 
     * @param cedula Número de Cédula con o sin guiones
     */
    public void setCedula(String cedula) {
        cedula = cedula.trim().replaceAll("-","");
        
        if(cedula == null || cedula.length() != 14)
            this.cedula = null;
        else
            this.cedula = cedula.trim().replaceAll("-","").toUpperCase();
    }

    /**
     * Retorna el Número de Cédula
     * @return 
     */
    public String getCedula() {
        return cedula;
    }
    
    /**
     * Retorna el prefijo de la cédula
     * @return
     */
    public String getPrefijoCedula(){
        if(cedula!=null)
            return cedula.substring(0,3);
        else 
            return null;
    }
    
    /**
     * Retorna la fecha en la cédula
     * @return
     */
    public String getFechaCedula(){
        if(cedula!=null)
            return cedula.substring(3,9);
        else 
            return null;
    }
    
    /**
     * Retorna el sufijo en la cédula
     * @return
     */
    public String getSufijoCedula(){
        if(cedula!=null)
            return cedula.substring(9,14);
        else 
            return null;
    }
    
    /**
     * Retorna la letra de la cédula
     * @return
     */
    public String getLetraCedula(){
        if(cedula!=null)
            return cedula.substring(13,14);
        else 
            return null;
    }
    
    /**
     * Retorna la cédula sin la letra de validación
     * @return
     */
    public String getCedulaSinLetra(){
        if(cedula!=null)
            return cedula.substring(0,13);
        else 
            return null;
    }
}

