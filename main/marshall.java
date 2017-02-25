package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import generated.Project;


public class marshall {

	public static void main(String[] args) {
		
		Project report = new Project();
		
		try{
		File file = new File("D:\\Filipa\\OneDrive - Universidade de Coimbra\\4ºano\\IS\\Projeto_1\\src\\series.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(report, file);
		jaxbMarshaller.marshal(report, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
}
