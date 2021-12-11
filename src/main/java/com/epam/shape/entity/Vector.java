package com.epam.shape.entity;

public class Vector {
	private final double coordinateX;
	private final double coordinateY;
	private final double coordinateZ;

	public Vector(double coordinateX, double coordinateY, double coordinateZ) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.coordinateZ = coordinateZ;
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public double getCoordinateZ() {
		return coordinateZ;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Vector)) {
			return false;
		}
		Vector vector = (Vector) o;
		return this.coordinateX == vector.getCoordinateX() && this.coordinateY == vector.getCoordinateY()
				&& this.coordinateZ == vector.getCoordinateZ();
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = (int) (31 * result + coordinateX);
		result = (int) (31 * result + coordinateY);
		result = (int) (31 * result + coordinateZ);
		return result;
	}

	@Override
	public String toString() {
		return "Coordinate x: " + coordinateX + ", Coordinate y: " + coordinateY + ", Coordinate z: " + coordinateZ;

	}

}
