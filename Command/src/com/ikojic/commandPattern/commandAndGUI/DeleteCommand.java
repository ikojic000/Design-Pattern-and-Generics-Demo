package com.ikojic.commandPattern.commandAndGUI;


public interface DeleteCommand {
	
	void executeDeleteCMD();
	
	void undoDeleteCMD();
	
	void redoDeleteCMD();
	
}
