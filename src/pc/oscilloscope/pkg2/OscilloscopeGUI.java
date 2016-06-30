package pc.oscilloscope.pkg2;

import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.UnsupportedCommOperationException;
import java.awt.Font;
import java.io.IOException;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.DefaultCaret;

public class OscilloscopeGUI extends javax.swing.JFrame {

    PCOscilloscope2 master;
    TwoWaySerialComm commni;
    byte currMode = 0;
    
    public OscilloscopeGUI(PCOscilloscope2 master) {
        // this.window = null;
        initComponents();
        this.master = master;
        commni = master.getSerialCommunication();
        this.setTitle("Oscilloscope cum Function Generator");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        amplitudeSlider = new javax.swing.JSlider();
        frequencySpinner = new javax.swing.JSpinner();
        sineButton = new javax.swing.JButton();
        squareButton = new javax.swing.JButton();
        triangleButton = new javax.swing.JButton();
        hundredButton = new javax.swing.JRadioButton();
        thousandButton = new javax.swing.JRadioButton();
        millionButton = new javax.swing.JRadioButton();
        oneButton = new javax.swing.JRadioButton();
        fgOffsetSlider = new javax.swing.JSlider();
        label7 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logText = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        disconnectButton = new javax.swing.JButton();
        fgModeButton = new javax.swing.JButton();
        pcoModeButton = new javax.swing.JButton();
        startReadingButton = new javax.swing.JButton();
        autoConnectButton = new javax.swing.JButton();
        comComboBox = new javax.swing.JComboBox();
        connectButton = new javax.swing.JButton();
        findPortsButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        scale1 = new javax.swing.JButton();
        scale2 = new javax.swing.JButton();
        scale3 = new javax.swing.JButton();
        scale4 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        xAxisSlider = new javax.swing.JSlider();
        yAxisSlider = new javax.swing.JSlider();
        triggerPointSlider = new javax.swing.JSlider();
        triggerRange = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        offsetPCOSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        holdOffSlider = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        autoTriggerButton = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(230, 230, 230));

        label4.setText("Function Generator Mode");

        label5.setText("Frequency");

        label6.setText("Amplitude");

        amplitudeSlider.setMajorTickSpacing(50);
        amplitudeSlider.setMaximum(250);
        amplitudeSlider.setMinorTickSpacing(5);
        amplitudeSlider.setPaintTicks(true);
        amplitudeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                amplitudeSliderStateChanged(evt);
            }
        });
        amplitudeSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                amplitudeSliderMouseReleased(evt);
            }
        });

        frequencySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        frequencySpinner.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frequencySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                frequencySpinnerStateChanged(evt);
            }
        });

        sineButton.setText("Sine");
        sineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sineButtonActionPerformed(evt);
            }
        });

        squareButton.setText("Square");
        squareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                squareButtonActionPerformed(evt);
            }
        });

        triangleButton.setText("Triangle");
        triangleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                triangleButtonActionPerformed(evt);
            }
        });

        hundredButton.setText("100 Hz");
        hundredButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hundredButtonActionPerformed(evt);
            }
        });

        thousandButton.setText("10 kHz");
        thousandButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thousandButtonActionPerformed(evt);
            }
        });

        millionButton.setText("1 MHz");
        millionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                millionButtonActionPerformed(evt);
            }
        });

        oneButton.setSelected(true);
        oneButton.setText("1 Hz");
        oneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oneButtonActionPerformed(evt);
            }
        });

        fgOffsetSlider.setMajorTickSpacing(25);
        fgOffsetSlider.setMaximum(250);
        fgOffsetSlider.setMinorTickSpacing(5);
        fgOffsetSlider.setPaintTicks(true);
        fgOffsetSlider.setValue(125);
        fgOffsetSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fgOffsetSliderStateChanged(evt);
            }
        });
        fgOffsetSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                fgOffsetSliderMouseReleased(evt);
            }
        });

        label7.setText("Offset");

        jLabel1.setText("Value:");

        jLabel10.setText("Factor:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(squareButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(triangleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(77, 77, 77))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(frequencySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oneButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hundredButton, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(millionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thousandButton))
                                .addGap(34, 34, 34))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fgOffsetSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amplitudeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {sineButton, squareButton, triangleButton});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {hundredButton, millionButton, oneButton, thousandButton});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(frequencySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(oneButton)
                            .addComponent(thousandButton)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hundredButton)
                            .addComponent(millionButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(sineButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(squareButton)
                        .addGap(9, 9, 9)
                        .addComponent(triangleButton)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(amplitudeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fgOffsetSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {hundredButton, millionButton, oneButton, thousandButton});

        logText.setColumns(20);
        logText.setRows(5);
        jScrollPane1.setViewportView(logText);
        logText.setFont(new Font("Consolas", Font.PLAIN, 12));
        logText.setLineWrap(true);
        logText.setWrapStyleWord(true);
        ((DefaultCaret)logText.getCaret()).setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        jPanel1.setBackground(new java.awt.Color(230, 230, 230));

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        fgModeButton.setText("FG Mode");
        fgModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fgModeButtonActionPerformed(evt);
            }
        });

        pcoModeButton.setText("PCO Mode");
        pcoModeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcoModeButtonActionPerformed(evt);
            }
        });

        startReadingButton.setText("Start Reading Stream");
        startReadingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startReadingButtonMouseClicked(evt);
            }
        });
        startReadingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startReadingButtonActionPerformed(evt);
            }
        });

        autoConnectButton.setText("Auto-connect");
        autoConnectButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autoConnectButtonMouseClicked(evt);
            }
        });
        autoConnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoConnectButtonActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        findPortsButton.setText("Find Available COM Ports");
        findPortsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findPortsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startReadingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(findPortsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(autoConnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(fgModeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(disconnectButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(pcoModeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pcoModeButton)
                    .addComponent(fgModeButton))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoConnectButton)
                    .addComponent(disconnectButton))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton))
                .addGap(6, 6, 6)
                .addComponent(findPortsButton)
                .addGap(6, 6, 6)
                .addComponent(startReadingButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(230, 230, 230));

        scale1.setText("+10/-10V");
        scale1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scale1ActionPerformed(evt);
            }
        });

        scale2.setText("+5/-5V");
        scale2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scale2ActionPerformed(evt);
            }
        });

        scale3.setText("+1/-1V");
        scale3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scale3ActionPerformed(evt);
            }
        });

        scale4.setText("+0.1/-0.1V");
        scale4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scale4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scale1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(scale3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scale2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scale4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scale1)
                    .addComponent(scale2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scale3)
                    .addComponent(scale4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(230, 230, 230));

        xAxisSlider.setMajorTickSpacing(10);
        xAxisSlider.setMaximum(200);
        xAxisSlider.setMinimum(1);
        xAxisSlider.setPaintTicks(true);
        xAxisSlider.setSnapToTicks(true);
        xAxisSlider.setToolTipText("");
        xAxisSlider.setValue(10);
        xAxisSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                xAxisSliderStateChanged(evt);
            }
        });

        yAxisSlider.setMajorTickSpacing(10);
        yAxisSlider.setMinimum(1);
        yAxisSlider.setMinorTickSpacing(1);
        yAxisSlider.setPaintTicks(true);
        yAxisSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yAxisSliderStateChanged(evt);
            }
        });

        triggerPointSlider.setMaximum(300);
        triggerPointSlider.setMinimum(-300);
        triggerPointSlider.setMinorTickSpacing(10);
        triggerPointSlider.setPaintTicks(true);
        triggerPointSlider.setToolTipText("");
        triggerPointSlider.setValue(0);
        triggerPointSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                triggerPointSliderStateChanged(evt);
            }
        });

        triggerRange.setMaximum(25);
        triggerRange.setMinimum(1);
        triggerRange.setMinorTickSpacing(1);
        triggerRange.setPaintTicks(true);
        triggerRange.setValue(10);
        triggerRange.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                triggerRangeStateChanged(evt);
            }
        });

        jLabel2.setText("Trigger Point");

        jLabel3.setText("Check Range");

        offsetPCOSlider.setMaximum(300);
        offsetPCOSlider.setMinimum(-300);
        offsetPCOSlider.setValue(0);
        offsetPCOSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                offsetPCOSliderStateChanged(evt);
            }
        });

        jLabel4.setText("Magnification");

        jLabel5.setText("Magnification");

        jLabel6.setText("Offset");

        jLabel7.setText("Hold Off");

        holdOffSlider.setMajorTickSpacing(2);
        holdOffSlider.setMinimum(1);
        holdOffSlider.setMinorTickSpacing(1);
        holdOffSlider.setPaintTicks(true);
        holdOffSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                holdOffSliderStateChanged(evt);
            }
        });

        jLabel8.setText("(V/div)");

        jLabel9.setText("(ms/div)");

        autoTriggerButton.setText("Auto-trigger");
        autoTriggerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoTriggerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(4, 4, 4)
                        .addComponent(xAxisSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(4, 4, 4)
                        .addComponent(yAxisSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(triggerPointSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(triggerRange, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)
                        .addGap(36, 36, 36)
                        .addComponent(offsetPCOSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7)
                        .addGap(27, 27, 27)
                        .addComponent(holdOffSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(autoTriggerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(xAxisSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(yAxisSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(triggerPointSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(triggerRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(offsetPCOSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel7))
                    .addComponent(holdOffSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(autoTriggerButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scale1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scale1ActionPerformed
        if (!checkScale()) return;
        this.currMode = 1;
        commni.instruction = 1;
        Sketch.m1Voltage = 10;
        (new Thread(commni)).start();
        log("Request sent to change for +10/-10V.");
    }//GEN-LAST:event_scale1ActionPerformed

    private void scale2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scale2ActionPerformed
        if (!checkScale()) return;
        this.currMode = 2;
        commni.instruction = 2;
        Sketch.m1Voltage = 5;
        (new Thread(commni)).start();
        log("Sent request to change to +5/-5V.");
    }//GEN-LAST:event_scale2ActionPerformed

    private void scale3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scale3ActionPerformed
        if (!checkScale()) return;
        this.currMode = 3;
        commni.instruction = 3;
        Sketch.m1Voltage = 1;
        (new Thread(commni)).start();
        log("Sent request to change to +1/-1V.");        
    }//GEN-LAST:event_scale3ActionPerformed

    private void scale4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scale4ActionPerformed
        if (!checkScale()) return;
        this.currMode = 4;
        commni.instruction = 4;
        Sketch.m1Voltage = 0.1f;
        (new Thread(commni)).start();
        log("Sent request to change to +0.1/-0.1V.");
    }//GEN-LAST:event_scale4ActionPerformed

    private void xAxisSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_xAxisSliderStateChanged
        Sketch.timeMagnification = ((float) xAxisSlider.getValue()) / 10;
    }//GEN-LAST:event_xAxisSliderStateChanged

    private void autoConnectButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_autoConnectButtonMouseClicked
        
    }//GEN-LAST:event_autoConnectButtonMouseClicked

    private void autoConnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoConnectButtonActionPerformed
        if (commni == null) { commni = master.getSerialCommunication(); return; }
        if (commni.setConnected == false) {       
            try {
                commni.findAndConnect();
                commni.startOutputStreaming();
                commni.disconnectInputStream();
            } catch (Exception ex) {
                Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            log("Connection is already established.");
        }
    }//GEN-LAST:event_autoConnectButtonActionPerformed

    private void startReadingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startReadingButtonMouseClicked
        
    }//GEN-LAST:event_startReadingButtonMouseClicked

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed
        if (commni.setConnected == true) {
            try {
              commni.disconnect();
              // System.out.println("Counter is now " + TwoWaySerialComm.counter);
            } catch (IOException | TooManyListenersException ex) {
             Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            log("Connection is already disconnected.");
        }
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void startReadingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startReadingButtonActionPerformed
        if (commni.setConnected == false) { log("Establish a connection first."); return; }
        if (!commni.pcoMode) { log("You are not using PCO Mode."); return; }
        if (!commni.inStreaming || !commni.outStreaming) {
            try {
                commni.startInputStreaming();
                commni.instruction = 5;
                (new Thread(commni)).start();
                // TwoWaySerialComm.counter = 0;
            } catch (IOException | TooManyListenersException ex) {
                Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }   
        } else { log("Already streaming."); }
    }//GEN-LAST:event_startReadingButtonActionPerformed

    private void yAxisSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yAxisSliderStateChanged
        // log((((float) yAxisSlider.getValue()) / 100) + "");
        Sketch.magnification = (((float) yAxisSlider.getValue()) / 10);
    }//GEN-LAST:event_yAxisSliderStateChanged

    private void pcoModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcoModeButtonActionPerformed
        if (commni == null || !commni.setConnected) { log("Connect to device first."); return; }    
        if (!commni.pcoMode) {
            commni.fGMode = false;
            try {
                commni.startOutputStreaming();
            } catch (IOException | TooManyListenersException ex) {
                Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            commni.pcoMode = true;
            commni.fGMode = false;
            log("Switched to PC Oscilloscope Mode.");
        } else {
            log("You are already using PCO Mode.");
        }
    }//GEN-LAST:event_pcoModeButtonActionPerformed

    private void triggerPointSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_triggerPointSliderStateChanged
        Sketch.triggerPoint = (((float) triggerPointSlider.getValue()));
    }//GEN-LAST:event_triggerPointSliderStateChanged

    private void triggerRangeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_triggerRangeStateChanged
        Trigger.triggerRange = triggerRange.getValue();
    }//GEN-LAST:event_triggerRangeStateChanged

    private void offsetPCOSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_offsetPCOSliderStateChanged
        Sketch.offset = offsetPCOSlider.getValue();
    }//GEN-LAST:event_offsetPCOSliderStateChanged

    private void holdOffSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_holdOffSliderStateChanged
        Sketch.holdOff = (((float) holdOffSlider.getValue())/100)*Sketch.timePerDiv;
    }//GEN-LAST:event_holdOffSliderStateChanged

    private void sineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sineButtonActionPerformed
        if (commni != null && !commni.fGMode) {
            log("You are not using FG Mode.");
            return;
        }
        if (commni != null && commni.setConnected && commni.outStreaming) {
            commni.instruction = 7;
            (new Thread(commni)).start();  
            log("Sent request to chage to Sine wave.");
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_sineButtonActionPerformed

    private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_squareButtonActionPerformed
        if (commni != null && !commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni != null && commni.setConnected && commni.outStreaming) {
            commni.instruction = 8;
            (new Thread(commni)).start();
            log("Sent request to chage to Square wave.");
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_squareButtonActionPerformed

    private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_triangleButtonActionPerformed
        if (commni != null && !commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni != null && commni.setConnected && commni.outStreaming) {
            commni.instruction = 9;
            (new Thread(commni)).start(); 
            log("Sent request to chage to Triangle wave.");
        } else {
            log("Establish a connection first.");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_triangleButtonActionPerformed

    private void autoTriggerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoTriggerButtonActionPerformed
        Trigger.autoTrigger();
        triggerPointSlider.setValue((int) Sketch.triggerPoint);
        triggerRange.setValue((int) Trigger.triggerRange);
    }//GEN-LAST:event_autoTriggerButtonActionPerformed

    private void oneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oneButtonActionPerformed
        oneButton.setSelected(true);
        hundredButton.setSelected(false);
        thousandButton.setSelected(false);
        millionButton.setSelected(false);
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 10;
            commni.run();
            commni.instruction = Byte.parseByte(Integer.toString((int) frequencySpinner.getValue()));
            commni.run();
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_oneButtonActionPerformed

    private void hundredButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hundredButtonActionPerformed
        oneButton.setSelected(false);
        hundredButton.setSelected(true);
        thousandButton.setSelected(false);
        millionButton.setSelected(false);
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 11;
            commni.run();
            commni.instruction = Byte.parseByte(Integer.toString((int) frequencySpinner.getValue()));
            commni.run();
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_hundredButtonActionPerformed

    private void thousandButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thousandButtonActionPerformed
        oneButton.setSelected(false);
        hundredButton.setSelected(false);
        thousandButton.setSelected(true);
        millionButton.setSelected(false);
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 12;
            commni.run();
            commni.instruction = Byte.parseByte(Integer.toString((int) frequencySpinner.getValue()));
            commni.run();
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_thousandButtonActionPerformed

    private void millionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_millionButtonActionPerformed
        oneButton.setSelected(false);
        hundredButton.setSelected(false);
        thousandButton.setSelected(false);
        millionButton.setSelected(true);
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 13;
            commni.run();
            commni.instruction = Byte.parseByte(Integer.toString((int) frequencySpinner.getValue()));
            commni.run();
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_millionButtonActionPerformed

    private void frequencySpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_frequencySpinnerStateChanged
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 14;
            commni.run();
            commni.instruction = Byte.parseByte(Integer.toString((int) frequencySpinner.getValue()));
            commni.run();
        } else {
            log("Establish a connection first.");
        }
    }//GEN-LAST:event_frequencySpinnerStateChanged

    private void amplitudeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_amplitudeSliderStateChanged
       
    }//GEN-LAST:event_amplitudeSliderStateChanged

    private void fgOffsetSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fgOffsetSliderStateChanged

    }//GEN-LAST:event_fgOffsetSliderStateChanged

    private void findPortsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findPortsButtonActionPerformed
        if (commni == null) { commni = master.getSerialCommunication(); return; }
        try {
            comComboBox.removeAllItems();
            commni.setPortNames();
        } catch (PortInUseException | UnsupportedCommOperationException ex) {
            Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_findPortsButtonActionPerformed

    private void fgModeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fgModeButtonActionPerformed
        if (commni == null || !commni.setConnected) { log("Connect to device first."); return; }
        if (!commni.fGMode) {
            try {
                commni.startOutputStreaming();
                commni.disconnectInputStream();
            } catch (IOException | TooManyListenersException ex) {
                Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            commni.fGMode = true;
            commni.pcoMode = false;
            log("Switched to Function Generator Mode.");
        } else {
            log("You are already using FG Mode.");
        }
    }//GEN-LAST:event_fgModeButtonActionPerformed

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        if (commni == null || commni.setConnected) { return; }
        
        try {
            commni.connectTo((String) comComboBox.getSelectedItem());
        } catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException ex) {
            Logger.getLogger(OscilloscopeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void amplitudeSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amplitudeSliderMouseReleased
         if (commni == null) return;
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 15;
            commni.run();
            commni.instruction = ((byte) amplitudeSlider.getValue());
            commni.run();
        }
    }//GEN-LAST:event_amplitudeSliderMouseReleased

    private void fgOffsetSliderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fgOffsetSliderMouseReleased
        if (commni == null) return;
        if (!commni.fGMode) {
            log("FG Mode is not being used curently.");
            return;
        }
        if (commni.setConnected && commni.outStreaming) {
            commni.instruction = 16;
            commni.run();
            commni.instruction = ((byte) fgOffsetSlider.getValue());
            commni.run();
        }
    }//GEN-LAST:event_fgOffsetSliderMouseReleased

    public void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OscilloscopeGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
                // System.out.println("Setting Java window visible...");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider amplitudeSlider;
    private javax.swing.JButton autoConnectButton;
    private javax.swing.JButton autoTriggerButton;
    private javax.swing.JComboBox comComboBox;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton fgModeButton;
    private javax.swing.JSlider fgOffsetSlider;
    private javax.swing.JButton findPortsButton;
    private javax.swing.JSpinner frequencySpinner;
    private javax.swing.JSlider holdOffSlider;
    private javax.swing.JRadioButton hundredButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JTextArea logText;
    private javax.swing.JRadioButton millionButton;
    private javax.swing.JSlider offsetPCOSlider;
    private javax.swing.JRadioButton oneButton;
    private javax.swing.JButton pcoModeButton;
    private javax.swing.JButton scale1;
    private javax.swing.JButton scale2;
    private javax.swing.JButton scale3;
    private javax.swing.JButton scale4;
    private javax.swing.JButton sineButton;
    private javax.swing.JButton squareButton;
    private javax.swing.JButton startReadingButton;
    private javax.swing.JRadioButton thousandButton;
    private javax.swing.JButton triangleButton;
    private javax.swing.JSlider triggerPointSlider;
    private javax.swing.JSlider triggerRange;
    private javax.swing.JSlider xAxisSlider;
    private javax.swing.JSlider yAxisSlider;
    // End of variables declaration//GEN-END:variables

    void log(String str) {
        logText.append("\n>> " + str);
    }

    private boolean checkScale() {
        if (commni == null || !commni.setConnected) {
            log("Establish connection first.");
            return false;
        }
        if (commni.fGMode) {
            log("You are not using PCO Mode.");
            return false;
        }
        return true;
    }

    void addPortName(String name) {
        comComboBox.addItem(name);
    }
    
}    
