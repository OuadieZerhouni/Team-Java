package Competition;


import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;

public class MDB {
    private static Connection  connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/competition", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public MDB() throws SQLException {
    }

    // Team(ID_E,Nom,Pays)
    //Compettion(Ncomp,Nom,Pays,annee)
    //participer(ID_E,Ncomp,CL(Classement))

    public static void createTeam(int ID_E, String Nom, String Pays) throws SQLException {
        String query = "INSERT INTO Team(ID_E,Nom,Pays) VALUES(?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, ID_E);
            preparedStmt.setString(2, Nom);
            preparedStmt.setString(3, Pays);
            preparedStmt.execute();

    }

    public static void createCompetition(int Ncomp, String Nom, String Pays, int annee) throws SQLException {
        String query = "INSERT INTO Competition(Ncomp,Nom,Pays,annee) VALUES(?,?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, Ncomp);
            preparedStmt.setString(2, Nom);
            preparedStmt.setString(3, Pays);
            preparedStmt.setInt(4, annee);
            preparedStmt.execute();

    }
    public static void createParticipe(int ID_E, int Ncomp, int CL) throws SQLException {
        String query = "INSERT INTO Participer(ID_E,Ncomp,CL) VALUES(?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, ID_E);
            preparedStmt.setInt(2, Ncomp);
            preparedStmt.setInt(3, CL);
            preparedStmt.execute();

    }
    //getCompetitionID_ByName
    public static int getCompetitionID_ByName(String Nom) throws SQLException {
        String query = "SELECT * FROM Competition WHERE Nom = ?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, Nom);
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("Ncomp");
        }
        return 0;
    }

    

    public static Competition[] getCompetitions() throws SQLException {
        String query = "SELECT * FROM Competition";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        ResultSet rs = preparedStmt.executeQuery();
        Competition[] competitions = new Competition[10];
        int i = 0;
        while (rs.next()) {
            competitions[i] = new Competition(rs.getInt("Ncomp"), rs.getString("Nom"), rs.getString("Pays"), rs.getInt("annee"),1);
            i++;
        }
        return competitions;
    }
    //FillCompet(Combobox) fill combobox from database competitions
    public static void FillCompet(JComboBox<String> combo) throws SQLException {
        String query = "SELECT * FROM Competition";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        ResultSet rs = preparedStmt.executeQuery();
        combo.addItem(null);
        while (rs.next()) {
            combo.addItem(rs.getString("Nom"));
        }
    }
    //FillTeams by competitionName  that take a jTable and CompetitionName as parameters and fill the table with the teams that participate in the competition
    public static void FillTeams(JTable table, String CompetitionName) throws SQLException {
        String query = "SELECT Team.ID_E,Team.Nom,Team.Pays,Participer.CL FROM Team,Participer,Competition WHERE Team.ID_E=Participer.ID_E AND Participer.Ncomp=Competition.Ncomp AND Competition.Nom=?";
        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, CompetitionName);
        ResultSet rs = preparedStmt.executeQuery();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            model.addRow(new Object[]{rs.getInt("ID_E"), rs.getString("Nom"), rs.getString("Pays"), rs.getInt("CL")});
        }
    }
    


    

    


}
