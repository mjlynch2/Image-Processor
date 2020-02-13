package com.example.imageprocessor;

import com.example.imageprocessor.filters.ImageProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.image.BufferedImage;
import java.io.File;

@SpringBootApplication
public class ImageProcessorApplication {

	public static void main(String[] args) {
		ImageProcessor p = new ImageProcessor();
		BufferedImage imageWithFilter = p.getNewImage();

		JFileChooser chooserSave = new JFileChooser();
		FileNameExtensionFilter imgExtensionFilter = new FileNameExtensionFilter("jpg", "jpg");
		chooserSave.setFileFilter(imgExtensionFilter);
		int returnVal = chooserSave.showSaveDialog(chooserSave);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			String fileName = chooserSave.getSelectedFile().getAbsolutePath();
			try {
				ImageIO.write(imageWithFilter, "jpg", new File(fileName + ".jpg"));
			}
			catch(Exception e) {
				System.out.println(e);
				System.exit(0);
			}
		}
		else{
			System.exit(0);
		}

		SpringApplication.run(ImageProcessorApplication.class, args);
	}

}
