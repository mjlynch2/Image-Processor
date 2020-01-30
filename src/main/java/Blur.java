import java.awt.*;
import java.awt.image.BufferedImage;

public class Blur implements ImageFilter {
    public BufferedImage filter(BufferedImage image) {
        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < image.getHeight(); y++) {
            for(int x = 0; x < image.getWidth(); x++){

                int redAverage = 0;
                int greenAverage = 0;
                int blueAverage = 0;


                for(int i = -1; i < 2; i++) {
                    for(int j = -1; j < 2; j++) {

                        try {
                            int nearbyRGB = image.getRGB(x + i, y + j);
                            int redNearby = (nearbyRGB >> 16) & 0xff;
                            redAverage += redNearby;
                            int greenNearby = (nearbyRGB >> 8) & 0xff;
                            greenAverage += greenNearby;
                            int blueNearby = (nearbyRGB >> 0) & 0xff;
                            blueAverage += blueNearby;
                        }
                        catch (ArrayIndexOutOfBoundsException error){
                            System.out.println(error);
                        }

                    }
                }

                redAverage = redAverage / 6;
                greenAverage = greenAverage / 6;
                blueAverage = blueAverage/ 6;

                int newRGB = (redAverage << 16) | (greenAverage << 8) | blueAverage;
                result.setRGB(x, y, newRGB);
            }
        }
        return result;
    }
}
