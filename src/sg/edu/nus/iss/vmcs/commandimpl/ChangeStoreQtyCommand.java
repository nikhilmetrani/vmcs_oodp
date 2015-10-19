package sg.edu.nus.iss.vmcs.commandimpl;

import java.awt.TextField;

import sg.edu.nus.iss.vmcs.command.Command;

import sg.edu.nus.iss.vmcs.store.StoreController;

public class ChangeStoreQtyCommand implements Command {
	
	private int type;
	private int item;
	private StoreController storeController;
	TextField textField;

	public ChangeStoreQtyCommand(int type, int item,
			StoreController storeController, TextField textField) {
		super();
		this.type = type;
		this.item = item;
		this.storeController = storeController;
		this.textField = textField;
	}

	@Override
	public void execute() {
		int qty;
		String sqty;
		sqty = textField.getText();
		qty = Integer.parseInt(sqty);
		storeController.changeStoreQty(type, item, qty);
		
	}

}
