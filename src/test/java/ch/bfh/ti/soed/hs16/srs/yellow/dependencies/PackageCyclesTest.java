
/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 *
 * Project Smart Reservation System.
 *
 * Distributable under GPL license. See terms of license at gnu.org.
 */

package ch.bfh.ti.soed.hs16.srs.yellow.dependencies;

import jdepend.framework.JDepend;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertFalse;

public class PackageCyclesTest {

    @Test
    public void testIfPackageHasCyclicDependencies() throws IOException {

        JDepend jdepend = new JDepend();

        jdepend.addDirectory("target/classes");

        jdepend.analyze();

        assertFalse(jdepend.containsCycles());
    }
}
