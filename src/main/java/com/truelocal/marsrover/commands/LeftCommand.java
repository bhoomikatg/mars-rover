package com.truelocal.marsrover.commands;

import com.truelocal.marsrover.model.Rover;

public class LeftCommand implements ICommand {

	public void run(Rover r) {
		System.out.println("Running left command");
		r.setDirection(r.getDirection().getLeft());
		System.out.println(r);
	}

}
