/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author lab656
 */
public class ImageSelectView extends javax.swing.JFrame {

    private Imagem imagem = new Imagem();

    /**
     * Creates new form ImageSelectView
     */
    public ImageSelectView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SelectImageBtn = new javax.swing.JButton();
        SelectImageLabel = new javax.swing.JLabel();
        FileName = new java.awt.Label();
        AplyFilterBtn = new javax.swing.JButton();
        FilePathInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sobel FIlter");

        SelectImageBtn.setText("Escolher Imagem");
        SelectImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectImageBtnActionPerformed(evt);
            }
        });

        SelectImageLabel.setText("Selecione uma imagem");

        FileName.setText("label1");

        AplyFilterBtn.setText("Aplicar Filtro");
        AplyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplyFilterBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Caminho da imagem");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(AplyFilterBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SelectImageLabel)
                        .addGap(88, 88, 88)
                        .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SelectImageBtn)
                    .addComponent(FilePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectImageLabel)
                    .addComponent(FileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectImageBtn)
                .addGap(121, 121, 121)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FilePathInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AplyFilterBtn)
                .addContainerGap(192, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectImageBtnActionPerformed
        // TODO add your handling code here:
        SelectFileView selectFileView = new SelectFileView(imagem);
        selectFileView.setVisible(rootPaneCheckingEnabled);
        FileName.setText(imagem.getFileName());
    }//GEN-LAST:event_SelectImageBtnActionPerformed

    private void AplyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplyFilterBtnActionPerformed
        // TODO add your handling code here:
        imagem.setFile(new File(FilePathInput.getText()));

        BufferedImage bi;
        try {
            
            bi = ImageIO.read(imagem.getFile());
            int width = bi.getWidth();
            int height = bi.getHeight();
            System.out.println("w: " + width);
            System.out.println("h: " + height);

            System.out.println("test git");
            
        } catch (IOException ex) {
            Logger.getLogger(ImageSelectView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_AplyFilterBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ImageSelectView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageSelectView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageSelectView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageSelectView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImageSelectView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AplyFilterBtn;
    private java.awt.Label FileName;
    private javax.swing.JTextField FilePathInput;
    private javax.swing.JButton SelectImageBtn;
    private javax.swing.JLabel SelectImageLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
