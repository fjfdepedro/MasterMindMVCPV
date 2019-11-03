package MasterMindMVCPV.views.console;

import MasterMindMVCPV.views.MessageView;
import MasterMindMVCPV.utils.WithConsoleView;

public class StartView extends WithConsoleView {

	public void writeGameIntro() {
		this.console.writeln(MessageView.TITLE.getMessage());
	}
}
