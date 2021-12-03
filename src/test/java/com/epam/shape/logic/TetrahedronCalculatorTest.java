package com.epam.shape.logic;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.entity.Axis;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronCalculatorTest {
	@Test
	public void testСalculateSurfaceAreaShouldCalculateAreaWhenTetrahedronIsValid() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(14, 4, 5), new Point(-5, -3, 2), new Point(-2, -6, -3),
				new Point(-2, 2, -1));
		// when
		double result = tetrahedronCalculator.calculateSurfaceArea(tetrahedron);
		// then
		Assert.assertEquals(209.60, result, 0.01);
	}

	@Test
	public void testCalculateVolumeShouldCalculateVolumeWhenTetrahedronIsValid() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(14, 4, 5), new Point(-5, -3, 2), new Point(-2, -6, -3),
				new Point(-2, 2, -1));
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
		Tetrahedron tetrahedron = new Tetrahedron(new Point(3, 3, 3), new Point(1.5, -2, 0), new Point(1.2, 1.76, 0),
				new Point(5, 1, 0));
		Point firstPoint = new Point(2.1, 0, 1.2);
		Point secondPoint = new Point(1.34, 0, 0);
		Point thirdPoint = new Point(3.83, 0, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, firstPoint, secondPoint, thirdPoint,
				givenAxis);
		// then
		Assert.assertEquals(0.165, actual, 0.01);
	}

	@Test
	public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenAxisIsOY() {
		// given
		Axis givenAxis = Axis.OY;
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(2, 2, 3), new Point(1.5, -2, 0), new Point(1.2, 1.76, 0),
				new Point(3.5, 1, 0));
		Point firstPoint = new Point(0, 1.85, 1.13);
		Point secondPoint = new Point(0, 1.57, 0);
		Point thirdPoint = new Point(0, 0.09, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, firstPoint, secondPoint, thirdPoint,
				givenAxis);
		// then
		Assert.assertEquals(0.086, actual, 0.01);
	}

	@Test
	public void testCalculateVolumeRatioShouldCalculateVolumeRatioWhenAxisIsOZ() {
		// given
		Axis givenAxis = Axis.OZ;
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(0, 0, 2), new Point(1.5, -2, -6), new Point(-1.2, 1.76, -6),
				new Point(3.5, 1, -6));
		Point secondPoint = new Point(-0.3, 0.44, 0);
		Point thirdPoint = new Point(0.38, -0.5, 0);
		Point fourthPoint = new Point(0.88, 0.25, 0);
		// when
		double actual = tetrahedronCalculator.calculateVolumeRatio(tetrahedron, secondPoint, thirdPoint, fourthPoint,
				givenAxis);
		// then
		Assert.assertEquals(0.016, actual, 0.01);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOXCrossingWhenTetrahedronGiven() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, 5), new Point(-15, 3, 2), new Point(-15, 3, 5),
				new Point(-15, 2, 5));
		List<Axis> expected = Arrays.asList(Axis.OX);
		// when
		List<Axis> actual = tetrahedronCalculator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOYCrossingWhenTetrahedronGiven() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, 5), new Point(15, -2, 2), new Point(15, 3, 5),
				new Point(15, -4, 5));
		List<Axis> expected = Arrays.asList(Axis.OY);
		// when
		List<Axis> actual = tetrahedronCalculator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOZCrossingWhenTetrahedronGiven() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, -5), new Point(15, 2, 2), new Point(15, 3, -5),
				new Point(15, 4, 5));
		List<Axis> expected = Arrays.asList(Axis.OZ);
		// when
		List<Axis> actual = tetrahedronCalculator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOXOYOZCrossingWhenTetrahedronGiven() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, -5), new Point(-15, -2, 2), new Point(-15, 3, -5),
				new Point(-15, 4, 5));
		List<Axis> expected = Arrays.asList(Axis.OX, Axis.OY, Axis.OZ);
		// when
		List<Axis> actual = tetrahedronCalculator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnOX() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, -5), new Point(0, -2, 2), new Point(0, 3, -5),
				new Point(0, 4, 5));
		// when
		boolean actual = tetrahedronCalculator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnOY() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, -5), new Point(1, 0, 2), new Point(2, 0, -5),
				new Point(4, 0, 5));
		// when
		boolean actual = tetrahedronCalculator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnAxis() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, 0), new Point(6, -2, 0), new Point(3, 3, 0),
				new Point(4, 4, 0));
		// when
		boolean actual = tetrahedronCalculator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnFalseWhenBaseIsNotOnAxis() {
		// given
		TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();
		Tetrahedron tetrahedron = new Tetrahedron(new Point(30, 2, -5), new Point(10, -2, 2), new Point(10, 3, -5),
				new Point(10, 4, 5));
		// when
		boolean actual = tetrahedronCalculator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertFalse(actual);
	}
}