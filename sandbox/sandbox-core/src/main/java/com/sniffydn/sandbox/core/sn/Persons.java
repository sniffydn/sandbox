
package com.sniffydn.sandbox.core.sn;

import java.util.List;
import java.util.Map;

public enum Persons {
    FIRST_PERSON(Util.FIRST_PERSON),
    SECOND_PERSON(Util.SECOND_PERSON);
    private Map<String, List<String>> personMap;

    private Persons(Map<String,List<String>> personMap) {
        this.personMap = personMap;
    }

    /**
     * @return the personMap
     */
    public Map<String, List<String>> getPersonMap() {
        return personMap;
    }


}
