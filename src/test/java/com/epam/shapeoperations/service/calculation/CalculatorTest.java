package com.epam.shapeoperations.service.calculation;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;

public class CalculatorTest {
	@Test
	public void testcalculateVolumeShouldCalculateVolumeWhenNumbersGiven() {
		// given
		Calculator calculator = new Calculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(14, 4, 5), new Dot(-5, -3, 2), new Dot(-2, -6, -3),
				new Dot(-2, 2, -1));
		// when
		double result = calculator.calculateVolume(tetrahedron);
		// then
		Assert.assertEquals(112.67, result, 0.01);
	}

	@Test
	public void getSegmentLengthShouldGetSegmentLengthWhenNumbersGiven() {
		// given
		Calculator calculator = new Calculator();
		Dot firstPoint = new Dot(3, 2, 3);
		Dot secondPoint = new Dot(5, 3, 8);
		// when
		double result = calculator.getSegmentLength(firstPoint, secondPoint);
		// then
		Assert.assertEquals(5.48, result,0.01);
	}
}