/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-present, by David Gilbert and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ---------------------
 * XYBarDatasetTest.java
 * ---------------------
 * (C) Copyright 2007-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.data.xy;

import org.jfree.chart.TestUtils;
import org.jfree.chart.util.PublicCloneable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Some tests for the {@link XYBarDataset} class.
 */
public class XYBarDatasetTest {

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] {1.0, 2.0, 3.0};
        double[] y1 = new double[] {4.0, 5.0, 6.0};
        double[][] data1 = new double[][] {x1, y1};
        d1.addSeries("S1", data1);
        DefaultXYDataset d2 = new DefaultXYDataset();
        double[] x2 = new double[] {1.0, 2.0, 3.0};
        double[] y2 = new double[] {4.0, 5.0, 6.0};
        double[][] data2 = new double[][] {x2, y2};
        d2.addSeries("S1", data2);

        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = new XYBarDataset(d2, 5.0);
        assertEquals(bd1, bd2);
        assertEquals(bd2, bd1);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] {1.0, 2.0, 3.0};
        double[] y1 = new double[] {4.0, 5.0, 6.0};
        double[][] data1 = new double[][] {x1, y1};
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = (XYBarDataset) bd1.clone();
        assertNotSame(bd1, bd2);
        assertSame(bd1.getClass(), bd2.getClass());
        assertEquals(bd1, bd2);

        // check independence
        d1 = (DefaultXYDataset) bd1.getUnderlyingDataset();
        d1.addSeries("S2", new double[][] {{1.0}, {2.0}});
        assertNotEquals(bd1, bd2);
        DefaultXYDataset d2 = (DefaultXYDataset) bd2.getUnderlyingDataset();
        d2.addSeries("S2", new double[][] {{1.0}, {2.0}});
        assertEquals(bd1, bd2);
    }

    /**
     * Verify that this class implements {@link PublicCloneable}.
     */
    @Test
    public void testPublicCloneable() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] {1.0, 2.0, 3.0};
        double[] y1 = new double[] {4.0, 5.0, 6.0};
        double[][] data1 = new double[][] {x1, y1};
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        assertTrue(bd1 instanceof PublicCloneable);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        DefaultXYDataset d1 = new DefaultXYDataset();
        double[] x1 = new double[] {1.0, 2.0, 3.0};
        double[] y1 = new double[] {4.0, 5.0, 6.0};
        double[][] data1 = new double[][] {x1, y1};
        d1.addSeries("S1", data1);
        XYBarDataset bd1 = new XYBarDataset(d1, 5.0);
        XYBarDataset bd2 = TestUtils.serialised(bd1);
        assertEquals(bd1, bd2);
    }

}
