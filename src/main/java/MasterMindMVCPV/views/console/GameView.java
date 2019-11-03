package MasterMindMVCPV.views.console;

import MasterMindMVCPV.models.Session;
import MasterMindMVCPV.types.Color;
import MasterMindMVCPV.utils.WithConsoleView;

public class GameView extends WithConsoleView {

        public GameView() { }

        public void writeGame(Session session) {
            new AttemptConsoleView().writeln(session.getAttempts());
            new SecretCombinationView().writeln(session.getGameWidth());
            for (int i = 0; i < session.getAttempts(); i++) {
                this.writeColors(i,session);
            }
        }

        private void writeColors(int position,Session session){
            for (Color color : session.getColors(position)) {
                new ColorView(color).write();
            }
            new ResultView().writeln(session.getBlacks(position),session.getWhites(position));
        }
}
