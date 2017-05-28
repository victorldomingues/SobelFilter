/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Image;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Victor-PC
 */
public class ImageService {

    private final String outputpath = "";

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

        String ext = getFileExtension(_image.getFile());
        _processedImage = new Image();

        File outputfile = new File(outputpath + "result." + ext);

        try {

            ImageIO.write(_image.getImage(), ext, outputfile);
            _processedImage.setFile(outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
        }

        int width = _processedImage.getImage().getWidth();

        int height = _processedImage.getImage().getHeight();

        int[][] imgH = new int[width][height];

        int[][] imgV = new int[width][height];

        int[][] imgFinal = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int[][] mask = new int[3][3];
                int counter1 = -1;

                for (int k = 0; k < mask.length; k++) {
                    int counter2 = -1;
                    for (int l = 0; l < mask.length; l++) {
                        int iCount = i + counter1;
                        int jCount = j + counter2;
                        if (iCount == -1) {
                            iCount = height - 1;
                        }
                        if (iCount >= (height)) {
                            iCount = 0;
                        }
                        if (jCount == -1) {
                            jCount = width - 1;
                        }
                        if (jCount >= (width)) {
                            jCount = 0;
                        }
                        try {
                            int rgb
                                    = (new Color(_processedImage.getImage().getRGB(jCount, iCount)).getBlue()
                                    + new Color(_processedImage.getImage().getRGB(jCount, iCount)).getRed()
                                    + new Color(_processedImage.getImage().getRGB(jCount, iCount)).getGreen()) / 3;
                            mask[k][l] = rgb;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        counter2++;
                    }
                    counter1++;
                }

                imgH[j][i] = Convolution(mask);
                imgV[j][i] = Correlation(mask);

                int convulation = imgH[j][i];
                int correlation = imgV[j][i];
                int finalValue = (int) Math.sqrt((convulation * convulation) + (correlation * correlation));

                imgFinal[j][i] = finalValue;
            }

        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int rgb = imgFinal[j][i];
                if (rgb < 0) {
                    rgb = 0;
                }
                if (rgb > 255) {
                    rgb = 255;
                }
                _processedImage.getImage().setRGB(j, i, rgb);
            }
        }

        try {
            ImageIO.write(_processedImage.getImage(), ext, outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int Convolution(int[][] mask) {
        int[][] Gx = {{-1, 0, 1},
        {-2, 0, 2},
        {-1, 0, 1}};

        int returnValue = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                returnValue += Gx[i][j] * mask[i][j];
            }
        }

        return returnValue;
    }

    private int Correlation(int[][] mask) {
        int[][] Gy = {{1, 2, 1},
        {0, 0, 0},
        {-1, -2, -1}};

        int returnValue = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int maskValue = mask[i][j];
                returnValue += Gy[i][j] * maskValue;
            }
        }

        return returnValue;
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

}
