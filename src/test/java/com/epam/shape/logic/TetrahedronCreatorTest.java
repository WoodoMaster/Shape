package com.epam.shape.logic;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.data.DataException;
import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronCreatorTest {
	@Test
	public void testTetrahedronCreatorShouldCreateTetrahedronWhenDataIsValid() throws DataException {
		// given
		TetrahedronCreator tetrahedronCreator = new TetrahedronCreator();
		String line = "1.4 2.3 5.4 -3.4 -6.4 1.3 2.8 4.3 6.2 -7.6 3.4 -7.6";
		Tetrahedron expectedThetrahedron = new Tetrahedron(new Point(1.4, 2.3, 5.4), new Point(-3.4, -6.4, 1.3),
				new Point(2.8, 4.3, 6.2), new Point(-7.6, 3.4, -7.6));
		// when
		Tetrahedron actualThetrahedron = tetrahedronCreator.create(line).get();
		// then
		Assert.assertEquals(expectedThetrahedron, actualThetrahedron);
	}
}
