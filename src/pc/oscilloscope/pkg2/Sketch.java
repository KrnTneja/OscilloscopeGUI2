
package pc.oscilloscope.pkg2;

import processing.core.PApplet;

public class Sketch {
    
    PCOscilloscope2 master;
    int p;
    int q;
    float[] x;
    float[] currDataPoints;
    GraphPlotter plotter;
    static float magnification = 1.00f; // varies from 0 to 10
    static float timeMagnification = 1;
    static float holdOff = 0.000004f;
    static float triggerPoint = 0;
    static float m1Voltage = 0;
    static float standardLevel = 60;
    static float timePerDiv = 0.000008f;
    static float offset = 0;
    
    void giveMaster(PCOscilloscope2 myMaster) {
        this.master = myMaster;        
    }
    
    void givePlotter (GraphPlotter myPlotter) {
        this.plotter = myPlotter;
        /*if (this.plotter != null) {
            System.out.println("Masters Plotter isn't null.");
        } else {
            System.out.println("Masters plotter is null.");
        }*/
    }
    
    public void assignVar() {
        p = 600;
        q = 600;
        x = new float[200];
        for (int i = 0; i < 199; i++){
            x[i+1] = x[i] + (p/200);
        }
        // this.dataPoints = new float[200];
        //System.out.println(x);
    }
    
    public void refresh(PApplet pApplet) {
        pApplet.background(0);
        pApplet.stroke(0, 255, 200);
        pApplet.strokeWeight((float) 0.25);
        pApplet.line(0, 60, 600, 60);
        pApplet.line(0, 120, 600, 120);
        pApplet.line(0, 180, 600, 180);
        pApplet.line(0, 240, 600, 240);
        pApplet.line(0, 360, 600, 360);
        pApplet.line(0, 420, 600, 420);
        pApplet.line(0, 480, 600, 480);
        pApplet.line(0, 540, 600, 540);
        pApplet.line(60, 0, 60, 600);
        pApplet.line(120, 0, 120, 600);
        pApplet.line(180, 0, 180, 600);
        pApplet.line(240, 0, 240, 600);
        pApplet.line(360, 0, 360, 600);
        pApplet.line(420, 0, 420, 600);
        pApplet.line(480, 0, 480, 600);
        pApplet.line(540, 0, 540, 600);
        pApplet.strokeWeight((float) 1);
        pApplet.stroke(255);
        pApplet.line(0, 300, 600, 300);
        pApplet.line(300, 0, 300, 600);
        pApplet.fill(255, 200, 0);
        pApplet.stroke(255, 200, 0);
        pApplet.triangle(600, -triggerPoint+300-5 , 600, -triggerPoint+300+5 , 590, -triggerPoint+300);
        pApplet.strokeWeight((float) 0.5);
        pApplet.stroke(255, 0, 0);
        pApplet.line(0, -triggerPoint+300, 590, -triggerPoint+300);
        pApplet.strokeWeight((float) 1);
        pApplet.textSize(15);
        pApplet.fill(255);
        pApplet.text("Y axis (V/div) " + m1Voltage/magnification + " V", 0, 590);
        pApplet.text("X axis (ms/div) " + (PCOscilloscope2.minTimePerDiv/timeMagnification * 1000) + " ms", 305, 590);

        currDataPoints = GraphPlotter.newDataPoints;
        for (int i = 1; i < 198; i++) {
            pApplet.stroke(0, 255, 0);
            pApplet.strokeWeight(1);
            pApplet.curve(x[i-1] * timeMagnification, -(currDataPoints[i-1]) * magnification + (q/2) + offset, x[i] * timeMagnification, -(currDataPoints[i]) * magnification + (q/2) + offset, x[i+1] * timeMagnification,  -(currDataPoints[i+1]) * magnification + (q/2) + offset, x[i+2] * timeMagnification, -(currDataPoints[i+2]) * magnification + (q/2) + offset);
        }
        // TwoWaySerialComm.counter++;
    }
    
}