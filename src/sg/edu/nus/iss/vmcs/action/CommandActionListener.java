package sg.edu.nus.iss.vmcs.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sg.edu.nus.iss.vmcs.command.CommandParam;
import sg.edu.nus.iss.vmcs.command.Invoker;

//import sg.edu.nus.iss.vmcs.customer.command;

public class CommandActionListener implements ActionListener {

	private String commandName;
	private CommandParam object;

	public CommandActionListener(String commandName, CommandParam object) {
		this.commandName = commandName;
		this.object = object;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Invoker invoker = Invoker.getInstance();
		invoker.invoke(commandName, object);
	}

}
