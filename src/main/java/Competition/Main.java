package Competition;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws SQLException {
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
        JButton selectbtn = new JButton("Select");
        selectbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    LaodTeamInsert(frame);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        CompetitionPanel.add(selectComptLabel);
        CompetitionPanel.add(selectCompt);
        CompetitionPanel.add(selectbtn);
        frame.add(CompetitionPanel);
        CompetitionPanel.setVisible(true);
        
        
    }
    public static void DesPanels(JFrame frame) {
        for (Component c : frame.getContentPane().getComponents()) {
            c.setVisible(false);
        }
    }
    
    public static void LaodTeamInsert(JFrame frame) throws SQLException {
        DesPanels(frame);
        JPanel TeamInsertPanel = new JPanel();
        TeamInsertPanel.setLayout(new FlowLayout());
        JLabel TeamInsertLabel1 = new JLabel("entrer ID");
        JTextField Id_txt = new JTextField();
        JLabel TeamInsertLabel2 = new JLabel("entrer Nom");
        JTextField  Nom_txt = new JTextField();
        JLabel TeamInsertLabel3 = new JLabel("entrer Pays");
        JTextField  Pays_txt = new JTextField();
        JLabel TeamInsertLabel4 = new JLabel("entrer Classement");
        JTextField  CL_txt = new JTextField();
        Id_txt.setPreferredSize(new Dimension(100, 20));
        Nom_txt.setPreferredSize(new Dimension(100, 20));
        Pays_txt.setPreferredSize(new Dimension(100, 20));
        CL_txt.setPreferredSize(new Dimension(100, 20));

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
