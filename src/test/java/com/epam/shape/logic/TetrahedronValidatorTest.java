package com.epam.shape.logic;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.entity.Point;

public class TetrahedronValidatorTest {
	@Test
	public void testIsObjectIsTetrahedronShouldReturnTrueWhenTetrahedronIsTetrahedron() {
		// given
		TetrahedronValidator tetrahedronValidator = new TetrahedronValidator();
		Point pointA = new Point(1.4, 2.3, 5.4);
		Point pointB = new Point(-3.4, -6.4, 1.3);
		Point pointC = new Point(2.8, 4.3, 6.2);
		Point pointD = new Point(-7.6, 3.4, -7.6);
		// when
		boolean actual = tetrahedronValidator.isObjectIsTetrahedron(pointA, pointB, pointC, pointD);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsObjectIsTetrahedronShouldReturnFalseWhenTetrahedronIsTetrahedron() {
		// given
		TetrahedronValidator tetrahedronValidator = new TetrahedronValidator();
		Point pointA = new Point(1.4, 2.3, 5.4);
		Point pointB = new Point(-3.4, -6.4, 1.3);
		Point pointC = new Point(2.8, 4.3, 6.2);
		Point pointD = new Point(2.8, 4.3, 6.2);
		// when
		boolean actual = tetrahedronValidator.isObjectIsTetrahedron(pointA, pointB, pointC, pointD);
		// then
		Assert.assertFalse(actual);
	}

}
