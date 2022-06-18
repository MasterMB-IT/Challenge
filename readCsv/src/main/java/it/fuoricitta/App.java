package it.fuoricitta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.fuoricitta.model.InfoRecord;
import it.fuoricitta.model.InsertData;

public class App {
    public static void main( String[] args ) {
    	String line = ""; 
    	String path= "C:\\Users\\mirko\\Downloads\\file.csv";
    	int riga = 0;
    	int numRecord = 0;
    	try (BufferedReader reader = new BufferedReader(new FileReader(path)))
    	{
    		reader.readLine();
    		while ((line = reader.readLine()) != null) {
    			riga++;
    			String[] box = line.split(";"); 
    			for (int i = 0; i < box.length; i++) {
    				if (box[i].isEmpty() || box[i].isBlank()) {
    					System.out.println("Campo mancante \nPosizione: " + i + "\n" + "Riga: " + riga);
    					return;
    				} else if (box.length < 4) {
        				System.out.println("Campo mancante \nPosizione: " + box.length + "\n" + "Riga: " + riga);
        				return;
        			} else if (i == box.length - 1) {
    				
				        	Configuration configure = new Configuration();
				        	configure.configure("hibernate.cfg.xml");
				        	configure.addAnnotatedClass(InsertData.class).addAnnotatedClass(InfoRecord.class);
				        	SessionFactory sessionFactory = configure.buildSessionFactory();
				        	Session session = sessionFactory.openSession();
				        
				        try {       
        								
				        		session.beginTransaction();
				        		
				        		InsertData record = new InsertData();		
				        		record.setCode(Integer.parseInt(box[0]));
				        		record.setDescription(box[1]);
				        		record.setScadenza(box[2]);
				        		record.setValore(Double.parseDouble(box[3]));
        							
				        		session.save(record);
				        		session.getTransaction().commit();
        								
				        	if (numRecord < 1) {
        				
				        			session.beginTransaction();
				        			
				        			InfoRecord info = new InfoRecord();
				        			File file = new File(path);
				        			Path pathDim = Paths.get(path);
				        			long dim = Files.size(pathDim);
				        			String name = file.getName();
				        			
				        			info.setNomeFile(name);
				        			info.setDimensioneFile(dim);
				        			
				        			session.save(info);
				        			session.getTransaction().commit();
				        	}					
				        } finally {
				        session.close();
        				sessionFactory.close();
				        }
        		    	numRecord++;				
        			}
        		}
    		}	
    	} catch (Exception e) {
			System.out.println(e);
		}
    	System.out.println("Record caricati: " + numRecord);
    }
}
