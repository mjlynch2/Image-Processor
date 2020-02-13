package com.example.imageprocessor.filters;

import java.awt.image.BufferedImage;

public interface ImageFilter {

    BufferedImage filter(BufferedImage image);

}
