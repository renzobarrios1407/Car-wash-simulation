package Vista;

import Logica.generadores.Aditivo;
import Logica.generadores.Verificador;
import Logica.generadores.CongMixto;
import Logica.generadores.Cuadratico;
import Logica.generadores.Mixto;
import Logica.generadores.Multiplicativo;
import Logica.lavadero.Generador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;  

public class Resultado extends javax.swing.JFrame {      
    
    Verificador ver;
    CongMixto congMixto = new CongMixto();
    Cuadratico cuad = new Cuadratico();
    Aditivo ad = new Aditivo();
    Multiplicativo mul = new Multiplicativo();
    Mixto mix = new Mixto();
    Generador gen = new Generador();
  
    DefaultTableModel modelo1;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
   

    public Resultado() {
        initComponents();
        ver= new Verificador();   
        setLocationRelativeTo(null);
        camp_semilla.setText("7");
        camp_varA.setText("7");
        camp_varC.setText("13");
        camp_mod.setText("20");
        camp_numeros.setText("10");
        camp_varD.setText("15");
        camp_semilla2.setText("1");
        camp_K.setText("16");
        contador.setText("0");
        camp_varD.setEnabled(false);
        camp_semilla2.setEnabled(false);   
        camp_K.setEnabled(false);
        camp_numeros.setEnabled(false);

        al1N.setVisible(false);
        al1a.setVisible(false);
        al1c.setVisible(false);
        al1d.setVisible(false);
        al1xo.setVisible(false);
        al1m.setVisible(false);
        contador.setVisible(false);
        al2N.setVisible(false);
        al2a.setVisible(false);
        al2c.setVisible(false);
        al2d.setVisible(false);
        al2xo.setVisible(false);
        al2m.setVisible(false);
               
        labelLlegadas.setVisible(false);
        labelServicios.setVisible(false);
        
        botonSimulacion.setEnabled(false);
        botonConclusion.setEnabled(true);
        
        spinerDias.setValue(20);
        spinerHoras.setValue(5);
    }
   
    public void cargarTabla1(double[] ingresos, double[] perdidas){
        
       String[] titulos = {"Dias", "Ingresos", "Perdidas"};
       String[] NoCampos = new String[3];
       modelo1 = new DefaultTableModel (null,titulos);
       
       for(int i=0; i<ingresos.length; i++)
       {
        NoCampos[0] = Integer.toString(i+1);
        NoCampos[1] = Double.toString(ingresos[i]);
        NoCampos[2] = Double.toString(perdidas[i]);
        modelo1.addRow(NoCampos);
       }
       tablaPol1.setModel(modelo1);
    }
    
     public void cargarTabla2(double[] ingresos, double[] perdidas){
        
       String[] titulos = {"Dias", "Ingresos", "Perdidas"};
       String[] NoCampos = new String[3];
       modelo2 = new DefaultTableModel (null,titulos);
       
       for(int i=0; i<ingresos.length; i++)
       {
        NoCampos[0] = Integer.toString(i+1);
        NoCampos[1] = Double.toString(ingresos[i]);
        NoCampos[2] = Double.toString(perdidas[i]);
        modelo2.addRow(NoCampos);
       }
       tablaPol2.setModel(modelo2);
    }
    
    public void cargarTabla3(double[] ingresos, double[] perdidas){
        
       String[] titulos = {"Dias", "Ingresos", "Perdidas"};
       String[] NoCampos = new String[3];
       modelo3 = new DefaultTableModel (null,titulos);
       
       for(int i=0; i<ingresos.length; i++)
       {
        NoCampos[0] = Integer.toString(i+1);
        NoCampos[1] = Double.toString(ingresos[i]);
        NoCampos[2] = Double.toString(perdidas[i]);
        modelo3.addRow(NoCampos);
       }
       tablaPol3.setModel(modelo3);
    }

 //EJECUTAR LA SIMULACION DE LAVADERO
  public void ejecutarSimulacion(int m, int horario){
        
        int xo = 0, a = 0, c = 0, d = 0;
        int horarioP3 = horario + 180;
        int dias = Integer.parseInt(spinerDias.getValue().toString());
        double[] lista1 = new double[m];   //lista de aleatorios para la llegada
        double[] lista3 = new double[m];  //lista de aleatorios para los servicios
        int[] lista2 = new int[m];        
        double[] ingresos = new double[dias];
        double[] ingresosP2 = new double[dias];
        double[] ingresosP3 = new double[dias];
        double[] perdidas = new double[dias];
        double[] perdidasP2 = new double[dias];
        double[] perdidasP3 = new double[dias];
        double aux =0;
        ArrayList<Integer> posiciones = new ArrayList<Integer>();
        ArrayList<Integer> posiciones2 = new ArrayList<Integer>();
        ArrayList<Integer> posiciones3 = new ArrayList<Integer>();
  
        for(int i =0; i<dias; i++)
        {
        //DEFINICION DE LLEGADAS POR DIA
        if(Integer.parseInt(al1N.getText()) == 1)//---------------------------congruencial mixto
        {     
           xo = Integer.parseInt(al1xo.getText());
           a = Integer.parseInt(al1a.getText());
           c = Integer.parseInt(al1c.getText());
           lista1 = congMixto.metodoMixto(xo, a, c, m);  //numeros aleatorios de las llegadas
        }
        if(Integer.parseInt(al1N.getText()) == 2)//---------------------------cuadratico
        {  
           xo = Integer.parseInt(al1xo.getText());  
           a = Integer.parseInt(al1a.getText());
           c = Integer.parseInt(al1c.getText());
           d = Integer.parseInt(al1d.getText());
           lista1 = cuad.metodoCuadratico(xo, a, c, d, m);
        }
         if(Integer.parseInt(al1N.getText()) == 3)//---------------------------fibonacci
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double sem1 = Double.parseDouble(al1xo.getText());
           double sem2 = Double.parseDouble(al1a.getText());
           double mod = m*1.0;
           double[] listaAux = new double[m];
           resultado = ad.Fibonacci(mod, sem1, sem2);
            for(int x =0; x<resultado.size(); x++)
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista1 = listaAux;
        }
          if(Integer.parseInt(al1N.getText()) == 4)//---------------------------mitchel y moore
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double n = Double.parseDouble(al1xo.getText());
           double mod = m*1.0;
           resultado = ad.MitchellMoore(mod, n);
           double[] listaAux = new double[m];
            for(int x =0; x<resultado.size(); x++)
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista1 = listaAux;
        }
        if(Integer.parseInt(al1N.getText()) == 5)//---------------------------green
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double k = Double.parseDouble(al1xo.getText());
           double mod = m*1.0;
           resultado = ad.Green(k, mod);
           double[] listaAux = new double[m];
            for(int x =0; x<resultado.size(); x++)
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
            lista1 = listaAux;
        }
        if(Integer.parseInt(al1N.getText()) == 6)//---------------------------congruencial multiplicativo
        {     
           xo = Integer.parseInt(al1xo.getText());
           a = Integer.parseInt(al1a.getText());
           lista1 = mul.metodoMultiplicativo(xo, a, m);
        }
         if(Integer.parseInt(al1N.getText()) == 7)//---------------------------mixto
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double k = Double.parseDouble(al1xo.getText());
           double n = Double.parseDouble(al1a.getText());
           double mod = m*1.0;
           resultado = ad.Green(k, mod);
           double[] listaAux = new double[m];
            for(int x =0; x<resultado.size(); x++)
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista1 = listaAux;
        }

        //DEFINICION DE SERVICIOS SOLICITADOS
       if(Integer.parseInt(al2N.getText()) == 1)//---------------------------congruencial mixto
        {  
           xo = Integer.parseInt(al2xo.getText());
           a = Integer.parseInt(al2a.getText());
           c = Integer.parseInt(al2c.getText());
           lista3 = congMixto.metodoMixto(xo, a, c, m); //lista de numeros aleatorios
       }
        if(Integer.parseInt(al2N.getText()) == 2)//---------------------------cuadratico
        {  
           xo = Integer.parseInt(al2xo.getText());
           a = Integer.parseInt(al2a.getText());
           c = Integer.parseInt(al2c.getText());
           d = Integer.parseInt(al2d.getText());
           lista3 = cuad.metodoCuadratico(xo, a, c, d, m);
        }
        if(Integer.parseInt(al2N.getText()) == 3)//---------------------------fibonacci
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double sem1 = Double.parseDouble(al2xo.getText());
           double sem2 = Double.parseDouble(al2a.getText());
           double mod = m*1.0;
           double[] listaAux = new double[m];
           resultado = ad.Fibonacci(mod, sem1, sem2);
           for(int x =0; x<resultado.size(); x++)
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista3 = listaAux;
        }
        if(Integer.parseInt(al2N.getText()) == 4)//---------------------------mitchel y moore
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double n = Double.parseDouble(al2xo.getText());
           double mod = m*1.0;
           resultado = ad.MitchellMoore(mod, n);
           double[] listaAux = new double[m];
           for(int x =0; x<resultado.size(); x++)
           {
             listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista3 = listaAux;
        }
        if(Integer.parseInt(al2N.getText()) == 5)//---------------------------green
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double k = Double.parseDouble(al2xo.getText());
           double mod = m*1.0;
           resultado = ad.Green(k, mod);
           double[] listaAux = new double[m];
           for(int x =0; x<resultado.size(); x++)  
           {
            listaAux[x] = resultado.get(x);          //numeros aleatorios
           }
           lista3 = listaAux;
        }
        if(Integer.parseInt(al2N.getText()) == 6)//---------------------------congruencial multiplicativo
        {  
           xo = Integer.parseInt(al2xo.getText());
           a = Integer.parseInt(al2a.getText());
           lista3 = mul.metodoMultiplicativo(xo, a, m); //lista de numeros aleatorios
        }
        if(Integer.parseInt(al2N.getText()) == 7)//---------------------------mixto
        {  
           ArrayList<Double> resultado = new ArrayList<>();
           double k = Double.parseDouble(al2xo.getText());
           double n = Double.parseDouble(al2a.getText());
           double mod = m*1.0;
           resultado = mix.mixto(k, n, k);
           for(int x =0; x<resultado.size(); x++)  
           {
            lista3[x] = resultado.get(x);          //numeros aleatorios de los servicios
           }
        }
          lista2 = gen.generarServicios(lista3, lista3.length); //lista de todos lo servicios solicitados (atendidos y no atendidos)
          posiciones = gen.contarAtendidos(lista1, lista2, horario);
          posiciones2 = gen.inmediatos(lista1, lista2, horario);
          posiciones3 = gen.contarAtendidos(lista1, lista2, horarioP3);
          gen.inmediatos(lista1, lista2, horario);
                                              
          aux = gen.calcularDinero(gen.contarAtendidos(lista1, lista2, 1000000));  //dinero que se hubiera conseguido si se hubiera atendido todo
          
          ingresos[i] =  gen.calcularDinero(posiciones);  //ingresos del dia con la politica 1
          perdidas[i] = aux - ingresos[i];               //total - ingresos
          
          ingresosP2[i] = gen.calcularDinero(posiciones2);//ingresos del dia con la politica 2
          perdidasP2[i] = aux - ingresosP2[i];
          
          ingresosP3[i] = gen.calcularDinero(posiciones3);//ingresos  del dia con la politica 3
          perdidasP3[i] = aux - ingresosP3[i];
          
          cargarTabla1(ingresos, perdidas);//cargar resultados politica 1
          cargarTabla2(ingresosP2, perdidasP2);
          cargarTabla3(ingresosP3, perdidasP3);//cargar resultados politica 3
          m++;
        }
        
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
        camp_semilla = new javax.swing.JTextField();
        boton_Generar = new javax.swing.JButton();
        camp_varA = new javax.swing.JTextField();
        camp_mod = new javax.swing.JTextField();
        camp_varC = new javax.swing.JTextField();
        labelSemilla = new javax.swing.JLabel();
        labelA = new javax.swing.JLabel();
        labelC = new javax.swing.JLabel();
        labelMod = new javax.swing.JLabel();
        camp_numeros = new javax.swing.JTextField();
        labelNum = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPol1 = new javax.swing.JTable();
        comboAlgoritmos = new javax.swing.JComboBox<>();
        camp_varD = new javax.swing.JTextField();
        labelD = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        labelXn = new javax.swing.JLabel();
        camp_semilla2 = new javax.swing.JTextField();
        labelK = new javax.swing.JLabel();
        camp_K = new javax.swing.JTextField();
        botonPrubFrec = new javax.swing.JButton();
        checkValidar = new javax.swing.JCheckBox();
        botonP_Prom = new javax.swing.JButton();
        botonP_kol = new javax.swing.JButton();
        al1xo = new javax.swing.JTextField();
        al1a = new javax.swing.JTextField();
        al1d = new javax.swing.JTextField();
        al1c = new javax.swing.JTextField();
        al1m = new javax.swing.JTextField();
        al1N = new javax.swing.JTextField();
        al2xo = new javax.swing.JTextField();
        al2a = new javax.swing.JTextField();
        al2m = new javax.swing.JTextField();
        al2c = new javax.swing.JTextField();
        al2d = new javax.swing.JTextField();
        al2N = new javax.swing.JTextField();
        botonSimulacion = new javax.swing.JButton();
        contador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelNum1 = new javax.swing.JLabel();
        spinerDias = new javax.swing.JSpinner();
        spinerHoras = new javax.swing.JSpinner();
        labelNum2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonConclusion = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaPol2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaPol3 = new javax.swing.JTable();
        labelLlegadas = new javax.swing.JLabel();
        labelServicios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Simulación Lavadero", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 24))); // NOI18N

        camp_semilla.setToolTipText("Semilla");
        camp_semilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camp_semillaActionPerformed(evt);
            }
        });
        camp_semilla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_semillaKeyTyped(evt);
            }
        });

        boton_Generar.setText("Seleccionar");
        boton_Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_GenerarActionPerformed(evt);
            }
        });

        camp_varA.setToolTipText("A");
        camp_varA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_varAKeyTyped(evt);
            }
        });

        camp_mod.setToolTipText("M");
        camp_mod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_modKeyTyped(evt);
            }
        });

        camp_varC.setToolTipText("C");
        camp_varC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camp_varCActionPerformed(evt);
            }
        });
        camp_varC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_varCKeyTyped(evt);
            }
        });

        labelSemilla.setText("Xo");

        labelA.setText("A");

        labelC.setText("C");

        labelMod.setText("M");

        camp_numeros.setToolTipText("Números aleatorios deseados");
        camp_numeros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_numerosKeyTyped(evt);
            }
        });

        labelNum.setText("n");

        tablaPol1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dia", "Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPol1);

        comboAlgoritmos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Congruencial Mixto", "Congruencial cuadrático", "Aditivo Fibonacci", "Aditivo Mitchell y Moore", "Aditivo Green", "Multiplicativo", "Mixto" }));
        comboAlgoritmos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAlgoritmosItemStateChanged(evt);
            }
        });
        comboAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAlgoritmosActionPerformed(evt);
            }
        });

        camp_varD.setToolTipText("D");
        camp_varD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                camp_varDActionPerformed(evt);
            }
        });
        camp_varD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_varDKeyTyped(evt);
            }
        });

        labelD.setText("D");

        botonLimpiar.setText("Reiniciar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        labelXn.setText("X1");

        camp_semilla2.setToolTipText("A");
        camp_semilla2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_semilla2KeyTyped(evt);
            }
        });

        labelK.setText("K");

        camp_K.setToolTipText("A");
        camp_K.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                camp_KKeyTyped(evt);
            }
        });

        botonPrubFrec.setText("Prueba frecuencias");
        botonPrubFrec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPrubFrecActionPerformed(evt);
            }
        });

        checkValidar.setText("Validar");

        botonP_Prom.setText("Prueba de promedios");
        botonP_Prom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonP_PromActionPerformed(evt);
            }
        });

        botonP_kol.setText("Prueba de Kolmovorok");
        botonP_kol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonP_kolActionPerformed(evt);
            }
        });

        al1xo.setToolTipText("Semilla");
        al1xo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1xoActionPerformed(evt);
            }
        });
        al1xo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1xoKeyTyped(evt);
            }
        });

        al1a.setToolTipText("Semilla");
        al1a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1aActionPerformed(evt);
            }
        });
        al1a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1aKeyTyped(evt);
            }
        });

        al1d.setToolTipText("Semilla");
        al1d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1dActionPerformed(evt);
            }
        });
        al1d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1dKeyTyped(evt);
            }
        });

        al1c.setToolTipText("Semilla");
        al1c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1cActionPerformed(evt);
            }
        });
        al1c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1cKeyTyped(evt);
            }
        });

        al1m.setToolTipText("Semilla");
        al1m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1mActionPerformed(evt);
            }
        });
        al1m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1mKeyTyped(evt);
            }
        });

        al1N.setToolTipText("Semilla");
        al1N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al1NActionPerformed(evt);
            }
        });
        al1N.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al1NKeyTyped(evt);
            }
        });

        al2xo.setToolTipText("Semilla");
        al2xo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2xoActionPerformed(evt);
            }
        });
        al2xo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2xoKeyTyped(evt);
            }
        });

        al2a.setToolTipText("Semilla");
        al2a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2aActionPerformed(evt);
            }
        });
        al2a.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2aKeyTyped(evt);
            }
        });

        al2m.setToolTipText("Semilla");
        al2m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2mActionPerformed(evt);
            }
        });
        al2m.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2mKeyTyped(evt);
            }
        });

        al2c.setToolTipText("Semilla");
        al2c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2cActionPerformed(evt);
            }
        });
        al2c.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2cKeyTyped(evt);
            }
        });

        al2d.setToolTipText("Semilla");
        al2d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2dActionPerformed(evt);
            }
        });
        al2d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2dKeyTyped(evt);
            }
        });

        al2N.setToolTipText("Semilla");
        al2N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                al2NActionPerformed(evt);
            }
        });
        al2N.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                al2NKeyTyped(evt);
            }
        });

        botonSimulacion.setText("Simulacion");
        botonSimulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSimulacionActionPerformed(evt);
            }
        });

        jLabel1.setText("Politica 1");

        jLabel3.setText("Politica 2");

        labelNum1.setText("Dias");

        labelNum2.setText("Horas de trabajo");

        jLabel4.setText("Politica 3");

        botonConclusion.setText("Conclusión");
        botonConclusion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConclusionActionPerformed(evt);
            }
        });

        tablaPol2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dia", "Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaPol2);

        tablaPol3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dia", "Ingreso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaPol3);

        labelLlegadas.setText("Num. aleatorios para las llegadas seleccionado");

        labelServicios.setText("Num. aleatorios para los servicios seleccionado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(al1xo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(al1a, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(al1c, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(al1m, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(al1d, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(al1N, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(camp_varA, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelSemilla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(camp_semilla, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(labelLlegadas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(camp_varD, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(183, 183, 183)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(labelMod)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(camp_mod, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelXn)
                                    .addGap(18, 18, 18)
                                    .addComponent(camp_semilla2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(labelK)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(camp_K, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelNum)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(camp_numeros, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(botonConclusion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(checkValidar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(boton_Generar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonSimulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(comboAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(193, 193, 193)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(al2xo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(al2a, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(al2c, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(al2m, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(al2d, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(al2N, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(labelServicios)))
                                .addGap(4, 4, 4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(botonP_Prom, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(labelC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(camp_varC, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(spinerDias, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(labelNum2)
                                            .addComponent(spinerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(labelNum1)))
                                .addGap(185, 185, 185))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(botonPrubFrec, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(botonP_kol, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(al1xo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al1a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al1m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al1N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al1c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al1d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2xo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2a, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2c, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2m, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(al2N, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(comboAlgoritmos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boton_Generar)
                            .addComponent(checkValidar))
                        .addGap(18, 18, 18)
                        .addComponent(botonSimulacion)
                        .addGap(18, 18, 18)
                        .addComponent(botonLimpiar)
                        .addGap(20, 20, 20)
                        .addComponent(botonConclusion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNum1)
                                    .addComponent(labelNum2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spinerDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spinerHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelD)
                                    .addComponent(camp_varD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelMod, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(camp_mod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(camp_semilla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(camp_K, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelK)
                                    .addComponent(labelNum)
                                    .addComponent(camp_numeros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelXn)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelSemilla)
                                    .addComponent(camp_semilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLlegadas)
                                    .addComponent(labelServicios))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelA)
                                    .addComponent(camp_varA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(camp_varC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelC))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonP_Prom)
                    .addComponent(botonPrubFrec)
                    .addComponent(botonP_kol))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void camp_semillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camp_semillaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camp_semillaActionPerformed

    private void camp_varCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camp_varCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camp_varCActionPerformed

    private void boton_GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_GenerarActionPerformed
      

        if(contador.getText().equals("1") && (Integer.parseInt(al1m.getText())!=Integer.parseInt(camp_mod.getText())))
            {
             JOptionPane.showMessageDialog(null, "El valor de m debe ser igual en los algoritmos seleccionados");
            }
        else
        {
        
        if(comboAlgoritmos.getSelectedItem().equals("Congruencial Mixto")){
            
            if(camp_semilla.getText().equals("")  || camp_varA.getText().equals("") || camp_varC.getText().equals("") ||
            camp_mod.getText().equals(""))
               {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
               }
              
            else 
               {
               int xo = Integer.parseInt(camp_semilla.getText());
               int a = Integer.parseInt(camp_varA.getText());
               int c = Integer.parseInt(camp_varC.getText());
               int m = Integer.parseInt(camp_mod.getText());
               
               if(checkValidar.isSelected()==true && ver.mensajesErrorCongMixto(xo, a, c, m)==true)
              {
                  if(Integer.parseInt(contador.getText()) ==0)
                  {
                  al1xo.setText(camp_semilla.getText());
                  al1a.setText(camp_varA.getText());
                  al1c.setText(camp_varC.getText());
                  al1m.setText(camp_mod.getText());
                  al1N.setText("1");        //numero que representa al algoritmo
                  contador.setText("1");
                  labelLlegadas.setVisible(true);
                  }
                  else
                  {
                  al2xo.setText(camp_semilla.getText());
                  al2a.setText(camp_varA.getText());
                  al2c.setText(camp_varC.getText());
                  al2m.setText(camp_mod.getText());
                  al2N.setText("1");
                  contador.setText("2");
                  botonSimulacion.setEnabled(true);
                  labelServicios.setVisible(true);
                  boton_Generar.setEnabled(false);
                  }
              }
               else if(checkValidar.isSelected()==false)
              {
                  if(Integer.parseInt(contador.getText()) ==0)
                  {
                  al1xo.setText(camp_semilla.getText());
                  al1a.setText(camp_varA.getText());
                  al1c.setText(camp_varC.getText());
                  al1m.setText(camp_mod.getText());
                  al1N.setText("1");        //numero que representa al algoritmo
                  contador.setText("1");
                  labelLlegadas.setVisible(true);
                  }
                  else
                  {
                  al2xo.setText(camp_semilla.getText());
                  al2a.setText(camp_varA.getText());
                  al2c.setText(camp_varC.getText());
                  al2m.setText(camp_mod.getText());
                  al2N.setText("1");
                  contador.setText("2");
                  botonSimulacion.setEnabled(true);
                  labelServicios.setVisible(true);
                  boton_Generar.setEnabled(false);
                  }
              }
              }  
        }
        //-------------------------------------------------CONGRUENCIAL CUADRATICO
        else if(comboAlgoritmos.getSelectedItem().equals("Congruencial cuadrático")){

             if(camp_semilla.getText().equals("")  || camp_varA.getText().equals("") || camp_varC.getText().equals("") ||
            camp_varD.getText().equals("") || camp_mod.getText().equals(""))
            {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
            }
            else 
            {
            int xo = Integer.parseInt(camp_semilla.getText());
            int a = Integer.parseInt(camp_varA.getText());
            int c = Integer.parseInt(camp_varC.getText());
            int m = Integer.parseInt(camp_mod.getText());
            int d = Integer.parseInt(camp_varD.getText());
            
             if(checkValidar.isSelected()==true && ver.mensajesErrorCuadratico(xo, a, c, m, d)==true )
              {
                  if(Integer.parseInt(contador.getText()) ==0)
                   {
                   al1xo.setText(camp_semilla.getText());
                   al1a.setText(camp_varA.getText());
                   al1c.setText(camp_varC.getText());
                   al1m.setText(camp_mod.getText());
                   al1d.setText(camp_varD.getText());
                   al1N.setText("2");                       //numero del algoritmo
                   contador.setText("1");
                   labelLlegadas.setVisible(true);
                  
                   }
                   else
                   {
                   al2xo.setText(camp_semilla.getText());
                   al2a.setText(camp_varA.getText());
                   al2c.setText(camp_varC.getText());
                   al2m.setText(camp_mod.getText());
                   al2d.setText(camp_varD.getText());
                   al2N.setText("2");
                   contador.setText("2");
                   boton_Generar.setEnabled(false);
                   botonSimulacion.setVisible(true);
                   labelServicios.setVisible(true);
                   }
              }
             else if(checkValidar.isSelected()==false)
             {
                  if(Integer.parseInt(contador.getText()) ==0)
                   {
                   al1xo.setText(camp_semilla.getText());
                   al1a.setText(camp_varA.getText());
                   al1c.setText(camp_varC.getText());
                   al1m.setText(camp_mod.getText());
                   al1d.setText(camp_varD.getText());
                   al1N.setText("2");                       //numero del algoritmo
                   contador.setText("1");
                   labelLlegadas.setVisible(true);
                   }
                   else
                   {
                   al2xo.setText(camp_semilla.getText());
                   al2a.setText(camp_varA.getText());
                   al2c.setText(camp_varC.getText());
                   al2m.setText(camp_mod.getText());
                   al2d.setText(camp_varD.getText());
                   al2N.setText("2");
                   contador.setText("2");
                   labelServicios.setVisible(true);
                   boton_Generar.setEnabled(false);
                   botonSimulacion.setEnabled(true);
                   } 
             }
             }
        }
     //----------------------------------------------ADITIVO FIBONACCI
        
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Fibonacci")){
            
            
         if(camp_semilla.getText().equals("")  || camp_semilla2.getText().equals("") ||
            camp_mod.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
         }
        else
         {
         double xo = Double.parseDouble(camp_semilla.getText());
         double x1 = Double.parseDouble(camp_semilla2.getText());
         double m = Double.parseDouble(camp_mod.getText());
         
         if(m<=0 || xo<0 || x1<0)  
         {
           JOptionPane.showMessageDialog(null, "Ingrese datos validos");
         }
         else
         {
         if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_semilla.getText());
               al1a.setText(camp_semilla2.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("3");                       //numero del algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_semilla.getText());
               al2a.setText(camp_semilla2.getText());
               al2m.setText(camp_mod.getText());
               al2N.setText("3");
               contador.setText("2");
               labelServicios.setVisible(true);
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }
         }
         }
        }
//-------------------------------------------ADITIVO Mitchell y Moore
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Mitchell y Moore")){
           
             if(camp_numeros.getText().equals("")  || camp_mod.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
         }
        else
         {
         double n = Double.parseDouble(camp_numeros.getText());
         double m = Double.parseDouble(camp_mod.getText());
         
         if(m<=0 || n<=54)  
         {
           JOptionPane.showMessageDialog(null, "Ingrese datos validos m>0 y n>=55");
         }
         else
         {
         if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_numeros.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("4");                       //numero del algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_numeros.getText());
               al2m.setText(camp_mod.getText());
               al2N.setText("4");
               contador.setText("2");
               labelServicios.setVisible(true);
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }  
         }
         }
        }//------------------------ADITIVO Green
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Green")){
               
         if(camp_K.getText().equals("")  || camp_mod.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
         }
        else
         {
         double k = Double.parseDouble(camp_K.getText());
         double m = Double.parseDouble(camp_mod.getText());
         
         if(m<=0 || k<=15 || k>m)  
         {
           JOptionPane.showMessageDialog(null, "Ingrese datos validos m>k y k>=16");
         }
         else
         {
         if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_K.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("5");                       //numero del algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_K.getText());
               al2m.setText(camp_mod.getText());
               al2N.setText("5");
               contador.setText("2");
               labelServicios.setVisible(true);
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }  
         }
         }
        }
        //------------------------Congruencial multiplicativo
        else if(comboAlgoritmos.getSelectedItem().equals("Multiplicativo")){
            
             if(camp_semilla.getText().equals("")  || camp_varA.getText().equals("") ||
            camp_mod.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
        }
         else 
         {
        int xo = Integer.parseInt(camp_semilla.getText());
        int a = Integer.parseInt(camp_varA.getText());
        int m = Integer.parseInt(camp_mod.getText());

        if(checkValidar.isSelected()==true &&  ver.mensajesErrorMultiplicativo(xo, a, m)==true)
              {
              if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_semilla.getText());
               al1a.setText(camp_varA.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("6");        //numero que representa al algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_semilla.getText());
               al2a.setText(camp_varA.getText());
               al2m.setText(camp_mod.getText());
               al2N.setText("6");
               labelServicios.setVisible(true);
               contador.setText("1");
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }
              }
             else if(checkValidar.isSelected()==false)
             {
              if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_semilla.getText());
               al1a.setText(camp_varA.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("6");        //numero que representa al algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_semilla.getText());
               al2a.setText(camp_varA.getText());
               al2m.setText(camp_mod.getText());
               al2N.setText("6");
               labelServicios.setVisible(true);
               contador.setText("2");
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }
             }
         }
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Mixto")){
            
            if(camp_K.getText().equals("")  || camp_mod.getText().equals("") || camp_numeros.getText().equals(""))
         {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos");
         }
        else
         {
         double k = Double.parseDouble(camp_K.getText());
         double n = Double.parseDouble(camp_numeros.getText());
         double m = Double.parseDouble(camp_mod.getText());
         
         if(m<=0 || k<=15 || k>m)  
         {
           JOptionPane.showMessageDialog(null, "Ingrese datos validos m>k y k>=16");
         }
         else
         {
         if(Integer.parseInt(contador.getText()) ==0)
               {
               al1xo.setText(camp_numeros.getText());
               al1a.setText(camp_K.getText());
               al1m.setText(camp_mod.getText());
               al1N.setText("6");                       //numero del algoritmo
               contador.setText("1");
               labelLlegadas.setVisible(true);
               }
               else
               {
               al2xo.setText(camp_numeros.getText());
               al2a.setText(camp_K.getText());
               al2N.setText("6");
               contador.setText("2");
               labelServicios.setVisible(true);
               boton_Generar.setEnabled(false);
               botonSimulacion.setEnabled(true);
               }  
         }
         } 
        }
        }

    }//GEN-LAST:event_boton_GenerarActionPerformed

    private void camp_varDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_camp_varDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_camp_varDActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
  
        for (int i = 0; i < tablaPol1.getRowCount(); i++)
        {
           modelo1.removeRow(i);
           modelo2.removeRow(i);
           modelo3.removeRow(i);
           i-=1;
        }
        
        al1xo.setText("");
        al1a.setText("");
        al1c.setText("");
        al1m.setText("0");  
        al1d.setText("");
        al1N.setText("");
        
        al2xo.setText("");
        al2a.setText("");
        al2c.setText("");  
        al2m.setText("");  
        al2d.setText("");
        al2N.setText("");
        
        contador.setText("0");
        labelLlegadas.setVisible(false);
        labelServicios.setVisible(false);
        boton_Generar.setEnabled(true);
        botonSimulacion.setEnabled(false);
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void comboAlgoritmosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAlgoritmosItemStateChanged
        
        int s = comboAlgoritmos.getSelectedIndex();
        switch(s){
            case 0:
                camp_semilla.setEnabled(true);
                camp_varA.setEnabled(true);
                camp_varC.setEnabled(true);
                camp_varD.setEnabled(false);        //MIXTO
                camp_K.setEnabled(false);  
                camp_numeros.setEnabled(false);
                break;   
            case 1:
                camp_semilla.setEnabled(true);
                camp_varC.setEnabled(true);
                camp_varD.setEnabled(true);          //CUADRATICO
                camp_numeros.setEnabled(false);
                camp_K.setEnabled(false);
                camp_varD.setText("15");
                camp_varA.setText("16");
                break;
            case 2:
                camp_semilla2.setEnabled(true);
                camp_varA.setEnabled(false);
                camp_varC.setEnabled(false);       //FIBONACCI
                camp_varD.setEnabled(false);
                camp_K.setEnabled(false);
                camp_semilla.setEnabled(true);
                camp_numeros.setEnabled(false);
                break;
            case 3:
                camp_semilla2.setEnabled(false);
                camp_semilla.setEnabled(false);
                camp_varA.setEnabled(false);
                camp_varC.setEnabled(false);      //MITCHEL Y MOORE
                camp_varD.setEnabled(false);
                camp_numeros.setEnabled(true);
                camp_K.setEnabled(false);
                camp_numeros.setText("55");
                break;
            case 4:
                camp_semilla2.setEnabled(false);
                camp_semilla.setEnabled(false);
                camp_varA.setEnabled(false);
                camp_varC.setEnabled(false);     //GREEN
                camp_varD.setEnabled(false);
                camp_numeros.setEnabled(false);
                camp_K.setEnabled(true);
                camp_mod.setText("20");
                break;   
            case 5:
                camp_varA.setEnabled(true);
                camp_varC.setEnabled(false);
                camp_varD.setEnabled(false);
                camp_semilla2.setEnabled(false);       //MULTIPLICATIVO
                camp_numeros.setEnabled(false);
                camp_K.setEnabled(false);
                camp_semilla.setEnabled(true);
                break;
            case 6:
                camp_varA.setEnabled(false);
                camp_varC.setEnabled(false);
                camp_varD.setEnabled(false);
                camp_semilla2.setEnabled(false);        //MIXTO
                camp_numeros.setEnabled(true);
                camp_semilla.setEnabled(false);
                camp_K.setEnabled(true);
                camp_numeros.setText("55");
                break;
        }
    }//GEN-LAST:event_comboAlgoritmosItemStateChanged

    private void camp_semillaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_semillaKeyTyped
       char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_semillaKeyTyped

    private void camp_semilla2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_semilla2KeyTyped
        char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_semilla2KeyTyped

    private void camp_varAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_varAKeyTyped
        char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_varAKeyTyped

    private void camp_varCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_varCKeyTyped
        char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_varCKeyTyped

    private void camp_modKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_modKeyTyped
      char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_modKeyTyped

    private void camp_varDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_varDKeyTyped
      char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_varDKeyTyped

    private void camp_numerosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_numerosKeyTyped
       char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_numerosKeyTyped

    private void camp_KKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_camp_KKeyTyped
        char c = (char)evt.getKeyChar();
        
        if ( (c <'0' || c > '9') && (c != '.'))
            evt.consume();
    }//GEN-LAST:event_camp_KKeyTyped

    private void comboAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAlgoritmosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAlgoritmosActionPerformed

    private void al1aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1aActionPerformed

    private void al1aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1aKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1aKeyTyped

    private void al1dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1dActionPerformed

    private void al1dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1dKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1dKeyTyped

    private void al1cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1cActionPerformed

    private void al1cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1cKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1cKeyTyped

    private void al1mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1mActionPerformed

    private void al1mKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1mKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1mKeyTyped

    private void al1NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1NActionPerformed

    private void al1NKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1NKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1NKeyTyped

    private void al2mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2mActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2mActionPerformed

    private void al2mKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2mKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2mKeyTyped

    private void al2dActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2dActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2dActionPerformed

    private void al2dKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2dKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2dKeyTyped

    private void al2NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2NActionPerformed

    private void al2NKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2NKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2NKeyTyped

    private void botonSimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSimulacionActionPerformed
         
        if(Integer.parseInt(spinerDias.getValue().toString())<=0 || Integer.parseInt(spinerHoras.getValue().toString())<=0)
        {
         JOptionPane.showMessageDialog(null, "La cantidad de dias y horas debe ser mayor a 0");
        }

        int m = Integer.parseInt(al1m.getText());
        int horario = (Integer.parseInt(spinerHoras.getValue().toString())*60);

        ejecutarSimulacion(m, horario);
        botonConclusion.setEnabled(true);
  
    }//GEN-LAST:event_botonSimulacionActionPerformed

    private void botonP_kolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonP_kolActionPerformed

        Res_Kolmovorok vista2 = new Res_Kolmovorok();
        vista2.setVisible(true);

        if(comboAlgoritmos.getSelectedItem().equals("Congruencial Mixto")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("1");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Congruencial cuadrático")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campD.setText(camp_varD.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("2");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Fibonacci")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campSem2.setText(camp_semilla2.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("3");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Mitchell y Moore")){
            vista2.campSem1.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("4");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Green")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("5");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Multiplicativo")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("6");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Mixto")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campSem2.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("7");
        }

    }//GEN-LAST:event_botonP_kolActionPerformed

    private void botonPrubFrecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPrubFrecActionPerformed

        Res_Frecuencias vista2 = new Res_Frecuencias();
        vista2.setVisible(true);
        ArrayList<Double> lista = new ArrayList<>();

        if(comboAlgoritmos.getSelectedItem().equals("Congruencial Mixto")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("1");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Congruencial cuadrático")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campD.setText(camp_varD.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("2");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Fibonacci")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campSem2.setText(camp_semilla2.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("3");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Mitchell y Moore")){
            vista2.campSem1.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("4");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Green")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("5");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Multiplicativo")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("6");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Mixto")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campSem2.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("7");
        }
    }//GEN-LAST:event_botonPrubFrecActionPerformed

    private void botonP_PromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonP_PromActionPerformed

        Res_Promedios vista2 = new Res_Promedios();
        vista2.setVisible(true);

        if(comboAlgoritmos.getSelectedItem().equals("Congruencial Mixto")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("1");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Congruencial cuadrático")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campC.setText(camp_varC.getText());
            vista2.campD.setText(camp_varD.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("2");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Fibonacci")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campSem2.setText(camp_semilla2.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("3");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Mitchell y Moore")){
            vista2.campSem1.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("4");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Aditivo Green")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("5");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Multiplicativo")){
            vista2.campSem1.setText(camp_semilla.getText());
            vista2.campA.setText(camp_varA.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("6");
        }
        else if(comboAlgoritmos.getSelectedItem().equals("Mixto")){
            vista2.campSem1.setText(camp_K.getText());
            vista2.campSem2.setText(camp_numeros.getText());
            vista2.campM.setText(camp_mod.getText());
            vista2.NumAlg.setText("7");
        }

    }//GEN-LAST:event_botonP_PromActionPerformed

    private void al1xoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al1xoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al1xoKeyTyped

    private void al1xoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al1xoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al1xoActionPerformed

    private void al2xoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2xoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2xoKeyTyped

    private void al2xoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2xoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2xoActionPerformed

    private void al2aKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2aKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2aKeyTyped

    private void al2aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2aActionPerformed

    private void al2cKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_al2cKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_al2cKeyTyped

    private void al2cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_al2cActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_al2cActionPerformed

    private void botonConclusionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConclusionActionPerformed
        
        double ingresos =0;
        double perdidas =0;
        double ingresosp2 =0;
        double perdidasp2 =0;
        double ingresosp3 =0;
        double perdidasp3 =0;
        String conclusion1 ="No es necesario comprar otra máquina";
        String conclusion2 ="No es necesario comprar otra máquina";
        String conclusion3 ="No es necesario comprar otra máquina";
        
        for(int i=0; i<tablaPol1.getRowCount(); i++)
        {
         ingresos = ingresos + Double.parseDouble(tablaPol1.getValueAt(i, 1).toString());
         perdidas = perdidas + Double.parseDouble(tablaPol1.getValueAt(i, 2).toString());
        }
 
        if(perdidas>=(ingresos * 0.5))
        {
         conclusion1 = "Se debe comprar otra máquina";
        }
        //------------------------POLITICA 2
         for(int i=0; i<tablaPol2.getRowCount(); i++)
        {
         ingresosp2 = ingresosp2 + Double.parseDouble(tablaPol2.getValueAt(i, 1).toString());
         perdidasp2 = perdidasp2 + Double.parseDouble(tablaPol2.getValueAt(i, 2).toString());
        }
 
        if(perdidasp2>=(ingresosp2 * 0.5))
        {
         conclusion2 = "Se debe comprar otra máquina";
        }
        //------------------------------------------------POLITICA 3
        for(int i=0; i<tablaPol3.getRowCount(); i++)
        {
         ingresosp3 = ingresosp3 + Double.parseDouble(tablaPol3.getValueAt(i, 1).toString());
         perdidasp3 = perdidasp3 + Double.parseDouble(tablaPol3.getValueAt(i, 2).toString());
        }
        
        if(perdidasp3>=(ingresosp3 * 0.6))
        {
         conclusion3 = "Se debe comprar otra máquina";
        }
        
            Conclusion vista2 = new Conclusion();
            vista2.setVisible(true);

            vista2.ingTp1.setText(Double.toString(ingresos));   
            vista2.perdTp1.setText(Double.toString(perdidas));
            vista2.conclusion.setText(conclusion1);
            
            vista2.ingTp2.setText(Double.toString(ingresosp2));   
            vista2.perdTp2.setText(Double.toString(perdidasp2));
            vista2.conclusionp2.setText(conclusion2);
            
            vista2.intTp3.setText(Double.toString(ingresosp3));   
            vista2.perdTp3.setText(Double.toString(perdidasp3));
            vista2.conclusionp3.setText(conclusion3);

    }//GEN-LAST:event_botonConclusionActionPerformed

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
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Resultado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Resultado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField al1N;
    private javax.swing.JTextField al1a;
    private javax.swing.JTextField al1c;
    private javax.swing.JTextField al1d;
    private javax.swing.JTextField al1m;
    private javax.swing.JTextField al1xo;
    private javax.swing.JTextField al2N;
    private javax.swing.JTextField al2a;
    private javax.swing.JTextField al2c;
    private javax.swing.JTextField al2d;
    private javax.swing.JTextField al2m;
    private javax.swing.JTextField al2xo;
    private javax.swing.JButton botonConclusion;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonP_Prom;
    private javax.swing.JButton botonP_kol;
    private javax.swing.JButton botonPrubFrec;
    private javax.swing.JButton botonSimulacion;
    private javax.swing.JButton boton_Generar;
    private javax.swing.JTextField camp_K;
    private javax.swing.JTextField camp_mod;
    private javax.swing.JTextField camp_numeros;
    private javax.swing.JTextField camp_semilla;
    private javax.swing.JTextField camp_semilla2;
    private javax.swing.JTextField camp_varA;
    private javax.swing.JTextField camp_varC;
    private javax.swing.JTextField camp_varD;
    private javax.swing.JCheckBox checkValidar;
    private javax.swing.JComboBox<String> comboAlgoritmos;
    private javax.swing.JTextField contador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelA;
    private javax.swing.JLabel labelC;
    private javax.swing.JLabel labelD;
    private javax.swing.JLabel labelK;
    private javax.swing.JLabel labelLlegadas;
    private javax.swing.JLabel labelMod;
    private javax.swing.JLabel labelNum;
    private javax.swing.JLabel labelNum1;
    private javax.swing.JLabel labelNum2;
    private javax.swing.JLabel labelSemilla;
    private javax.swing.JLabel labelServicios;
    private javax.swing.JLabel labelXn;
    private javax.swing.JSpinner spinerDias;
    private javax.swing.JSpinner spinerHoras;
    private javax.swing.JTable tablaPol1;
    private javax.swing.JTable tablaPol2;
    private javax.swing.JTable tablaPol3;
    // End of variables declaration//GEN-END:variables
}
