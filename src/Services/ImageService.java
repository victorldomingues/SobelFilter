/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Image;
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

    private final String outputpath = "C:\\Users\\Victor-PC\\Desktop";
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

        for (int i = 0; i < _processedImage.getImage().getWidth(); i++) {
            for (int j = 0; j < _processedImage.getImage().getHeight(); j++) {

                int[][] mascara = new int[3][3];
                int cont1 = -1;

                //preeche a mascara 3x3 corretamente
                for (int k = 0; k < mascara.length; k++) {
                    int cont2 = -1;
                    for (int l = 0; l < mascara.length; l++) {
                        int iCount = i + cont1;
                        int jCount = j + cont2;
                        if (iCount == -1) {
                            iCount = height - 1;
                        }
                        if (iCount == (height)) {
                            iCount = 0;
                        }
                        if (jCount == -1) {
                            jCount = width - 1;
                        }
                        if (jCount == (width)) {
                            jCount = 0;
                        }
                        mascara[k][l] = _processedImage.getImage().getRGB(iCount, jCount);
                        cont2++;
                    }
                    cont1++;
                }

                imgH[i][j] = Convolution(mascara);
                imgV[i][j] = Correlation(mascara);
                
                _processedImage.getImage().setRGB(j, i, imgV[i][j]);

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
                retorno += Gy[i][j] * mascara[i][j];
            }
        }

        return retorno;
    }

}
