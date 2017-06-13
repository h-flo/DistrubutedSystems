
package de.oth.vs.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pruefungsleistung {
    private String pruefungId;
    private int matrNr;
    private int versuch;
    private double grade;

    public Pruefungsleistung() {
    }

    public Pruefungsleistung(String pruefungId, int matrNr, int versuch, double grade) {
        this.pruefungId = pruefungId;
        this.matrNr = matrNr;
        this.versuch = versuch;
        this.grade = grade;
    }

    public String getPruefungsId() {
        return pruefungId;
    }

    public void setPruefungsId(String pruefungsId) {
        this.pruefungId = pruefungsId;
    }

    public int getMatrNr() {
        return matrNr;
    }

    public void setMatrNr(int matrNr) {
        this.matrNr = matrNr;
    }

    public int getVersuch() {
        return versuch;
    }

    public void setVersuch(int versuch) {
        this.versuch = versuch;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    
    
    
    
}
