package com.epam.shape.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import com.epam.shape.logic.TetrahedronCalculator;

public class TetrahedronStore implements Observer {
	private static final Logger LOGGER = Logger.getLogger(TetrahedronStore.class.getName());
	private static TetrahedronStore instance;
	private final Map<UUID, Parameters> parameters = new HashMap<>();
	private final TetrahedronCalculator tetrahedronCalculator = new TetrahedronCalculator();

	private TetrahedronStore() {
	}

	public void update(TetrahedronObservable tetrahedron) {
		double volume = tetrahedronCalculator.calculateVolume(tetrahedron);
		double surfaceArea = tetrahedronCalculator.calculateSurfaceArea(tetrahedron);
		parameters.put(tetrahedron.getId(), new Parameters(volume, surfaceArea));
		LOGGER.info("Tetrahedron parameters updated");
	}

	public Map<UUID, Parameters> getParameters() {
		return parameters;
	}

	public static TetrahedronStore getInstance() {
		if (instance == null) {
			instance = new TetrahedronStore();
		}
		return instance;
	}
}
