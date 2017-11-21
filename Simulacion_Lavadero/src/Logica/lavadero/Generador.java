
package Logica.lavadero;

import java.util.ArrayList;

public class Generador {
                //                        5    10    15   20   25   30   35    40
    private static Double[] probLlegada={0.05, 0.1, 0.2, 0.3, 0.6, 0.8, 0.95, 1.0};
    

      //DEVUELVE UNA LISTA CON LOS TIEMPOS DE CADA SERVICIO OFRECIDO PARA LA POLITICA 1 Y 3
     public ArrayList<Integer> contarAtendidos(double[] alLlegadas, int[] servicios, int horario){
        
        double aux =0; 
        int tiempo =0;
        int tiempoS =0; //suma de los tiempos de los servicios solicitados
        int aux2 =0;
        int aux3 = 0;
        int cont =0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
         
        for(int j =0; j<alLlegadas.length; j++)
        {
            aux = alLlegadas[j];
            aux3 = servicios[j];
            
            for(int i=0;i<8; i++)
            {
             aux2 = (i+1)*5;
             if(aux<probLlegada[i])
             {
                 if((tiempoS + aux3)<=horario && (tiempo + aux2)<=horario)   //si aun es horario de trabajo
                 {
                  tiempo = tiempo + aux2; //tiempo de llegada
                  tiempoS = tiempoS + aux3;
                  cont++;
                  posiciones.add(aux3);
                  break;
                 }
                 else
                 {
                 break;
                 }
             }
            } 
        }
//        System.out.println("tiempo total de trabajo-- "+tiempoS);
//        System.out.println("atendidos con servicios-- "+cont);
//        System.out.println("--------servicios atendidos-------- ");
//        for(int i =0; i<posiciones.size(); i++)
//        {
//         System.out.println("tiempo servicio= "+posiciones.get(i));
//        }

       return posiciones;
       }
     
     //TIEMPO DE DURACION DEL SERVICIO SOLICITADO
     public int[] generarServicios(double[] noAleatorios, int limite){
        
        int[] valores = new int[noAleatorios.length ];  
        double aux =0; 

        for(int j =0; j<limite; j++)
        {
            aux = noAleatorios[j];
            
            if(aux>=0 && aux<0.15)
            {
            valores[j]= 10; 
            }
            else if(aux>=0.15 && aux<0.25)
            {
            valores[j]= 20; 
            }
            else if(aux>=0.25 && aux<0.4)
            {
            valores[j]= 30; 
            }
            else if(aux>=0.4 && aux<1.0)
            {
            valores[j]= 40; 
            }
        } 
        return valores;
       }
     
    //CALCULA EL DINERO POR LOS SERVICIOS OFRECIDOS
   public double calcularDinero(ArrayList<Integer> listaServicios){  

        double dinero = 0;
        
        for(int i =0; i<listaServicios.size(); i++)
        {
            if(listaServicios.get(i)==10)
            {
             dinero = dinero + 5000;
            }
            if(listaServicios.get(i)==20)
            {
             dinero = dinero + 7000;
            }
            if(listaServicios.get(i)==30)
            {
             dinero = dinero + 9000;
            }
            if(listaServicios.get(i)==40)
            {
             dinero = dinero + 11000;
            }
        }
//        System.out.println("----------------------- ");
//        System.out.println("valor= "+dinero);
//        System.out.println("----------------------- ");
        return dinero;
    }
   
   
    //DEVUELVE UNA LISTA DE LOS SERVICIOS QUE SE OFRECIERON EN LA POLITICA 2
     public ArrayList<Integer> inmediatos(double[] alLlegadas, int[] servicios, int horario){
        
        double aux =0; 
        int tiempo =0;
        int tiempo2 =0;
        int tiempoS =0; //suma de los tiempos de los servicios solicitados
        int aux2 =0;
        int aux3 = 0;
        int aux4 = 0;
        int actual =0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        ArrayList<Integer> llegadas = new ArrayList<Integer>();
        ArrayList<Integer> atendidos = new ArrayList<Integer>();
         
        for(int j =0; j<alLlegadas.length; j++)
        {
            aux = alLlegadas[j];
            aux3 = servicios[j];
            
            for(int i=0;i<8; i++)
            {
             aux2 = (i+1)*5;
             if(aux<probLlegada[i])
             {
                 if((tiempoS + aux3)<=horario && (tiempo + aux2)<=horario)   //si aun es horario de trabajo
                 {
                  tiempo = tiempo + aux2; //tiempo de llegada
                  tiempoS = tiempoS + aux3;
                  llegadas.add(aux2);
                  posiciones.add(aux3);
                  break;
                 }
                 else
                 {
                 break;
                 }
             }
            } 
        }
        
//         for(int i =0; i<posiciones.size(); i++)
//        {
//         System.out.println("llegada= "+llegadas.get(i)+ "tiempo servicio= "+posiciones.get(i));
//        }

         //Comienzo politica 3
            atendidos.add(posiciones.get(0));
            aux4++;

            for(int i =1; i<llegadas.size(); i++)
            {  
                if((tiempo2 + llegadas.get(i))>=actual && actual>0)
                {
                 actual = posiciones.get(i);
                 atendidos.add(posiciones.get(i));   
                 aux4++;
                 tiempo2=0;
                }
                else if(llegadas.get(i)>=posiciones.get(i-1) && tiempo2==0)  //primero
                {   
                actual = posiciones.get(i);
//                System.out.println("actual = "+actual); 
                atendidos.add(posiciones.get(i));   
                aux4++;
                }
                else if(llegadas.get(i)<=posiciones.get(i-1))
                {
                 tiempo2 = tiempo2 + llegadas.get(i);
                }
          }
//            for(int i =0; i<atendidos.size(); i++)
//            {
//             System.out.println("atendido servicio de= "+atendidos.get(i)); 
//            }
//        System.out.println("atendidos p2= "+aux4);
//        System.out.println("tiempo perdido= "+tiempo2);

       return atendidos;   
       }

}

