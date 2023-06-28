
package Ventanas;

import Controladores.ControladorDescarga;
import javax.swing.JOptionPane;
import Logica.Descarga;
import Logica.Usuario;

public class V_DescargaUsuario extends javax.swing.JFrame {
    ControladorDescarga controlador_descarga_de_libro;
    Usuario modelo_usuario;

    public V_DescargaUsuario(Usuario modelo_usuario_p) {
        initComponents();
        controlador_descarga_de_libro = new ControladorDescarga();
        modelo_usuario = modelo_usuario_p;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnFinalizar = new javax.swing.JButton();
        txt_3 = new javax.swing.JTextField();
        lbl_3 = new javax.swing.JLabel();
        lbl_1 = new javax.swing.JLabel();
        txt_1 = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        lbl_5 = new javax.swing.JLabel();
        lbl_4 = new javax.swing.JLabel();
        txt_5 = new javax.swing.JTextField();
        txt_4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFinalizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnFinalizar.setText("Finalizar");
        btnFinalizar.setBorderPainted(false);
        btnFinalizar.setFocusable(false);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        txt_3.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        lbl_3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_3.setText("ISBN:");

        lbl_1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_1.setText("Ip:");

        txt_1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgregar.setText("Descargar");
        btnAgregar.setBorderPainted(false);
        btnAgregar.setFocusable(false);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        lbl_5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_5.setText("Hora de descarga:  ");

        lbl_4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_4.setText("Fecha de descarga:");

        txt_5.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        txt_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_5ActionPerformed(evt);
            }
        });

        txt_4.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(lbl_4))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lbl_1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_1)
                    .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_3)
                    .addComponent(txt_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_5)
                    .addComponent(lbl_4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String ip_descarga, codigo_usuario_descarga, isbn_libro_digital_descarga, fecha_descarga, hora_deacarga; 
       
        ip_descarga = txt_1.getText();
        codigo_usuario_descarga = modelo_usuario.getUsuario_id();
        isbn_libro_digital_descarga = txt_3.getText();
        fecha_descarga = txt_4.getText();
        hora_deacarga = txt_5.getText();
                

       
        try{
            controlador_descarga_de_libro.agregar_descarga_de_libro(ip_descarga, codigo_usuario_descarga, isbn_libro_digital_descarga, fecha_descarga, hora_deacarga);
            limpiarGUI();

        }
        catch(Exception e){

        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txt_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_5ActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed
   private void limpiarGUI(){
        txt_1.setText("");
        txt_3.setText("");
        txt_4.setText("");
        txt_5.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnFinalizar;
    private javax.swing.JLabel lbl_1;
    private javax.swing.JLabel lbl_3;
    private javax.swing.JLabel lbl_4;
    private javax.swing.JLabel lbl_5;
    public javax.swing.JTextField txt_1;
    public javax.swing.JTextField txt_3;
    public javax.swing.JTextField txt_4;
    public javax.swing.JTextField txt_5;
    // End of variables declaration//GEN-END:variables
}
