/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.generadores;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo2
 */
public class Aditivo {   

    
    //METODO ADITIVO FIBONACCI
     public ArrayList<Double> Fibonacci(double m, double x0, double x1){

        ArrayList<Double> valores = new ArrayList<>();
        double aux=0, inicio;
        int n=0;
        inicio = 0;
        double res=0;
       
            do{
                res = (x0+x1)%m;
                x0 = x1;
                x1 = res;
                valores.add( res/m );
                n++;
            }while(n<m);

        return valores;
    }

     
         //METODO ADITIVO DE MITCHEL Y MOORE
       public ArrayList<Double> MitchellMoore(double m,double n){
           
        ArrayList<Double> numeros = new ArrayList<>();
        ArrayList<Double> fibonacci = new ArrayList<>(); //55 semillas aleatorias no todas pares
        fibonacci.addAll(Fibonacci(n, 0, 1));
        double x1=0, x2=0, i=0, res=0;
        
        if(n>54)
        {
            do
            {
                x1 = fibonacci.get((fibonacci.size()-1)-24)*n;
                x2 = fibonacci.get((int)(fibonacci.size()-n))*n;
                res = (x1+x2)%m;
                fibonacci.add(res/m);
                numeros.add(res/m);
                i++;
            }while(i<m);
        }
        else  
        {  
            JOptionPane.showMessageDialog(null, "El valor de N debe de ser mayor a 54");
        }
        
        return numeros;
    }

      //METODO ADITIVO DE GREEN
      public ArrayList<Double> Green(double k, double m){
       
        ArrayList<Double> valores = new ArrayList<>();
        double x=0, x1=0, res=0;
        int i=0;
        
        ArrayList<Double> fibonacci = new ArrayList<>();
        fibonacci.addAll(Fibonacci(m, 0, 1));
 
            do
            {
                x = fibonacci.get((int) (fibonacci.size()-k))*m;
                x1 = fibonacci.get(i)*m;
                res = (x+x1)%m;

                valores.add(res/m);
                fibonacci.add(res/m);
                i++;
            }while(i<m);

        return valores;
    }
    

}
