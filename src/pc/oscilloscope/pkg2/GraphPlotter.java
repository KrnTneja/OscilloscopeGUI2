package pc.oscilloscope.pkg2;

public class GraphPlotter implements Runnable {
    
    OscilloscopeGUI gui;
    static int samplesPerFrame = 200;
    static float[] rawFrameData;
    static float[] newDataPoints;
    // float[] update;
    // int updateSize = (int) PCOscilloscope2.samplesPerUpdation;
    int arrayFillIndex = 0;
    float received = 0;
    PCOscilloscope2 master;    
    
    GraphPlotter(PCOscilloscope2 myMaster,OscilloscopeGUI myGUI) {
        this.master = myMaster;
        this.gui = myGUI;
        //update = new float[updateSize];
        rawFrameData = new float[samplesPerFrame];
        newDataPoints = new float[samplesPerFrame];
    }

    void takeData(float digit) {
        // update[arrayFillIndex] = (float) ((digit - 127.5) / 127.5)*100 ;
        //TwoWaySerialComm.counter++;
        /* arrayFillIndex++;
        if (arrayFillIndex >= PCOscilloscope2.samplesPerUpdation) {
            for (int i = 0; i < samplesPerFrame - arrayFillIndex; i++) {
                rawFrameData[i] = rawFrameData[i + arrayFillIndex];
            }
            for (int i = 0; i < arrayFillIndex; i++) {
                rawFrameData[samplesPerFrame - arrayFillIndex + i] = update[i]; 
            }
            arrayFillIndex = 0;
            GraphPlotter.newDataPoints = rawFrameData;
        } */
        if (arrayFillIndex == GraphPlotter.samplesPerFrame) {
            Trigger.triggerData(rawFrameData);
            arrayFillIndex = 0;
        }

        rawFrameData[arrayFillIndex] = (float) ((digit - 127.5) / 127.5)*Sketch.standardLevel;
        // TwoWaySerialComm.printer.toPrint = rawFrameData[arrayFillIndex];
        // (new Thread(TwoWaySerialComm.printer)).start();
        arrayFillIndex++;
    }
    
    
    public float[] getDataPoints() {
        return newDataPoints;
    } 
    
    @Override
    public void run() {
       this.takeData(received);
    }
    
}
