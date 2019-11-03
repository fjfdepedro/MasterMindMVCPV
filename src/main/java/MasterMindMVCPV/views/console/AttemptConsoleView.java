package MasterMindMVCPV.views.console;

import MasterMindMVCPV.views.MessageView;
import MasterMindMVCPV.utils.WithConsoleView;

class AttemptConsoleView extends WithConsoleView {

    void writeln(int attemps) {
        this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceAll("#attempts", "" + attemps));
    }
}