package com.example.imageprocessor.filters;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageProcessor {

    private static ImageFilter f;
    private static BufferedImage image;

    public static BufferedImage getNewImage() {
        try {
            URL imageUrl = new URL("https://pixabay.com/get/55e2d4474950b108f5d08460962933771636d9e0564c704c7d2e7dd6924dc15e_1280.jpg");
            image = ImageIO.read(imageUrl.openStream());
        }
        catch (IOException e) {
            System.out.println(e);
    }
        f = new com.imageprocessor.demo.filters.Blur();
        BufferedImage imageWithFilter = f.filter(image);

        return imageWithFilter;
    }



}
