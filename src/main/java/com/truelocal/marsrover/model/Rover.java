package com.truelocal.marsrover.model;

import com.truelocal.marsrover.commands.CommandFactory;
import com.truelocal.marsrover.commands.ICommand;
import com.truelocal.marsrover.type.DirectionType;

public class Rover 
{
	private DirectionType direction;
	private Coordinates coordinates;
	public static Coordinates upperBoundaryCoordinates;
	public static final Coordinates lowerBoundaryCoordinates = new Coordinates(0, 0);
	
	public Rover(DirectionType direction, Coordinates coordinates) {
		this.direction = direction;
		this.coordinates = coordinates;
	}	
	
	public DirectionType getDirection() {
		return direction;
	}

	public void setDirection(DirectionType direction) {
		this.direction = direction;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public void explore(String commands) {		
		for (int i= 0 ; i < commands.length(); i++) {
			char command = commands.charAt(i);
			ICommand commandToExecute = CommandFactory.createCommand(command);
			if (commandToExecute != null)
				commandToExecute.run(this);
		}
	}
	
	@Override
	public String toString() {
		return this.getCoordinates().getxCordinate() + " "
				+ this.getCoordinates().getyCordinate() +" "
				+ this.getDirection();
	}
}
