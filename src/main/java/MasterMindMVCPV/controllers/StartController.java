package MasterMindMVCPV.controllers;

import MasterMindMVCPV.models.Session;
import MasterMindMVCPV.views.console.SecretCombinationView;
import MasterMindMVCPV.views.console.StartView;

public class StartController extends Controller {

    private StartView starView;

    public StartController(Session session) {
        super(session);
        this.starView = new StartView();
    }

    public void start() {
        this.session.next();
    }

    @Override
    public void control() {
        new StartView().writeGameIntro();
        new SecretCombinationView().writeln(this.session.getGameWidth());
        session.next();
    }
}