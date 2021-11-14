package Ventanas;

import Clases.Service;

public class Principal extends javax.swing.JFrame {

    Service s;

    public Principal(Service S) {
        this.s = S;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Btn_Directorio = new javax.swing.JButton();
        Btn_Administracion = new javax.swing.JButton();
        Btn_Tunning = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Btn_Seguridad = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DB-Developer");

        Btn_Directorio.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Directorio.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Directorio.setText("Administracion de Respaldos");
        Btn_Directorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn_Directorio.setBorderPainted(false);
        Btn_Directorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DirectorioActionPerformed(evt);
            }
        });

        Btn_Administracion.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Administracion.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Administracion.setText("Administración de tablespace");
        Btn_Administracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn_Administracion.setBorderPainted(false);
        Btn_Administracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AdministracionActionPerformed(evt);
            }
        });

        Btn_Tunning.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Tunning.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Tunning.setText("Tunning");
        Btn_Tunning.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn_Tunning.setBorderPainted(false);
        Btn_Tunning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_TunningActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 51, 51));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Auditoría BD");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Btn_Seguridad.setBackground(new java.awt.Color(51, 51, 51));
        Btn_Seguridad.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Seguridad.setText("Seguridad de usuarios");
        Btn_Seguridad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btn_Seguridad.setBorderPainted(false);
        Btn_Seguridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SeguridadActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Slide1 (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Tunning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Administracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Directorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Btn_Seguridad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(Btn_Directorio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(Btn_Administracion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(Btn_Tunning, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(Btn_Seguridad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//boton directorio
    private void Btn_DirectorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DirectorioActionPerformed
        Respaldos re = new Respaldos(s);
        re.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_DirectorioActionPerformed

    private void Btn_AdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AdministracionActionPerformed
        AdminTablespace table = new AdminTablespace(s);
        table.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_AdministracionActionPerformed

    private void Btn_SeguridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SeguridadActionPerformed
        Seguridad se = new Seguridad(this.s);
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_SeguridadActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Auditoria se = new Auditoria(this.s);
        se.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Btn_TunningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_TunningActionPerformed
        Tunning t = new Tunning(this.s);
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_TunningActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Administracion;
    private javax.swing.JButton Btn_Directorio;
    private javax.swing.JButton Btn_Seguridad;
    private javax.swing.JButton Btn_Tunning;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
