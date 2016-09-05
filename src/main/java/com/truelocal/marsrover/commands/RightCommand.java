package com.truelocal.marsrover.commands;

import com.truelocal.marsrover.model.Rover;

public class RightCommand implements ICommand {

	public void run(Rover r) {
		System.out.println("Running right command");
		r.setDirection(r.getDirection().getRight());
		System.out.println(r);
	}

}
