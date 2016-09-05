package com.truelocal.marsrover.commands;

public class CommandFactory {
	public static ICommand createCommand(char c) {
		ICommand command = null;
		switch(c) {
		case 'L':
			command = new LeftCommand();
			break;
		case 'R':
			command = new RightCommand();
			break;
		case 'M':
			command = new MoveCommand();
			break;
		}
		return command;
	}
}
