package com.epam.shapeoperations.service.dal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.epam.shapeoperations.service.exception.DataException;

public class DataReader{
	public List<String> read(String filePath) throws DataException {
		try {
			return Files.readAllLines(Paths.get(filePath));
		} catch (IOException err) {
			throw new DataException("The file cannot be found at the specified path! ", err.getCause());
		}
	}
}
