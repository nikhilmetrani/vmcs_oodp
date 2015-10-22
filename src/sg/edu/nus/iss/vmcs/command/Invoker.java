package sg.edu.nus.iss.vmcs.command;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
	
	private Map<String, Command> commandMap = new HashMap<>();
	private static Invoker instance = new Invoker();
	private Invoker(){
	}
	
	public static Invoker getInstance(){
		return instance;
	}
	
	public void addCommand(String cmdStr, Command command){
		commandMap.put(cmdStr, command);
	}
	
	public void invoke(String commandName, CommandParam object){
		Command command = commandMap.get(commandName);
		command.execute(object);
	}
	
}
