package com.example.imageprocessor;

import com.example.imageprocessor.filters.ImageProcessor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class Controller {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

//    @RequestMapping("/random")
//    public BufferedImage randomImage() {
//        ImageProcessor p = new ImageProcessor();
//        return p.getNewImage();
//        $('#myImg').attr('src', base64Img);
    }

