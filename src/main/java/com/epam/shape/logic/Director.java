package com.epam.shape.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.epam.shape.data.DataException;
import com.epam.shape.data.DataReader;
import com.epam.shape.entity.Tetrahedron;

public class Director {
	private final DataReader dataReader;
	private final TetrahedronLineValidator tetrahedronLineValidator;
	private final TetrahedronCreator tetrahedronCreator;
	private static final Logger LOGGER = Logger.getLogger(Director.class.getName());

	public Director(DataReader dataReader, TetrahedronLineValidator tetrahedronLineValidator,
			TetrahedronCreator tetrahedronCreator) {
		this.dataReader = dataReader;
		this.tetrahedronLineValidator = tetrahedronLineValidator;
		this.tetrahedronCreator = tetrahedronCreator;
	}

	public List<Tetrahedron> read(String path) throws DataException {
		List<Tetrahedron> tetrahedrons = new ArrayList<>();
		for (String line : dataReader.read(path)) {
			if (tetrahedronLineValidator.isTetrahedronLineValid(line)) {
				Optional<Tetrahedron> tetrahedron = tetrahedronCreator.create(line);
				if (tetrahedron.isPresent()) {
					tetrahedrons.add(tetrahedron.get());
				}

			}
		}
		LOGGER.info("Data was read successfully");
		return tetrahedrons;
	}
}
