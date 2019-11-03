package MasterMindMVCPV.controllers;

import MasterMindMVCPV.models.Session;

public abstract class Controller {
    
    protected Session session;

    Controller(Session session) {
        this.session = session;
    }

    public abstract void control() throws CloneNotSupportedException;
}