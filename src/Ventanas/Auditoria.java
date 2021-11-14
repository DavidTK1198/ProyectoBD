package Ventanas;

import Clases.Service;
import Clases.TableModelAuditoria;

public class Auditoria extends javax.swing.JFrame {
    
    Service s;
    
    public Auditoria(Service S) {
        this.s = S;
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void mostrarEstado(String estado) {
        etiqueta_estado.setText(estado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Btn_MenuPrincipal = new javax.swing.JButton();
        Btn_AuditarUpdate = new javax.swing.JButton();
        Btn_AuditarInsert = new javax.swing.JButton();
        Btn_AuditarTablas = new javax.swing.JButton();
        Btn_AuditarDelete = new javax.swing.JButton();
        Btn_AuditarConexiones = new javax.swing.JButton();
        Btn_AuditarSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        etiqueta_estado = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(850, 470));
        getContentPane().setLayout(null);
        getContentPane().add(filler1);
        filler1.setBounds(0, 0, 0, 0);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Auditoria");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(100, 10, 654, 22);

        Btn_MenuPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        Btn_MenuPrincipal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Btn_MenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        Btn_MenuPrincipal.setText("Atras");
        Btn_MenuPrincipal.setBorderPainted(false);
        Btn_MenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_MenuPrincipalActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_MenuPrincipal);
        Btn_MenuPrincipal.setBounds(10, 290, 130, 20);

        Btn_AuditarUpdate.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarUpdate.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarUpdate.setText("Auditar Updates");
        Btn_AuditarUpdate.setBorderPainted(false);
        Btn_AuditarUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarUpdate);
        Btn_AuditarUpdate.setBounds(10, 250, 127, 23);

        Btn_AuditarInsert.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarInsert.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarInsert.setText("Auditar Inserts ");
        Btn_AuditarInsert.setBorderPainted(false);
        Btn_AuditarInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarInsertActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarInsert);
        Btn_AuditarInsert.setBounds(10, 130, 127, 23);

        Btn_AuditarTablas.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarTablas.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarTablas.setText("Auditar Tablas ");
        Btn_AuditarTablas.setBorderPainted(false);
        Btn_AuditarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarTablasActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarTablas);
        Btn_AuditarTablas.setBounds(10, 90, 127, 23);

        Btn_AuditarDelete.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarDelete.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarDelete.setText("Auditar Deletes");
        Btn_AuditarDelete.setBorderPainted(false);
        Btn_AuditarDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarDelete);
        Btn_AuditarDelete.setBounds(10, 210, 127, 23);

        Btn_AuditarConexiones.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarConexiones.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarConexiones.setText("Auditar Conexiones");
        Btn_AuditarConexiones.setBorderPainted(false);
        Btn_AuditarConexiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarConexionesActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarConexiones);
        Btn_AuditarConexiones.setBounds(10, 50, 140, 23);

        Btn_AuditarSelect.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarSelect.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarSelect.setText("Auditar Selects");
        Btn_AuditarSelect.setBorderPainted(false);
        Btn_AuditarSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarSelectActionPerformed(evt);
            }
        });
        jPanel2.add(Btn_AuditarSelect);
        Btn_AuditarSelect.setBounds(10, 170, 127, 23);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel( new Clases.TableModelAuditoria()
        );
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(190, 50, 600, 330);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        etiqueta_estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiqueta_estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_estado.setText("Estado");
        jPanel1.add(etiqueta_estado, new java.awt.GridBagConstraints());

        jPanel2.add(jPanel1);
        jPanel1.setBounds(160, 400, 654, 29);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 850, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_MenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_MenuPrincipalActionPerformed
        Principal mp = new Principal(s);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_MenuPrincipalActionPerformed

    private void Btn_AuditarInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarInsertActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarInsert();
        mostrarEstado(String.format("Se encontraron %d registros de Inserts.", a.getRowCount()));
    }//GEN-LAST:event_Btn_AuditarInsertActionPerformed

    private void Btn_AuditarConexionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarConexionesActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarConexiones();
        mostrarEstado(String.format("Se encontraron %d registros de Conexión.", a.getRowCount()));
        
    }//GEN-LAST:event_Btn_AuditarConexionesActionPerformed

    private void Btn_AuditarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarTablasActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarTablas();
        mostrarEstado(String.format("Se encontraron %d Tablas.", a.getRowCount()));
    }//GEN-LAST:event_Btn_AuditarTablasActionPerformed

    private void Btn_AuditarSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarSelectActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarSelect();
        mostrarEstado(String.format("Se encontraron %d de resgistros de Selects.", a.getRowCount()));
    }//GEN-LAST:event_Btn_AuditarSelectActionPerformed

    private void Btn_AuditarUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarUpdateActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarUpdate();
        mostrarEstado(String.format("Se encontraron %d de registros de Updates.", a.getRowCount()));
    }//GEN-LAST:event_Btn_AuditarUpdateActionPerformed

    private void Btn_AuditarDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AuditarDeleteActionPerformed
        TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarDelete();
        mostrarEstado(String.format("Se encontraron %d de registros de Deletes.", a.getRowCount()));
    }//GEN-LAST:event_Btn_AuditarDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AuditarConexiones;
    private javax.swing.JButton Btn_AuditarDelete;
    private javax.swing.JButton Btn_AuditarInsert;
    private javax.swing.JButton Btn_AuditarSelect;
    private javax.swing.JButton Btn_AuditarTablas;
    private javax.swing.JButton Btn_AuditarUpdate;
    private javax.swing.JButton Btn_MenuPrincipal;
    private javax.swing.JLabel etiqueta_estado;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
