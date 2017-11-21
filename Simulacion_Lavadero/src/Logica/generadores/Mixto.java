
package Logica.generadores;
import java.util.ArrayList;

public class Mixto {
    
    public ArrayList<Double> mixto(double m, double n, double k){
        
        Aditivo ad = new Aditivo();
        ArrayList<Double> valores= new ArrayList<>();
        ArrayList<Double> green = new ArrayList<>();
        ArrayList<Double> mitchellMoore = new ArrayList<>();
        
        double res=0;
        int i=0;
        green.addAll(ad.Green(k, m));                //serie 1          
        mitchellMoore.addAll(ad.MitchellMoore(m, n));//serie 2
        
        do
        {
            res = ( green.get(i)*m + mitchellMoore.get(i)*m )%m; 
            valores.add(res/m);
            i++;
        }while(i<m);  
        
        return valores;
    }
    
}
