package MasterMindMVCPV.views.console;

import MasterMindMVCPV.types.Error;
import MasterMindMVCPV.utils.Console;

public class ErrorView extends MasterMindMVCPV.views.ErrorView {

	public ErrorView(Error error) {
		super(error);
	}
	
	public void writeln() {
		new Console().writeln(ErrorView.MESSAGES[this.error.ordinal()]);
	}	

}
