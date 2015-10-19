package sg.edu.nus.iss.vmcs.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.command.Command;

//import sg.edu.nus.iss.vmcs.customer.command;

public class CommandActionListener implements ActionListener {

	private Command command;
	
	public CommandActionListener(Command command) {
		this.command = command;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Command.INVOKER.invoke(command);
	}

}
