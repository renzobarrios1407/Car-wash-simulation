
package Logica.generadores;

public class CongMixto {   
    
    //CALCULA RESIDUO ENTRE A Y M 
    public double[] metodoMixto(int xo, int a, int c, int m){
       
        double[] aleatoriosMix = new double[m];

        double res = ((a*xo)+c)%m;
        aleatoriosMix[0]  = res/m;
        for(int i=1; i<m; i++)
        {
           res = ((a*res)+c)%m;
           aleatoriosMix[i] = res/m;
        }
         return aleatoriosMix; 
    }

}
