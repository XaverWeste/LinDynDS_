package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;

public class QueueTriangle extends Object {

    private final QueueTriangle previousQueueTriangle;
    private final boolean up;
    private int a=255;

    public QueueTriangle(double x, double y, QueueTriangle previousQueueTriangle, ViewController viewController){
        this.previousQueueTriangle=previousQueueTriangle;
        this.x = x;
        this.y = y;
        this.viewController = viewController;
        up = previousQueueTriangle == null || !previousQueueTriangle.getUp();
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0,0,0,a);
        if(up){
            drawTool.drawTriangle(x,y-20,x-20,y+20,x+20,y+20);
        }else{
            drawTool.drawTriangle(x,y+20,x-20,y-20,x+20,y-20);
        }
    }

    public boolean getUp(){ return up; }

    @Override
    public void update(double dt){
        if(!arrived){
            if(previousQueueTriangle == null || x > previousQueueTriangle.getX()+30) x -= 100*dt;
            if (x < 120) arrived = true;
        }
        if(deleted){
            a-=20;
            if(up){
                y+=50*dt;
            }else{
                y-=50*dt;
            }
            if(a<=1){
                viewController.removeDrawable(this);
                x=-100;
            }
        }
    }
}