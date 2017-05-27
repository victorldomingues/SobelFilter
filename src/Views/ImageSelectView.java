/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Image;
import Services.ImageService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author lab656
 */
public class ImageSelectView extends javax.swing.JFrame {

    private final Image _image = new Image();

    private final ImageService _imageService = new ImageService(_image);

    /**
     * Creates new form ImageSelectView
     */
    public ImageSelectView() {
        initComponents();
        SetInvisibleComponents();
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
        AplyFilterBtn = new javax.swing.JButton();
        AplyFilterLabel = new javax.swing.JLabel();
        AfterImage = new javax.swing.JPanel();
        BeforeImage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sobel FIlter");

        SelectImageBtn.setText("Escolher Imagem");
        SelectImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectImageBtnActionPerformed(evt);
            }
        });

        SelectImageLabel.setText("Selecione uma imagem");

        AplyFilterBtn.setText("Aplicar Filtro");
        AplyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplyFilterBtnActionPerformed(evt);
            }
        });

        AplyFilterLabel.setText("Aplicar Filtro");

        javax.swing.GroupLayout AfterImageLayout = new javax.swing.GroupLayout(AfterImage);
        AfterImage.setLayout(AfterImageLayout);
        AfterImageLayout.setHorizontalGroup(
            AfterImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        AfterImageLayout.setVerticalGroup(
            AfterImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BeforeImageLayout = new javax.swing.GroupLayout(BeforeImage);
        BeforeImage.setLayout(BeforeImageLayout);
        BeforeImageLayout.setHorizontalGroup(
            BeforeImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 365, Short.MAX_VALUE)
        );
        BeforeImageLayout.setVerticalGroup(
            BeforeImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AplyFilterBtn)
                    .addComponent(SelectImageLabel)
                    .addComponent(SelectImageBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AplyFilterLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BeforeImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(AfterImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(SelectImageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectImageBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AfterImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BeforeImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(AplyFilterLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AplyFilterBtn)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SelectImageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectImageBtnActionPerformed
        // TODO add your handling code here:

        SetInvisibleComponents();

        int selecionado = FileChooser.showDialog(this, "Selecione o arquivo");

        if (selecionado == 1) {
            return;
        }

        _image.setFile(FileChooser.getSelectedFile());

        SetVisibleComponents();
    }//GEN-LAST:event_SelectImageBtnActionPerformed

    private void AplyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplyFilterBtnActionPerformed
        // TODO add your handling code here:
        _imageService.AplyFilter();
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

    private void SetInvisibleComponents() {
        AplyFilterBtn.setVisible(false);
        AplyFilterLabel.setVisible(false);
        AfterImage.setVisible(false);
    }

    private void SetVisibleComponents() {
        AplyFilterBtn.setVisible(true);
        AplyFilterLabel.setVisible(true);
        AfterImage.setVisible(true);
    }

    final JFileChooser FileChooser = new JFileChooser();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AfterImage;
    private javax.swing.JButton AplyFilterBtn;
    private javax.swing.JLabel AplyFilterLabel;
    private javax.swing.JPanel BeforeImage;
    private javax.swing.JButton SelectImageBtn;
    private javax.swing.JLabel SelectImageLabel;
    // End of variables declaration//GEN-END:variables
}
