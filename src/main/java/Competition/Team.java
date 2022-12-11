package Competition;

import java.sql.SQLException;

public class Team {
    private int ID_E;
    private String Nom;
    private String Pays;
    private int annee;

    public Team(int ID_E, String Nom, String Pays, int annee) throws SQLException {
        this.ID_E = ID_E;
        this.Nom = Nom;
        this.Pays = Pays;
        this.annee = annee;
        MDB.createTeam(ID_E, Nom, Pays);
    }

    public int getID_E() {
        return ID_E;
    }

    public void setID_E(int ID_E) {
        this.ID_E = ID_E;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String Pays) {
        this.Pays = Pays;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    
}
