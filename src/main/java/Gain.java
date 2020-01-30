import java.awt.image.BufferedImage;

public class Gain implements ImageFilter {
    public BufferedImage filter(BufferedImage image){
// User will set this value, 0<x<2
        final double gainValue = 0.5;

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);

                int red = (rgb >> 16) & 0xff;
                int green = (rgb >> 8) & 0xff;
                int blue = rgb & 0xff;

                red *= gainValue;
                green *= gainValue;
                blue *= gainValue;

                if(red > 255){
                    red = 255;
                }
                if(green > 255){
                    green = 255;
                }
                if(blue > 255){
                    blue = 255;
                }

                int newRGB = (red << 16) | (green << 8) | blue;
                result.setRGB(x,y, newRGB);
            }
        }
        return result;
    }
}
