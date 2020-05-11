package xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.transform.TransformerFactory;
import java.io.StringWriter;

/**
 * This class is used to extract all text from descriptions tag.
 *
 * @author pramesh-bhattarai
 */
public class DescriptionAdapter extends XmlAdapter<Object, String> {

    private final TransformerFactory transformerFactory;

    public DescriptionAdapter() {
        transformerFactory = TransformerFactory.newInstance();
    }

    @Override
    public String unmarshal(Object v) throws Exception {
        StringWriter stringWriter = AdapterUtil.extractInnerTagsAsText(v, transformerFactory);
        return stringWriter.toString().trim();
    }

    @Override
    public Object marshal(String v) {
        return v;
    }

}
