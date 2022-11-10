
package newpackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the newpackage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Somme_QNAME = new QName("http://newpackage/", "somme");
    private final static QName _SommeResponse_QNAME = new QName("http://newpackage/", "sommeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: newpackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Somme }
     * 
     */
    public Somme createSomme() {
        return new Somme();
    }

    /**
     * Create an instance of {@link SommeResponse }
     * 
     */
    public SommeResponse createSommeResponse() {
        return new SommeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Somme }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://newpackage/", name = "somme")
    public JAXBElement<Somme> createSomme(Somme value) {
        return new JAXBElement<Somme>(_Somme_QNAME, Somme.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SommeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://newpackage/", name = "sommeResponse")
    public JAXBElement<SommeResponse> createSommeResponse(SommeResponse value) {
        return new JAXBElement<SommeResponse>(_SommeResponse_QNAME, SommeResponse.class, null, value);
    }

}
