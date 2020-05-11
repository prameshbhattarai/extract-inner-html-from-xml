package xml.adapter;

import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * This class hold the static method for converting inner XML tags to text.
 *
 * @author pramesh-bhattarai
 */
public final class AdapterUtil {

    /**
     * XSLT that will strip the root element. Used to only take the content of an element given
     */
    private final static String UNMARSHAL_XSLT = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<xsl:transform xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
            "\n" +
            "    <xsl:output method=\"xml\" omit-xml-declaration=\"yes\" />\n" +
            "\n" +
            "    <xsl:template match=\"/*\">\n" +
            "      <xsl:apply-templates select=\"@*|node()\"/>\n" +
            "    </xsl:template>\n" +
            "\n" +
            "    <xsl:template match=\"@*|node()\">\n" +
            "        <xsl:copy>\n" +
            "            <xsl:apply-templates select=\"@*|node()\"/>\n" +
            "        </xsl:copy>\n" +
            "    </xsl:template>\n" +
            "    \n" +
            "</xsl:transform>";

    public static StringWriter extractInnerTagsAsText(Object v, TransformerFactory transformerFactory) throws TransformerException {
        Element rootElement = (Element) v;
        DOMSource source = new DOMSource(rootElement);

        StreamSource xsltSource = new StreamSource(new StringReader(UNMARSHAL_XSLT));
        Transformer transformer = transformerFactory.newTransformer(xsltSource);

        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);
        transformer.transform(source, result);
        return stringWriter;
    }
}
