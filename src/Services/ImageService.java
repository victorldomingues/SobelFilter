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
 * @author Treeze-Dev
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

        _processedImage = new Image();
        File outputfile = new File(outputpath + "result.jpg");
        try {
            ImageIO.write(_image.getImage(), "jpg", outputfile);
            _processedImage.setFile(outputfile);
        } catch (IOException ex) {
            Logger.getLogger(ImageService.class.getName()).log(Level.SEVERE, null, ex);
        }

        int width = _processedImage.getImage().getWidth();
        int height = _processedImage.getImage().getHeight();

        //imagem que será alterada horizontalmente
        int[][] imgH = new int[width][height];
        //imagem que será alterada verticalmente
        int[][] imgV = new int[width][height];
        //imagem que terá o valor a ser passado para _processedImage
        int[][] imgFinal = new int[width][height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                int[][] mascara = new int[3][3];
                int cont1 = -1;

                for (int k = 0; k < mascara.length; k++) {
                    int cont2 = -1;
                    for (int l = 0; l < mascara.length; l++) {
                        int iCount = i + cont1;
                        int jCount = j + cont2;
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
                            int rgb = 
                                    (new Color(_processedImage.getImage().getRGB(jCount, iCount)).getBlue()
                                    + new Color(_processedImage.getImage().getRGB(jCount, iCount)).getRed()
                                    + new Color(_processedImage.getImage().getRGB(jCount, iCount)).getGreen())/ 3 ;
                            mascara[k][l] = rgb;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        cont2++;
                    }
                    cont1++;
                }

                imgH[j][i] = Convolution(mascara);
                imgV[j][i] = Correlation(mascara);

            }

        }

        for (int k = 0; k < height; k++) {
            for (int l = 0; l < width; l++) {
                imgFinal[l][k] = (int) Math.sqrt((imgH[l][k] * imgH[l][k]) + (imgV[l][k] * imgV[l][k]));
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

    }

    public int Convolution(int[][] mascara) {
        int[][] Gx = {{-1, 0, 1},
        {-2, 0, 2},
        {-1, 0, 1}};

        int retorno = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                retorno += Gx[i][j] * mascara[i][j];
            }
        }

        return retorno;
    }

    public int Correlation(int[][] mascara) {
        int[][] Gy = {{1, 2, 1},
        {0, 0, 0},
        {-1, -2, -1}};

        int retorno = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int maskValue = mascara[i][j];
                retorno += Gy[i][j] * maskValue;
            }
        }

        return retorno;
    }

}
