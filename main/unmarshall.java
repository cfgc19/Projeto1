package main;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import generated.Actors;
import generated.Project;

public class unmarshall {

	public static Project unmarshalles_project() {
		Unmarshaller jaxbUnmarshaller;
		try {
			File xmlFile = new File("./src/series.xml");
			File schemaFile = new File("./src/schema.xsd");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
			
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(schemaFile);
			
			jaxbUnmarshaller.setSchema(schema);
			Project project = (Project) jaxbUnmarshaller.unmarshal(xmlFile);
			
			return project;
		} catch (JAXBException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public static Actors unmarshalles_actors() {
		Unmarshaller jaxbUnmarshaller;
		try {
			File xmlFile = new File("./src/actors.xml");
			File schemaFile = new File("./src/actor.xsd");
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Actors.class);
			
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(schemaFile);
			
			jaxbUnmarshaller.setSchema(schema);
			Actors actors = (Actors) jaxbUnmarshaller.unmarshal(xmlFile);
			
			return actors;
		} catch (JAXBException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
