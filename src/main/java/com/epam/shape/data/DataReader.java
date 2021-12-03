package com.epam.shape.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class DataReader {
	private static final Logger LOGGER = Logger.getLogger(DataReader.class.getName());

	public List<String> read(String filePath) throws DataException {
		List<String> data = new ArrayList<>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				data.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new DataException("The file cannot be found at the specified path! ", e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					LOGGER.warning(e.getMessage());
				}
			}
		}
		return data;
	}
}
