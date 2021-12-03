package com.epam.shape.logic;


import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Vector;
import com.epam.shape.logic.VectorCalculator;
import com.epam.shape.logic.VectorCreator;

public class VectorCalculatorTest {
	@Test
	public void testProductOfVectorsShouldProductOfVectorsWhenTwoVectorsGiven() {
		// given
		VectorCalculator vectorCalculator = new VectorCalculator();
		Vector firstVector = new Vector(1, 2, -3);
		Vector secondVector = new Vector(-4, 6, 4);
		Vector expected = new Vector(26, 8, 14);
		// when
		Vector actual = vectorCalculator.productOfVectors(firstVector, secondVector);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLengthOfVectorShouldLengthOfVectorWhenVectorGiven() {
		// given
		VectorCalculator vectorCalculator = new VectorCalculator();
		Vector firstVector = new Vector(1, 3, 5);
		// when
		double result = vectorCalculator.lengthOfVector(firstVector);
		// then
		Assert.assertEquals(5.916, result, 0.01);
	}

	@Test
	public void testCreateVectorShouldCreateVectorWhenTwoDotsGiven() {
		// given
		VectorCreator vectorCreator = new VectorCreator();
		Point firstPoint = new Point(-4, 2, 5);
		Point secondPoint = new Point(1, 9, 0);
		Vector expected = new Vector(5, 7, -5);
		// when
		Vector actual = vectorCreator.createVector(firstPoint, secondPoint);
		// then
		Assert.assertEquals(expected, actual);
	}

}
