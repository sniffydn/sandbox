package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.sentence.Paragraph;
import java.util.ArrayList;
import java.util.List;

public class Scene {

    private Kristen her = new Kristen();
    private Dustin me = new Dustin();
    protected List<Paragraph> scene = new ArrayList<Paragraph>();

    public String print() {
        StringBuilder sb = new StringBuilder();

        for(Paragraph p: scene) {
            sb.append(p.toString());
            sb.append("  ");
        }

        String temp = sb.toString();
        temp = Util.globalReplace(temp);
        return temp;
    }

    /**
     * @return the her
     */
    public Kristen getHer() {
        return her;
    }

    /**
     * @return the me
     */
    public Dustin getMe() {
        return me;
    }
}
