
package Logica.Pruebas;

import Logica.generadores.Verificador;

/**
 *
 * @author Win 10
 */
public class Promedio {
    
    Verificador ver = new Verificador();
    
    public double calcularMedia(double[] listaA){
        
        double[] listaP = ver.calcularPeriodo(listaA);
        double suma=0, media =0;
        
        for(int i=0; i<listaP.length; i++)
        {
         suma = suma + listaP[i];
        }
        
        media = suma / listaP.length;
        return media;
       
    }
    
    
    public double calcularZO(double media, int tamañoP){
        
        double zo  = ((media - 0.5)*(Math.sqrt(tamañoP))) / Math.sqrt(0.5);
        
        return Math.abs(zo);
    }
    
    
    
    
    
    
    
}
