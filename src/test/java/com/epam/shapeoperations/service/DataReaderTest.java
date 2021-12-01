package com.epam.shapeoperations.service;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
	@Test
	public void testDataReaderShouldReadDataWhenPathValid() throws DataException {
		// given
		final String PATH = "src/test/resources/correctData";
		DataReader dataReader = new DataReader();
		List<String> expected = Arrays.asList("1.4 2.3 5.4 -3.4 -6.4 1.3 2.8 4.3 6.2 -7.6 3.4 -7.6",
				"-43.5 6.5 3.4 -3.5 5.4 2.4 10.3 4.3 4.5 8.9 2.3 -3.4");
		// when
		List<String> actual = dataReader.read(PATH);
		// then
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = DataException.class)
	public void testDataReaderShouldReadDataWhenPathInvalid() throws DataException {
		// given
		final String INVALID_PATH = "src/test/resources/c0rrectD4ta";
		DataReader dataReader = new DataReader();
		// when
		List<String> actual = dataReader.read(INVALID_PATH);
	}
}
