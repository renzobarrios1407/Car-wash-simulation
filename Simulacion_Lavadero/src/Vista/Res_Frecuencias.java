
package Vista;

import Logica.Pruebas.Frecuencia;
import Logica.generadores.Aditivo;
import Logica.generadores.CongMixto;
import Logica.generadores.Cuadratico;
import Logica.generadores.Verificador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win 10
 */
public class Res_Frecuencias extends javax.swing.JFrame {


     DefaultTableModel modelo;
     DefaultTableModel modelo1;
     Frecuencia frec = new Frecuencia();
     
     
    public Res_Frecuencias(){
        initComponents();
        setLocationRelativeTo(null);
        campNoIntervalos.setText("5");
         campA.setVisible(false);
        campC.setVisible(false);
        campD.setVisible(false);
        campM.setVisible(false);
        campC.setVisible(false);
        campSem1.setVisible(false);
        campSem2.setVisible(false);
        NumAlg.setVisible(false);
    }
    
    
    public void ejecutarKolmovorok(){
        
        CongMixto congMixto = new CongMixto();
        Cuadratico cuad = new Cuadratico();
        Aditivo ad = new Aditivo();
        Verificador ver = new Verificador();
        int xo = 0, x1, a = 0, c = 0, d = 0, diasM =0;

        if(campNoIntervalos.getText().equals("") || Integer.parseInt(campNoIntervalos.getText())<=0 || Integer.parseInt(campNoIntervalos.getText())>10 )
        {
            JOptionPane.showMessageDialog(null, "Ingrese un número de intervalos valido entre 1 y 10");
        }
        else 
        {
        int intervalos = Integer.parseInt(campNoIntervalos.getText());
        double[] lista = new double[diasM];

        if(Integer.parseInt(NumAlg.getText()) == 1)//-------------------------- //congruencial mixto
        {
        xo = Integer.parseInt(campSem1.getText());
        a = Integer.parseInt(campA.getText());
        c = Integer.parseInt(campC.getText());
        diasM = Integer.parseInt(campM.getText());
        lista = congMixto.metodoMixto(xo, a, c, diasM);  
        double[] lista2 = new double[ver.calcularPeriodo(lista).length];
        lista2 = ver.calcularPeriodo(lista);                            //obtener numeros aleatorios que conforman el periodo
        cargarNumeros(lista2);                                         //cargar numeros a probar
        cargartablaResultados(intervalos, lista2);                    //cantidad de intervalos y numeros del periodo como parametros
        }
        else if(Integer.parseInt(NumAlg.getText()) == 2)//----------------------cuadratico
        {
        xo = Integer.parseInt(campSem1.getText());
        a = Integer.parseInt(campA.getText());
        c = Integer.parseInt(campC.getText());
        d = Integer.parseInt(campD.getText());
        diasM = Integer.parseInt(campM.getText());
        lista = cuad.metodoCuadratico(xo, a, c, d, diasM);
        double[] lista2 = new double[ver.calcularPeriodo(lista).length];
        lista2 = ver.calcularPeriodo(lista);                            //obtener numeros aleatorios que conforman el periodo
        cargarNumeros(lista2);                                         //cargar numeros a probar
        cargartablaResultados(intervalos, lista2);                    //cantidad de intervalos y numeros del periodo como parametros
        }
        else if(Integer.parseInt(NumAlg.getText()) == 3)//----------------------aditivo fibonacci
        {
        ArrayList<Double> resultado = new ArrayList<>();
        double xoAd = Double.parseDouble(campSem1.getText());
        double x1Ad = Double.parseDouble(campSem2.getText());
        double mAd = Double.parseDouble(campM.getText());  
        resultado = ad.Fibonacci(mAd, xoAd, x1Ad);  
        double[] lista2 = new double[resultado.size()];
        for(int i =0; i<resultado.size(); i++)
           {
            lista2[i] = resultado.get(i);
           }
        double[] lista3 = new double[ver.calcularPeriodo(lista2).length];
        lista3 = ver.calcularPeriodo(lista2);                            //obtener numeros aleatorios que conforman el periodo
        cargarNumeros(lista3);                                         //cargar numeros a probar
        cargartablaResultados(intervalos, lista3);                    //cantidad de intervalos y numeros del periodo como parametros
        }
        }
    }
    
    //CARGA LOS NUMEROS ALEATORIOS A PROBAR   ---------------CORREGIR PARA QUE MUESTRE SOLO LOS DEL PERIODO
    public void cargarNumeros(double[] lista){
        
        String[] titulos = {"#", " Aleatorios periodo" };
        String[] NoCampos = new String[2];
        modelo1 = new DefaultTableModel (null,titulos);
        
        for(int i=0; i<lista.length; i++)
        {
            NoCampos[0] = Integer.toString(i+1);
            NoCampos[1] = Double.toString(lista[i]);
            modelo1.addRow(NoCampos);
        }
        
        tablaNums.setModel(modelo1);
    }
    
    //CARGA LOS RESULTADOS DE LA PRUEBA DE FRECUENCIAS
    public void cargartablaResultados(int intervalos, double[] periodo){  //------pasar el valor del periodo para calcular la FO
        
        Verificador ver = new Verificador();
        
        String[] titulos = {"MIN", "MAX", "FE", "FO", "RESULTADO" };
        String[] NoCampos = new String[5];  
        modelo = new DefaultTableModel (null,titulos);
        double[] res1 = frec.calcularMinimos(intervalos); //limites minimos
        double[] res2 = frec.calcularMaximos(intervalos); //limites maximos
        int cant = Integer.parseInt(campM.getText());     
        int[] fo = new int[intervalos];
        double fe = cant/intervalos;  //frecuencia esperada
        double form = 0;
        double total =0;

        for(int i=0; i<res1.length; i++)    
        { 
         fo = frec.calcularFO(res1[i], res2[i], periodo, intervalos); //obtenemos las frecuencias observadas por periodo
         form = (Math.pow((fe-fo[i]), 2))/fe;
         total = total + form;
         
         NoCampos[0] = Double.toString(res1[i]);
         NoCampos[1] = Double.toString(res2[i]);
         NoCampos[2] = Double.toString(fe);
         NoCampos[3] = Integer.toString(fo[i]);
         NoCampos[4] = Double.toString(form);
         modelo.addRow(NoCampos);  
        }
        
        tablaFrec.setModel(modelo);
        campChiCuadrado.setText(Double.toString(total));    
        campGradosL.setText(Integer.toString(intervalos - 1));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFrec = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        campNoIntervalos = new javax.swing.JTextField();
        campChiCuadrado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        campGradosL = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotonEjecutarP = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaNums = new javax.swing.JTable();
        campSem1 = new javax.swing.JTextField();
        campSem2 = new javax.swing.JTextField();
        campA = new javax.swing.JTextField();
        campC = new javax.swing.JTextField();
        campM = new javax.swing.JTextField();
        campD = new javax.swing.JTextField();
        NumAlg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado prueba de frecuencias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tablaFrec.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tablaFrec);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("# Intervalos");

        campChiCuadrado.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Ji Cuadrado X2");

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        campGradosL.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("          G. libertad");

        BotonEjecutarP.setText("Ejecutar");
        BotonEjecutarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEjecutarPActionPerformed(evt);
            }
        });

        tablaNums.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                ""
            }
        ));
        jScrollPane2.setViewportView(tablaNums);

        NumAlg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumAlgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(86, 86, 86))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campNoIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(campChiCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(campGradosL, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(BotonEjecutarP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(NumAlg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addGap(70, 70, 70))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NumAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campNoIntervalos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campChiCuadrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campGradosL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(BotonEjecutarP)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonEjecutarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEjecutarPActionPerformed
        
        ejecutarKolmovorok();
    }//GEN-LAST:event_BotonEjecutarPActionPerformed

    private void NumAlgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumAlgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumAlgActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Res_Frecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Res_Frecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Res_Frecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Res_Frecuencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Res_Frecuencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEjecutarP;
    public javax.swing.JTextField NumAlg;
    public javax.swing.JTextField campA;
    public javax.swing.JTextField campC;
    private javax.swing.JTextField campChiCuadrado;
    public javax.swing.JTextField campD;
    private javax.swing.JTextField campGradosL;
    public javax.swing.JTextField campM;
    private javax.swing.JTextField campNoIntervalos;
    public javax.swing.JTextField campSem1;
    public javax.swing.JTextField campSem2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFrec;
    private javax.swing.JTable tablaNums;
    // End of variables declaration//GEN-END:variables
}
