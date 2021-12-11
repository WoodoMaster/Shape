package com.epam.shape.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.epam.shape.observer.TetrahedronObservable;
import com.epam.shape.repository.specification.Specification;

public class TetrahedronRepositoryImpl implements TetrahedronRepository {
	private Map<UUID, TetrahedronObservable> store = new HashMap<>();

	@Override
	public List<TetrahedronObservable> query(final Specification specification) {
		List<TetrahedronObservable> tetrahedrons = new ArrayList<>();
		for (TetrahedronObservable tetrahedron : store.values()) {
			if (specification.specified(tetrahedron)) {
				tetrahedrons.add(tetrahedron);
			}
		}
		return tetrahedrons;
	}

	@Override
	public void add(TetrahedronObservable tetrahedron) {
		UUID id = tetrahedron.getId();
		store.put(id, tetrahedron);
	}

	@Override
	public void remove(TetrahedronObservable tetrahedron) {
		UUID id = tetrahedron.getId();
		store.remove(id, tetrahedron);
	}

	@Override
	public void update(TetrahedronObservable oldTetrahedron, TetrahedronObservable newTetrahedron) {
		UUID oldTetrahedronId = oldTetrahedron.getId();
		UUID newTetrahedronId = newTetrahedron.getId();
		store.remove(oldTetrahedronId, oldTetrahedron);
		store.put(newTetrahedronId, newTetrahedron);

	}

	@Override
	public List<TetrahedronObservable> sort(final Comparator<TetrahedronObservable> comparator) {
		List<TetrahedronObservable> result = new ArrayList<>(store.values());
		result.sort(comparator);
		return result;
	}

}
