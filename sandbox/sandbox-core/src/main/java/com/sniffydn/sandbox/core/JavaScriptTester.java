
package com.sniffydn.sandbox.core;

import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author dnyffeler
 */
public class JavaScriptTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String key = "e8d639b63c5780d1d7e2f20ab33253cb";
        String secret = "3ea3af77dc2052015e98607879727a8ddbc08bf2a12498cefe32ff2cebf12667";

        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        File f = new File("C:\\Users\\dnyffeler\\Documents\\NetBeansProjects\\sandbox\\sandbox\\sandbox-core\\src\\main\\java\\com\\sniffydn\\sandbox\\core\\TrelloTest.js");
        System.out.println(f.getAbsoluteFile());
        try {
            engine.eval(new FileReader(f));
        } catch (Exception ex) {
            Logger.getLogger(JavaScriptTester.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
