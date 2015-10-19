package sg.edu.nus.iss.vmcs.command;

public interface Command {
	
	class Invoker{
		public void invoke(Command command){
			command.execute();
		}
	};
	
	Invoker INVOKER = new Invoker();

	void execute();

}