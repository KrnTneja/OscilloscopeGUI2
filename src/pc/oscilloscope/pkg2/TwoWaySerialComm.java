package pc.oscilloscope.pkg2;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.awt.PopupMenu;
import java.util.Enumeration;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TwoWaySerialComm implements SerialPortEventListener, Runnable {
    PCOscilloscope2 master;
    OscilloscopeGUI gui;
    GraphPlotter plotter;
    static Printer printer;
    byte instruction = 0;
    final byte factor = 5;
    private Enumeration ports = null;
    private CommPortIdentifier selectedPortIdentifier;
    private SerialPort serialPort;
    private InputStream in = null;
    private OutputStream out = null;
    final static int TIMEOUT = 2000;
    final static int SPACE_ASCII = 32;
    final static int DASH_ASCII = 45;
    final static int NEW_LINE_ASCII = 10;
    public boolean setConnected = false;
    public boolean inStreaming = false;
    public boolean outStreaming = false;
    // static int counter = 0;
    public boolean fGMode = false;
    boolean pcoMode = false;
    
    public TwoWaySerialComm(PCOscilloscope2 myMaster, OscilloscopeGUI myGUI, GraphPlotter myPlotter) {
        super();    
        this.master = myMaster;
        this.gui = myGUI;
        this.plotter = myPlotter;
        this.printer = new Printer();
        // initiate();
    }
    
    void findAndConnect () throws Exception {
        ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();
            if (!curPort.isCurrentlyOwned()) {
                CommPort commPort = curPort.open(this.getClass().getName(),2000);
                if (commPort instanceof SerialPort) {
                    serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                    gui.log("Connected to " + curPort.getName());
                    setConnected = true;
                    return;
                }
            }
        }
        gui.log("Couldn't connect. Make sure that your USB is connected properly and not in use currently.");
    }
    
    void startInputStreaming() throws IOException, TooManyListenersException {
        if(setConnected && !inStreaming) {
            in = serialPort.getInputStream();
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
            this.inStreaming = true;
            // gui.log("Started Streaming.");
        }
    }

    void setPortNames() throws PortInUseException, UnsupportedCommOperationException {
        ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier curPort = (CommPortIdentifier)ports.nextElement();
            if (!curPort.isCurrentlyOwned()) {
                    gui.log("Found an avaibale port: " + curPort.getName());
                    gui.addPortName(curPort.getName());
            }
        }
    }

    void connectTo (String portName) throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        CommPortIdentifier curPort = CommPortIdentifier.getPortIdentifier(portName);
        if (!curPort.isCurrentlyOwned()) {
            CommPort commPort = curPort.open(this.getClass().getName(),2000);
            if (commPort instanceof SerialPort) {
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
                gui.log("Connected to " + curPort.getName());
                setConnected = true;
                return;
            }
        }
    }


    void startOutputStreaming() throws IOException, TooManyListenersException {
        if(setConnected && !outStreaming) {
            out = serialPort.getOutputStream();
            this.outStreaming = true;
            // gui.log("Started Streaming.");
        }
    }
    
    void disconnect() throws IOException, TooManyListenersException {
        if (setConnected) {
            serialPort.removeEventListener();
            serialPort.close();
            this.inStreaming = false;
            this.outStreaming = false;
            instruction = 6;
            giveInstruction(instruction);
            if (in != null) in.close();
            if (out != null) out.close();
            setConnected = false;
            gui.log("Disconnected successfully.");
        }
    }
    
    void disconnectInputStream() throws IOException {
        if (inStreaming) in.close();
        this.inStreaming = false; 
    }
    
    void disconnectOutputStream() throws IOException, TooManyListenersException {
        instruction = 6;
        giveInstruction(instruction);
        if (outStreaming) out.close();
        this.outStreaming = false; 
    }
    
    @Override
    public void serialEvent(SerialPortEvent spe) {
        if (spe.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                float digit = (float) in.read();
                plotter.received = digit;
                (new Thread(plotter)).start();
                // printer.toPrint = digit;
                // (new Thread(printer)).start();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void run() {
        try {
            this.giveInstruction(instruction);
        } catch (IOException ex) {
            Logger.getLogger(TwoWaySerialComm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TooManyListenersException ex) {
            Logger.getLogger(TwoWaySerialComm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void giveInstruction(byte instruction) throws IOException, TooManyListenersException {
        if (out == null) {
            startOutputStreaming();
        }
        try {
            if (out != null && outStreaming) out.write(instruction*factor);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // getPortList() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    // }
}

class Printer implements Runnable {
    float toPrint;
    
    void print() {
        System.out.println(toPrint + "");
    }

    @Override
    public void run() {
        print();
    }
} 