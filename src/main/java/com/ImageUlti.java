package com;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ImageUlti {
    public void saveFileFromUrl(String imageUrl, String destination) {
        try {
            URL url = new URL(imageUrl);
//            InputStream in = new BufferedInputStream(url.openStream());
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            byte[] buf = new byte[1024];
//            int n = 0;
//            while (-1 != (n = in.read(buf))) {
//                out.write(buf, 0, n);
//            }
//            out.close();
//            in.close();
//            byte[] response = out.toByteArray();
//            FileOutputStream fos = new FileOutputStream(destination);
//            fos.write(response);
//            fos.close();
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(destination);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();

//            URL website = new URL("http://www.website.com/information.asp");
//            try (InputStream in = website.openStream()) {
//                Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void compareSizeImage(File fileA, File fileB) {
        float percentage = 0;
        try {
            BufferedImage biA = ImageIO.read(fileA);
            DataBuffer dbA = biA.getData().getDataBuffer();
            int sizeA = dbA.getSize();
            BufferedImage biB = ImageIO.read(fileB);
            DataBuffer dbB = biB.getData().getDataBuffer();
            int sizeB = dbB.getSize();
            int count = 0;
            if (sizeA == sizeB) {
                for (int i = 0; i < sizeA; i++) {

                    if (dbA.getElem(i) == dbB.getElem(i)) {
                        count = count + 1;
                    }

                }
                percentage = (count * 100) / sizeA;
            } else {
                System.out.println("Both the images are not of same size");
            }

        } catch (Exception e) {
            System.out.println("Failed to compare image files ...");
        }
        System.out.println("same size: " + percentage);
    }

    public void compareWithImage(File fileA, File fileB) throws IOException {
        BufferedImage img1 = ImageIO.read(fileA);
        BufferedImage img2 = ImageIO.read(fileB);
        int w1 = img1.getWidth();
        int w2 = img2.getWidth();
        int h1 = img1.getHeight();
        int h2 = img2.getHeight();
        if ((w1 != w2) || (h1 != h2)) {
            System.out.println("Both images should have same dimwnsions");
        } else {
            long diff = 0;
            for (int j = 0; j < h1; j++) {
                for (int i = 0; i < w1; i++) {
                    //Getting the RGB values of a pixel
                    int pixel1 = img1.getRGB(i, j);
                    Color color1 = new Color(pixel1, true);
                    int r1 = color1.getRed();
                    int g1 = color1.getGreen();
                    int b1 = color1.getBlue();
                    int pixel2 = img2.getRGB(i, j);
                    Color color2 = new Color(pixel2, true);
                    int r2 = color2.getRed();
                    int g2 = color2.getGreen();
                    int b2 = color2.getBlue();
                    //sum of differences of RGB values of the two images
                    long data = Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
                    diff = diff + data;
                }
            }
            double avg = diff / (w1 * h1 * 3);
            double percentage = (avg / 255) * 100;
            System.out.println("Difference: " + percentage);
        }
    }
}

