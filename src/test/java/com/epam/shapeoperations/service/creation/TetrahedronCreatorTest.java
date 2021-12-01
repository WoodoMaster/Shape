package com.epam.shapeoperations.service.creation;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shapeoperations.entity.Dot;
import com.epam.shapeoperations.entity.Tetrahedron;
import com.epam.shapeoperations.service.DataException;

public class TetrahedronCreatorTest {
	@Test
	public void testTetrahedronCreatorShouldCreateTetrahedronWhenDataIsValid() throws DataException {
		// given
		TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();
		String line = "1.4 2.3 5.4 -3.4 -6.4 1.3 2.8 4.3 6.2 -7.6 3.4 -7.6";
		Tetrahedron expectedThetrahedron = new Tetrahedron(new Dot(1.4, 2.3, 5.4), new Dot(-3.4, -6.4, 1.3),
				new Dot(2.8, 4.3, 6.2), new Dot(-7.6, 3.4, -7.6));
		// when
		Tetrahedron actualThetrahedron = tetrahedronCreator.create(line);
		// then
		Assert.assertEquals(expectedThetrahedron, actualThetrahedron);
	}
}
