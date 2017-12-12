package com.sniffydn.sandbox.core.font;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class FontImageCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        List<String> fontNames = new ArrayList<>();
//        fontNames.add("AGaramondPro-Bold");
//        fontNames.add("AGaramondPro-BoldItalic");
//        fontNames.add("AGaramondPro-Italic");
//        fontNames.add("AGaramondPro-Regular");
//        fontNames.add("AGaramondPro-Semibold");
//        fontNames.add("AGaramondPro-SemiboldItalic");
//
//        fontNames.add("EB Garamond Bold");
//        fontNames.add("EB Garamond Bold Italic");
//        fontNames.add("EB Garamond ExtraBold");
//        fontNames.add("EB Garamond ExtraBold Italic");
//        fontNames.add("EB Garamond Italic");
//        fontNames.add("EB Garamond Medium");
//        fontNames.add("EB Garamond Medium Italic");
//        fontNames.add("EB Garamond Regular");
//        fontNames.add("EB Garamond SemiBold");
//        fontNames.add("EB Garamond SemiBold Italic");
//
//        for (String fontName : fontNames) {
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
//        }

        int count = 0;
        List<String> ignoreFonts = new ArrayList<>();
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Adobe Wood Type Ornaments Two");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("AlteSchwabacherEF-RegularDfr");
        ignoreFonts.add("AlternateGothicEF-NoOne");
        ignoreFonts.add("AlternateGothicEF-NoThree");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Arial");
        ignoreFonts.add("Arial Black");
        ignoreFonts.add("Arial Bold");
        ignoreFonts.add("Arial Bold Italic");
        ignoreFonts.add("Arial Italic");
        ignoreFonts.add("Arial Narrow");
        ignoreFonts.add("Arial Narrow Bold");
        ignoreFonts.add("Arial Narrow Bold Italic");
        ignoreFonts.add("Arial Narrow Italic");
        ignoreFonts.add("Bahnschrift");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("BeastyEF-Regular");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("BibleScriptEF-Regular");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Blue Highway");
        ignoreFonts.add("Blue Highway   Bold");
        ignoreFonts.add("Blue Highway Condensed Regular");
        ignoreFonts.add("Blue Highway D Type");
        ignoreFonts.add("BodoniEF-DemiBoldCondIta");
        ignoreFonts.add("BodoniEF-Regular");
        ignoreFonts.add("BodoniEF-RegularIta");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Bundesbahn Pi 1");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Bundesbahn Pi 3");
        ignoreFonts.add("Calibri");
        ignoreFonts.add("Calibri Bold");
        ignoreFonts.add("Calibri Bold Italic");
        ignoreFonts.add("Calibri Italic");
        ignoreFonts.add("Calibri Light");
        ignoreFonts.add("Calibri Light Italic");
        ignoreFonts.add("Cambria");
        ignoreFonts.add("Cambria Bold");
        ignoreFonts.add("Cambria Bold Italic");
        ignoreFonts.add("Cambria Italic");
        ignoreFonts.add("Cambria Math");
        ignoreFonts.add("Candara");
        ignoreFonts.add("Candara Bold");
        ignoreFonts.add("Candara Bold Italic");
        ignoreFonts.add("Candara Italic");
        ignoreFonts.add("Caravan LH Four");
        ignoreFonts.add("Caravan LH One");
        ignoreFonts.add("Caravan LH Three");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("CarpediemEF-InitialsCaps");
        ignoreFonts.add("CarpediemEF-Regular");
        ignoreFonts.add("CentennialLTStd-Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Comic Sans MS");
        ignoreFonts.add("Comic Sans MS Bold");
        ignoreFonts.add("Comic Sans MS Bold Italic");
        ignoreFonts.add("Comic Sans MS Italic");
        ignoreFonts.add("Consolas");
        ignoreFonts.add("Consolas Bold");
        ignoreFonts.add("Consolas Bold Italic");
        ignoreFonts.add("Consolas Italic");
        ignoreFonts.add("Constantia");
        ignoreFonts.add("Constantia Bold");
        ignoreFonts.add("Constantia Bold Italic");
        ignoreFonts.add("Constantia Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Corbel");
        ignoreFonts.add("Corbel Bold");
        ignoreFonts.add("Corbel Bold Italic");
        ignoreFonts.add("Corbel Italic");
        ignoreFonts.add("Courier New");
        ignoreFonts.add("Courier New Bold");
        ignoreFonts.add("Courier New Bold Italic");
        ignoreFonts.add("Courier New Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("DIN1451EF-MittelNeu");
        ignoreFonts.add("Dialog.bold");
        ignoreFonts.add("Dialog.bolditalic");
        ignoreFonts.add("Dialog.italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("DialogInput.bold");
        ignoreFonts.add("DialogInput.bolditalic");
        ignoreFonts.add("DialogInput.italic");
        ignoreFonts.add("DialogInput.plain");
        ignoreFonts.add("Ebrima");
        ignoreFonts.add("Ebrima Bold");
        ignoreFonts.add("European Pi 1");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("European Pi 3");
        ignoreFonts.add("European Pi 4");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("FaceFaceEF-Solid");
        ignoreFonts.add("FairfieldLTStd-MediumItalic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("FerroStencilEF-MetalCutNegativ");
        ignoreFonts.add("Franklin Gothic Medium");
        ignoreFonts.add("Franklin Gothic Medium Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("FranklinGothicEF-Regular");
        ignoreFonts.add("FranklinGothicEF-RegularCond");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Freehand575 BT");
        ignoreFonts.add("FrutigerLTStd-Italic");
        ignoreFonts.add("FrutigerLTStd-LightItalic");
        ignoreFonts.add("FuturaEF-BoldCond");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Gabriola");
        ignoreFonts.add("Gadugi");
        ignoreFonts.add("Gadugi Bold");
        ignoreFonts.add("Georgia");
        ignoreFonts.add("Georgia Bold");
        ignoreFonts.add("Georgia Bold Italic");
        ignoreFonts.add("Georgia Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("GuardiLTStd-Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("GutenbergsTracesEF-RegularDfr");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("HelioEF-Three");
        ignoreFonts.add("HoloLens MDL2 Assets");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("ITC Stone Sans Phonetic IPA");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("ITC Stone Serif Phonetic IPA");
        ignoreFonts.add("Impact");
        ignoreFonts.add("JansonTextLTStd-Italic");
        ignoreFonts.add("Javanese Text");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("KaffeesatzEF-Weiss");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("LOOKAlikeEF-Full");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("LasertacStencilEF-RegularRough");
        ignoreFonts.add("Leelawadee UI");
        ignoreFonts.add("Leelawadee UI Bold");
        ignoreFonts.add("Leelawadee UI Semilight");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("LindsayEF-Regular");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Linotype Astrology Pi Two");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Linotype Decoration Pi 2");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Linotype Didot Ornaments Two");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Linotype Game Pi Dice Dominoes");
        ignoreFonts.add("Linotype Game Pi English Cards");
        ignoreFonts.add("Linotype Game Pi French Cards");
        ignoreFonts.add("Linotype Holiday Pi 1");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Linotype Holiday Pi 3");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Lucida Bright Demibold");
        ignoreFonts.add("Lucida Bright Demibold Italic");
        ignoreFonts.add("Lucida Bright Italic");
        ignoreFonts.add("Lucida Bright Regular");
        ignoreFonts.add("Lucida Console");
        ignoreFonts.add("Lucida Sans Demibold");
        ignoreFonts.add("Lucida Sans Regular");
        ignoreFonts.add("Lucida Sans Typewriter Bold");
        ignoreFonts.add("Lucida Sans Typewriter Regular");
        ignoreFonts.add("Lucida Sans Unicode");
        ignoreFonts.add("MS Gothic");
        ignoreFonts.add("MS PGothic");
        ignoreFonts.add("MS UI Gothic");
        ignoreFonts.add("MT Extra");
        ignoreFonts.add("MV Boli");
        ignoreFonts.add("Malgun Gothic");
        ignoreFonts.add("Malgun Gothic Bold");
        ignoreFonts.add("Malgun Gothic Semilight");
        ignoreFonts.add("Marlett");
        ignoreFonts.add("Mathematical Pi 1");
        ignoreFonts.add("Mathematical Pi 2");
        ignoreFonts.add("Mathematical Pi 3");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Mathematical Pi 5");
        ignoreFonts.add("Mathematical Pi 6");
        ignoreFonts.add("Meiryo");
        ignoreFonts.add("Meiryo Italic");
        ignoreFonts.add("Meiryo UI");
        ignoreFonts.add("Meiryo UI Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Microsoft Himalaya");
        ignoreFonts.add("Microsoft JhengHei");
        ignoreFonts.add("Microsoft JhengHei Bold");
        ignoreFonts.add("Microsoft JhengHei Light");
        ignoreFonts.add("Microsoft JhengHei UI");
        ignoreFonts.add("Microsoft JhengHei UI Bold");
        ignoreFonts.add("Microsoft JhengHei UI Light");
        ignoreFonts.add("Microsoft New Tai Lue");
        ignoreFonts.add("Microsoft New Tai Lue Bold");
        ignoreFonts.add("Microsoft PhagsPa");
        ignoreFonts.add("Microsoft PhagsPa Bold");
        ignoreFonts.add("Microsoft Sans Serif");
        ignoreFonts.add("Microsoft Tai Le");
        ignoreFonts.add("Microsoft Tai Le Bold");
        ignoreFonts.add("Microsoft YaHei");
        ignoreFonts.add("Microsoft YaHei Bold");
        ignoreFonts.add("Microsoft YaHei Light");
        ignoreFonts.add("Microsoft YaHei UI");
        ignoreFonts.add("Microsoft YaHei UI Bold");
        ignoreFonts.add("Microsoft YaHei UI Light");
        ignoreFonts.add("Microsoft Yi Baiti");
        ignoreFonts.add("MingLiU-ExtB");
        ignoreFonts.add("MingLiU_HKSCS-ExtB");
        ignoreFonts.add("Mongolian Baiti");
        ignoreFonts.add("Monospaced.bold");
        ignoreFonts.add("Monospaced.bolditalic");
        ignoreFonts.add("Monospaced.italic");
        ignoreFonts.add("Monospaced.plain");
        ignoreFonts.add("Myanmar Text");
        ignoreFonts.add("Myanmar Text Bold");
        ignoreFonts.add("Myriad Web Pro");
        ignoreFonts.add("Myriad Web Pro Bold");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("NOODlessEF-inType");
        ignoreFonts.add("NSimSun");
        ignoreFonts.add("NationalCodes Africa");
        ignoreFonts.add("NationalCodes America");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("NationalCodes Europe");
        ignoreFonts.add("NationalCodes Universal");
        ignoreFonts.add("NeueLutherscheFrakturEF-Regular");
        ignoreFonts.add("NewCenturySchlbkLTStd-Fra");
        ignoreFonts.add("NewCenturySchlbkLTStd-FraBd");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Nirmala UI");
        ignoreFonts.add("Nirmala UI Bold");
        ignoreFonts.add("Nirmala UI Semilight");
        ignoreFonts.add("OCRA");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("OCRB");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("PLAcardEF-Serif");
        ignoreFonts.add("PMingLiU-ExtB");
        ignoreFonts.add("Palatino Linotype");
        ignoreFonts.add("Palatino Linotype Bold");
        ignoreFonts.add("Palatino Linotype Bold Italic");
        ignoreFonts.add("Palatino Linotype Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("PapyrusEF-Regular");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("QuadruPetsEF-Dogs");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("RadiantEFDisplay-CondNo6");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("SansSerif.bold");
        ignoreFonts.add("SansSerif.bolditalic");
        ignoreFonts.add("SansSerif.italic");
        ignoreFonts.add("SansSerif.plain");
        ignoreFonts.add("Segoe MDL2 Assets");
        ignoreFonts.add("Segoe Print");
        ignoreFonts.add("Segoe Print Bold");
        ignoreFonts.add("Segoe Script Bold");
        ignoreFonts.add("Serif.bold");
        ignoreFonts.add("Serif.bolditalic");
        ignoreFonts.add("Serif.italic");
        ignoreFonts.add("Serif.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("SerifaStd-Italic");
        ignoreFonts.add("SerifaStd-LightItalic");
        ignoreFonts.add("SimSun");
        ignoreFonts.add("SimSun-ExtB");
        ignoreFonts.add("Sitka Banner");
        ignoreFonts.add("Sitka Banner Bold");
        ignoreFonts.add("Sitka Banner Bold Italic");
        ignoreFonts.add("Sitka Banner Italic");
        ignoreFonts.add("Sitka Display");
        ignoreFonts.add("Sitka Display Bold");
        ignoreFonts.add("Sitka Display Bold Italic");
        ignoreFonts.add("Sitka Display Italic");
        ignoreFonts.add("Sitka Heading");
        ignoreFonts.add("Sitka Heading Bold");
        ignoreFonts.add("Sitka Heading Bold Italic");
        ignoreFonts.add("Sitka Heading Italic");
        ignoreFonts.add("Sitka Small");
        ignoreFonts.add("Sitka Small Bold");
        ignoreFonts.add("Sitka Small Bold Italic");
        ignoreFonts.add("Sitka Small Italic");
        ignoreFonts.add("Sitka Subheading");
        ignoreFonts.add("Sitka Subheading Bold");
        ignoreFonts.add("Sitka Subheading Bold Italic");
        ignoreFonts.add("Sitka Subheading Italic");
        ignoreFonts.add("Sitka Text");
        ignoreFonts.add("Sitka Text Bold");
        ignoreFonts.add("Sitka Text Bold Italic");
        ignoreFonts.add("Sitka Text Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Sylfaen");
        ignoreFonts.add("Symbol");
        ignoreFonts.add("Tahoma");
        ignoreFonts.add("Tahoma Bold");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("TeaChestStencilEF-RegularRough");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("TheSans Italic");
        ignoreFonts.add("Times New Roman");
        ignoreFonts.add("Times New Roman Bold");
        ignoreFonts.add("Times New Roman Bold Italic");
        ignoreFonts.add("Times New Roman Italic");
        ignoreFonts.add("Times Phonetic Alternate");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Trebuchet MS");
        ignoreFonts.add("Trebuchet MS Bold");
        ignoreFonts.add("Trebuchet MS Bold Italic");
        ignoreFonts.add("Trebuchet MS Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("Universal News with Commercial Pi 97");
        ignoreFonts.add("VectoraLTStd-BlackItalic");
        ignoreFonts.add("VectoraLTStd-BoldItalic");
        ignoreFonts.add("VectoraLTStd-Italic");
        ignoreFonts.add("VectoraLTStd-LightItalic");
        ignoreFonts.add("Verdana");
        ignoreFonts.add("Verdana Bold");
        ignoreFonts.add("Verdana Bold Italic");
        ignoreFonts.add("Verdana Italic");
        ignoreFonts.add("VersaillesLTStd-BoldItalic");
        ignoreFonts.add("VersaillesLTStd-Italic");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("WalbaumFrakturEF-RegularDfr");
        ignoreFonts.add("Webdings");
        ignoreFonts.add("WesternStencilEF-Regular");
        ignoreFonts.add("Dialog.plain");
        ignoreFonts.add("WilkeLTStd-BoldItalic");
        ignoreFonts.add("WilkeLTStd-Italic");
        ignoreFonts.add("Wingdings");
        ignoreFonts.add("Yu Gothic Bold");
        ignoreFonts.add("Yu Gothic Light");
        ignoreFonts.add("Yu Gothic Medium");
        ignoreFonts.add("Yu Gothic Regular");
        ignoreFonts.add("Yu Gothic UI Bold");
        ignoreFonts.add("Yu Gothic UI Light");
        ignoreFonts.add("Yu Gothic UI Regular");
        ignoreFonts.add("Yu Gothic UI Semibold");
        ignoreFonts.add("Yu Gothic UI Semilight");

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Font[] fonts = e.getAllFonts(); // Get the fonts

        for (Font f : fonts) {
            count++;
            String fontName = f.getFontName();
            System.out.println(f.getFontName());

            if (!ignoreFonts.contains(fontName)) {
//            String text = "The quick brown fox jumps over the lazy dog";
//            createImage(fontName, text, "fox");

            for (int i = 'A'; i <= 'Z'; i++) {
                createImage(fontName, "" + (char) i, "" + i);
            }

            for (int i = 'a'; i <= 'z'; i++) {
                createImage(fontName, "" + (char) i, "" + i);
            }
            if (count > 150) {
                break;
            }
            }
        }

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
            Font font = new Font(fontName, Font.PLAIN, 100);
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
