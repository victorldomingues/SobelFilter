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



        int width = _image.getImage().getWidth();
        int height = _image.getImage().getHeight();

        System.out.println("w: " + width);
        System.out.println("h: " + height);

        _processedImage = new Image();

        //imagem que será alterada horizontalmente
        int[][] imgH = new int[_image.getImage().getWidth()][_image.getImage().getHeight()];
        //imagem que será alterada verticalmente
        int[][] imgV = new int[_image.getImage().getWidth()][_image.getImage().getHeight()];

        for (int i = 0; i < _image.getImage().getWidth(); i++) {
            for (int j = 0; j < _image.getImage().getHeight(); j++) {
                
                int [][]mascara = new int[3][3];
                int cont1=-1;
                
                //preeche a mascara 3x3 corretamente
                for (int k = 0; k < mascara.length; k++) {
                    int cont2=-1;
                    for (int l = 0; l < mascara.length; l++) {
                        mascara[k][l]=_image.getImage().getRGB(i+cont1, j+cont2);
                        cont2++;
                    }
                    cont1++;
                }
                
                
                imgH[i][j] = Convolution(mascara);
                imgV[i][j] = Correlation(mascara);
                
            }
        }

    }

    public int Convolution(int[][] mascara) {
        int[][] Gx = {{-1, 0, 1},
                     {-2, 0, 2},
                     {-1, 0, 1}};
        
        int retorno=0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                retorno += Gx[i][j]*mascara[i][j];
            }
        }
        
        
        return retorno;
    }
    
    public int Correlation(int[][] mascara){
        int[][] Gy = {{1, 2, 1},
                     {0, 0, 0},
                     {-1, -2, -1}};
        
        int retorno=0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                retorno += Gy[i][j]*mascara[i][j];
            }
        }
        
        
        return retorno;        
    }

}
