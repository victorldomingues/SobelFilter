/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Image;
import Services.ImageService;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

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
        BeforeImage = new javax.swing.JLabel();
        AfterImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sobel FIlter");
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(java.awt.Color.darkGray);

        SelectImageBtn.setText("Escolher Imagem");
        SelectImageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectImageBtnActionPerformed(evt);
            }
        });

        SelectImageLabel.setText("Selecione uma imagem");

        AplyFilterBtn.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AplyFilterBtn.setText("Aplicar Filtro");
        AplyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AplyFilterBtnActionPerformed(evt);
            }
        });

        BeforeImage.setBackground(new java.awt.Color(204, 204, 204));
        BeforeImage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BeforeImage.setForeground(new java.awt.Color(102, 102, 102));
        BeforeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BeforeImage.setText("Pré visualização (Escolha uma Imagem)");
        BeforeImage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createCompoundBorder(), null)));

        AfterImage.setBackground(new java.awt.Color(204, 204, 204));
        AfterImage.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AfterImage.setForeground(new java.awt.Color(102, 102, 102));
        AfterImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AfterImage.setText("Resultado Final");
        AfterImage.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectImageLabel)
                    .addComponent(SelectImageBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(AplyFilterBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BeforeImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AfterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(SelectImageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectImageBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AfterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BeforeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AplyFilterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        SelectImageLabel.getAccessibleContext().setAccessibleDescription("");

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

        PaintBefore();

    }//GEN-LAST:event_SelectImageBtnActionPerformed

    private void AplyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AplyFilterBtnActionPerformed
        // TODO add your handling code here:
        PaintAfter(_imageService.AplyFilter());
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
//        AfterImage.setVisible(false);     
//        BeforeImage.setVisible(false);
    }

    private void SetVisibleComponents() {
        AplyFilterBtn.setVisible(true);
    }

    private void PaintAfter(Image image) {
        AfterImage.setText("");
        AfterImage.setIcon(new ImageIcon(image.getImage()));
    }

    private void PaintBefore() {
        BeforeImage.setText("");
        BeforeImage.setIcon(new ImageIcon(_image.getImage()));
    }

    final JFileChooser FileChooser = new JFileChooser();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AfterImage;
    private javax.swing.JButton AplyFilterBtn;
    private javax.swing.JLabel BeforeImage;
    private javax.swing.JButton SelectImageBtn;
    private javax.swing.JLabel SelectImageLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
