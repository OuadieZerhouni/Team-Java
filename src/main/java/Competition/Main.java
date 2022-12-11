package Competition;

//import swing stuff
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        // create a frame
        JFrame frame = new JFrame("Competition");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
        LaodComp(frame);



       
    }
    private int N_Slct_Comp;

    public static void LaodComp(JFrame frame) throws SQLException {
        DesPanels(frame);
        
        JPanel CompetitionPanel = new JPanel();
        JComboBox selectCompt = new JComboBox();
        selectCompt.setPreferredSize(new Dimension(100, 20));
        CompetitionPanel.setLayout(new FlowLayout());
        JLabel selectComptLabel = new JLabel("Select Competition");
        for (Competition c : MDB.getCompetitions()) {
            if (c != null) {
                selectCompt.addItem(c.getNom());
            }
        }
        CompetitionPanel.add(selectComptLabel);
        CompetitionPanel.add(selectCompt);
        frame.add(CompetitionPanel);
        CompetitionPanel.setVisible(true);
        
    }
    public static void DesPanels(JFrame frame) {
        for (Component c : frame.getContentPane().getComponents()) {
            c.setVisible(false);
        }
    }
    
    //LaodTeamInsert
    public static void LaodTeamInsert(JFrame frame) throws SQLException {
        DesPanels(frame);
        JPanel TeamInsertPanel = new JPanel();
        TeamInsertPanel.setLayout(new FlowLayout());
        JLabel TeamInsertLabel1 = new JLabel("entrer ID");
        JTextField Id_txt = new JTextField();
        JLabel TeamInsertLabel2 = new JLabel("entrer Nom");
        JtextField  Nom_txt = new JTextField();
        JLabel TeamInsertLabel3 = new JLabel("entrer Pays");
        JtextField  Pays_txt = new JTextField();
        //input CL
        JLabel TeamInsertLabel4 = new JLabel("entrer Classement");
        JtextField  CL_txt = new JTextField();
        TeamInsertText1.setPreferredSize(new Dimension(100, 20));
        TeamInsertText2.setPreferredSize(new Dimension(100, 20));
        TeamInsertText3.setPreferredSize(new Dimension(100, 20));
        TeamInsertText4.setPreferredSize(new Dimension(100, 20));
        TeamInsertPanel.add(TeamInsertLabel1);
        TeamInsertPanel.add(Id_txt); 
        TeamInsertPanel.add(TeamInsertLabel4);
        TeamInsertPanel.add(CL_txt);
        TeamInsertPanel.add(TeamInsertLabel3);
        TeamInsertPanel.add(Pays_txt);
        TeamInsertPanel.add(TeamInsertLabel2);
        TeamInsertPanel.add(Nom_txt);
        
        frame.add(TeamInsertPanel);
        TeamInsertPanel.setVisible(true);
    }

 
}
