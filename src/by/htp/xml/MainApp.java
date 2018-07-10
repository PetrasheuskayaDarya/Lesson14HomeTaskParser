package by.htp.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainApp {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException  {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder documentBuilder = factory.newDocumentBuilder();
	Document doc = documentBuilder.parse("xml/MyXMLConfig.xml");
	
	String titleEl = doc.getDocumentElement().getNodeName();
	System.out.println("titleEl = " + titleEl);
	
	NodeList nodeList = doc.getElementsByTagName("mother");
	
	String name = "";
	String surname = "";
	int age = 0;
	int family = 0;
	
	System.out.println("family    name     surname     age");
	for (int i = 0; i< nodeList.getLength(); i++) {
			Element element = (Element)nodeList.item(i);
			name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			surname = element.getElementsByTagName("surname").item(0).getChildNodes().item(0).getNodeValue();
			age = Integer.parseInt(element.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue());
			family = Integer.parseInt((element.getParentNode().getAttributes().getNamedItem("id").getNodeValue()));
			
			System.out.println(family + "         "  + name + "     " + surname + "       " + age);
	}

	}

}
