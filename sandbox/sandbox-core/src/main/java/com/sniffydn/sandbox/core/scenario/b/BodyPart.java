package com.sniffydn.sandbox.core.scenario.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BodyPart {

    private List<BodyPart> down = new ArrayList<>();
    private List<BodyPart> up = new ArrayList<>();
    private List<BodyPart> around = new ArrayList<>();
    private List<BodyPart> composedOf = new ArrayList<>();
    private BodyPart partOf = null;
    private Boolean rightSide = null;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (rightSide != null) {
            if (rightSide) {
                sb.append("right ");
            } else {
                sb.append("left ");
            }
        }

        sb.append(getClass().getSimpleName());
        return sb.toString();
    }

    /**
     * @return the rightSide
     */
    public Boolean getRightSide() {
        return rightSide;
    }

    /**
     * @param rightSide the rightSide to set
     */
    public void setRightSide(Boolean rightSide) {
        this.rightSide = rightSide;
    }

    /**
     * @return the down
     */
    public List<BodyPart> getDown() {
        return down;
    }

    /**
     * @return the up
     */
    public List<BodyPart> getUp() {
        return up;
    }

    /**
     * @return the composedOf
     */
    public List<BodyPart> getComposedOf() {
        return composedOf;
    }

    /**
     * @return the partOf
     */
    public BodyPart getPartOf() {
        return partOf;
    }

    /**
     * @param partOf the partOf to set
     */
    public void setPartOf(BodyPart partOf) {
        this.partOf = partOf;
    }

    /**
     * @return the around
     */
    public List<BodyPart> getAround() {
        return around;
    }

    private Set<BodyPart> checkedParts = new HashSet<BodyPart>();
    public BodyPart find(Class c) {
        checkedParts.clear();
        return internalFind(c);
    }

    private BodyPart internalFind(Class c) {
        if(c.isInstance(this)) {
            return this;
        } else {
            if(getPartOf() != null) {
                getPartOf().internalFind(c);
            } else {
                
                //TODO
            }
        }


        return null;
    }
}
