package com.sniffydn.sandbox.sprite.service;

import com.sniffydn.sandbox.sprite.model.Accessory;
import com.sniffydn.sandbox.sprite.model.Action;
import com.sniffydn.sandbox.sprite.model.Hr;
import com.sniffydn.sandbox.sprite.model.HrType;
import com.sniffydn.sandbox.sprite.model.Item;
import com.sniffydn.sandbox.sprite.model.Mood;
import com.sniffydn.sandbox.sprite.model.Mu;
import com.sniffydn.sandbox.sprite.model.MuType;
import com.sniffydn.sandbox.sprite.model.Scene;
import com.sniffydn.sandbox.sprite.model.clts.Bottom;
import com.sniffydn.sandbox.sprite.model.clts.BottomType;
import com.sniffydn.sandbox.sprite.model.clts.Platz;
import com.sniffydn.sandbox.sprite.model.clts.Shu;
import com.sniffydn.sandbox.sprite.model.clts.ShuType;
import com.sniffydn.sandbox.sprite.model.clts.TopLower;
import com.sniffydn.sandbox.sprite.model.clts.TopLowerType;
import com.sniffydn.sandbox.sprite.model.clts.TopUpper;
import com.sniffydn.sandbox.sprite.model.clts.TopUpperType;
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

    public static void writeHr(File file, Hr item) throws Exception {

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

    public static Hr readHr(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Hr document = (Hr) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeMu(File file, Mu item) throws Exception {

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

    public static Mu readMu(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Mu document = (Mu) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeBottom(File file, Bottom item) throws Exception {

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

    public static Bottom readBottom(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Bottom document = (Bottom) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeTopLower(File file, TopLower item) throws Exception {

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

    public static TopLower readTopLower(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        TopLower document = (TopLower) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeTopUpper(File file, TopUpper item) throws Exception {

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

    public static TopUpper readTopUpper(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        TopUpper document = (TopUpper) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writePlatz(File file, Platz item) throws Exception {

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

    public static Platz readPlatz(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Platz document = (Platz) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void writeShu(File file, Shu item) throws Exception {

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

    public static Shu readShu(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Shu document = (Shu) xstream.fromXML(new FileReader(file));
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
        xstream.alias("Item", Item.class);
        xstream.alias("Accessory", Accessory.class);
        xstream.alias("Hr", Hr.class);
        xstream.alias("Mu", Mu.class);
        xstream.alias("Bottom", Bottom.class);
        xstream.alias("TL", TopLower.class);
        xstream.alias("TU", TopUpper.class);
        xstream.alias("Platz", Platz.class);
        xstream.alias("Shu", Shu.class);
        xstream.alias("Mood", Mood.class);
        xstream.alias("Action", Action.class);
        xstream.alias("MuType", MuType.class);
        xstream.alias("HrType", HrType.class);
        xstream.alias("BottomType", BottomType.class);
        xstream.alias("TLType", TopLowerType.class);
        xstream.alias("TUType", TopUpperType.class);
        xstream.alias("SType", ShuType.class);
        xstream.alias("Scene", Scene.class);
    }
}
