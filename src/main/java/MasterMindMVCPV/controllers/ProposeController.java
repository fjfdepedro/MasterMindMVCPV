package MasterMindMVCPV.controllers;

import java.util.ArrayList;
import java.util.List;
import MasterMindMVCPV.models.Combination;
import MasterMindMVCPV.models.Session;
import MasterMindMVCPV.types.Color;
import MasterMindMVCPV.types.Error;
import MasterMindMVCPV.views.console.ErrorView;
import MasterMindMVCPV.views.MessageView;
import MasterMindMVCPV.views.console.ColorView;
import MasterMindMVCPV.views.console.GameView;
import MasterMindMVCPV.views.console.ProposedCombinationView;

public class ProposeController extends Controller {

    private final ProposedCombinationView proposedCombinationView;

    public ProposeController(Session session) {
        super(session);
        this.proposedCombinationView = new ProposedCombinationView();
    }
    @Override
    public void control(){
        Error error;
        do {
            String characters = this.proposedCombinationView.read();
            List<Color> colors = new ArrayList<Color>();
            for (int i=0; i<characters.length(); i++) {
                colors.add(ColorView.getInstance(characters.charAt(i)));
            }
            error = this.addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        this.proposedCombinationView.writeln();
        new GameView().writeGame(this.session);
        this.checkGame();
    }

    private void checkGame(){
        if (this.session.isWinner()) {
            this.proposedCombinationView.writeln(MessageView.WINNER.getMessage());
            this.session.next();
        } else if (this.session.isLooser()) {
            this.proposedCombinationView.writeln(MessageView.LOOSER.getMessage());
            this.session.next();
        }
    }


    private Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }
            }
        }
        if (error == null){
            this.session.addProposedCombination(colors);
        }
        return error;
    }
}