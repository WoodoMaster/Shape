package com.epam.shape.logic;

import java.util.ArrayList;
import java.util.List;

import com.epam.shape.data.DataException;
import com.epam.shape.data.DataReader;
import com.epam.shape.entity.Tetrahedron;

public class Director {
	private final DataReader dataReader;
	private final TetrahedronLineValidator tetrahedronLineValidator;
	private final TetrahedronCreator tetrahedronCreator;

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
				Tetrahedron tetrahedron = tetrahedronCreator.create(line);
				tetrahedrons.add(tetrahedron);
			}
		}
		return tetrahedrons;
	}
}
