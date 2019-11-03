package MasterMindMVCPV.views.console;

import MasterMindMVCPV.utils.WithConsoleView;
import MasterMindMVCPV.views.MessageView;

public class ProposedCombinationView extends WithConsoleView {

	public ProposedCombinationView() { }

	public String read() {
		return (this.console.readString(MessageView.PROPOSED_COMBINATION.getMessage()));
	}

	public void writeln(){
		this.console.writeln();
	}

	public void writeln(String message){
		this.console.writeln(message);
	}
	
}
