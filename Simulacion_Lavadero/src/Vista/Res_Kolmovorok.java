/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.Pruebas.Kolmovorok;
import Logica.Pruebas.Promedio;
import Logica.generadores.Aditivo;
import Logica.generadores.CongMixto;
import Logica.generadores.Cuadratico;
import Logica.generadores.Verificador;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Win 10
 */
public class Res_Kolmovorok extends javax.swing.JFrame {
    
    DefaultTableModel modelo;
    Kolmovorok kol = new Kolmovorok();


    public Res_Kolmovorok() {
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
    
    
    public void ejecutarKolmovorok(){
        
        CongMixto congMixto = new CongMixto();
        Cuadratico cuad = new Cuadratico();
        Aditivo ad = new Aditivo();
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
                cargar(kol.ordenar(lista2));                                         //cargar numeros a probar

                
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
                cargar(kol.ordenar(lista2));                                          //cargar numeros a probar
                                  
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
                cargar(kol.ordenar(lista3));                                         //cargar numeros a probar
                
            }
        
    }
    
       //CARGAR RESULTADOS
    public void cargar(double[] lista){
        
        String[] titulos = {"i", "RNDi", "F(RNDi)", "|RNDi - F(RNDi)|" };
        String[] NoCampos = new String[4];
        modelo = new DefaultTableModel (null,titulos);
        campN.setText(Integer.toString(lista.length));
        double dn = 0;
        
        
        for(int i=0; i<lista.length; i++)
        {
            double division = (((i+1)*1.0)/lista.length);
            double resta = (division - lista[i]);
            NoCampos[0] = Integer.toString(i+1);
            NoCampos[1] = Double.toString(lista[i]);
            NoCampos[2] = Double.toString(division);
            NoCampos[3] = Double.toString(Math.abs(resta)); 
            modelo.addRow(NoCampos);
            
            if(Math.abs(resta)>dn)
            {
                dn = Math.abs(resta);
            }
        }
        campDn.setText(Double.toString(dn));
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
        campN = new javax.swing.JTextField();
        campDn = new javax.swing.JTextField();
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resultado prueba de Kolmovorok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("n");

        campDn.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Dn");

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonEjecutarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(campDn)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campN, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(82, 82, 82))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(campM, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(NumAlg, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campDn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotonEjecutarP)
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campSem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campSem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumAlg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Res_Kolmovorok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Res_Kolmovorok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Res_Kolmovorok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Res_Kolmovorok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Res_Kolmovorok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonEjecutarP;
    public javax.swing.JTextField NumAlg;
    public javax.swing.JTextField campA;
    public javax.swing.JTextField campC;
    public javax.swing.JTextField campD;
    private javax.swing.JTextField campDn;
    public javax.swing.JTextField campM;
    private javax.swing.JTextField campN;
    public javax.swing.JTextField campSem1;
    public javax.swing.JTextField campSem2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaNums;
    // End of variables declaration//GEN-END:variables
}
