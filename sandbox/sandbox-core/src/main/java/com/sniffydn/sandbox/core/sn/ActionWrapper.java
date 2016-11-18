
package com.sniffydn.sandbox.core.sn;

public class ActionWrapper {
    private Step action;
    private Integer repeat;

    /**
     * @return the action
     */
    public Step getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Step action) {
        this.action = action;
    }

    /**
     * @return the repeat
     */
    public Integer getRepeat() {
        return repeat;
    }

    /**
     * @param repeat the repeat to set
     */
    public void setRepeat(Integer repeat) {
        this.repeat = repeat;
    }

    public void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
