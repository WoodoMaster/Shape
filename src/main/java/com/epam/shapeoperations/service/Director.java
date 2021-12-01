package com.epam.shapeoperations.service;

import java.util.ArrayList;
import java.util.List;

import com.epam.shapeoperations.entity.Tetrahedron;
import com.epam.shapeoperations.service.creation.TetrahedronCreator;

public class Director {
	private DataReader dataReader;
	private Validator validator;
	private TetrahedronCreator tetrahedronCreator;

	public Director(DataReader dataReader, Validator validator, TetrahedronCreator tetrahedronCreator) {
		this.dataReader = dataReader;
		this.validator = validator;
		this.tetrahedronCreator = tetrahedronCreator;
	}

	public List<Tetrahedron> read(String path) throws DataException {
		List<Tetrahedron> tetrahedrons = new ArrayList<>();
		for (String line : dataReader.read(path)) {
			if (validator.isTetrahedronLineValid(line)) {
				Tetrahedron tetrahedron = tetrahedronCreator.create(line);
				if (validator.isObjectIsTetrahedron(tetrahedron)) {
					tetrahedrons.add(tetrahedron);
				}
			}
		}
		return tetrahedrons;
	}
}
