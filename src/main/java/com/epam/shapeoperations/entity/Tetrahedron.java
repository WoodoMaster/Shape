package com.epam.shapeoperations.entity;

public class Tetrahedron {
	private Dot a;
	private Dot b;
	private Dot c;
	private Dot d;
	private double surfaceArea;
	private double volume;

	public Tetrahedron(Dot a, Dot b, Dot c, Dot d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Dot getA() {
		return a;
	}

	public void setA(Dot a) {
		this.a = a;
	}

	public Dot getB() {
		return b;
	}

	public void setB(Dot b) {
		this.b = b;
	}

	public Dot getC() {
		return c;
	}

	public void setC(Dot c) {
		this.c = c;
	}

	public Dot getD() {
		return d;
	}

	public void setD(Dot d) {
		this.d = d;
	}

}
