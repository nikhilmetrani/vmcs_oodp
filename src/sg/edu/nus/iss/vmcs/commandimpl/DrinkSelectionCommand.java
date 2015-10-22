package sg.edu.nus.iss.vmcs.commandimpl;

import java.awt.Button;
import java.awt.Color;

import sg.edu.nus.iss.vmcs.command.*;
import sg.edu.nus.iss.vmcs.customer.TransactionController;

public class DrinkSelectionCommand implements Command {
	
	public static final String COMMAND_NAME = "drinkSelection";
	
	private TransactionController transactionController;

	public DrinkSelectionCommand(TransactionController transactionController) {
		this.transactionController = transactionController;
	}

	@Override
	public void execute(CommandParam object) {
		Button button = (Button)object.getSource();
		button.requestFocus();
		transactionController.startTransaction(object.getItemNumber());
		button.setBackground(Color.yellow);
	}

}
