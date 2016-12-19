package com.sniffydn.sandbox.core.sn.impl.acc;

import com.sniffydn.sandbox.core.sn.impl.Dustin;
import com.sniffydn.sandbox.core.sn.impl.Kristen;
import com.sniffydn.sandbox.sentence.Paragraph;

public interface Anchorable {

    public Paragraph anchor(Kristen k, Dustin d, Anchor a);

    public Anchor getAnchor();
}
