package Competition;


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


    //constructor vide
    public MDB() throws SQLException {
    }
    //mysql connection 

    // Team(ID_E,Nom,Pays)
    //Compettion(Ncomp,Nom,Pays,annee)
    //participer(ID_E,Ncomp,CL(Classement))

    //createTeam method
    public static void createTeam(int ID_E, String Nom, String Pays) throws SQLException {
        String query = "INSERT INTO Team(ID_E,Nom,Pays) VALUES(?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, ID_E);
            preparedStmt.setString(2, Nom);
            preparedStmt.setString(3, Pays);
            preparedStmt.execute();

    }

    //CreateCompetition method
    public static void createCompetition(int Ncomp, String Nom, String Pays, int annee) throws SQLException {
        String query = "INSERT INTO Competition(Ncomp,Nom,Pays,annee) VALUES(?,?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, Ncomp);
            preparedStmt.setString(2, Nom);
            preparedStmt.setString(3, Pays);
            preparedStmt.setInt(4, annee);
            preparedStmt.execute();

    }
    //CreateParticipe 
    public static void createParticipe(int ID_E, int Ncomp, int CL) throws SQLException {
        String query = "INSERT INTO Participer(ID_E,Ncomp,CL) VALUES(?,?,?)";

            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, ID_E);
            preparedStmt.setInt(2, Ncomp);
            preparedStmt.setInt(3, CL);
            preparedStmt.execute();

    }
    

    


}
