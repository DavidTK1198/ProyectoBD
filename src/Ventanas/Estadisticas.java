/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;


import Clases.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author srami
 */
public class Estadisticas extends javax.swing.JFrame {

    

    private static Statement st;
    private static ResultSet rs;
    ArrayList<String> tablas, schemas;
    Service servicio;
    
    public Estadisticas(Service serv) {
         this.servicio=serv;
        initComponents();
        llenarTablas();
        this.setLocationRelativeTo(null);
    }

    private void llenarTablas(){
        tablas = new ArrayList<String>();
        schemas = new ArrayList<String>();
        try{
             st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"select al.table_name, al.owner from all_tables AL join all_users AU on(AL.owner=AU.username) Where AU.created >= '15/10/20'");
            while(rs.next()){
                tablas.add(rs.getString("table_name"));
                schemas.add(rs.getString("owner"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error");
        }
        this.comboTabla.addItem("Seleccione");
        this.comboTabla1.addItem("Seleccione");
        this.comboTabla2.addItem("Seleccione");
        for(int i=0; i<tablas.size(); i++){
            this.comboTabla.addItem(tablas.get(i));
            this.comboTabla1.addItem(tablas.get(i));
            this.comboTabla2.addItem(tablas.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboTabla = new javax.swing.JComboBox<>();
        comTabla = new javax.swing.JButton();
        comColum = new javax.swing.JButton();
        comCompleta = new javax.swing.JButton();
        comColumI = new javax.swing.JButton();
        comIndice = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        estCompleta = new javax.swing.JButton();
        estIndexC = new javax.swing.JButton();
        estTabla = new javax.swing.JButton();
        DeleteStats = new javax.swing.JButton();
        comboTabla1 = new javax.swing.JComboBox<>();
        comboTabla2 = new javax.swing.JComboBox<>();
        estColum = new javax.swing.JButton();
        estIndice = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Estadísticas");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Compute Statistics");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tabla a Analizar");

        comTabla.setBackground(new java.awt.Color(0, 0, 0));
        comTabla.setForeground(new java.awt.Color(255, 255, 255));
        comTabla.setText("Solo Tabla");
        comTabla.setBorderPainted(false);
        comTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comTablaActionPerformed(evt);
            }
        });

        comColum.setBackground(new java.awt.Color(0, 0, 0));
        comColum.setForeground(new java.awt.Color(255, 255, 255));
        comColum.setText("Todas las columnas");
        comColum.setBorderPainted(false);
        comColum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comColumActionPerformed(evt);
            }
        });

        comCompleta.setBackground(new java.awt.Color(0, 0, 0));
        comCompleta.setForeground(new java.awt.Color(255, 255, 255));
        comCompleta.setText("Completa");
        comCompleta.setBorderPainted(false);
        comCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comCompletaActionPerformed(evt);
            }
        });

        comColumI.setBackground(new java.awt.Color(0, 0, 0));
        comColumI.setForeground(new java.awt.Color(255, 255, 255));
        comColumI.setText("Columnas Indexadas");
        comColumI.setBorderPainted(false);
        comColumI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comColumIActionPerformed(evt);
            }
        });

        comIndice.setBackground(new java.awt.Color(0, 0, 0));
        comIndice.setForeground(new java.awt.Color(255, 255, 255));
        comIndice.setText("Solo Indice");
        comIndice.setBorderPainted(false);
        comIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comIndiceActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Delete Statistics");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estimate Statistics");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tabla a Analizar");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tabla a Eliminar");

        estCompleta.setBackground(new java.awt.Color(0, 0, 0));
        estCompleta.setForeground(new java.awt.Color(255, 255, 255));
        estCompleta.setText("Completa");
        estCompleta.setBorderPainted(false);
        estCompleta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estCompletaActionPerformed(evt);
            }
        });

        estIndexC.setBackground(new java.awt.Color(0, 0, 0));
        estIndexC.setForeground(new java.awt.Color(255, 255, 255));
        estIndexC.setText("Columnas Indexadas");
        estIndexC.setBorderPainted(false);
        estIndexC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estIndexCActionPerformed(evt);
            }
        });

        estTabla.setBackground(new java.awt.Color(0, 0, 0));
        estTabla.setForeground(new java.awt.Color(255, 255, 255));
        estTabla.setText("Solo Tabla");
        estTabla.setBorderPainted(false);
        estTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estTablaActionPerformed(evt);
            }
        });

        DeleteStats.setBackground(new java.awt.Color(0, 0, 0));
        DeleteStats.setForeground(new java.awt.Color(255, 255, 255));
        DeleteStats.setText("Eliminar");
        DeleteStats.setBorderPainted(false);
        DeleteStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteStatsActionPerformed(evt);
            }
        });

        estColum.setBackground(new java.awt.Color(0, 0, 0));
        estColum.setForeground(new java.awt.Color(255, 255, 255));
        estColum.setText("Todas las columnas");
        estColum.setBorderPainted(false);
        estColum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estColumActionPerformed(evt);
            }
        });

        estIndice.setBackground(new java.awt.Color(0, 0, 0));
        estIndice.setForeground(new java.awt.Color(255, 255, 255));
        estIndice.setText("Solo Indice");
        estIndice.setBorderPainted(false);
        estIndice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estIndiceActionPerformed(evt);
            }
        });

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        btnRegresar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Atras");
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comColumI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comColum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comIndice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comCompleta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboTabla1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estColum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estIndice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estIndexC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(estCompleta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(DeleteStats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(21, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnRegresar)
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(74, 74, 74)
                                .addComponent(comCompleta)
                                .addGap(13, 13, 13)
                                .addComponent(comTabla)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comIndice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comColum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comColumI)
                                            .addComponent(estIndexC)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(estColum))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(estCompleta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estTabla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(estIndice)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTabla2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteStats))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comCompletaActionPerformed
        try{
           String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
           st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla.getSelectedItem().toString()+" COMPUTE STATISTICS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla.getSelectedItem().toString()+" analizada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_comCompletaActionPerformed

    private void comTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comTablaActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla.getSelectedItem().toString()+" COMPUTE STATISTICS FOR TABLE");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla.getSelectedItem().toString()+" analizada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_comTablaActionPerformed

    private void comIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comIndiceActionPerformed
        try{
             String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla.getSelectedItem().toString()+" COMPUTE STATISTICS FOR ALL INDEXES");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla.getSelectedItem().toString()+" analizada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_comIndiceActionPerformed

    private void comColumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comColumActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
          st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla.getSelectedItem().toString()+" COMPUTE STATISTICS FOR ALL COLUMNS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla.getSelectedItem().toString()+" analizada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_comColumActionPerformed

    private void comColumIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comColumIActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla.getSelectedItem().toString()+" COMPUTE STATISTICS FOR ALL INDEXED COLUMNS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla.getSelectedItem().toString()+" analizada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_comColumIActionPerformed

    private void estCompletaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estCompletaActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
       st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" ESTIMATE STATISTICS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" estimada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_estCompletaActionPerformed

    private void estTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estTablaActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" ESTIMATE STATISTICS FOR TABLE");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" estimada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_estTablaActionPerformed

    private void estIndiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estIndiceActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" ESTIMATE STATISTICS FOR ALL INDEXES");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" estimada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_estIndiceActionPerformed

    private void estColumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estColumActionPerformed
        try{
             String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" ESTIMATE STATISTICS FOR ALL COLUMNS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" estimada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_estColumActionPerformed

    private void estIndexCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estIndexCActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
           st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" ESTIMATE STATISTICS FOR ALL INDEXED COLUMNS");
            this.txtResultado.setText("Tabla "+schema+"."+this.comboTabla1.getSelectedItem().toString()+" estimada.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_estIndexCActionPerformed

    private void DeleteStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteStatsActionPerformed
        try{
            String schema =  schemas.get(this.comboTabla1.getSelectedIndex());
            st = servicio.getConexion().prepareStatement();
            servicio.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = servicio.getConexion().executeQuery(st,"ANALYZE TABLE "+schema+"."+this.comboTabla2.getSelectedItem().toString()+" DELETE STATISTICS");
            this.txtResultado.setText("Estadisticas de "+schema+"."+this.comboTabla2.getSelectedItem().toString()+" eliminadas.");
        }catch(SQLException ex){
            this.txtResultado.setText(ex.getMessage());
        }
    }//GEN-LAST:event_DeleteStatsActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Tunning t = new Tunning(servicio);
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteStats;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton comColum;
    private javax.swing.JButton comColumI;
    private javax.swing.JButton comCompleta;
    private javax.swing.JButton comIndice;
    private javax.swing.JButton comTabla;
    private javax.swing.JComboBox<String> comboTabla;
    private javax.swing.JComboBox<String> comboTabla1;
    private javax.swing.JComboBox<String> comboTabla2;
    private javax.swing.JButton estColum;
    private javax.swing.JButton estCompleta;
    private javax.swing.JButton estIndexC;
    private javax.swing.JButton estIndice;
    private javax.swing.JButton estTabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
