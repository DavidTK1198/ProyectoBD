package Ventanas;

import Clases.Service;

public class Seguridad extends javax.swing.JFrame {

    Service s;

    public Seguridad(Service S) {
        this.s = S;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnCrearRol = new javax.swing.JButton();
        BtnEliminarRol = new javax.swing.JButton();
        BtnCrearUsuario = new javax.swing.JButton();
        Btndelete = new javax.swing.JButton();
        BtnAsignarRol = new javax.swing.JButton();
        BtnRevocarRole = new javax.swing.JButton();
        BtnQuitarPermisos = new javax.swing.JButton();
        btnMenuPrincipal = new javax.swing.JButton();
        btnDarPermisos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        btnCrearRol.setBackground(new java.awt.Color(51, 51, 51));
        btnCrearRol.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearRol.setText("Crear rol");
        btnCrearRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnCrearRol.setBorderPainted(false);
        btnCrearRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRolActionPerformed(evt);
            }
        });

        BtnEliminarRol.setBackground(new java.awt.Color(51, 51, 51));
        BtnEliminarRol.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminarRol.setText("Eliminar rol");
        BtnEliminarRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnEliminarRol.setBorderPainted(false);
        BtnEliminarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarRolActionPerformed(evt);
            }
        });

        BtnCrearUsuario.setBackground(new java.awt.Color(51, 51, 51));
        BtnCrearUsuario.setForeground(new java.awt.Color(255, 255, 255));
        BtnCrearUsuario.setText("Crear usuario");
        BtnCrearUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnCrearUsuario.setBorderPainted(false);
        BtnCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCrearUsuarioActionPerformed(evt);
            }
        });

        Btndelete.setBackground(new java.awt.Color(51, 51, 51));
        Btndelete.setForeground(new java.awt.Color(255, 255, 255));
        Btndelete.setText("Eliminar usuario");
        Btndelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Btndelete.setBorderPainted(false);
        Btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtndeleteActionPerformed(evt);
            }
        });

        BtnAsignarRol.setBackground(new java.awt.Color(51, 51, 51));
        BtnAsignarRol.setForeground(new java.awt.Color(255, 255, 255));
        BtnAsignarRol.setText("Asignar rol a usuario");
        BtnAsignarRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnAsignarRol.setBorderPainted(false);
        BtnAsignarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAsignarRolActionPerformed(evt);
            }
        });

        BtnRevocarRole.setBackground(new java.awt.Color(51, 51, 51));
        BtnRevocarRole.setForeground(new java.awt.Color(255, 255, 255));
        BtnRevocarRole.setText("Quitar rol a usuario");
        BtnRevocarRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnRevocarRole.setBorderPainted(false);
        BtnRevocarRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRevocarRoleActionPerformed(evt);
            }
        });

        BtnQuitarPermisos.setBackground(new java.awt.Color(51, 51, 51));
        BtnQuitarPermisos.setForeground(new java.awt.Color(255, 255, 255));
        BtnQuitarPermisos.setText("Quitar permisos");
        BtnQuitarPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BtnQuitarPermisos.setBorderPainted(false);
        BtnQuitarPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnQuitarPermisosActionPerformed(evt);
            }
        });

        btnMenuPrincipal.setBackground(new java.awt.Color(51, 51, 51));
        btnMenuPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnMenuPrincipal.setText("Regresar");
        btnMenuPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnMenuPrincipal.setBorderPainted(false);
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });

        btnDarPermisos.setBackground(new java.awt.Color(51, 51, 51));
        btnDarPermisos.setForeground(new java.awt.Color(255, 255, 255));
        btnDarPermisos.setText("Asignar permisos");
        btnDarPermisos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnDarPermisos.setBorderPainted(false);
        btnDarPermisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarPermisosActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/database-security-assessment (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDarPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearRol, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnEliminarRol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnQuitarPermisos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtnAsignarRol, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(BtnCrearUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btndelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnRevocarRole, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(BtnAsignarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRevocarRole, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnQuitarPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDarPermisos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed

        Principal mp = new Principal(s);
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    private void BtnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCrearUsuarioActionPerformed
        CrearUsuario crearUsuario = new CrearUsuario(s);
        crearUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCrearUsuarioActionPerformed

    private void BtndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtndeleteActionPerformed
        EliminarUsuario deleteUsuario = new EliminarUsuario(s);
        deleteUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtndeleteActionPerformed

    private void btnDarPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarPermisosActionPerformed
        AsignarPermisos rol = new AsignarPermisos(s);
        rol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDarPermisosActionPerformed

    private void btnCrearRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRolActionPerformed
        CrearRole rol = new CrearRole(s);
        rol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCrearRolActionPerformed

    private void BtnAsignarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAsignarRolActionPerformed
        AsignarRol rol = new AsignarRol(s);
        rol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAsignarRolActionPerformed

    private void BtnEliminarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarRolActionPerformed
        EliminarRole deleteRole = new EliminarRole(s);
        deleteRole.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnEliminarRolActionPerformed

    private void BtnQuitarPermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnQuitarPermisosActionPerformed
        EliminarPermiso eu = new EliminarPermiso(s);
        eu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnQuitarPermisosActionPerformed

    private void BtnRevocarRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRevocarRoleActionPerformed
        RevocarRol rol = new RevocarRol(s);
        rol.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnRevocarRoleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAsignarRol;
    private javax.swing.JButton BtnCrearUsuario;
    private javax.swing.JButton BtnEliminarRol;
    private javax.swing.JButton BtnQuitarPermisos;
    private javax.swing.JButton BtnRevocarRole;
    private javax.swing.JButton Btndelete;
    private javax.swing.JButton btnCrearRol;
    private javax.swing.JButton btnDarPermisos;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
