package com.epam.shape.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.epam.shape.data.DataException;
import com.epam.shape.data.DataReader;
import com.epam.shape.entity.Tetrahedron;

public class DirectorTest {
	private final static String PATH = "src/test/resources/correctData";
	private final static String LINE = "1.4 2.3 5.4 -3.4 -6.4 1.3 2.8 4.3 6.2 -7.6 3.4 -7.6";
	private final static Optional<Tetrahedron> TETRAHEDRON = Optional.of(Mockito.mock(Tetrahedron.class));

	@Test
	public void testReadShouldCreateWhenValid() throws DataException {
		// given
		DataReader reader = Mockito.mock(DataReader.class);
		Mockito.when(reader.read(PATH)).thenReturn(Arrays.asList(LINE));

		TetrahedronLineValidator tetrahedronLineValidator = Mockito.mock(TetrahedronLineValidator.class);
		Mockito.when(tetrahedronLineValidator.isTetrahedronLineValid(LINE)).thenReturn(true);

		TetrahedronCreator tetrahedronCreator = Mockito.mock(TetrahedronCreator.class);
		Mockito.when(tetrahedronCreator.create(LINE)).thenReturn(TETRAHEDRON);
		Director director = new Director(reader, tetrahedronLineValidator, tetrahedronCreator);
//		// when
		List<Tetrahedron> tetrahedrons = director.read(PATH);
//		// then
		Assert.assertEquals(1, tetrahedrons.size());
		Assert.assertEquals(TETRAHEDRON.get(), tetrahedrons.get(0));

		Mockito.verify(reader, Mockito.times(1)).read(PATH);
		Mockito.verify(tetrahedronLineValidator, Mockito.times(1)).isTetrahedronLineValid(LINE);
		Mockito.verify(tetrahedronCreator, Mockito.times(1)).create(LINE);
		Mockito.verifyNoMoreInteractions(reader, tetrahedronLineValidator, tetrahedronCreator);
	}
}
