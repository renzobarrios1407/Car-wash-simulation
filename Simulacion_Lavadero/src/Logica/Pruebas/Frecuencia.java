
package Logica.Pruebas;

/**
 *
 * @author Win 10
 */
public class Frecuencia {
    
    //GENERAR LIMITES MAXIMOS DE LOS INTERVALOS
    public double[] calcularMaximos(int noIntervalos){
        
        double acumulacion = 1.0/noIntervalos;
        double limiteMin = 0, limiteMax=0; 
        double aux = acumulacion;
        double[] intervalosMax = new double[noIntervalos];

        for(int i=0; i<noIntervalos; i++)
        { 

              limiteMax = aux;
              aux = limiteMax + acumulacion;
              intervalosMax[i] = limiteMax;
//            System.out.println("---MAX ---"+intervalosMax[i]+"\n");
        }
        
        return intervalosMax;
    }
    
    //GENERAR LIMITES MINIMOS DE LOS INTERVALOS
    public double[] calcularMinimos(int noIntervalos){
        
        
        double[] intervalosMin = new double[noIntervalos];
        double acumulacion = 1.0/noIntervalos;
        double limiteMin = 0; 
        double aux2 = 0;
        
         for(int i=0; i<noIntervalos; i++)
        { 
              
              limiteMin = aux2;
              aux2 = limiteMin + acumulacion;
 
              intervalosMin[i] = limiteMin;           //captura del los limites minimos
//              System.out.println("---MIN ---"+intervalosMin[i]+"\n");
        }
         
         return intervalosMin;
    }
    
    //CALCULAR LA FRECUENCIA OBSERVADA TOMA LOS LIMITES DE LOS INTERVALOS Y LOS NUMEROS DEL PERIODO
    public int[] calcularFO(double min, double max, double[] periodo, int intervalos){
        
        double aleatorio =0;
        int cont =0;
        int[] fo = new int[intervalos];

          for(int j =0; j<periodo.length; j++)
        {
             aleatorio = periodo[j];
             //Intervalo para la determinacion de la FO
             if(aleatorio>=min && aleatorio<max)
             {
              cont++;
             }  
        }
 
          for(int i=0; i<fo.length; i++)
        {
            fo[i] = cont;
        }
//        System.out.println("para: "+min+"---"+max+"---FO= "+cont);
        
        return fo;

    }
    
 
}
