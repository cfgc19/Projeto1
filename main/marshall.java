package main;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import generated.Actors;
import generated.Project;


public class marshall {

		public static Boolean marshalles_project(Project project) {
			
		if (project.getSerie().size() == 0) {
				return false;
		}
		
		try{
		File xmlFile = new File("./src/series_temporario.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		
		File schemaFile = new File("./src/schema.xsd"); //ainda nao percebi para o que é que isto serve - filipa
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(schemaFile);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setSchema(schema);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(project, xmlFile);
		jaxbMarshaller.marshal(project, System.out);
		return true;
	      } catch (JAXBException | SAXException e) {
		e.printStackTrace();
	      }
		return false;
	}
		
		public static Boolean marshalles_actors(Actors actors) {
			
		if (actors.getActor().size() == 0) {
				return false;
		}
		
		try{
		File xmlFile = new File("./src/actors_temporario.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		
		File schemaFile = new File("./src/actor.xsd"); //ainda nao percebi para o que é que isto serve - filipa
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(schemaFile);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setSchema(schema);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(actors, xmlFile);
		jaxbMarshaller.marshal(actors, System.out);
		return true;
	      } catch (JAXBException | SAXException e) {
		e.printStackTrace();
	      }
		return false;
	}
}
