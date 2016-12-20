package ch.bfh.ti.soed.hs16.srs.yellow;

import jdepend.framework.JDepend;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class packageCyclesTest {

    @Test
    public void testIfPackageHasCyclicDependencies() throws IOException {

        JDepend jdepend = new JDepend();

        jdepend.addDirectory("target/classes");

        jdepend.analyze();

        assertThat(jdepend.containsCycles(), is(false));
    }
}
