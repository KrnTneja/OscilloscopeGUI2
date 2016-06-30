package pc.oscilloscope.pkg2;

public class Trigger {
    
    static int triggerRange = 2;

    static void triggerData(float[] data) {
        
        // System.out.println("Triggering Data...");
        float triggerLength = (Sketch.holdOff / Sketch.timePerDiv) * GraphPlotter.samplesPerFrame;
        float stopPoint;
        float[] newData = new float[GraphPlotter.samplesPerFrame];
        for (int i = 0; i < GraphPlotter.samplesPerFrame - 1; i++) {
          if ((data[i] < Sketch.triggerPoint + triggerRange) && (data[i] > Sketch.triggerPoint - triggerRange) && (data[i+1] - data[i] > 0)) {
              stopPoint = i + triggerLength;
              // System.out.println("Number i is..." + i);
              // System.out.println("Trigger length is... " + triggerLength);
              // System.out.println("Stop Point is... " + stopPoint);
              if (stopPoint >= GraphPlotter.samplesPerFrame) {
                  stopPoint = GraphPlotter.samplesPerFrame;
                  // System.out.println("Stop Point is... " + stopPoint);
              }
              int newDataCounter = 0;
              for (int j = i; j < stopPoint; j++) {
                  newData[newDataCounter] = data[j];
                  newDataCounter++;
              }
              // System.out.println("Data setting done...");
              // System.out.println("Finishing triggering...");
              // System.out.println("Making new data things...");
              GraphPlotter.newDataPoints = newData;
              return;
          } else {
              GraphPlotter.newDataPoints = GraphPlotter.rawFrameData;
          }
        }  
    }
    
    public static void autoTrigger() {
        Sketch.triggerPoint = averageOut(GraphPlotter.rawFrameData);
        triggerRange = (int) maxDifference(GraphPlotter.rawFrameData);
    }
    
    public static float averageOut(float[] data){
        float sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum  = sum + data[i];
        }
        return sum/data.length;
    }

    private static float maxDifference(float[] data) {
        float maxDiff = 0;
        for (int i = 0; i < data.length - 1; i++) {
            if ((data[i+1] - data[i]) > maxDiff) {
                maxDiff = data[i+1] - data[i];
            }
        }
        return maxDiff;
    }
}