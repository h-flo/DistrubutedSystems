
package de.oth.vs.rest;

import de.oth.vs.xml.Pruefung;
import de.oth.vs.xml.Pruefungsleistung;
import de.oth.vs.xml.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("studienangelegenheiten")
public class PruefungsleistungResource {
    
    @POST
    @Path("pruefung")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updatePruefung(Pruefungsleistung p) {
        try {
            System.out.println("Prüfungsleistung erhalten");
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://im-vm-011/vs-08","vs-08","vs-08-pw");
            Statement stm = c.createStatement();
            String query = "SELECT ects from Student where matrikelNr = " + p.getMatrNr();
            ResultSet rs = stm.executeQuery(query);
            rs.first();
            int ectspoints = rs.getInt("ects");
            String query2 = "SELECT ects from Pruefung where pruefungId = '"+p.getPruefungsId()+"'";
            System.out.println("Query2 OK");
            ResultSet rs2 = stm.executeQuery(query2);
            rs2.first();
            int ectspointsNew = rs2.getInt("ects");
            System.out.println("Ects durch Prüfung: "+ectspointsNew);
            int ectsComplete = ectspoints + ectspointsNew;
            c.setAutoCommit(false);
            Statement stmt = c.createStatement();
            String q1 = "UPDATE Student set ects = "+ectsComplete;
            stmt.executeUpdate(q1);	
            System.out.println("Update Query Bereit");
            String q2 = "INSERT into Pruefungsleistung (pruefungId, matrikelNr, versuch, note) VALUES('"+p.getPruefungsId()+"','"+p.getMatrNr()+"', '1', '9.0')"; 
            stmt.executeUpdate(q2);
            System.out.println("Insert Query Bereit");
            c.commit();
            System.out.println("COMMIT");
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruefungsleistungResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PruefungsleistungResource.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
        
    
    }
    
    @GET
    @Path("pruefung/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Pruefungsleistung getPruefungById(@PathParam("id") int id) {
        
        return new Pruefungsleistung("p002", 1234, 1, 4.0);
    }
    
    
}
