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
 * -----------------------------
 * WaterfallBarRendererTest.java
 * -----------------------------
 * (C) Copyright 2003-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   -;
 *
 */

package org.jfree.chart.renderer.category;

import java.awt.Color;

import org.jfree.chart.TestUtils;
import org.jfree.chart.util.PublicCloneable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link WaterfallBarRenderer} class.
 */
public class WaterfallBarRendererTest {

    /**
     * Some tests for the findRangeBounds() method.
     */
    @Test
    public void testFindRangeBounds() {
        WaterfallBarRenderer r = new WaterfallBarRenderer();
        assertNull(r.findRangeBounds(null));
    }

    /**
     * Check that the equals() method distinguishes all fields.
     */
    @Test
    public void testEquals() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = new WaterfallBarRenderer();
        assertEquals(r1, r2);

        // firstBarPaint;
        r1.setFirstBarPaint(Color.cyan);
        assertNotEquals(r1, r2);
        r2.setFirstBarPaint(Color.cyan);
        assertEquals(r1, r2);

        // lastBarPaint;
        r1.setLastBarPaint(Color.cyan);
        assertNotEquals(r1, r2);
        r2.setLastBarPaint(Color.cyan);
        assertEquals(r1, r2);

        // positiveBarPaint;
        r1.setPositiveBarPaint(Color.cyan);
        assertNotEquals(r1, r2);
        r2.setPositiveBarPaint(Color.cyan);
        assertEquals(r1, r2);

        //private Paint negativeBarPaint;
        r1.setNegativeBarPaint(Color.cyan);
        assertNotEquals(r1, r2);
        r2.setNegativeBarPaint(Color.cyan);
        assertEquals(r1, r2);

    }

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    @Test
    public void testHashcode() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = new WaterfallBarRenderer();
        assertEquals(r1, r2);
        int h1 = r1.hashCode();
        int h2 = r2.hashCode();
        assertEquals(h1, h2);
    }

    /**
     * Confirm that cloning works.
     */
    @Test
    public void testCloning() throws CloneNotSupportedException {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = (WaterfallBarRenderer) r1.clone();
        assertNotSame(r1, r2);
        assertSame(r1.getClass(), r2.getClass());
        assertEquals(r1, r2);

        // quick check for independence
        r1.setFirstBarPaint(Color.YELLOW);
        assertNotEquals(r1, r2);
        r2.setFirstBarPaint(Color.YELLOW);
        assertEquals(r1, r2);

    }

    /**
     * Check that this class implements PublicCloneable.
     */
    @Test
    public void testPublicCloneable() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        assertTrue(r1 instanceof PublicCloneable);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        WaterfallBarRenderer r1 = new WaterfallBarRenderer();
        WaterfallBarRenderer r2 = TestUtils.serialised(r1);
        assertEquals(r1, r2);
    }

//    /**
//     * Check that the paint object returned for a middle column with 0 
//     * difference is the positive bar paint object
//     */
//    @Test
// public void testGetSeriesPaintForDifferentValues() {
//Color firstPaint = Color.cyan;
//Color positivePaint = Color.GREEN;
//Color negativePaint = Color.RED;
//Color lastPaint = Color.BLUE;
//WaterfallBarRenderer waterfallBarRenderer = new WaterfallBarRenderer(firstPaint, positivePaint, negativePaint, lastPaint);
//
//// Sets of tests for making sure the correct paint object is returned
//// for different scenarios. 
//	
//// In the first set, the "firstPaint" object is always returned because
//// this is first column (regardless of the value of the value difference).
//assertSame(firstPaint, waterfallBarRenderer.getSeriesPaintObject(0, 1, 0d));
//assertSame(firstPaint, waterfallBarRenderer.getSeriesPaintObject(0, 2, 1d));
//assertSame(firstPaint, waterfallBarRenderer.getSeriesPaintObject(0, 2, -1d));
//
//// In the second set, the "positivePaint" object is returned for middle
//// columns which are greater than or equal to 0. 
//assertSame(positivePaint, waterfallBarRenderer.getSeriesPaintObject(1, 1, 1d));
//assertSame(positivePaint, waterfallBarRenderer.getSeriesPaintObject(1, 1, 0d));
//assertSame(positivePaint, waterfallBarRenderer.getSeriesPaintObject(1, 3, 0d));
//
//// In the third set, the "negativePaint" object is returned for middle 
//// columns which are less than zero.
//assertSame(negativePaint, waterfallBarRenderer.getSeriesPaintObject(1, 1, -0.5d));
//assertSame(negativePaint, waterfallBarRenderer.getSeriesPaintObject(1, 3, -0.5d));
//assertSame(negativePaint, waterfallBarRenderer.getSeriesPaintObject(1, 0, -0.5d));
//		
//// In the last set, the "lastPaint" object is returned because this is the 
//// last column (regardless of the value of the value difference).
//assertSame(lastPaint, waterfallBarRenderer.getSeriesPaintObject(1, 2, 0d));
//assertSame(lastPaint, waterfallBarRenderer.getSeriesPaintObject(1, 2, 1d));
//assertSame(lastPaint, waterfallBarRenderer.getSeriesPaintObject(1, 2, -1d));
//}

}
