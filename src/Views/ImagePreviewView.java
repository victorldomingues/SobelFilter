/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.ImageModel;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Treeze-Dev
 */
public class ImagePreviewView extends JFrame {

    private ImageModel _image;
    private ImageIcon _ico;
    private JLabel _lbl;

    public ImagePreviewView(ImageModel image) {
        setLayout(new FlowLayout());
        _image = image;
        _ico = new ImageIcon(_image.getImage());
        _lbl = new JLabel(_ico);
        _lbl.setIcon(_ico);
        this.setIconImage(_image.getImage());
        add(_lbl);
    }
}
