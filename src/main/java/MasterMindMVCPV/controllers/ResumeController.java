package MasterMindMVCPV.controllers;

import MasterMindMVCPV.models.Game;
import MasterMindMVCPV.models.Session;
import MasterMindMVCPV.views.console.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        if (new ResumeView().newGame()) {
            this.session.resume();
        }
        this.session.next();
    }
}
