package com.sniffydn.sandbox.core.font;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;

/**
 *
 * @author dnyffeler
 */
public class FontComparison {

    private static List<String> fontList = new ArrayList<String>();
    static {
        fontList.add("AGaramondPro-Regular");
fontList.add("AGaramondPro-Italic");
fontList.add("AGaramondPro-Semibold");
fontList.add("AGaramondPro-SemiboldItalic");
fontList.add("AGaramondPro-Bold");
fontList.add("AGaramondPro-BoldItalic");
fontList.add("AmericanaStd-Italic");
fontList.add("AmericanaStd-Bold");
fontList.add("AmericanaStd-ExtraBold");
fontList.add("BernhardModernStd-Roman");
fontList.add("BernhardModernStd-Italic");
fontList.add("BodoniStd");
fontList.add("BodoniStd-Italic");
fontList.add("BodoniStd-Bold");
fontList.add("BodoniStd-BoldItalic");
fontList.add("BookmanOldStyleStd");
fontList.add("BookmanOldStyleStd-Italic");
fontList.add("BookmanOldStyleStd-BoldIt");
fontList.add("ClarendonLTStd-Light");
fontList.add("ClarendonLTStd");
fontList.add("Clarendon Com Bold Expanded");
fontList.add("GoudyOlSt BT Roman");
fontList.add("GoudyOlSt BT Italic");
fontList.add("GoudyOlSt BT Bold");
fontList.add("HorleyOldStyleMTStd-Light");
fontList.add("HorleyOldStyleMTStd-LightIt");
fontList.add("HorleyOldStyleMTStd-Italic");
fontList.add("HorleyOldStyleMTStd");
fontList.add("HorleyOldStyleMTStd-Bold");
fontList.add("HorleyOldStyleMTStd-BoldIt");
fontList.add("ItaliaStd-Medium");
fontList.add("NewBaskervilleStd-Roman");
fontList.add("NewBaskervilleStd-Italic");
fontList.add("NewBaskervilleStd-Bold");
fontList.add("NewBaskervilleStd-BoldIt");
fontList.add("PerpetuaMTStd");
fontList.add("AnnaITCStd");
fontList.add("BauhausStd-Medium");
fontList.add("Biographer");
fontList.add("BrunoJBStd");
fontList.add("CafeBrasil");
fontList.add("CassandraEF-Light");
fontList.add("CharcuterieDeco");
fontList.add("CharcuterieEngraved");
fontList.add("CharcuterieEtched");
fontList.add("CharcuterieSerif");
fontList.add("CloisterStd-OpenFace");
fontList.add("EccentricStd");
fontList.add("Frosted");
fontList.add("GalliaMTStd");
fontList.add("GillSansShadowMTStd");
fontList.add("Helvetica Neue LT Com 75 Bold Outline");
fontList.add("HoneyBee");
fontList.add("MachineStd");
fontList.add("MonaLisaStd-Recut");
fontList.add("MonaLisaStd-Solid");
fontList.add("TiffanyStd-Heavy");
fontList.add("TiffanyStd-HeavyItalic");
fontList.add("KG Love You Through It");
fontList.add("KG Second Chances Sketch");
fontList.add("LadyRene");
fontList.add("Lemonade ICG");
fontList.add("Markerfield-Regular");
fontList.add("Nexa Rust Sans Black 03");
fontList.add("Nexa Rust Script R 02");
fontList.add("OldEnglishTextMTStd");
fontList.add("ParisianStd");
fontList.add("RosewoodStd-Fill");
fontList.add("SackersSolidAntiqueStd");
fontList.add("SchmutzPro-Cleaned");
fontList.add("Sketchley BT");
fontList.add("SmaragdLTStd");
fontList.add("Stencil BT");
fontList.add("TouchToneLight");
fontList.add("VivaStd-Bold");
fontList.add("Zebrawood Std - Regular ");//not found
fontList.add("Futura Com Extra Bold");
fontList.add("FuturaStd-Light");
fontList.add("FuturaStd-Book");
fontList.add("FuturaStd-Bold");
fontList.add("GillSansMTStd-Light");
fontList.add("GillSansMTStd-LightItalic");
fontList.add("GillSansMTStd-Medium");
fontList.add("GillSansMTStd-MediumItalic");
fontList.add("GillSansMTStd-Bold");
fontList.add("HarmoniaSansStd-Light");
fontList.add("HarmoniaSansStd-LightItalic");
fontList.add("Helvetica Neue LT Com 77 Bold Condensed");
fontList.add("HelveticaNeueLTStd-ThCn");
fontList.add("HelveticaNeueLTStd-Cn");
fontList.add("HelveticaNeueLTStd-CnO");
fontList.add("HelveticaNeueLTStd-XBlkCn");
fontList.add("HelveticaNeueLTStd-Th");
fontList.add("HelveticaNeueLTStd-Roman");
fontList.add("HelveticaNeueLTStd-It");
fontList.add("HelveticaNeueLTStd-Bd");
fontList.add("HelveticaNeueLTStd-BdIt");
fontList.add("HelveticaNeueLTStd-ThEx");
fontList.add("HelveticaNeueLTStd-ExO");
fontList.add("HelveticaNeueLTStd-BdEx");
fontList.add("ITCAvantGardeStd-XLt");
fontList.add("ITCAvantGardeStd-XLtCn");
fontList.add("ITCAvantGardeStd-Md");
fontList.add("ITCAvantGardeStd-MdObl");
fontList.add("ITCAvantGardeStd-Bold");
fontList.add("ITCKabelStd-Book");
fontList.add("ITCKabelStd-Medium");
fontList.add("ITCKabelStd-Demi");
fontList.add("KahloLightPro");
fontList.add("KahloLightPro-Italic");
fontList.add("MyriadPro-Regular");
fontList.add("MyriadPro-It");
fontList.add("MyriadPro-Bold");
fontList.add("OceanSansStd-Book");
fontList.add("OceanSansStd-BookIta");
fontList.add("OptimaLTStd-Medium");
fontList.add("OptimaLTStd-Italic");
fontList.add("OptimaLTStd-Black");
fontList.add("UniversLTStd-LightCn");
fontList.add("UniversLTStd-Cn");
fontList.add("UniversLTStd-CnObl");
fontList.add("UniversLTStd-UltraCn");
fontList.add("UniversLTStd-BoldCn");
fontList.add("UniversLTStd-BoldCnObl");
fontList.add("BelovedSans");
fontList.add("CopperplateGothicStd-31BC");
fontList.add("Engravers MT - Regular");//not found
fontList.add("HandleOldstyleStd");
fontList.add("LifeEF-RegularSC");
fontList.add("SackersRomanStd-Light");
fontList.add("SerlioLTStd");
fontList.add("TrajanPro-Bold");
fontList.add("CaeciliaLTStd-Light");
fontList.add("CaeciliaLTStd-LightItalic");
fontList.add("CaeciliaLTStd-Roman");
fontList.add("CaeciliaLTStd-Italic");
fontList.add("CaeciliaLTStd-Heavy");
fontList.add("CaeciliaLTStd-HeavyItalic");
fontList.add("MemphisLTStd-Light");
fontList.add("MemphisLTStd-Medium");
fontList.add("MemphisLTStd-MediumItalic");
fontList.add("MemphisLTStd-Bold");
fontList.add("MemphisLTStd-ExtraBold");
fontList.add("AmericanTypewriterStd-Light");
fontList.add("AmericanTypewriterStd-LtCnd");
fontList.add("AmericanTypewriterStd-Med");
fontList.add("AmericanTypewriterStd-Bold");
fontList.add("PrestigeEliteStd");
fontList.add("PrestigeEliteStd-Slanted");

    }

    public static void main(String[] args) {
        File mono = new File("C:\\TEMP\\Font\\1MonoType");
        File repCandidates = new File("C:\\TEMP\\Font\\2ReplacementCandidates");
        File resultPath = new File("C:\\TEMP\\Font\\3Results");

        int count = 0;
        int min = 210;   //210 - 312
        int max = 312;

        System.out.println("Min: " + min + "  Max: " + max);
        long time = System.currentTimeMillis();
        for (File m : mono.listFiles()) {

            count++;

            if (count > min && count < max && fontList.contains(m.getName())) {
                for (File n : m.listFiles()) {
                    for (File r : repCandidates.listFiles()) {
                        File fileA = n;
                        File fileB = new File(r.getPath() + "\\" + n.getName());
                        if (fileB.exists()) {
                            File resultFile = new File(resultPath + "\\" + m.getName() + "\\" + r.getName() + "\\" + n.getName());
                            compareImages(fileA, fileB, resultFile);
                        }
                    }
                    System.out.println("      " + n.getName() + ", Elapsed Time: " + (System.currentTimeMillis() - time));
                }
                System.out.println("Finished (" + count +") " + m.getName() + ", Elapsed Time: " + (System.currentTimeMillis() - time));
                time = System.currentTimeMillis();
            }
        }
    }

    private static void compareImages(File fileA, File fileB, File resultFile) {
        try {
            BufferedImage imgA = null;
            BufferedImage imgB = null;
            BufferedImage resultImage = null;
            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);

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
                        if (cB.getRGB() != 0) {
                            onPixelCount++;
                        }
                    }
                }
            }

            int percentage = (int) (100 * ((double) onPixelCount / (onPixelCount + offPixelCount)));

            if (percentage > 40) {
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("   " + fileA + ", " + fileB + ", " + resultFile);
        }
    }
}
