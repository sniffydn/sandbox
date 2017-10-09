/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    private static Util instance;
    private File[] files;
    private List<String> folderNames;
    private Map<String, String> folderToPathMap = new HashMap<>();
    private List<String> imageNames = new ArrayList<>();

    private Util() {
        File f = new File(getClass().getResource("").getPath() + File.separator + "quizFolder");
        System.out.println(f.getAbsolutePath());
        files = f.listFiles();

        folderNames = new ArrayList<String>();

        for (File f1 : files) {
            folderNames.add(f1.getName());
            String path = "";
            try {
                path = f1.listFiles()[0].getAbsolutePath();
                imageNames.add(path);
            } catch (Exception e) {
            }
            folderToPathMap.put(f1.getName(), path);
        }
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }

        return instance;
    }

    public List<String> getFolderNames() {
        return folderNames;
    }

    public static void main(String[] args) {
        Map<String, String> map = Util.getInstance().getFolderToPathMap();
        for (String s : Util.getInstance().getFolderNames()) {
            System.out.println(s);
            System.out.println("    " + map.get(s));
        }
    }

    public Map<String, String> getFolderToPathMap() {
        return folderToPathMap;
    }

    /**
     * @return the imageNames
     */
    public List<String> getImageNames() {
        return imageNames;
    }
}
