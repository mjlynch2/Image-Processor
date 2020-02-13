package com.imageprocessor.demo.filters;

import java.awt.image.BufferedImage;

public interface ImageFilter {

    BufferedImage filter(BufferedImage image);

}
