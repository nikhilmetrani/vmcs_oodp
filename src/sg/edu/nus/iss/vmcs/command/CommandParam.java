package sg.edu.nus.iss.vmcs.command;

public class CommandParam {
	
	private Object source;
	private int itemNumber;
	
	public CommandParam(){
		
	}
	
	public CommandParam(Object source, int itemNumber){
		this.source = source;
		this.itemNumber = itemNumber;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}

	public int getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	
	
}
