package main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import generated.Project;


public class marshall {

	public static void main(String[] args) {
		
		Project project = new Project();
		
		try{
		File file = new File("D:\\Filipa\\OneDrive - Universidade de Coimbra\\4�ano\\IS\\Projeto_1\\src\\series.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Project.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(project, file);
		jaxbMarshaller.marshal(project, System.out);

	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
	}
}
