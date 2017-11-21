
package Logica.generadores;

public class Cuadratico { 
    
    Verificador ver = new Verificador();
    
    //CALCULA  NUMERO ALEATORIO ENTERO
    public double[] metodoCuadratico(int xo, int a, int c, int d, int m){
       
        double[] aleatorios = new double[m];
        int potencia = (int) Math.pow(xo, 2);
        double res = ((d*potencia) + (a*xo) + c)%m;
        aleatorios[0]  = res/m; //primer numero aleatorio
        
        for(int i=1; i<m; i++)
        {
           potencia = (int) Math.pow(aleatorios[i-1], 2);
           res = ((d*potencia) + (a*aleatorios[i-1]) + c)%m;
           aleatorios[i] = res/m;
        }
         return aleatorios; 
    }
    
}
