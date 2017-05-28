/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Services.ImageService;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lab656
 */
public class Image {

    private File _file;

    private BufferedImage _image;

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    private String fileName;

    public File getFile() {
        return _file;
    }

    public void setFile(File file) {
        this._file = file;
        this.fileName = file.getName();
        this.path = file.getAbsolutePath();
        transFormImage();
    }

    public BufferedImage getImage() {
        return _image;
    }

    public void SetImage(BufferedImage image) {
        ImageService iS = new ImageService();
        if (iS.getFileExtension(_file).compareTo("png") == 0) {
            _image = new BufferedImage(image.getWidth(), image.getHeight(), TYPE_INT_ARGB);
        } else {
            _image = new BufferedImage(image.getWidth(), image.getHeight(), TYPE_INT_RGB);
        }

    }

    private void transFormImage() {
        try {
            _image = ImageIO.read(_file);
        } catch (IOException ex) {
            Logger.getLogger(Image.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image() {

    }

}
