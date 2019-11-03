package MasterMindMVCPV.views.console;

import MasterMindMVCPV.views.MessageView;
import MasterMindMVCPV.utils.YesNoDialog;

public class ResumeView {

	public ResumeView(){}

	public boolean newGame() {
		return new YesNoDialog().read(MessageView.RESUME.getMessage());
	}

}
