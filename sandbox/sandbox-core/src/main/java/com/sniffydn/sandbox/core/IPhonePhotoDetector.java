package com.sniffydn.sandbox.core;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import java.io.File;
import java.io.IOException;

public class IPhonePhotoDetector {

    private static final String regex = "\\d{2,}";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("C:\\TEMP\\gmi\\image1.jpg");
        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            printImageTags(metadata);
        } catch (ImageProcessingException e) {
            System.err.println("error 1a: " + e);
        } catch (IOException e) {
            System.err.println("error 1b: " + e);
        }
    }

    private static void printImageTags(Metadata metadata) {
        // iterate over the exif data and print to System.out
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                System.out.println(tag.getTagName() + "    " + tag.getDescription());
                if(tag.getTagName().equals("Orientation")) {
                    if(tag.getDescription().contains("90")) {
                        System.out.println("contains 90");
                    }
                    if(tag.getDescription().contains("180")) {
                        System.out.println("contains 180");
                    }
                }
            }
            for (String error : directory.getErrors()) {
                System.err.println("ERROR: " + error);
            }
        }
    }

}
