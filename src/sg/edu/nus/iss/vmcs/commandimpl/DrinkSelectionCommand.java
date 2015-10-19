package sg.edu.nus.iss.vmcs.commandimpl;

import java.awt.Button;
import java.awt.Color;

import sg.edu.nus.iss.vmcs.command.*;
import sg.edu.nus.iss.vmcs.customer.TransactionController;



public class DrinkSelectionCommand implements Command{
	
	private Button button;
	private TransactionController transactionController;
	private int drinkIdentifier;

	public DrinkSelectionCommand(Button button,
			TransactionController transactionController, int drinkIdentifier) {
		super();
		this.button = button;
		this.transactionController = transactionController;
		this.drinkIdentifier = drinkIdentifier;
	}

	@Override
	public void execute() {
		button.requestFocus();
		transactionController.startTransaction(drinkIdentifier);
		button.setBackground(Color.yellow);
	}

}
