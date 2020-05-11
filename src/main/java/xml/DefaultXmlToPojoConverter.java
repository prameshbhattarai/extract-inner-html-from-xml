package xml;

import exception.GenericException;
import model.Record;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

/**
 * @author pramesh-bhattarai
 */
public class DefaultXmlToPojoConverter implements XmlToPojoConverter<Record> {

    private final Unmarshaller unmarshaller;
    private final XMLInputFactory xmlInputFactory;

    public DefaultXmlToPojoConverter() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(Record.class);
        xmlInputFactory = XMLInputFactory.newFactory();

        // ignoring all namespaces from tags
        xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
        unmarshaller = jc.createUnmarshaller();
    }

    @Override
    public Record unmarshal(InputStream inputStream) {
        try {
            XMLStreamReader xsr = xmlInputFactory.createXMLStreamReader(inputStream);
            return (Record) unmarshaller.unmarshal(xsr);
        } catch (Exception e) {
            throw new GenericException(e);
        }
    }
}
