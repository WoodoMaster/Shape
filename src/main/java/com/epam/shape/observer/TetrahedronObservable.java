package com.epam.shape.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.epam.shape.entity.Point;
import com.epam.shape.entity.Tetrahedron;

public class TetrahedronObservable extends Tetrahedron implements Observable {
	private final UUID id;
	private final String name;
	private final List<Observer> observers = new ArrayList<>();

	public TetrahedronObservable(UUID id, String name, Tetrahedron tetrahedron) {
		super(tetrahedron.getPointA(), tetrahedron.getPointB(), tetrahedron.getPointC(), tetrahedron.getPointD());
		this.id = id;
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public void setPointA(Point pointA) {
		super.setPointA(pointA);
		notifyObservers();
	}

	@Override
	public void setPointB(Point pointB) {
		super.setPointA(pointB);
		notifyObservers();
	}

	@Override
	public void setPointC(Point pointC) {
		super.setPointA(pointC);
		notifyObservers();
	}

	@Override
	public void setPointD(Point pointD) {
		super.setPointA(pointD);
		notifyObservers();
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);

	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);

	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}

	}

}
