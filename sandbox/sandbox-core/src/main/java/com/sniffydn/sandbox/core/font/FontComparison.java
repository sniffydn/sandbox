package com.sniffydn.sandbox.core.font;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

/**
 *
 * @author dnyffeler
 */
public class FontComparison {

    public static void main(String[] args) {
        File mono = new File("C:\\TEMP\\Font\\1MonoType");
        File repCandidates = new File("C:\\TEMP\\Font\\2ReplacementCandidates");
        File resultPath = new File("C:\\TEMP\\Font\\3Results");

        for (File m : mono.listFiles()) {
            for (File n : m.listFiles()) {
                for (File r : repCandidates.listFiles()) {
                    File fileA = n;
                    File fileB = new File(r.getPath() + "\\" + n.getName());
                    File resultFile = new File(resultPath + "\\" + m.getName() + "\\" + r.getName() + "\\" + n.getName());
                    compareImages(fileA, fileB, resultFile);
                }
            }
        }

//        File resultFile = new File("C:\\TEMP\\Font\\3Results\\AachenStd-Bold\\Akron\\65.png");
//        File fileA = new File("C:\\TEMP\\Font\\1MonoType\\AachenStd-Bold\\65.png");
//        File fileB = new File("C:\\TEMP\\Font\\2ReplacementCandidates\\Akron\\65.png");
//        compareImages(fileA, fileB, resultFile);
    }

    private static void compareImages(File fileA, File fileB, File resultFile) {
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        BufferedImage resultImage = null;
        try {

            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);

        } catch (IOException e) {
            System.out.println(e);
        }
        int width1 = imgA.getWidth();
        int maxWidth = width1;
        int width2 = imgB.getWidth();
        if (width2 > maxWidth) {
            maxWidth = width2;
        }
        int height1 = imgA.getHeight();
        int maxHeight = height1;
        int height2 = imgB.getHeight();
        if (height2 > maxHeight) {
            maxHeight = height2;
        }

        while (height1 < maxHeight && width1 < maxWidth) {
            height1++;
            width1++;
        }

        while (height2 < maxHeight && width2 < maxWidth) {
            height2++;
            width2++;
        }

        BufferedImage tempA = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
        tempA.getGraphics().drawImage(imgA.getScaledInstance(width1, height1, Image.SCALE_AREA_AVERAGING), 0, 0, null);
        imgA = tempA;

        resultImage = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);

        Graphics resultGraphics = resultImage.getGraphics();
        resultGraphics.drawImage(imgA, 0, 0, null);

        BufferedImage tempB = new BufferedImage(maxWidth, maxHeight, BufferedImage.TYPE_INT_ARGB);
        tempB.getGraphics().drawImage(imgB.getScaledInstance(width2, height2, Image.SCALE_AREA_AVERAGING), 0, 0, null);
        imgB = tempB;

        Color cA;
        Color cB;
        int offPixelCount = 0;
        int onPixelCount = 0;
        for (int y = 0; y < maxHeight; y++) {
            for (int x = 0; x < maxWidth; x++) {
                cA = new Color(imgA.getRGB(x, y), true);
                cB = new Color(imgB.getRGB(x, y), true);

                if (cA.getRGB() != cB.getRGB() && Math.abs(cA.getAlpha() - cB.getAlpha()) > 30) {
                    offPixelCount++;
                    if (cB.getAlpha() == 0) {
                        resultGraphics.setColor(new Color(cB.getRed(), 255, cB.getBlue(), 128));
                    } else {
                        resultGraphics.setColor(new Color(255, cB.getGreen(), cB.getBlue(), (int) (cB.getAlpha() * .75) + 20));
                    }
                    resultGraphics.fillRect(x, y, 1, 1);

                } else {
                    onPixelCount++;
                }

//                int rgbA = imgA.getRGB(x, y);
//                int rgbB = imgB.getRGB(x, y);
//
//
//                int redA = (rgbA >> 16) & 0xff;
//                int greenA = (rgbA >> 8) & 0xff;
//                int blueA = (rgbA) & 0xff;
//                int redB = (rgbB >> 16) & 0xff;
//                int greenB = (rgbB >> 8) & 0xff;
//                int blueB = (rgbB) & 0xff;
//                System.out.println(redA + " " + redB + "   " + greenA + " " + greenB + "   " + blueA + " " + blueB);
//                if (rgbA != rgbB) {
//                    resultGraphics.setColor(new Color(255, greenB, blueB, 128));
//                    resultGraphics.fillRect(x, y, 1, 1);
//                }
            }
        }

        int percentage = (int) (100 * ((double) onPixelCount / (onPixelCount + offPixelCount)));

        if (percentage > 75) {
            String path = resultFile.getPath();
            path = path.replaceFirst(Pattern.quote(".png"), "_" + percentage + ".png");

            resultFile = new File(path);
            try {

                if (!resultFile.getParentFile().exists()) {
                    resultFile.getParentFile().mkdirs();
                }
                ImageIO.write(resultImage, "png", resultFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
//            // Total number of red pixels = width * height
//        // Total number of blue pixels = width * height
//        // Total number of green pixels = width * height
//        // So total number of pixels = width * height * 3
//        double total_pixels = width1 * height1 * 3;
//
//            // Normalizing the value of different pixels
//        // for accuracy(average pixels per color
//        // component)
//        double avg_different_pixels = difference
//                / total_pixels;
//
//        // There are 255 values of pixels in total
//        double percentage = (avg_different_pixels
//                / 255) * 100;
//
//        System.out.println("Difference Percentage-->"
//                + percentage);
    }
}
