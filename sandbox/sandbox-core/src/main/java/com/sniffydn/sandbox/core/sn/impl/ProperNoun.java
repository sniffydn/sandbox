
package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.sentence.Noun;
import com.sniffydn.sandbox.sentence.Verb;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProperNoun extends Noun {

    private Map<Verb, List<String>> verbReplacementList = new HashMap<>();

    public ProperNoun(String noun) {
        super(noun);
    }

    /**
     * @return the verbReplacementList
     */
    public Map<Verb, List<String>> getVerbReplacementList() {
        return verbReplacementList;
    }

}
