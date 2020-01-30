import java.awt.image.BufferedImage;

public class BlackWhite implements ImageFilter {

    public BufferedImage filter(BufferedImage image) {

        BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                int redInt = rgb >> 16 & 0xff;
                int greenInt = rgb >> 8 & 0xff;
                int blueInt = rgb & 0xff;

                int blackWhiteRGB = (int) ((0.3 * redInt) + (0.59 * greenInt) + (0.11 * blueInt));

                int newPixel = (blackWhiteRGB << 16) | (blackWhiteRGB << 8) | blackWhiteRGB;

                result.setRGB(x, y, newPixel);
            }
        }
        return result;
    }
}
