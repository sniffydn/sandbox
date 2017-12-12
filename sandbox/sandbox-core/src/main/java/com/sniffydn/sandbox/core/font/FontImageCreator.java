package com.sniffydn.sandbox.core.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FontImageCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


//        int count = 0;
//
//        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
//        Font[] fonts = e.getAllFonts(); // Get the fonts
//
//        for (Font f : fonts) {
//            count++;
//            String fontName = f.getFontName();
//            System.out.println(f.getFontName());
//
//            String text = "The quick brown fox jumps over the lazy dog";
//
//            createImage(fontName, text, "fox");
//
//            for (int i = 'A'; i <= 'Z'; i++) {
//                createImage(fontName, "" + (char) i, "" + i);
//            }
//
//            for (int i = 'a'; i <= 'z'; i++) {
//                createImage(fontName, "" + (char) i, "" + i);
//            }
//
////            if (count > 150) {
////                break;
////            }
//        }

    }

    private static void createImage(String fontName, String text, String filePrefix) {
        createImage(fontName, text, filePrefix, 0, 0, 0, 0, 0);
    }

    private static void createImage(String fontName, String text, String filePrefix, int translateX, int translateY, int addToWidth, int addToHeight, int count) {
        try {
            /*
             Because font metrics is based on a graphics context, we need to create
             a small, temporary image so we can ascertain the width and height
             of the final image
             */
            BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            Font font = new Font(fontName, Font.PLAIN, 48);
            g2d.setFont(font);
            FontMetrics fm = g2d.getFontMetrics();
            int width = Math.abs(fm.stringWidth(text));
            if (width <= 0) {
                width = 100;
            }
            width += addToWidth;
            int height = Math.abs(fm.getHeight());
            if (height <= 0) {
                height = 10;
            }
            height += addToHeight;
            g2d.dispose();

            img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = img.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2d.setFont(font);
            fm = g2d.getFontMetrics();
            g2d.setColor(Color.BLACK);
            g2d.drawString(text, translateX, translateY + fm.getAscent());
            g2d.dispose();

            //try to prevent stack overflow exception
            if (count < 500) {
                boolean greyOnTop = false;
                boolean greyOnBottom = false;
                boolean greyOnLeft = false;
                boolean greyOnRight = false;

                for (int i = 0; i < width; i++) {
                    //check for 1 pixel of white space at the top and bottom of the image
                    if (img.getRGB(i, 0) != 0) {
                        createImage(fontName, text, filePrefix, translateX, translateY + 1, addToWidth, addToHeight, count + 1);
                        return;
                    }
                    if (img.getRGB(i, height - 1) != 0) {
                        createImage(fontName, text, filePrefix, translateX, translateY, addToWidth, addToHeight + 1, count + 1);
                        return;
                    }

                    //check for 1 pixel of grey at the top and bottom of the image
                    if (!greyOnTop && img.getRGB(i, 1) != 0) {
                        greyOnTop = true;
                    }
                    if (!greyOnBottom && img.getRGB(i, height - 2) != 0) {
                        greyOnBottom = true;
                    }
                }

                if (!greyOnTop) {
                    createImage(fontName, text, filePrefix, translateX, translateY - 1, addToWidth, addToHeight, count + 1);
                    return;
                }

                if (!greyOnBottom) {
                    createImage(fontName, text, filePrefix, translateX, translateY, addToWidth, addToHeight - 1, count + 1);
                    return;
                }

                for (int i = 0; i < height; i++) {
                    //check for 1 pixel of white space at the left and right of the image
                    if (img.getRGB(0, i) != 0) {
                        createImage(fontName, text, filePrefix, translateX + 1, translateY, addToWidth, addToHeight, count + 1);
                        return;
                    }
                    if (img.getRGB(width - 1, i) != 0) {
                        createImage(fontName, text, filePrefix, translateX, translateY, addToWidth + 1, addToHeight, count + 1);
                        return;
                    }

                    //check for 1 pixel of grey at the left and right of the image
                    if (!greyOnLeft && img.getRGB(1, i) != 0) {
                        greyOnLeft = true;
                    }
                    if (!greyOnRight && img.getRGB(width - 2, i) != 0) {
                        greyOnRight = true;
                    }
                }

                if (!greyOnLeft) {
                    createImage(fontName, text, filePrefix, translateX - 1, translateY, addToWidth, addToHeight, count + 1);
                    return;
                }

                if (!greyOnRight) {
                    createImage(fontName, text, filePrefix, translateX, translateY, addToWidth - 1, addToHeight, count + 1);
                    return;
                }

                try {
                    File file = new File("C:\\TEMP\\Font\\" + fontName + "\\" + filePrefix + ".png");
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    ImageIO.write(img, "png", file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("AVOIDED Stack Overflow Exception: " + fontName + ", " + text + ", " + filePrefix + ", " + translateX + ", " + translateY + ", " + addToWidth + ", " + addToHeight + ", " + count);
            }

        } catch (Exception e) {
            System.out.println("Exception with: " + fontName + ", " + text + ", " + filePrefix + ", " + translateX + ", " + translateY + ", " + addToWidth + ", " + addToHeight + ", " + count);
            e.printStackTrace();
        }
    }

}
