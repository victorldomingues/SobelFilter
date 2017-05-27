/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Image;
import Views.ImageSelectView;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Treeze-Dev
 */
public class ImageService {

    private Image _image;

    private Image _processedImage;

    public ImageService(Image i) {
        _image = i;
    }

    public ImageService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Image AplyFilter() {
        Process();
        return _processedImage;
    }

    private void Process() {

        BufferedImage bi;
        try {

            bi = ImageIO.read(_image.getFile());
            int width = bi.getWidth();
            int height = bi.getHeight();

        } catch (IOException ex) {
            Logger.getLogger(ImageSelectView.class.getName()).log(Level.SEVERE, null, ex);
        }

        _processedImage = new Image();
    }
}
