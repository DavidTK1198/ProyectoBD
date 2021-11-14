/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author srami
 */
public class Respaldos extends javax.swing.JFrame {

    
    
    private static Statement st;
    private static ResultSet rs;
    Service s;
    ArrayList<String> tablas, schema, schemas, directorios;
    
    
    public Respaldos(Service s) {
        this.s = s;
        initComponents();
        llenarSchemas();
        llenarDirectorios();
        this.setLocationRelativeTo(null);
    }

    
    private void llenarTablas(){ //llena tablas y schemas
        schema = new ArrayList<String>();
        tablas = new ArrayList<String>();
        schemas = new ArrayList<String>();
        this.comboTablas.removeAllItems();
        this.comboSchemas.removeAllItems();
        try{
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "select table_name from all_tables where owner ='"+this.schemaDir.getSelectedItem().toString()+"' order by table_name");
                while(rs.next()) {
                    tablas.add(rs.getString("table_name"));
                }     
            rs = s.getConexion().executeQuery(st, "select * from sys.all_users Where created >= '20/10/20'");
                while(rs.next()) {
                    schemas.add(rs.getString("username"));
                } 
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado");
        }
        this.comboTablas.addItem("Seleccione");
        this.comboSchemas.addItem("Seleccione");
        for(int i=0; i<tablas.size(); i++){
            this.comboTablas.addItem(tablas.get(i));
        }
        for(int i=0; i<schemas.size(); i++){
            this.comboSchemas.addItem(schemas.get(i));
        }
    }
    
    private void llenarSchemas(){ //llena schemas de la parte de directorios
        schemas = new ArrayList<String>();
        try{
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "select * from sys.all_users Where created >= '20/10/20'");
            while(rs.next()){
                schemas.add(rs.getString("username"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado.");
        }
        this.schemaDir.addItem("Seleccione");
        for(int i = 0; i < schemas.size(); i++){
            this.schemaDir.addItem(schemas.get(i));
        }
    }
    
    private void llenarDirectorios(){
        directorios = new ArrayList<String>();
        try{
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "SELECT DIRECTORY_NAME FROM ALL_DIRECTORIES");
            while(rs.next()){
                directorios.add(rs.getString("DIRECTORY_NAME"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado.");
        }
        this.dirCombo.addItem("Seleccione");
        this.comboDir.addItem("Seleccione");
        for(int i = 0; i < directorios.size(); i++){
            this.dirCombo.addItem(directorios.get(i));
            this.comboDir.addItem(directorios.get(i));
        }
    }
   //--------------------------------------- 
    Runnable importarTabla = new Runnable()
    {
        @Override
        public void run(){
        importarTabla();
        }
    };
    
    public void importarTabla(){
        String ss = null;
        String tabla = txtTablaExp.getText();
        String dump = txtDumpTabla1.getText();
        String log = txtLogfileTabla1.getText();
        String dir = dirCombo.getSelectedItem().toString();
        String usr = schemaDir.getSelectedItem().toString();
        System.out.println(tabla);
        
        /*try{
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "select owner from ALL_OBJECTS where object_name = '"+tabla+"'");
            while(rs.next()){
                usr = rs.getString("owner");
                break;
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado.");
        }
        System.out.println(usr);*/
        try{
            String sql;
            sql = "cmd /c IMPDP " +usr+ "/root123@XE TABLES = " +usr+ "." + tabla +" DIRECTORY = " +dir+ " DUMPFILE = " +dump+ ".DMP LOGFILE = " +log+ "_log.LOG";
            System.out.println(sql);
          
            Process p = Runtime.getRuntime().exec(sql);
                        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));    
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));   
            while((ss = stdInput.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
            while((ss = stdError.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error");
        }
    }
    //--------------------------------------- 
    Runnable exportarTabla = new Runnable()
    {
        @Override
        public void run(){
        exportarTabla();
        }
    };
    
    public void exportarTabla() {
        String ss = null;
        String tabla = comboTablas.getSelectedItem().toString();
        String dump = txtDumpTabla1.getText();
        String log = txtLogfileTabla1.getText();
        String dir = dirCombo.getSelectedItem().toString();
        String usr = null;
        System.out.println(tabla);
        
        try{
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st,"select owner from ALL_OBJECTS where object_name = '"+tabla+"'");
                while (rs.next()) {
                    usr = rs.getString("owner");
                    break;
                }           
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Error en listado.");
        }
        
        System.out.println(usr);
        try {
            String comando;
            comando = "cmd /c EXPDP "+usr+"/root123@XE TABLES = " + usr + "." + tabla+" DIRECTORY = " + dir + " DUMPFILE = " + dump + ".DMP LOGFILE = " + log + "_log.LOG" ;
            System.out.println(comando);
          
            Process p = Runtime.getRuntime().exec(comando);
                        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((ss = stdInput.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
            while((ss = stdError.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
            
            JOptionPane.showMessageDialog(null, "Respaldo de tabla realizado.");
        }catch(Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
           System.out.println("Error");
           e.printStackTrace();
        }
    }
    
    //--------------------------------------- 
    Runnable importarSchema = new Runnable()
    {
        @Override
        public void run(){
        importarSchema();
        }
    };
    
    public void importarSchema() {
        String ss = null;
        String schema = comboSchemas.getSelectedItem().toString();
        String dump = txtDumpSchema.getText();
        String log = txtLogfileSchema.getText();
        String dir = dirCombo.getSelectedItem().toString();
        try {
            String comando;
            comando = "cmd /c IMPDP " + schema + "/root123@XE SCHEMAS = " + schema +" DIRECTORY = " + dir + " DUMPFILE = " + dump + ".DMP LOGFILE = " + log + "_log.LOG";
            
            System.out.println(comando);
          
            Process p = Runtime.getRuntime().exec(comando);
            
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((ss = stdInput.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
            while((ss = stdError.readLine()) != null){
                txtResultado.append(ss + "\n");
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error");
            e.printStackTrace();
        }

    }
    
    //--------------------------------------- 
    Runnable exportarSchema = new Runnable()
    {
        @Override
        public void run(){
        exportarSchema();
        }
    };
    
    public void exportarSchema(){
        String s = null;
        String schema = comboSchemas.getSelectedItem().toString();
        String dump = txtDumpSchema.getText();
        String log = txtLogfileSchema.getText();
        String dir = dirCombo.getSelectedItem().toString();
        try {
            String comando;
            comando = "cmd /c " + "EXPDP " + schema+ "/root123@XE" + " " + "SCHEMAS = "+schema+ " DIRECTORY = " + dir
                    + " DUMPFILE = " + dump + ".dmp LOGFILE = " + log + "_log.log";
            
            System.out.println(comando);
          
            Process p = Runtime.getRuntime().exec(comando);
                        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((s = stdInput.readLine()) != null){
                txtResultado.append(s + "\n");
            }
            while((s = stdError.readLine()) != null){
                txtResultado.append(s + "\n");
            }
            JOptionPane.showMessageDialog(null, "Respaldo de schema realizado.");
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    //--------------------------------------- 
    Runnable importarFull = new Runnable()
    {
        @Override
        public void run(){
        importarFull();
        }
    };
    
    public void importarFull(){
        String s = null;
        String dump = txtDumpFull.getText();
        String log = txtLogFull.getText();
        String dir = (String) dirCombo.getSelectedItem();
        try {
            String comando;
            comando = "cmd /c " + "IMPDP SYSTEM/root@XE  FULL = Y DIRECTORY = " + dir + " DUMPFILE = " + dump + ".DMP LOGFILE = " + log + "_log.LOG";
            System.out.println(comando);
            
            Process p = Runtime.getRuntime().exec(comando);
                        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((s = stdInput.readLine()) != null){
                txtResultado.append(s + "\n");
            }
            while((s = stdError.readLine()) != null){
                txtResultado.append(s + "\n");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    
    //--------------------------------------- 
    Runnable exportarFull = new Runnable()
    {
        @Override
        public void run(){
        exportarFull();
        }
    };
    
    public void exportarFull(){
        String s = null;
        String dump = txtDumpFull.getText();
        String log = txtLogFull.getText();
        String dir = (String) dirCombo.getSelectedItem();
        try {
            String comando;
            comando = "cmd /c EXPDP SYSTEM/root@XE FULL = Y DIRECTORY = " + dir + " DUMPFILE = " + dump + ".DMP LOGFILE = " + log + ".LOG";
            System.out.println(comando);
            
            Process p = Runtime.getRuntime().exec(comando);
                        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));  
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while((s = stdInput.readLine()) != null){
                txtResultado.append(s + "\n");
            }
            while((s = stdError.readLine()) != null){
                txtResultado.append(s + "\n");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage()); 
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nombreDir = new javax.swing.JTextField();
        btnAgregarDir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboDir = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txtDumpFull = new javax.swing.JTextField();
        txtLogFull = new javax.swing.JTextField();
        btnGenerarFull = new javax.swing.JButton();
        btnImpFull = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        dirCombo = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboTablas = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtDumpTabla1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtLogfileTabla1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboSchemas = new javax.swing.JComboBox<>();
        txtDumpSchema = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtLogfileSchema = new javax.swing.JTextField();
        btnRespaldoSchema = new javax.swing.JButton();
        btnImpSchema = new javax.swing.JButton();
        btnImpTabla1 = new javax.swing.JButton();
        btnRespaldoTabla1 = new javax.swing.JButton();
        txtTablaExp = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        schemaDir = new javax.swing.JComboBox<>();
        btnRellenar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Stencil", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Creación y Recuperación de Respaldos");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Directorios.");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre Directorio:");

        btnAgregarDir.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarDir.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarDir.setText("Agregar");
        btnAgregarDir.setBorderPainted(false);
        btnAgregarDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDirActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Eliminar Directorio");

        btnEliminar.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorderPainted(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Logfile:");

        btnGenerarFull.setBackground(new java.awt.Color(0, 0, 0));
        btnGenerarFull.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarFull.setText("Generar Respaldo");
        btnGenerarFull.setBorderPainted(false);
        btnGenerarFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFullActionPerformed(evt);
            }
        });

        btnImpFull.setBackground(new java.awt.Color(0, 0, 0));
        btnImpFull.setForeground(new java.awt.Color(255, 255, 255));
        btnImpFull.setText("Importar Respaldo");
        btnImpFull.setBorderPainted(false);
        btnImpFull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpFullActionPerformed(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Seleccion de Directorio");

        dirCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirComboActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(0, 0, 0));
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("Atras");
        btnRegresar.setBorderPainted(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Respaldos Completos");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dumpfile:");

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Respaldos de Tablas");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nombre de Tabla:");

        comboTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTablasActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Dumpfile:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Logfile:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Respaldos de Schemas");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Dumpfile:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre de Schema:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Logfile:");

        btnRespaldoSchema.setBackground(new java.awt.Color(0, 0, 0));
        btnRespaldoSchema.setForeground(new java.awt.Color(255, 255, 255));
        btnRespaldoSchema.setText("Generar Respaldo");
        btnRespaldoSchema.setBorderPainted(false);
        btnRespaldoSchema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldoSchemaActionPerformed(evt);
            }
        });

        btnImpSchema.setBackground(new java.awt.Color(0, 0, 0));
        btnImpSchema.setForeground(new java.awt.Color(255, 255, 255));
        btnImpSchema.setText("Importar Schema");
        btnImpSchema.setBorderPainted(false);
        btnImpSchema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpSchemaActionPerformed(evt);
            }
        });

        btnImpTabla1.setBackground(new java.awt.Color(0, 0, 0));
        btnImpTabla1.setForeground(new java.awt.Color(255, 255, 255));
        btnImpTabla1.setText("Importar Tabla");
        btnImpTabla1.setBorderPainted(false);
        btnImpTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpTabla1ActionPerformed(evt);
            }
        });

        btnRespaldoTabla1.setBackground(new java.awt.Color(0, 0, 0));
        btnRespaldoTabla1.setForeground(new java.awt.Color(255, 255, 255));
        btnRespaldoTabla1.setText("Generar Respaldo");
        btnRespaldoTabla1.setBorderPainted(false);
        btnRespaldoTabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRespaldoTabla1ActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nombre de la tabla a importar");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuarios:");

        btnRellenar.setBackground(new java.awt.Color(0, 0, 0));
        btnRellenar.setForeground(new java.awt.Color(255, 255, 255));
        btnRellenar.setText("Rellenar tablas y Schemas");
        btnRellenar.setBorderPainted(false);
        btnRellenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRellenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(comboDir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(331, 331, 331))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(40, 40, 40)))
                                .addComponent(txtTablaExp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(btnAgregarDir))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRellenar)
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnGenerarFull)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnImpFull)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(comboTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtLogfileTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jLabel8)
                                                    .addGap(16, 16, 16)
                                                    .addComponent(txtDumpTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel6)
                                            .addComponent(btnRegresar))
                                        .addGap(263, 263, 263)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboSchemas, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtDumpSchema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtLogfileSchema, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(schemaDir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(47, 47, 47))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(118, 118, 118))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDumpFull, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtLogFull, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(18, 18, 18)
                                                .addComponent(dirCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(40, 40, 40)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(202, 202, 202))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(386, 386, 386))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRespaldoTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(btnImpTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRespaldoSchema)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImpSchema, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarDir)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtDumpTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(txtDumpSchema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtLogfileTabla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtLogfileSchema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSchemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTablaExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRespaldoTabla1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnImpTabla1)
                                .addComponent(btnRespaldoSchema)
                                .addComponent(btnImpSchema)))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDumpFull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtLogFull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(dirCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarFull)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnImpFull))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnRegresar)))
                        .addGap(62, 62, 62))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(schemaDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnRellenar)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Principal menu = new Principal(s);
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    //respaldo de tabla
    private void btnRespaldoTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldoTabla1ActionPerformed
        txtResultado.setText("Creando Respaldo.");
        Thread t = new Thread(exportarTabla);
        t.start();
    }//GEN-LAST:event_btnRespaldoTabla1ActionPerformed
    //imp de tabla
    private void btnImpTabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpTabla1ActionPerformed
        txtResultado.setText("Importando Respaldo.");
        Thread t = new Thread(importarTabla);
        t.start();
    }//GEN-LAST:event_btnImpTabla1ActionPerformed
    //respaldo de schema
    private void btnRespaldoSchemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRespaldoSchemaActionPerformed
        txtResultado.setText("Creando Respaldo.");
        Thread t = new Thread(exportarSchema);
        t.start();
    }//GEN-LAST:event_btnRespaldoSchemaActionPerformed
    //imp de schema
    private void btnImpSchemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpSchemaActionPerformed
        txtResultado.setText("Importando Respaldo.");
        Thread t = new Thread(importarSchema);
        t.start();
    }//GEN-LAST:event_btnImpSchemaActionPerformed
    //respaldo full
    private void btnGenerarFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFullActionPerformed
        txtResultado.setText("Creando Respaldo.");
        Thread t = new Thread(exportarFull);
        t.start();
    }//GEN-LAST:event_btnGenerarFullActionPerformed
    //importar full
    private void btnImpFullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpFullActionPerformed
        txtResultado.setText("Importando Respaldo.");
        Thread t = new Thread(importarFull);
        t.start();
    }//GEN-LAST:event_btnImpFullActionPerformed
    //Agregar directorio
    private void btnAgregarDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDirActionPerformed
        try {
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "CREATE OR REPLACE DIRECTORY "+this.nombreDir.getText()+ " AS 'D:\\app\\Respaldos'");
            rs = s.getConexion().executeQuery(st, "GRANT READ, WRITE ON DIRECTORY "+this.nombreDir.getText()+ " TO "+this.schemaDir.getSelectedItem().toString());
        }catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnAgregarDirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            st = s.getConexion().prepareStatement();
            s.getConexion().executeQuery(st, "alter session set \"_ORACLE_SCRIPT\" =true");
            rs = s.getConexion().executeQuery(st, "DROP DIRECTORY "+this.comboDir.getSelectedItem().toString()); 
        }catch(SQLException ex) {
            System.out.println(ex.getMessage()); 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void dirComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirComboActionPerformed
        /*if(this.dirCombo.getSelectedIndex()>0){
        llenarTablas();
        }*/
    }//GEN-LAST:event_dirComboActionPerformed

    private void comboTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTablasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTablasActionPerformed

    private void btnRellenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRellenarActionPerformed
       llenarTablas();
    }//GEN-LAST:event_btnRellenarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDir;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarFull;
    private javax.swing.JButton btnImpFull;
    private javax.swing.JButton btnImpSchema;
    private javax.swing.JButton btnImpTabla1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnRellenar;
    private javax.swing.JButton btnRespaldoSchema;
    private javax.swing.JButton btnRespaldoTabla1;
    private javax.swing.JComboBox<String> comboDir;
    private javax.swing.JComboBox<String> comboSchemas;
    private javax.swing.JComboBox<String> comboTablas;
    private javax.swing.JComboBox<String> dirCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreDir;
    private javax.swing.JComboBox<String> schemaDir;
    private javax.swing.JTextField txtDumpFull;
    private javax.swing.JTextField txtDumpSchema;
    private javax.swing.JTextField txtDumpTabla1;
    private javax.swing.JTextField txtLogFull;
    private javax.swing.JTextField txtLogfileSchema;
    private javax.swing.JTextField txtLogfileTabla1;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtTablaExp;
    // End of variables declaration//GEN-END:variables
}
