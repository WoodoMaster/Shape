package com.epam.shapeoperations.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shapeoperations.entity.Axis;
import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;

public class ValidatorTest {
	@Test
	public void testWhichAxisCrossingShouldReturnAxisOXCrossingWhenTetrahedronGiven() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, 5), new Dot(-15, 3, 2), new Dot(-15, 3, 5),
				new Dot(-15, 2, 5));
		List<Axis> expected = Arrays.asList(Axis.OX);
		// when
		List<Axis> actual = validator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOYCrossingWhenTetrahedronGiven() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, 5), new Dot(15, -2, 2), new Dot(15, 3, 5),
				new Dot(15, -4, 5));
		List<Axis> expected = Arrays.asList(Axis.OY);
		// when
		List<Axis> actual = validator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOZCrossingWhenTetrahedronGiven() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, -5), new Dot(15, 2, 2), new Dot(15, 3, -5),
				new Dot(15, 4, 5));
		List<Axis> expected = Arrays.asList(Axis.OZ);
		// when
		List<Axis> actual = validator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testWhichAxisCrossingShouldReturnAxisOXOYOZCrossingWhenTetrahedronGiven() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, -5), new Dot(-15, -2, 2), new Dot(-15, 3, -5),
				new Dot(-15, 4, 5));
		List<Axis> expected = Arrays.asList(Axis.OX, Axis.OY, Axis.OZ);
		// when
		List<Axis> actual = validator.whichAxisesCrossing(tetrahedron);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnOX() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, -5), new Dot(0, -2, 2), new Dot(0, 3, -5),
				new Dot(0, 4, 5));
		// when
		boolean actual = validator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnOY() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, -5), new Dot(1, 0, 2), new Dot(2, 0, -5),
				new Dot(4, 0, 5));
		// when
		boolean actual = validator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnTrueWhenBaseIsOnAxis() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, 0), new Dot(6, -2, 0), new Dot(3, 3, 0),
				new Dot(4, 4, 0));
		// when
		boolean actual = validator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsBaseOnAxisShouldReturnFalseWhenBaseIsNotOnAxis() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(30, 2, -5), new Dot(10, -2, 2), new Dot(10, 3, -5),
				new Dot(10, 4, 5));
		// when
		boolean actual = validator.isBaseOnAxis(tetrahedron);
		// then
		Assert.assertFalse(actual);
	}

	@Test
	public void testIsisTetrahedronLineValidShouldReturnTrueWhenTetrahedronLineValid() {
		// given

		Validator validator = new Validator();
		String line = "-43.5 6.5 3.4 -3.5 5.4 2.4 10.3 4.3 4.5 8.9 2.3 -3.4";
		// when
		boolean actual = validator.isTetrahedronLineValid(line);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsisTetrahedronLineValidShouldReturnFalseWhenTetrahedronLineIsNotValid() {
		// given

		Validator validator = new Validator();
		String line = "-43.5 6.5 3.4-3.5 5.4 2.4 10.3z 4.3 4.5 8.9 2.3-3.4";
		// when
		boolean actual = validator.isTetrahedronLineValid(line);
		// then
		Assert.assertFalse(actual);
	}

	@Test
	public void testIsObjectIsTetrahedronShouldReturnTrueWhenTetrahedronIsTetrahedron() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(1.4, 2.3, 5.4), new Dot(-3.4, -6.4, 1.3),
				new Dot(2.8, 4.3, 6.2), new Dot(-7.6, 3.4, -7.6));
		// when
		boolean actual = validator.isObjectIsTetrahedron(tetrahedron);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsObjectIsTetrahedronShouldReturnFalseWhenTetrahedronIsTetrahedron() {
		// given
		Validator validator = new Validator();
		Tetrahedron tetrahedron = new Tetrahedron(new Dot(1.4, 2.3, 5.4), new Dot(-3.4, -6.4, 1.3),
				new Dot(2.8, 4.3, 6.2), new Dot(2.8, 4.3, 6.2));
		// when
		boolean actual = validator.isObjectIsTetrahedron(tetrahedron);
		// then
		Assert.assertFalse(actual);
	}

}
