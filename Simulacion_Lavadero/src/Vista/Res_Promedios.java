/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Pruebas.Promedio;
import Logica.generadores.Aditivo;
import Logica.generadores.CongMixto;
import Logica.generadores.Cuadratico;
import Logica.generadores.Mixto;
import Logica.generadores.Multiplicativo;
import Logica.generadores.Verificador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win 10
 */
public class Res_Promedios extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    Promedio  prom = new Promedio();


    public Res_Promedios() {
        initComponents();
        setLocationRelativeTo(null);
        campA.setVisible(false);
        campC.setVisible(false);
        campD.setVisible(false);
        campM.setVisible(false);
        campC.setVisible(false);
        campSem1.setVisible(false);
        campSem2.setVisible(false);
        NumAlg.setVisible(false);
    }
    
    
     //CARGA LOS NUMEROS ALEATORIOS A PROBAR   ---------------CORREGIR PARA QUE MUESTRE SOLO LOS DEL PERIODO
    public void cargarNumeros(double[] lista){
        
        String[] titulos = {"#", " Aleatorios periodo" };
        String[] NoCampos = new String[2];
        modelo = new DefaultTableModel (null,titulos);
        campmedia.setText(Double.toString(prom.calcularMedia(lista)));
        campZO.setText(Double.toString(prom.calcularZO(prom.calcularMedia(lista), lista.length)));
        
        
        for(int i=0; i<lista.length; i++)
        {
            NoCampos[0] = Integer.toString(i+1);
            NoCampos[1] = Double.toString(lista[i]);
            modelo.addRow(NoCampos);
        }
        
        tablaNums.setModel(modelo);
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
        jLabel1 = new javax.swing.JLabel();
        campmedia = new javax.swing.JTextField();
        campZO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado prueba de Promedios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Media");

        campZO.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("|Z0|");

        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))
                                    .addComponent(campmedia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campZO, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NumAlg)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BotonEjecutarP, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(campM)))
                .addGap(252, 252, 252))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campmedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campZO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonEjecutarP)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        CongMixto congMixto = new CongMixto();
        Cuadratico cuad = new Cuadratico();
        Aditivo ad = new Aditivo();
        Multiplicativo mul = new Multiplicativo();
        Mixto mix = new Mixto();
        Verificador ver = new Verificador();
        int xo = 0, x1, a = 0, c = 0, d = 0, diasM =0;
        
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
            }
             else if(Integer.parseInt(NumAlg.getText()) == 4)//---------------------Aditivo Mitchell y moore
            {
                ArrayList<Double> resultado = new ArrayList<>();
                double mAd = Double.parseDouble(campM.getText()); 
                double nAd = Double.parseDouble(campSem1.getText());
                resultado = ad.MitchellMoore(mAd, nAd);
                double[] lista2 = new double[resultado.size()];
                for(int i =0; i<resultado.size(); i++)
                {
                    lista2[i] = resultado.get(i);
                }
                double[] lista3 = new double[ver.calcularPeriodo(lista2).length];
                lista3 = ver.calcularPeriodo(lista2);                            //obtener numeros aleatorios que conforman el periodo
                cargarNumeros(lista3);                                         //cargar numeros a probar
            }
             else if(Integer.parseInt(NumAlg.getText()) == 5)//---------------------Aditivo green
            {
                ArrayList<Double> resultado = new ArrayList<>();
                double mAd = Double.parseDouble(campM.getText()); 
                double k = Double.parseDouble(campSem1.getText());
                resultado = ad.Green(k, mAd);
                double[] lista2 = new double[resultado.size()];
                for(int i =0; i<resultado.size(); i++)
                {
                    lista2[i] = resultado.get(i);
                }
                double[] lista3 = new double[ver.calcularPeriodo(lista2).length];
                lista3 = ver.calcularPeriodo(lista2);                            //obtener numeros aleatorios que conforman el periodo
                cargarNumeros(lista3);                                         //cargar numeros a probar
            }
             else if(Integer.parseInt(NumAlg.getText()) == 6)//-----------------congruencial multiplicativo
            {
                xo = Integer.parseInt(campSem1.getText());
                a = Integer.parseInt(campA.getText());
                diasM = Integer.parseInt(campM.getText());
                lista = mul.metodoMultiplicativo(xo, a,diasM);
                double[] lista2 = new double[ver.calcularPeriodo(lista).length];
                lista2 = ver.calcularPeriodo(lista);                            
                cargarNumeros(lista2);                                         
            }
             else if(Integer.parseInt(NumAlg.getText()) == 7)//-----------------mixto
            {
                double m = Double.parseDouble(campM.getText()); 
                double n = Double.parseDouble(campSem2.getText());
                double k = Double.parseDouble(campSem1.getText());
                ArrayList<Double> resultado = new ArrayList<>();
                resultado = mix.mixto(m, n, k);
                double[] lista2 = new double[resultado.size()];
                for(int i =0; i<resultado.size(); i++)
                {
                    lista2[i] = resultado.get(i);
                }
                double[] lista3 = new double[ver.calcularPeriodo(lista2).length];
                lista3 = ver.calcularPeriodo(lista2);                            //obtener numeros aleatorios que conforman el periodo
                cargarNumeros(lista3);                                        
            }
        
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
            java.util.logging.Logger.getLogger(Res_Promedios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Res_Promedios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Res_Promedios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Res_Promedios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Res_Promedios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEjecutarP;
    public javax.swing.JTextField NumAlg;
    public javax.swing.JTextField campA;
    public javax.swing.JTextField campC;
    public javax.swing.JTextField campD;
    public javax.swing.JTextField campM;
    public javax.swing.JTextField campSem1;
    public javax.swing.JTextField campSem2;
    private javax.swing.JTextField campZO;
    private javax.swing.JTextField campmedia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaNums;
    // End of variables declaration//GEN-END:variables
}