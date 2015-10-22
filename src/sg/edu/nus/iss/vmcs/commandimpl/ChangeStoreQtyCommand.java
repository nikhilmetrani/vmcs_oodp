package sg.edu.nus.iss.vmcs.commandimpl;

import java.awt.TextField;

import sg.edu.nus.iss.vmcs.command.Command;
import sg.edu.nus.iss.vmcs.command.CommandParam;
import sg.edu.nus.iss.vmcs.store.StoreController;

public class ChangeStoreQtyCommand implements Command {
	public static final String COMMAND_NAME = "changeStoreQty";
	private int type;
	private StoreController storeController;

	public ChangeStoreQtyCommand(int type, StoreController storeController) {
		super();
		this.type = type;
		this.storeController = storeController;
	}

	@Override
	public void execute(CommandParam object) {
		TextField textField = (TextField) object.getSource();
		storeController.changeStoreQty(type, object.getItemNumber(), Integer.parseInt(textField.getText()));

	}

}
