package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.clts.Accessory;
import com.sniffydn.sandbox.core.sn.clts.Bottoms;
import com.sniffydn.sandbox.core.sn.clts.Shoes;
import com.sniffydn.sandbox.core.sn.clts.Socks;
import com.sniffydn.sandbox.core.sn.clts.Top;
import com.sniffydn.sandbox.core.sn.clts.Under;

public class HerOutfit {

    private Shoes shoes;
    private Socks socks;
    private Bottoms bottoms;
    private Under under;
    private Top top;
    private Accessory acc1;
    private Accessory acc2;

    /**
     * @return the shoes
     */
    public Shoes getShoes() {
        return shoes;
    }

    /**
     * @param shoes the shoes to set
     */
    public void setShoes(Shoes shoes) {
        if(this.shoes != null) {
            this.shoes.updateMapRemove(null, null);
        }
        shoes.updateMapAdd(null, null);
        this.shoes = shoes;
    }

    /**
     * @return the socks
     */
    public Socks getSocks() {
        return socks;
    }

    /**
     * @param socks the socks to set
     */
    public void setSocks(Socks socks) {
        this.socks = socks;
    }

    /**
     * @return the bottoms
     */
    public Bottoms getBottoms() {
        return bottoms;
    }

    /**
     * @param bottoms the bottoms to set
     */
    public void setBottoms(Bottoms bottoms) {
        this.bottoms = bottoms;
    }

    /**
     * @return the under
     */
    public Under getUnder() {
        return under;
    }

    /**
     * @param under the under to set
     */
    public void setUnder(Under under) {
        this.under = under;
    }

    /**
     * @return the top
     */
    public Top getTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(Top top) {
        this.top = top;
    }

    /**
     * @return the acc1
     */
    public Accessory getAcc1() {
        return acc1;
    }

    /**
     * @param acc1 the acc1 to set
     */
    public void setAcc1(Accessory acc1) {
        this.acc1 = acc1;
    }

    /**
     * @return the acc2
     */
    public Accessory getAcc2() {
        return acc2;
    }

    /**
     * @param acc2 the acc2 to set
     */
    public void setAcc2(Accessory acc2) {
        this.acc2 = acc2;
    }

    public String print(Her her, Me me) {
        updateMap(her, me);

        boolean first = true;
        StringBuilder sb = new StringBuilder();

        if (top != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
                first = false;
            }
            sb.append(top.print());
        }
        if (bottoms != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
                first = false;
            }
            sb.append(bottoms.print());
        }

        if (shoes != null) {
            if (first) {
                sb.append(" nothing but ");
            } else {
                sb.append(" with ");
            }
            sb.append("a pair of ");
            sb.append(shoes.print());
        }
        if (socks != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append(" nothing but a pair of ");
            }
            sb.append(socks.print());
        }
        if (acc1 != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
            }
            sb.append(acc1.print());
        }
        if (acc2 != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
            }
            sb.append(acc2.print());
        }
        if (under != null) {
            if (!first) {
                sb.append(", with a ");
            } else {
                sb.append(" nothing but a ");
            }
            sb.append(under.print());
            if (!first) {
                sb.append(" underneath");
            }
        }
        if (first) {
            sb.append("nothing");
        }

        return sb.toString();
    }

    private void updateMap(Her her, Me me) {
        if (shoes != null) {
            shoes.updateMapAdd(her, me);
        }
        if (socks != null) {
            socks.updateMapAdd(her, me);
        }
        if (bottoms != null) {
            bottoms.updateMapAdd(her, me);
        }
        if (under != null) {
            under.updateMapAdd(her, me);
        }
        if (top != null) {
            top.updateMapAdd(her, me);
        }
        if (acc1 != null) {
            acc1.updateMapAdd(her, me);
        }
        if (acc2 != null) {
            acc2.updateMapAdd(her, me);
        }
    }
}
