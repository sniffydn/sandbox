package com.sniffydn.sandbox.core;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dnyffeler
 */
public class DinosaurJumper {

    private static Color c;
    private static BufferedImage image;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            int up = KeyEvent.VK_UP;
            int size = 10;
            int count = 0;

            while (true) {
                count = 0;
                Point p = MouseInfo.getPointerInfo().getLocation();

                image = robot.createScreenCapture(new Rectangle(p.x, p.y, size, size));
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
//                        System.out.println(i + ", " + j + "   " + image.getRGB(i, j));
                        if (image.getRGB(i, j) == -11316397) {
                            count++;

                        }
                    }
                }
                if (count > 0) {
                    robot.keyPress(up);

                    Thread.sleep(count * 50);

                    robot.keyRelease(up);
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(DinosaurJumper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
