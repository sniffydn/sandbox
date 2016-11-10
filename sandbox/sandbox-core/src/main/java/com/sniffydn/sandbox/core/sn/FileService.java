package com.sniffydn.sandbox.core.sn;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileService {

    public static void writeDocument(File file, Document document) throws Exception {

        XStream xstream = new XStream();
        setAliases(xstream);

        // When fields are omitted, they either need to have a null default constructor in
        // their class, or the class needs to implement readResolve to set up the initialized field
        // so that fields are initialized properly when loaded
        //xstream.omitField(Layer.class, "_cachedSourceImage");
        String xml = xstream.toXML(document);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    public static Document readDocument(File file) throws Exception {

        XStream xstream = new XStream(new DomDriver());
        setAliases(xstream);

        Document document = (Document) xstream.fromXML(new FileReader(file));
        return document;
    }

    public static void setAliases(XStream xstream) {
        xstream.alias("Document", Document.class);
    }
}
