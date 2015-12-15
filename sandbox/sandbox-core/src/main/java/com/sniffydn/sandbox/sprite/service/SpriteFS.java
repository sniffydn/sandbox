package com.sniffydn.sandbox.sprite.service;

import com.sniffydn.sandbox.sprite.model.her.Accessory;
import com.sniffydn.sandbox.sprite.model.Scene;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SpriteFS {

    public static void writeAccessory(File file, Accessory item) throws Exception {

        XStream xstream = new XStream();
        setAliases(xstream);

        // When fields are omitted, they either need to have a null default constructor in 
        // their class, or the class needs to implement readResolve to set up the initialized field
        // so that fields are initialized properly when loaded
        //xstream.omitField(Layer.class, "_cachedSourceImage");
        String xml = xstream.toXML(item);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    public static Accessory readAccessory(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Accessory document = (Accessory) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeScene(File file, Scene item) throws Exception {

        XStream xstream = new XStream();
        setAliases(xstream);

        // When fields are omitted, they either need to have a null default constructor in
        // their class, or the class needs to implement readResolve to set up the initialized field
        // so that fields are initialized properly when loaded
        //xstream.omitField(Layer.class, "_cachedSourceImage");
        String xml = xstream.toXML(item);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    public static Scene readScene(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Scene document = (Scene) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void setAliases(XStream xstream) {
        xstream.alias("Accessory", Accessory.class);
        xstream.alias("Scene", Scene.class);
    }
}
