package xml;

import java.io.InputStream;

/**
 * Interface to convert InputStream to POJO.
 *
 * @author pramesh-bhattarai
 */
public interface XmlToPojoConverter<T> {

    Object unmarshal(InputStream inputStream);
}
