package com.epam.shape.observer;

import java.util.Map;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronObservableTest {
	@Test
	public void testNotifyObserversShouldChangeParametersWhenDataChanged() {
		// given
		UUID TetrahedronObservableUUID = UUID.randomUUID();
		TetrahedronObservable TetrahedronObservable = new TetrahedronObservable(TetrahedronObservableUUID, "Petya",
				new Tetrahedron(new Point(30, 2, 5), new Point(-15, 3, 2), new Point(-15, 3, 5), new Point(-15, 2, 5)));
		TetrahedronStore tetrahedronStore = TetrahedronStore.getInstance();
		TetrahedronObservable.attach(tetrahedronStore);
		// when
		TetrahedronObservable.setPointA(new Point(3.3, 3.5, -1));
		// then
		Map<UUID, Parameters> parameters = tetrahedronStore.getParameters();
		Parameters firstParameter = parameters.get(TetrahedronObservableUUID);
		Assert.assertEquals(9.15, firstParameter.getVolume(), 0.01);
		Assert.assertEquals(67.53, firstParameter.getSurfaceArea(), 0.01);
	}
}
