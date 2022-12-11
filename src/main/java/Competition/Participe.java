package Competition;

import java.sql.SQLException;

public class Participe {
    private int ID_E;
    private int Ncomp;
    private int CL;

    public Participe(int ID_E, int Ncomp, int CL) throws SQLException {
        this.ID_E = ID_E;
        this.Ncomp = Ncomp;
        this.CL = CL;
        MDB.createParticipe(ID_E, Ncomp, CL);
    }

    public int getID_E() {
        return ID_E;
    }

    public void setID_E(int ID_E) {
        this.ID_E = ID_E;
    }

    public int getNcomp() {
        return Ncomp;
    }

    public void setNcomp(int Ncomp) {
        this.Ncomp = Ncomp;
    }

    public int getCL() {
        return CL;
    }

    public void setCL(int CL) {
        this.CL = CL;
    }
}
