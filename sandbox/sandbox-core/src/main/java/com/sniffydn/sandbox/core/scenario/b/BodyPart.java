package com.sniffydn.sandbox.core.scenario.b;

import java.util.ArrayList;
import java.util.List;

public class BodyPart {

    private List<BodyPart> down = new ArrayList<>();
    private List<BodyPart> up = new ArrayList<>();
    private List<BodyPart> around = new ArrayList<>();
    private List<BodyPart> composedOf = new ArrayList<>();
    private BodyPart partOf = null;
    private Boolean rightSide = null;
    private int plsrScale = 0;
    private List<PartState> states = new ArrayList<>();

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

    private List<BodyPart> checkedParts = new ArrayList<>();
    private BodyPart foundPart = null;

    public BodyPart find(Class c) {
        checkedParts.clear();
        foundPart = null;
        internalFind(c, this);
        return foundPart;
    }

    private void internalFind(Class c, BodyPart toCheck) {
        if (foundPart != null) {
            return;
        }
        if (c.isInstance(toCheck)) {
            foundPart = toCheck;
            return;
        } else {
            if (checkedParts.contains(toCheck)) {
                return;
            }
            checkedParts.add(toCheck);
            if (toCheck.getPartOf() != null) {
                if (!checkedParts.contains(toCheck.getPartOf())) {
                    toCheck.getPartOf().internalFind(c, toCheck);
                }
            }
            if (toCheck.getAround().size() > 0) {
                for (BodyPart bp : toCheck.getAround()) {
                    if (!checkedParts.contains(bp)) {
                        internalFind(c, bp);
                    }
                }
            }
            if (toCheck.getComposedOf().size() > 0) {
                for (BodyPart bp : toCheck.getComposedOf()) {
                    if (!checkedParts.contains(bp)) {
                        internalFind(c, bp);
                    }
                }
            }
            if (toCheck.getUp().size() > 0) {
                for (BodyPart bp : toCheck.getUp()) {
                    if (!checkedParts.contains(bp)) {
                        internalFind(c, bp);
                    }
                }
            }
            if (toCheck.getDown().size() > 0) {
                for (BodyPart bp : toCheck.getDown()) {
                    if (!checkedParts.contains(bp)) {
                        internalFind(c, bp);
                    }
                }
            }

        }

        return;
    }

    /**
     * @return the plsrScale
     */
    public int getPlsrScale() {
        return plsrScale;
    }

    /**
     * @param plsrScale the plsrScale to set
     */
    public void setPlsrScale(int plsrScale) {
        this.plsrScale = plsrScale;
    }

    /**
     * @return the states
     */
    public List<PartState> getStates() {
        return states;
    }
}
