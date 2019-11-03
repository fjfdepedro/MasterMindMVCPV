package MasterMindMVCPV;

import java.util.HashMap;
import java.util.Map;

import MasterMindMVCPV.controllers.Controller;
import MasterMindMVCPV.controllers.ProposeController;
import MasterMindMVCPV.controllers.ResumeController;
import MasterMindMVCPV.controllers.StartController;
import MasterMindMVCPV.models.Session;
import MasterMindMVCPV.models.StateValue;


public class MasterMind {

    Session session;
    Map<StateValue, Controller> controllers;

    private MasterMind() {
        this.session = new Session();
        this.controllers = new HashMap<>();
        controllers.put(StateValue.INITIAL, new StartController(session));
        controllers.put(StateValue.IN_GAME, new ProposeController(session));
        controllers.put(StateValue.FINAL, new ResumeController(session));
        controllers.put(StateValue.EXIT, null);
    }

    public void play() throws CloneNotSupportedException {
        Controller controller;
        do {
            controller = this.controllers.get(this.session.getStateValue());
            if (controller != null){
                controller.control();
            }
        } while (controller != null);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        new MasterMind().play();
    }

}