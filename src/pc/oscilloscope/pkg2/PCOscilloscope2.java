/* 
if sampling and sending samples is done side by side, graph produced is continuous 
and smooth but then MSPS of DAC decreases - as Sudeep said
if sampling few points and then sending them is done, then MSPS is good but graph 
plotted is not continuous and upon tima scaling higher than sampling time taken by 
ADC, graph will appear weird.
*/

package pc.oscilloscope.pkg2;

import processing.core.PApplet;

public class PCOscilloscope2 extends PApplet {
    
    static PCOscilloscope2 mainPCO;
    static OscilloscopeGUI session;
    static TwoWaySerialComm comm;
    static GraphPlotter plotter;
    static Sketch sketch;
    final static float samplesPerSecond = 400;
    final static float samplingRate = 1000000f;
    final static float samplingTime = 0.001f; // for a set of 200 points
    final static float samplingAndSendingTime = 0.036f; // for a set of 200 points
    final static float framesPerSecond = 1/samplingAndSendingTime;
    final static float minTimePerDiv = samplingTime / 10;
    final static float samplesPerUpdation = samplesPerSecond/framesPerSecond;
    
    public static void main (String[] args) {
        PCOscilloscope2 master = new PCOscilloscope2();
        PCOscilloscope2.mainPCO = master;
        PCOscilloscope2.session = new OscilloscopeGUI(master);
        PCOscilloscope2.plotter = new GraphPlotter(master, PCOscilloscope2.session);
        PCOscilloscope2.comm = new TwoWaySerialComm(master, PCOscilloscope2.session, PCOscilloscope2.plotter);
        PCOscilloscope2.main("pc.oscilloscope.pkg2.PCOscilloscope2");
        PCOscilloscope2.session.main();
    }
    
    TwoWaySerialComm getSerialCommunication() {
        return comm;
    }
    
    GraphPlotter getGraphPlotter() {
        return plotter;
    }

    @Override
    public void settings() {
        size(600,600);       
    }

    @Override
    public void setup () {
        frameRate(this.framesPerSecond);
        PCOscilloscope2.sketch = new Sketch();
        PCOscilloscope2.sketch.assignVar();
        PCOscilloscope2.sketch.giveMaster(this);
        PCOscilloscope2.sketch.givePlotter(PCOscilloscope2.plotter);
    }

    @Override
    public void draw() {
        this.sketch.refresh(this);
    }
}