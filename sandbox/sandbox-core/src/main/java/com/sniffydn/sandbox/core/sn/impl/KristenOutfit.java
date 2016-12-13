package com.sniffydn.sandbox.core.sn.impl;

import com.sniffydn.sandbox.core.sn.Util;
import com.sniffydn.sandbox.core.sn.clts.Accessory;
import com.sniffydn.sandbox.core.sn.clts.Bottoms;
import com.sniffydn.sandbox.core.sn.clts.Shoes;
import com.sniffydn.sandbox.core.sn.clts.Socks;
import com.sniffydn.sandbox.core.sn.clts.Top;
import com.sniffydn.sandbox.core.sn.clts.Under;
import com.sniffydn.sandbox.core.sn.impl.sh.S1;
import com.sniffydn.sandbox.core.sn.impl.tp.D1;
import com.sniffydn.sandbox.sentence.DirectObject;
import com.sniffydn.sandbox.sentence.Noun;
import java.util.ArrayList;
import java.util.List;

public class KristenOutfit {

    private Shoes shoes;
    private Socks socks;
    private Bottoms bottoms;
    private Under under;
    private Top top;
    private Accessory acc1;
    private Accessory acc2;

    public KristenOutfit() {
        List<Shoes> allShoes = new ArrayList<>();
        allShoes.add(new S1());
//        allShoes.add(new S2());
        setShoes(allShoes.get(Util.getRandom(allShoes.size())));
        setTop(new D1());
    }

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

    public DirectObject getDirectObject() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        if (top != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
                first = false;
            }
            sb.append(top.getNoun().getSubject());
        }
        if (bottoms != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
                first = false;
            }
            sb.append(bottoms.getNoun().getSubject());
        }

        if (shoes != null) {
            if (first) {
                sb.append(" nothing but ");
            } else {
                sb.append(" with ");
            }
            sb.append("a pair of ");
            sb.append(shoes.getNoun().getSubject());
        }
        if (socks != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append(" nothing but a pair of ");
            }
            sb.append(socks.getNoun().getSubject());
        }
        if (acc1 != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
            }
            sb.append(acc1.getNoun().getSubject());
        }
        if (acc2 != null) {
            if (!first) {
                sb.append(", ");
            } else {
                sb.append("a ");
            }
            sb.append(acc2.getNoun().getSubject());
        }
        if (under != null) {
            if (!first) {
                sb.append(", with a ");
            } else {
                sb.append(" nothing but a ");
            }
            sb.append(under.getNoun().getSubject());
            if (!first) {
                sb.append(" underneath");
            }
        }
        if (first) {
            sb.append("nothing");
        }

        return new DirectObject(new Noun(sb.toString()));
    }
}
