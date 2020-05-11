package xml;

import model.Record;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @author pramesh-bhattarai
 */
public class DefaultXmlToPojoConverterTest extends TestFileReader {

    private DefaultXmlToPojoConverter defaultXmlToPojoConverter;

    @Before
    public void setup() throws JAXBException {
        defaultXmlToPojoConverter = new DefaultXmlToPojoConverter();
    }

    @Test
    public void test_record() throws IOException {
        Record record = defaultXmlToPojoConverter.unmarshal(getResource("record.xml"));

        String expectedId = "1";
        Assert.assertEquals(expectedId, record.getId());

        String expectedName = "Lionel Messi";
        Assert.assertEquals(expectedName, record.getName());

        String expectedDescription = "<p>\n" +
                "            Born and raised in central Argentina, Messi relocated to Spain to join Barcelona at age 13,\n" +
                "            for whom he made his competitive debut aged 17 in October 2004. He established himself as an\n" +
                "            integral player for the club within the next three years, and in his first uninterrupted season\n" +
                "            in 2008–09 he helped Barcelona achieve the first\n" +
                "            <a href=\"/wiki/Treble_(association_football)\" title=\"Treble (association football)\">treble</a>\n" +
                "            in Spanish football; that year, aged 22, Messi won his first\n" +
                "            <a href=\"/wiki/2009_Ballon_d%27Or\" title=\"2009 Ballon d'Or\">Ballon d'Or</a>.\n" +
                "        </p>";
        System.out.println(record);
        Assert.assertEquals(expectedDescription, record.getDescription());

    }
}
