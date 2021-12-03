package com.epam.shape.logic;

import org.junit.Assert;
import org.junit.Test;

public class TetrahedronLineValidatorTest {

	@Test
	public void testIsisTetrahedronLineValidShouldReturnTrueWhenTetrahedronLineValid() {
		// given
		TetrahedronLineValidator tetrahedronLineValidator = new TetrahedronLineValidator();
		String line = "-43.5 6.5 3.4 -3.5 5.4 2.4 10.3 4.3 4.5 8.9 2.3 -3.4";
		// when
		boolean actual = tetrahedronLineValidator.isTetrahedronLineValid(line);
		// then
		Assert.assertTrue(actual);
	}

	@Test
	public void testIsisTetrahedronLineValidShouldReturnFalseWhenTetrahedronLineIsNotValid() {
		// given
		TetrahedronLineValidator tetrahedronLineValidator = new TetrahedronLineValidator();
		String line = "-43.5 6.5 3.4-3.5 5.4 2.4 10.3z 4.3 4.5 8.9 2.3-3.4";
		// when
		boolean actual = tetrahedronLineValidator.isTetrahedronLineValid(line);
		// then
		Assert.assertFalse(actual);
	}

}
