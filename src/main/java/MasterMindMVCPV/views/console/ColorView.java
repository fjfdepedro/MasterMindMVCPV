package MasterMindMVCPV.views.console;

import MasterMindMVCPV.types.Color;
import MasterMindMVCPV.utils.Console;

public class ColorView extends MasterMindMVCPV.views.ColorView {

    public ColorView(Color color) {
        super(color);
    }

    public void write() {
        new Console().write(ColorView.INITIALS[this.color.ordinal()]);
    }

}