package main;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import generated.Actors;
import generated1.Project;


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
		
		public static Boolean marshalles_actors(Actors actors) throws TransformerException {
			
		if (actors.getActor().size() == 0) {
				return false;
		}
		
		try{
		File xmlFile = new File("./src/actors_temporario.xml");
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Actors.class);
		
		File schemaFile = new File("./src/actor.xsd"); 
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(schemaFile);
		
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setSchema(schema);
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(actors, xmlFile);
		jaxbMarshaller.marshal(actors, System.out);
			
		//Transform XML to HTML
		TransformerFactory tf = TransformerFactory.newInstance();
		StreamSource xslt = new StreamSource("./src/file_xsl.xsl");
		Transformer transformer = tf.newTransformer(xslt);

		// Source
		JAXBSource source = new JAXBSource(jaxbContext, actors);

		// Result
		File fHTML = new File("./src/file_xsl.html");
		StreamResult result = new StreamResult(fHTML);

		// Transform
		transformer.transform(source, result);	

		
		return true;
	      } catch (JAXBException | SAXException e) {
		e.printStackTrace();
	      }
		return false;
	}
}
