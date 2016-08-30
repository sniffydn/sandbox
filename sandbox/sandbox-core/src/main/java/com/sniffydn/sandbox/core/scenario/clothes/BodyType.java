package com.sniffydn.sandbox.core.scenario.clothes;

import com.sniffydn.sandbox.core.scenario.CommonBody;
import com.sniffydn.sandbox.core.scenario.FBody;
import com.sniffydn.sandbox.core.scenario.MBody;

public enum BodyType {

    M,
    F,
    B;

    public boolean isType(CommonBody cb) {
        if (this.equals(M)) {
            return cb instanceof MBody;
        } else if (this.equals(F)) {
            return cb instanceof FBody;
        } else {
            return true;
        }
    }

}
