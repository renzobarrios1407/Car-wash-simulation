
package Logica.generadores;

public class Multiplicativo {
         
    public double[] metodoMultiplicativo(int xo, int a, int m){
       
        double[] aleatoriosMix = new double[m];

        double res = (a*xo)%m;
        aleatoriosMix[0]  = res/m;
        for(int i=1; i<m; i++)
        {
           res = (a*res)%m;
           aleatoriosMix[i] = res/m;
        }
         return aleatoriosMix; 
    }
}

