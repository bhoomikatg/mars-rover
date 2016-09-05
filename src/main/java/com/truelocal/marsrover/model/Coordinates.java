package com.truelocal.marsrover.model;

public class Coordinates {
	private int xCordinate;
	private int yCordinate;
	
	public Coordinates(int xCordinate, int yCordinate) {
		this.xCordinate = xCordinate;
		this.yCordinate = yCordinate;
	}

	public int getxCordinate() {
		return xCordinate;
	}

	public void setxCordinate(int xCordinate) {
		this.xCordinate = xCordinate;
	}

	public int getyCordinate() {
		return yCordinate;
	}

	public void setyCordinate(int yCordinate) {
		this.yCordinate = yCordinate;
	}

	public boolean isWithinBounds(Coordinates lowerBound , Coordinates upperBound) {
		if (xCordinate <= upperBound.getxCordinate()
			&& yCordinate <=  upperBound.getyCordinate()
			&& xCordinate >= lowerBound.getxCordinate()
			&& yCordinate >= lowerBound.getyCordinate()) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + xCordinate;
		result = prime * result + yCordinate;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (xCordinate != other.xCordinate)
			return false;
		if (yCordinate != other.yCordinate)
			return false;
		return true;
	}
}
