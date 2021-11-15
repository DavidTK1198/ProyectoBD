package Ventanas;

import Clases.Service;
import Clases.TableModelAuditoria;

public class Auditoria extends javax.swing.JFrame {

    private Service s;

    public Auditoria(Service s) {
        this.s = s;
        configurar();
    }

    private void configurar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void mostrarEstado(String estado) {
        etiqueta_estado.setText(estado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Btn_MenuPrincipal = new javax.swing.JButton();
        Btn_AuditarConexiones = new javax.swing.JButton();
        Btn_AuditarTablas = new javax.swing.JButton();
        Btn_AuditarInsert = new javax.swing.JButton();
        Btn_AuditarSelect = new javax.swing.JButton();
        Btn_AuditarDelete = new javax.swing.JButton();
        Btn_AuditarUpdate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        etiqueta_estado = new javax.swing.JLabel();
        btnAuditarTodos = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(1240, 510));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Auditoria");

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

        Btn_AuditarConexiones.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarConexiones.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarConexiones.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarConexiones.setText("Auditar Conexiones");
        Btn_AuditarConexiones.setBorderPainted(false);
        Btn_AuditarConexiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarConexionesActionPerformed(evt);
            }
        });

        Btn_AuditarTablas.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarTablas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarTablas.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarTablas.setText("Auditar Tablas ");
        Btn_AuditarTablas.setBorderPainted(false);
        Btn_AuditarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarTablasActionPerformed(evt);
            }
        });

        Btn_AuditarInsert.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarInsert.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarInsert.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarInsert.setText("Auditar Inserts ");
        Btn_AuditarInsert.setBorderPainted(false);
        Btn_AuditarInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarInsertActionPerformed(evt);
            }
        });

        Btn_AuditarSelect.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarSelect.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarSelect.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarSelect.setText("Auditar Selects");
        Btn_AuditarSelect.setBorderPainted(false);
        Btn_AuditarSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarSelectActionPerformed(evt);
            }
        });

        Btn_AuditarDelete.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarDelete.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarDelete.setText("Auditar Deletes");
        Btn_AuditarDelete.setBorderPainted(false);
        Btn_AuditarDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarDeleteActionPerformed(evt);
            }
        });

        Btn_AuditarUpdate.setBackground(new java.awt.Color(0, 0, 0));
        Btn_AuditarUpdate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Btn_AuditarUpdate.setForeground(new java.awt.Color(255, 255, 255));
        Btn_AuditarUpdate.setText("Auditar Updates");
        Btn_AuditarUpdate.setBorderPainted(false);
        Btn_AuditarUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AuditarUpdateActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTable1.setBackground(new java.awt.Color(153, 153, 153));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel( new Clases.TableModelAuditoria()
        );
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        etiqueta_estado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        etiqueta_estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        etiqueta_estado.setText("Estado");
        jPanel1.add(etiqueta_estado);

        btnAuditarTodos.setBackground(new java.awt.Color(0, 0, 0));
        btnAuditarTodos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAuditarTodos.setForeground(new java.awt.Color(255, 255, 255));
        btnAuditarTodos.setText("Auditar todos");
        btnAuditarTodos.setBorderPainted(false);
        btnAuditarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAuditarTodos(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btn_AuditarConexiones)
                            .addComponent(Btn_AuditarTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_AuditarInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_AuditarSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_AuditarDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_AuditarUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAuditarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_MenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(409, 409, 409)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Btn_AuditarConexiones)
                        .addGap(8, 8, 8)
                        .addComponent(Btn_AuditarTablas)
                        .addGap(8, 8, 8)
                        .addComponent(Btn_AuditarInsert)
                        .addGap(8, 8, 8)
                        .addComponent(Btn_AuditarSelect)
                        .addGap(8, 8, 8)
                        .addComponent(Btn_AuditarDelete)
                        .addGap(8, 8, 8)
                        .addComponent(Btn_AuditarUpdate)
                        .addGap(8, 8, 8)
                        .addComponent(btnAuditarTodos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btn_MenuPrincipal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1230, 480);
        getContentPane().add(filler1);
        filler1.setBounds(0, 0, 0, 0);

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

    private void btnAuditarTodos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAuditarTodos
       TableModelAuditoria a = (TableModelAuditoria) jTable1.getModel();
        a.auditarTodos();
        mostrarEstado(String.format("Se encontraron %d de registros de auditoría.", a.getRowCount()));

    }//GEN-LAST:event_btnAuditarTodos


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_AuditarConexiones;
    private javax.swing.JButton Btn_AuditarDelete;
    private javax.swing.JButton Btn_AuditarInsert;
    private javax.swing.JButton Btn_AuditarSelect;
    private javax.swing.JButton Btn_AuditarTablas;
    private javax.swing.JButton Btn_AuditarUpdate;
    private javax.swing.JButton Btn_MenuPrincipal;
    private javax.swing.JButton btnAuditarTodos;
    private javax.swing.JLabel etiqueta_estado;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
