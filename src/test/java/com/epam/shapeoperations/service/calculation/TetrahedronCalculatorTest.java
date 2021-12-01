package com.epam.shapeoperations.service.calculation;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shapeoperations.entity.Axis;
import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;

public class TetrahedronCalculatorTest {
	@Test
	public void testСalculateSurfaceAreaShouldCalculateAreaWhenTetrahedronIsValid() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(14, 4, 5), new Dot(-5, -3, 2), new Dot(-2, -6, -3),
				new Dot(-2, 2, -1));
		// when
		double result = tetrahedronCalculator.calculateSurfaceArea(tetrahedron);
		// then
		Assert.assertEquals(209.60, result, 0.01);
	}

	@Test
	public void testCalculateVolumeShouldCalculateVolumeWhenTetrahedronIsValid() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(14, 4, 5), new Dot(-5, -3, 2), new Dot(-2, -6, -3),
				new Dot(-2, 2, -1));
		// when
		double result = tetrahedronCalculator.calculateVolume(tetrahedron);
		// then
		Assert.assertEquals(112.67, result, 0.01);
	}

	@Test
	public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenAxisIsOX() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Axis givenAxis = Axis.OX;
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(3, 3, 3), new Dot(1.5, -2, 0), new Dot(1.2, 1.76, 0),
				new Dot(5, 1, 0));
		Dot firstDot = new Dot(2.1, 0, 1.2);
		Dot secondDot = new Dot(1.34, 0, 0);
		Dot thirdDot = new Dot(3.83, 0, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, firstDot, secondDot, thirdDot,
				givenAxis);
		// then
		Assert.assertEquals(0.165, actual, 0.01);
	}

	@Test
	public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenAxisIsOY() {
		// given
		Axis givenAxis = Axis.OY;
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(2, 2, 3), new Dot(1.5, -2, 0), new Dot(1.2, 1.76, 0),
				new Dot(3.5, 1, 0));
		Dot firstDot = new Dot(0, 1.85, 1.13);
		Dot secondDot = new Dot(0, 1.57, 0);
		Dot thirdDot = new Dot(0, 0.09, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, firstDot, secondDot, thirdDot,
				givenAxis);
		// then
		Assert.assertEquals(0.086, actual, 0.01);
	}

	@Test
	public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenAxisIsOZ() {
		// given
		Axis givenAxis = Axis.OZ;
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(0, 0, 2), new Dot(1.5, -2, -6), new Dot(-1.2, 1.76, -6),
				new Dot(3.5, 1, -6));
		Dot secondDot = new Dot(-0.3, 0.44, 0);
		Dot thirdDot = new Dot(0.38, -0.5, 0);
		Dot fourthDot = new Dot(0.88, 0.25, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, secondDot, thirdDot, fourthDot,
				givenAxis);
		// then
		Assert.assertEquals(0.016, actual, 0.01);
	}
}