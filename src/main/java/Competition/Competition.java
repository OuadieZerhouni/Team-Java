package Competition;

import java.sql.SQLException;

public class Competition {

    //Ncomp,Nom,Pays,annee,Team list
    private int Ncomp;
    private String Nom;
    private String Pays;
    private int annee;
    private int[] teamList = new int[10];


    //constructor that create compettion
    public Competition(int Ncomp, String Nom, String Pays, int annee) throws SQLException {
        this.Ncomp = Ncomp;
        this.Nom = Nom;
        this.Pays = Pays;
        this.annee = annee;
        MDB.createCompetition(Ncomp, Nom, Pays, annee);
    }
    //getters and setters
    public int getNcomp() {
        return Ncomp;
    }
    public void setNcomp(int Ncomp) {
        this.Ncomp = Ncomp;
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
    //addTeam(ID_E)
    public void addTeam(Team Team) {
        teamList[teamList.length] = Team.getID_E();
    }
}
