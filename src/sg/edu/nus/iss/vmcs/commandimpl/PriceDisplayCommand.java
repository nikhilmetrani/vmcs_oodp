/*
package sg.edu.nus.iss.vmcs.maintenance.commandimpl;

import java.awt.TextField;

import sg.edu.nus.iss.vmcs.command.Command;
import sg.edu.nus.iss.vmcs.maintenance.MaintenanceController;

public class PriceDisplayCommand implements Command {
	
	private MaintenanceController maintenanceController;
	private TextField textField;

	public PriceDisplayCommand(MaintenanceController maintenanceController,
			TextField textField) {
		super();
		this.maintenanceController = maintenanceController;
		this.textField = textField;
	}

	@Override
	public void execute() {
		String sp;
		int ip;
		sp = textField.getText();
		ip = Integer.parseInt(sp);
		maintenanceController.setPrice(ip);
		
	}

}
*/