
package Logica.generadores;

import javax.swing.JOptionPane;

public class Verificador {
    
    //Este método verifica si el nuemero es impares,
    public boolean verificarImpar(int numero)
    {
       boolean esimpar = true;        
        if(numero%2==0)
        {
            esimpar= false;
        }
            return esimpar;
    }
    
    //Este método verifica que la variable A NO sea divisible entre 3 y 5
    public boolean verificarDivisibilidad35(int numero){
        boolean divisible = true;
        if(numero%3==0 || numero%5==0){  
            divisible = false;
        }
        return divisible;
    }
    
    //Este método verifica que C Y M sean primos relativos
    public boolean VerificarPrimoRelativo(int c, int m) {
    	int divisor = 2;
        boolean primor = true;
        while ((divisor <=c / 2) || (divisor <= m / 2)) {
            if (((c % divisor) == 0) && ((m% divisor) == 0)) {
                return (primor = false);
            }
            divisor++;   
        }
        return primor;
    }
    //VERIFICA QUE EL NUMERO SEA PRIMO
     public boolean verificarPrimo(int n){
         
         boolean res = true;
         int cont =0;
         for(int i=0; i<=n; i++)
         {
             if(n%(i+1)==0)
             {
                 cont++;
             }
         }
            if(cont>2)
            {
             res= false;
            }  
            return res;
     }
     
     //regla D y A-1 deben ser multiplos de los divisores impares primos de M
     public boolean reglaMultiplosImparesPrimos(int m, int d, int a){
        boolean band = true;
         int resto, cont, aux1 = 0, aux2 = 0;
         
         for(int i=0; i<=m; i++)
         {
             resto = m%(i+1); //division exacta
             cont = i+1;

             if(resto==0 && verificarImpar(cont)==true && verificarPrimo(cont) ==true && cont!=1)
             {
                aux1 = d%cont;
                aux2 = (a-1)%cont;
                if(aux1 ==0 && aux2 ==0)
                {
                    System.out.println("Cumplen la regla");
                    return band;
                }
             }
             else if(aux1>0 || aux2>0)
                {
                   System.out.println("No se cumple la regla D y A-1");
                   band = false;
                }
         }  
         return band;
     }
   
    
     //VERIFICA REGLA M = 4K , M = 2K o M = 9K
     public boolean reglaM(int m, int a, int c, int d){
         
         boolean band = false;
         if(m%4==0 && (d%2==0 || (d%4==(a-1)%4)))
         {  
             System.out.println("Cumple regla 4k");
             band = true;
         }
         else if(m%2==0 && (d%2==0 || d%2==(a-1)%2)) //m puede ser dos (no se cumpliria la regla 4k)
         {
            System.out.println("Cumple regla 2k");
            band = true;
         }
         else if(m%9==0 && (d%9==(0%9) || a%9==1%9 || (c*d)%9==6%9))
         {
            System.out.println("Cumple regla 9k");
            band = true;
         }
         return band;
     }
     
    //CONJUNTO DE VERIFICACIONES DEL METODO congruencial Mixto
    public boolean mensajesErrorCongMixto(int xo, int a, int c, int m){

        boolean band = true;
        if(xo<=0 || a<=0 || c<=0 || m<=0)
        {
            JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a 0");
             band = false;
        }
        else if(m<xo || m<a || m<c)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que M sea mayor que Xo, A y C");
             band = false;
        }
         else if(verificarDivisibilidad35(a)==false)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que A no sea divisible entre 3 y 5");
             band = false;
        }
        else if(verificarImpar(a)==false || verificarImpar(c)==false)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que A y C sean impares");
             band = false;
        }
        else if(VerificarPrimoRelativo(c, m)==false)
        {
             JOptionPane.showMessageDialog(null, "C debe  ser relativamente primo a M");
             band = false;
        }
        return band;
    }
    
       //CONJUNTO DE VERIFICACIONES DEL METODO Cuadratico
    public boolean mensajesErrorCuadratico(int xo, int a, int c, int m, int d){
        
        Verificador ver = new Verificador();
        boolean band = true;
        if(xo<=0 || a<=0 || c<=0 || m<=0 || d<0)  
        {
            JOptionPane.showMessageDialog(null, "Xo, a, c y m deben ser >0  y d>=0");
             band = false;
        }
        else if(m<xo || m<a || m<c)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que M sea mayor que Xo, A y C");
             band = false;
        }
        else if(ver.VerificarPrimoRelativo(c, m)==false)
        {
             JOptionPane.showMessageDialog(null, "C debe  ser relativamente primo a M");
             band = false;
        }
          else if(reglaMultiplosImparesPrimos(m, d, a)==false)
        {
             JOptionPane.showMessageDialog(null, "D y A-1 no son multiplos de los factores primos impares de m");
             band = false;
        }
          else if(reglaM(m, a, c, d)==false)   
        {
             JOptionPane.showMessageDialog(null, "No se cumple la regla M = 4K, 2K o 9K");
             band = false;
        }
        return band;
    }
    
    //CONJUNTO DE VERIFICACIONES DEL METODO Multimplicativo
    public boolean mensajesErrorMultiplicativo(int xo, int a, int m){

        boolean band = true;
        if(xo<=0 || a<=0 || m<=0)
        {
            JOptionPane.showMessageDialog(null, "Los valores deben ser mayores a 0");
             band = false;  
        }
        else if(m<xo || m<a || m%2!=0)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que M sea par mayor que Xo, A y C");
             band = false;
        }
        else if(verificarImpar(xo)==false)
        {
             JOptionPane.showMessageDialog(null, "Se recomienda que la semilla sea impar");
             band = false;
        }
       else if(VerificarPrimoRelativo(xo, m)==false)
        {
             JOptionPane.showMessageDialog(null, "El valor de la semilla debe ser relativamente primo a M");
             band = false;
        }
        return band;
    }
    
     //OBTIENE LOS NUMEROS ALEATORIOS QUE CONFORMAN EL PERIODO
    public double[] calcularPeriodo(double[] listaA){
         
        int cont =1;
        double inicio = listaA[0];

        for(int i=1; i<listaA.length; i++)
        {
         if(listaA[i]!= inicio)   
         {
            cont++;  
         }
         else
         {
         break;
         }
        }
        
        double[] NoPeriodo = new double[cont];
        
        for(int j=0; j<cont; j++)
        {
         NoPeriodo[j] = listaA[j];
         //System.out.println("----: "+NoPeriodo[j]+"\n");
        }
        return NoPeriodo;

    }  
 
}
