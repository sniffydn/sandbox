package com.sniffydn.sandbox.core.sn;

public class Step {

    private Step preStep;
    private String prefixText;
    private Action action;
    private Step substep;
    private String suffixText;
    private Step pstStep;

    /**
     * @return the preStep
     */
    public Step getPreStep() {
        return preStep;
    }

    /**
     * @param preStep the preStep to set
     */
    public void setPreStep(Step preStep) {
        this.preStep = preStep;
    }

    /**
     * @return the prefixText
     */
    public String getPrefixText() {
        return prefixText;
    }

    /**
     * @param prefixText the prefixText to set
     */
    public void setPrefixText(String prefixText) {
        this.prefixText = prefixText;
    }

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }

    /**
     * @return the substep
     */
    public Step getSubstep() {
        return substep;
    }

    /**
     * @param substep the substep to set
     */
    public void setSubstep(Step substep) {
        this.substep = substep;
    }

    /**
     * @return the suffixText
     */
    public String getSuffixText() {
        return suffixText;
    }

    /**
     * @param suffixText the suffixText to set
     */
    public void setSuffixText(String suffixText) {
        this.suffixText = suffixText;
    }

    /**
     * @return the pstStep
     */
    public Step getPstStep() {
        return pstStep;
    }

    /**
     * @param pstStep the pstStep to set
     */
    public void setPstStep(Step pstStep) {
        this.pstStep = pstStep;
    }

    public void print() {
        if (preStep != null) {
            preStep.print();
        }
        if (prefixText != null) {
            System.out.println(prefixText);
        }
        if (action != null) {
            action.print();
        }
        if (substep != null) {
            substep.print();
        }
        if (suffixText != null) {
            System.out.println(suffixText);
        }
        if (pstStep != null) {
            pstStep.print();
        }
    }

}
