package com.truelocal.marsrover.commands;

import com.truelocal.marsrover.model.Rover;

public interface ICommand {
	public void run(Rover rover);
}
