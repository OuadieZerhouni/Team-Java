package Competition;
//import swing stuff
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;



public class
Main {
    public static void main(String[] args) throws SQLException {
        //create a frame 
        JFrame frame = new JFrame("Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2, 1));
        frame.setVisible(true);

        //create a createCompt panel with a selectComboBox and a fill it with Competitions qnd q label "Select Competition"

        JPanel createCompt = new JPanel();
        createCompt.setLayout(new GridLayout(2, 1));
        JComboBox selectCompt = new JComboBox();
        JLabel selectComptLabel = new JLabel("Select Competition");
        for (Competition c : MDB.getCompetitions()) {
            selectCompt.addItem(c.getNom());
        }
        createCompt.add(selectComptLabel);
        createCompt.add(selectCompt);
    }
}