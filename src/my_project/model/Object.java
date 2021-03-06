package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public abstract class Object extends GraphicalObject {

    protected boolean arrived;
    protected boolean deleted;
    protected ViewController viewController;

    public Object(){
        arrived = false;
        deleted = false;
        radius = 20;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawCircle(x,y,radius);
    }

    public boolean tryToDelete(){
        if(arrived)
            return deleted=true;
        return false;
    }
}
