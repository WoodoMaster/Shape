package com.epam.shape.repository.specification;

import com.epam.shape.observer.TetrahedronObservable;

public interface Specification {
	public boolean specified(TetrahedronObservable tetrahedron);
}
