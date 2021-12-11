package com.epam.shape.logic;


import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.data.DataException;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Vector;

public class VectorCreatorTest {
	@Test
	public void testVectorCreatorShouldCreateVectorWhenDataIsValid() throws DataException {
		// given
		VectorCreator vectorCreator = new VectorCreator();
		Point firstPoint = new Point(4, 4, 7);
		Point secondPoint = new Point(8, 9, 14);
		Vector expectedVector = new Vector(4, 5, 7);
		// when
		Vector actualVector = vectorCreator.createVector(firstPoint, secondPoint);
		// then
		Assert.assertEquals(expectedVector, actualVector);
	}
}
