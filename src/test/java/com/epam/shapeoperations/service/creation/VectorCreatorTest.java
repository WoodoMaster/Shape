package com.epam.shapeoperations.service.creation;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Vector;
import com.epam.shapeoperations.service.DataException;

public class VectorCreatorTest {
	@Test
	public void testVectorCreatorShouldCreateVectorWhenDataIsValid() throws DataException {
		// given
		VectorCreator vectorCreator = new VectorCreator();
		Dot firstDot = new Dot(4, 4, 7);
		Dot secondDot = new Dot(8, 9, 14);
		Vector expectedVector = new Vector(4, 5, 7);
		// when
		Vector actualVector = vectorCreator.createVector(firstDot, secondDot);
		// then
		Assert.assertEquals(expectedVector, actualVector);
	}
}
