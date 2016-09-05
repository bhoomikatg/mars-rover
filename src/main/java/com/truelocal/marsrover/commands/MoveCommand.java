package com.truelocal.marsrover.commands;

import com.truelocal.marsrover.model.Coordinates;
import com.truelocal.marsrover.model.Rover;

public class MoveCommand implements ICommand {
	public void run(Rover r) {
		System.out.println("Running move command");
		Coordinates newCoordinate = new Coordinates(r.getCoordinates().getxCordinate() + r.getDirection().getXstep(), r.getCoordinates().getyCordinate() + r.getDirection().getYstep());
		if (newCoordinate.isWithinBounds(Rover.lowerBoundaryCoordinates, Rover.upperBoundaryCoordinates)) {
			r.setCoordinates(newCoordinate);
			System.out.println(r);
		}
	}
}
