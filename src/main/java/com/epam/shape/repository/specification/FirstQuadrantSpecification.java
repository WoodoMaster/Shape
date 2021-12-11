package com.epam.shape.repository.specification;

import com.epam.shape.entity.Point;
import com.epam.shape.observer.TetrahedronObservable;

public class FirstQuadrantSpecification implements Specification {

	@Override
	public boolean specified(TetrahedronObservable tetrahedron) {
		Point point = tetrahedron.getPointA();
		return point.getCoordinateX() > 0 && point.getCoordinateY() > 0 && point.getCoordinateZ() > 0;
	}
}