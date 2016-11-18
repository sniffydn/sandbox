package com.sniffydn.sandbox.core.sn;

import java.util.ArrayList;
import java.util.List;

public class Step {

    private List<Restriction> addsRestriction = new ArrayList<>();
    private List<Restriction> hasRestriction = new ArrayList<>();
    private Step preStep;
    private String prefixText;
    private String description;
    private ActionWrapper actionWrapper;
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
        if (description != null) {
            System.out.println(description);
        }
        if(actionWrapper != null) {
            actionWrapper.print();
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the addsRestriction
     */
    public List<Restriction> getAddsRestriction() {
        return addsRestriction;
    }

    /**
     * @param addsRestriction the addsRestriction to set
     */
    public void setAddsRestriction(List<Restriction> addsRestriction) {
        this.addsRestriction = addsRestriction;
    }

    /**
     * @return the actionWrapper
     */
    public ActionWrapper getActionWrapper() {
        return actionWrapper;
    }

    /**
     * @param actionWrapper the actionWrapper to set
     */
    public void setActionWrapper(ActionWrapper actionWrapper) {
        this.actionWrapper = actionWrapper;
    }

    /**
     * @return the hasRestriction
     */
    public List<Restriction> getHasRestriction() {
        return hasRestriction;
    }

    /**
     * @param hasRestriction the hasRestriction to set
     */
    public void setHasRestriction(List<Restriction> hasRestriction) {
        this.hasRestriction = hasRestriction;
    }

}
