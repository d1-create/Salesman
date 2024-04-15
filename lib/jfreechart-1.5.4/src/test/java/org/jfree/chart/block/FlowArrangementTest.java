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
 * ------------------------
 * FlowArrangementTest.java
 * ------------------------
 * (C) Copyright 2005-present, by David Gilbert and Contributors.
 *
 * Original Author:  David Gilbert;
 * Contributor(s):   Tracy Hiltbrand;
 *
 */

package org.jfree.chart.block;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.jfree.chart.TestUtils;
import org.jfree.chart.ui.HorizontalAlignment;
import org.jfree.chart.ui.VerticalAlignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the {@link FlowArrangement} class.
 */
public class FlowArrangementTest {

    /**
     * Use EqualsVerifier to test that the contract between equals and hashCode
     * is properly implemented.
     */
    @Test
    public void testEqualsHashCode() {
        EqualsVerifier.forClass(FlowArrangement.class)
            .suppress(Warning.STRICT_INHERITANCE)
            .suppress(Warning.NONFINAL_FIELDS)
            .suppress(Warning.TRANSIENT_FIELDS)
            .verify();
    }

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
    @Test
    public void testEquals() {
        FlowArrangement f1 = new FlowArrangement(HorizontalAlignment.LEFT,
                VerticalAlignment.TOP, 1.0, 2.0);
        FlowArrangement f2 = new FlowArrangement(HorizontalAlignment.LEFT,
                VerticalAlignment.TOP, 1.0, 2.0);
        assertEquals(f1, f2);
        assertEquals(f2, f1);

        f1 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.TOP, 1.0, 2.0);
        assertNotEquals(f1, f2);
        f2 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.TOP, 1.0, 2.0);
        assertEquals(f1, f2);

        f1 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.0, 2.0);
        assertNotEquals(f1, f2);
        f2 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.0, 2.0);
        assertEquals(f1, f2);

        f1 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.1, 2.0);
        assertNotEquals(f1, f2);
        f2 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.1, 2.0);
        assertEquals(f1, f2);

        f1 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.1, 2.2);
        assertNotEquals(f1, f2);
        f2 = new FlowArrangement(HorizontalAlignment.RIGHT,
                VerticalAlignment.BOTTOM, 1.1, 2.2);
        assertEquals(f1, f2);

    }

    /**
     * Immutable - cloning is not necessary.
     */
    @Test
    public void testCloning() {
        FlowArrangement f1 = new FlowArrangement();
        assertFalse(f1 instanceof Cloneable);
    }

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    @Test
    public void testSerialization() {
        FlowArrangement f1 = new FlowArrangement(HorizontalAlignment.LEFT,
                VerticalAlignment.TOP, 1.0, 2.0);
        FlowArrangement f2 = TestUtils.serialised(f1);
        assertEquals(f1, f2);
    }

}
