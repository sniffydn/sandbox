package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.sentence.Verb;
import java.util.List;

public class ProperVerb extends Verb {

    String oldVerb = verb;

    public ProperVerb(String verb) {
        super(verb);
    }

    @Override
    public String toString() {
        oldVerb = verb;
        if (subject instanceof ProperNoun) {
            ProperNoun pn = (ProperNoun) subject;
            List<String> verbList = pn.getVerbReplacementList().get(this);
            if(verbList != null) {
                verb = verbList.get(Util.getRandom(verbList.size()));
            }
        }
        String retVal = super.toString();
        verb = oldVerb;
        return retVal;
    }

}
