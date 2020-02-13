package com.imageprocessor.demo.filters;

import com.example.imageprocessor.filters.ImageFilter;

import java.awt.image.BufferedImage;

public class Sepia implements ImageFilter {
    public BufferedImage filter(BufferedImage image){
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                double redNew = (red * 0.393) + (green * 0.769) + (blue * 0.189);
                double greenNew = (red * .349) + (green * .686) + (blue * .168);
                double blueNew = (red * .272) + (green * .534) + (blue * .131);

                if (redNew > 255) {
                    redNew = 255;
                }
                if (greenNew > 255) {
                    greenNew = 255;
                }
                if (blueNew > 255) {
                    blueNew = 255;
                }

                int newRGB = ((int) redNew << 16) | ((int) greenNew << 8) | (int) blueNew;
                result.setRGB(x, y, newRGB);
            }
        }
        return result;
    }
}
