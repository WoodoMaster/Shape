package com.epam.shape.logic;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;
import com.epam.shape.logic.TetrahedronCreator;

// TODO mochito
//TODO optional in creator
//TODO Tetr validator Point pointD=tetr.getPointD();
public class DirectorTest {
//	private static final String TEST_PATH = "path";
//	private static final String VALID_LINE1 = "1.4 2.3 5.4 -3.4 -6.4 1.3 2.8 4.3 6.2 -7.6 3.4 -7.6";
//	private static final String VALID_LINE2 = "-43.5 6.5 3.4 -3.5 5.4 2.4 10.3 4.3 4.5 8.9 2.3 -3.4";
//	private static final String INVALID_LINE = "-43.5 6.5 3.4-3.5 5.4 2.4 10.3z 4.3 4.5 8.9 2.3-3.4";
//	private static final Tetrahedron VALID_THETRAHEDRON1 = new Tetrahedron(new Dot(1.4, 2.3, 5.4),
//			new Dot(-3.4, -6.4, 1.3), new Dot(2.8, 4.3, 6.2), new Dot(-7.6, 3.4, -7.6));
//	private static final Tetrahedron VALID_THETRAHEDRON2 = new Tetrahedron(new Dot(-43.5, 6.5, 3.4),
//			new Dot(-3.5, 5.4, 2.4), new Dot(10.3, 4.3, 4.5), new Dot(8.9, 2.3, -3.4));
//
//	@Test
//	public void testReadShouldReadLinesWhenLinesAreValid() throws DataException {
//		// given
//		List<String> actualLines = Arrays.asList(VALID_LINE1, VALID_LINE2);
//		DataReader reader = Mockito.mock(DataReader.class);
//		Mockito.when(reader.read(TEST_PATH)).thenReturn(actualLines);
//		Validator validator = Mockito.mock(Validator.class);
//		Mockito.when(validator.isTetrahedronLineValid(VALID_LINE1)).thenReturn(true);
//		Mockito.when(validator.isTetrahedronLineValid(VALID_LINE2)).thenReturn(true);
//		TetrahedronCreator creator = Mockito.mock(TetrahedronCreator.class);
//		Mockito.when(creator.create(VALID_LINE1)).thenReturn(VALID_THETRAHEDRON1);
//		Mockito.when(creator.create(VALID_LINE2)).thenReturn(VALID_THETRAHEDRON2);
//		Director director = new Director(reader, validator, creator);
//		List<Tetrahedron> expected = Arrays.asList(VALID_THETRAHEDRON1, VALID_THETRAHEDRON2);
//		// when
//		List<Tetrahedron> actual = director.read(TEST_PATH);
//		// then
//		Assert.assertEquals(expected, actual);
//	}
}
