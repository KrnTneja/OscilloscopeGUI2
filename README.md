# OscilloscopeGUI2
  Winter Project 2015 IIT Bombay - USB Oscilloscope cum Function Generator

By
Kiran Dhope
Karan Taneja

It is assumed here that reader here understands what three parts of project viz. Analog, Digital and GUI are all about. In the documentation below (for GUI part), the names of these parts will be implicitly used. 

Feel free to ask questions. You can mail questions to tanejakaran083@gmail.com.

Story Behind the Merge of NetBeans IDE and Processing DE

Coolterm was used to check the working of digital part. 
Plan to use Processing application.
Processing is a Java based application.
It provides coder with easy-to-code environment and also has libraries to support various feature like PDF Export, Image Export, Streaming through serial connection.
Processing has no in-built button feature or scroll-bars which need to be coded.
Processing and its DE are not robust enough to make a dynamically changing, multi-thread program (i.e. multiple processes need to be executed at the same viz. listening to GUI Input, Serial communication involving listening to input stream and sending data over Serial at same time).
Plan to use NetBeans + Processing
NetBeans IDE is a robust, efficient and makes it easy to modify code. 
Java libraries provided for GUI components (Swing), Serial communication(RXTX) and other general utility functionality are sufficient to make a good easy-to-change-over-time and a program with lot of functionalities (to take care of future need to merge the Oscilloscope and Function Generator project).
Using RXTX for Windows 7 and above users: The RXTX JAR file will be provided inside the software package itself and need not be downloaded. A file rxtxDerial.dll has to be downloaded (preferably from jlog.org) and put inside System32 folder.
Using RXTX for other users: Other users can download corresponding file from jlog.org and follow the instructions there. (Instructions are OS specific.) 
Involving Processing with NetBeans: Processing being a graphics-oriented platform is easy, efficient and intuitive to code. Because of draw() and frameRate(), it is easy to control frame rate, plot graph (which use lines currently, future plans to use spline() are there), refresh screen.
Using Processing: ‘Core’ file of Processing (which is a library - core.jar) will be included in the software package itself and need not be downloaded. Hence, there is no need to install Processing DE. 

Brief: How program works?  

Five Files Working Together:
PCOscilloscope2.java - sub classclass of PApplet, contains the main() static class, provides refrence variables of its fields: TwoWaySerialComm class instance, GraphPlotter class instance, sets up Processing window and makes it visible, gets help of Sketch instance to continuously loop and plot graph.  
OscilloscopeGUI.java
TwoWaySerialComm.java - to search for available ports, to establish Serial connection, to initiate streams (input and output),  to read data from Serial and send it to GraphPlotter for collection, to write the instruction received from GUI over Serial (i.e. instruct device to start, change mode, stop, etc.), to disconnect from Serial. 
Note: All above actions are performed when corresponding buttons on GUI are clicked.
GraphPlotter.java
Class GraphPlotter - for collecting the data from Serial communication, grouping and sending it to get it plotted.
Class Printer - to print whatever is asked for.
Sketch.java - to plot the graph.

           PCOscilloscope2 is sub-class of PApplet (Processing Applet). The main(String[]) method of PCOscilloscope2.java instantiates and initializes a PCOscilloscope2 object master. It initializes its fields: session, a OscilloscopeGUI object, plotter, a GraphPlotter object, comm, a TwoWaySerialComm object. It calls main(String) method of PApplet with package name as argument. It then calls the main() method of session, the OscilloscopeGUI object.
           
a.       Initializing OscilloscopeGUI object calls its constructor which call its method initComponents() and assigns master to its field master.
                                                               i.      The initComponents() is the auto-generated code. As name suggests, it initializes components of GUI. It also adds event listeners to the components and sets correct position of components.
b.      Initializing GraphPlotter object method calls its constructor which assigns master to its field master, assigns gui to its field gui, initializes the field rawFrameData which is byte[] object of size 200.
c.       Initializing TwoWaySerialComm object calls its constructor which initialized all its fields: master, gui, plotter with arguments sent and printer with a new object.
d.      The main(String )method of PApplet exists in library. It sets up the Processing window.
e.      The main() method is again auto-generated code. It sets up GUI frame to visible. Now, the all the windows are set up and visible. It waits for user response.
