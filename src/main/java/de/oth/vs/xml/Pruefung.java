
package de.oth.vs.xml;


public class Pruefung {
   private String id;
   private String bezeichnung;
   private int ects;

    public Pruefung() {
    }

    public Pruefung(String id, String bezeichnung, int ects) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.ects = ects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }
   
   
   
   
   
}
