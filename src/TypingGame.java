import javax.swing.*;
import java.awt.event.*;

public class TypingGame extends JFrame implements ActionListener, KeyListener {
    StringBuilder sb = new StringBuilder();
    private JLabel textField;
    private JPanel typePanel;
    private JLabel scoreLabel;
    private JButton startButton;
    private JButton restartButton;
    private JComboBox modeSelector;
    private String playerText;
    private String answerText;
    private String displayString;
    private int counter;
    private Timer timer;
    private int currentTime;
    private double accuracy;
    private double wpm;
    private int timeLeft;
    private boolean quotes;
    private boolean sixty;
    private boolean thirty;
    private boolean fifteen;
    private int totalTyped;

    public TypingGame() {
        startPanel();
    }

    private void startPanel() {
        setContentPane(typePanel);
        setTitle("\uD83D\uDC22 Turtle Type! \uD83D\uDC22");
        setSize(1500, 400);
        setLocation(0, 0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(this);
        setVisible(true);
        playerText = "";
        displayString = "";
        answerText = "";
        textField.setText(String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 700, "<html> <font size='5' color=black>" + answerText + "</font> <html>"));
        counter = 0;
        timer = new Timer(1000, null);
        timer.addActionListener(this);
        startButton.addActionListener(this);
        restartButton.addActionListener(this);
        modeSelector.addActionListener(this);
        currentTime = 0;
        scoreLabel.setText("WPM: ? ; Accuracy: ? ; Time: ?");
        wpm = 0;
        accuracy = 0;
        totalTyped = 0;
        quotes = true;
        sixty = false;
        thirty = false;
        fifteen = false;
        timeLeft = 0;
        tempParser temp = new tempParser();
        temp.plswork2();
        temp.plswork3();
        setFocusable(true);
        requestFocus(); //for some reason these 2 lines let me do stuff with buttons and text ok
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (playerText.length() != answerText.length() && (timeLeft - currentTime ) > -1) {
            counter = 0;
            accuracy = 0;
            totalTyped = 0;
//            if (getFont().canDisplayUpTo(String.valueOf(e.getKeyChar())) == -1) {
                if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
                sb.append(e.getKeyChar());
//        System.out.println(sb.toString());
                String tempText = sb.toString();
                playerText += tempText;
                displayString = "<html>";

                for (int i = 0; i < playerText.length(); i++) {
                    if (String.valueOf(playerText.charAt(i)).equals(String.valueOf(answerText.charAt(i)))) {
//                        System.out.println("works");
                        displayString += "<font size='5' color=green>" + answerText.charAt(i) + "</font>";
                        counter++;
                        totalTyped++;
                    } else {
//                        System.out.println("broke");
                        displayString += "<font size='5' color=red>" + answerText.charAt(i) + "</font>";
                        totalTyped++;
                    }
                }
                displayString += "<font size='5' color=black>" + answerText.substring(playerText.length()) + "</font>";
                displayString += "<html>";
            } else {
                if (playerText.length() > 0) {
                    playerText = playerText.substring(0, playerText.length() - 1);
                    displayString = "<html>";

                    for (int i = 0; i < playerText.length(); i++) {
                        if (String.valueOf(playerText.charAt(i)).equals(String.valueOf(answerText.charAt(i)))) {
//                            System.out.println("works");
                            displayString += "<font size='5' color=green>" + answerText.charAt(i) + "</font>";
                            counter++;
                            totalTyped++;
                        } else {
//                            System.out.println("broke");
                            displayString += "<font size='5' color=red>" + answerText.charAt(i) + "</font>";
                            totalTyped++;
                        }
                    }
                    displayString += "<font size='5' color=black>" + answerText.substring(playerText.length()) + "</font>";
                    displayString += "<html>";
                }
            }
//            System.out.println(playerText.length());
            System.out.println(playerText);
            sb.setLength(0);
            textField.setText(String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 700, displayString));
//            textField.setText(displayString.replaceAll(">\\s+<", "><"));
        }

    }


//        for (int i = 0; i < sb.toString().length(); i++) {
//            if (String.valueOf(sb.toString().charAt(i)).equals(String.valueOf(answerText.charAt(i)))) {
//                System.out.println("works");
//            }   else    {
//                System.out.println("broke");
//            }
//        }

//        System.out.println(sb.toString());
//        String tempString = "<html><font size='4' color=red> wrong words </font> <font size='4'color=green> right words</font>";
//        System.out.println(tempString);
//        tempString += "<font size='4' color=blue> poop </font> </html>";
//        System.out.println(tempString);

//        playerText = sb.toString();
//        System.out.println(playerText);
//        textField.setText(sb.toString());
//        textField.setText("<html><font size='4' color=red> wrong words </font> <font size='4'color=green> right words</font></html>");
//        textField.setText(tempString);


    @Override
    public void keyPressed(KeyEvent e) {
//        int keyCode = e.getKeyCode();
//        if (keyCode == KeyEvent.VK_BACK_SPACE) {
//            sb.setLength(sb.length() - 1);
//        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            if (source == startButton) {
                modeSelector.setEnabled(false);
                startButton.setEnabled(false);
                restartButton.setEnabled(false);
                scoreLabel.setText("WPM: ? ; Accuracy: ? ; Time: ?");
                textField.setText("");
                playerText = "";
                currentTime = 0;
                counter = 0;
                wpm = 0;
                accuracy = 0;
                totalTyped = 0;


                if (quotes) {
                    timeLeft = Integer.MAX_VALUE;
                    answerText = tempParser.quotesList.get((int) (Math.random() * tempParser.quotesList.size()));
                }   else    {
                    if (sixty) {
                        timeLeft = 60;
                    }
                    if (thirty) {
                        timeLeft = 30;
                    }
                    if (fifteen) {
                        timeLeft = 15;
                    }
                    answerText = tempParser.wordList.get((int) (Math.random() * tempParser.wordList.size()));
                    for (int i = 0; i < tempParser.wordList.size(); i++) {
                        answerText += " " + tempParser.wordList.get((int) (Math.random() * tempParser.wordList.size()));
                    }
                }
                textField.setText(String.format("<html><div style=\"width:%dpx;\">%s</div></html>", 700, "<html> <font size='5' color=black>" + answerText + "</font> <html>"));
                timer.start();
            }
            if (source == restartButton) {
                restartButton.setEnabled(false);
                modeSelector.setEnabled(true);
                startButton.setEnabled(true);
                answerText = "";
                timer.stop();
                scoreLabel.setText("WPM: ? ; Accuracy: ? ; Time: ?");
                counter = 0;
                wpm = 0;
                accuracy = 0;
                currentTime = 0;
                totalTyped = 0;
                textField.setText("");
                playerText = "";
            }
        }   else if
        (source instanceof JComboBox) {
            if (modeSelector.getSelectedItem().toString().equals("Quotes")) {
                quotes = true;
                sixty = false;
                thirty = false;
                fifteen = false;
            }
            if (modeSelector.getSelectedItem().toString().equals("Time (60s)")) {
                System.out.println("60s");
                quotes = false;
                sixty = true;
                thirty = false;
                fifteen = false;
            }
            if (modeSelector.getSelectedItem().toString().equals("Time (30s)")) {
                System.out.println("30s");
                quotes = false;
                sixty = false;
                thirty = true;
                fifteen = false;
            }
            if (modeSelector.getSelectedItem().toString().equals("Time (15s)")) {
                System.out.println("15s");
                quotes = false;
                sixty = false;
                thirty = false;
                fifteen = true;
            }
        }   else    {
            timerFires();
            if (playerText.length() != answerText.length() && (timeLeft - currentTime > -1)) {
                wpm = (((double) counter / 5) / (double) currentTime) * 60;
                wpm = (double) Math.round(wpm * 100) / 100;
                accuracy = (double) Math.round(((double) counter / totalTyped) * 10000) / 100;
                System.out.println("counter: " + counter);
                System.out.println("acc: " + accuracy);
                if (currentTime > 3) {
                    restartButton.setEnabled(true);
                }
                if (quotes) {
                    scoreLabel.setText("WPM: " + wpm + " ; Accuracy: " + accuracy + "%" + " Time Taken: " + currentTime);
                }   else    {
                    scoreLabel.setText("WPM: " + wpm + " ; Accuracy: " + accuracy + "%" + " ; Time Remaining: " + (timeLeft - currentTime));
                }
            } else {
                wpm = (((double) counter / 5) / (double) currentTime) * 60;
                wpm = (double) Math.round(wpm * 100) / 100;
                accuracy = (double) Math.round(((double) counter / totalTyped) * 10000) / 100;
                scoreLabel.setText("Final WPM: " + wpm + " ; Final Accuracy: " + accuracy + "%");
                timer.stop();
                textField.setText("");
                startButton.setEnabled(true);
                modeSelector.setEnabled(true);
                restartButton.setEnabled(false);
            }
        }
    }

    public void timerFires() {
        currentTime++;
    }

}
