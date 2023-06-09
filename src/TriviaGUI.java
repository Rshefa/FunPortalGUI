import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TriviaGUI extends JFrame implements ActionListener, KeyListener {
    private JLabel title;
    private JComboBox typeSelector;
    private JButton confirmButton;
    private JPanel mainPanel;

    public TriviaGUI() {
        startPanel();
    }

    private void startPanel() {
        setContentPane(mainPanel);
        setTitle("Fun Portal!");
        setSize(800, 400);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        confirmButton.addActionListener(this);
        setVisible(true);
        tempParser temp = new tempParser();
        temp.plswork();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            String temp = typeSelector.getSelectedItem().toString();
            if (temp.equals("Anime")) {
                this.dispose();
                TriviaGame game = new TriviaGame("Anime");
            }
            if (temp.equals("Typing")) {
                this.dispose();
                TypingGame typeGame = new TypingGame();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
