
package estadistica.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the estadistica.webservice package. 
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

    private final static QName _UpsertInstitucionEducativa_QNAME = new QName("http://webservice.estadistica/", "upsertInstitucionEducativa");
    private final static QName _InsertLogsEstadisticaBot_QNAME = new QName("http://webservice.estadistica/", "insertLogsEstadisticaBot");
    private final static QName _InsertLogsEstadisticaBotResponse_QNAME = new QName("http://webservice.estadistica/", "insertLogsEstadisticaBotResponse");
    private final static QName _UpsertInstitucionEducativaResponse_QNAME = new QName("http://webservice.estadistica/", "upsertInstitucionEducativaResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: estadistica.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InsertLogsEstadisticaBotResponse }
     * 
     */
    public InsertLogsEstadisticaBotResponse createInsertLogsEstadisticaBotResponse() {
        return new InsertLogsEstadisticaBotResponse();
    }

    /**
     * Create an instance of {@link UpsertInstitucionEducativa }
     * 
     */
    public UpsertInstitucionEducativa createUpsertInstitucionEducativa() {
        return new UpsertInstitucionEducativa();
    }

    /**
     * Create an instance of {@link InsertLogsEstadisticaBot }
     * 
     */
    public InsertLogsEstadisticaBot createInsertLogsEstadisticaBot() {
        return new InsertLogsEstadisticaBot();
    }

    /**
     * Create an instance of {@link UpsertInstitucionEducativaResponse }
     * 
     */
    public UpsertInstitucionEducativaResponse createUpsertInstitucionEducativaResponse() {
        return new UpsertInstitucionEducativaResponse();
    }

    /**
     * Create an instance of {@link InstitucionEducativa }
     * 
     */
    public InstitucionEducativa createInstitucionEducativa() {
        return new InstitucionEducativa();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpsertInstitucionEducativa }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.estadistica/", name = "upsertInstitucionEducativa")
    public JAXBElement<UpsertInstitucionEducativa> createUpsertInstitucionEducativa(UpsertInstitucionEducativa value) {
        return new JAXBElement<UpsertInstitucionEducativa>(_UpsertInstitucionEducativa_QNAME, UpsertInstitucionEducativa.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertLogsEstadisticaBot }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.estadistica/", name = "insertLogsEstadisticaBot")
    public JAXBElement<InsertLogsEstadisticaBot> createInsertLogsEstadisticaBot(InsertLogsEstadisticaBot value) {
        return new JAXBElement<InsertLogsEstadisticaBot>(_InsertLogsEstadisticaBot_QNAME, InsertLogsEstadisticaBot.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertLogsEstadisticaBotResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.estadistica/", name = "insertLogsEstadisticaBotResponse")
    public JAXBElement<InsertLogsEstadisticaBotResponse> createInsertLogsEstadisticaBotResponse(InsertLogsEstadisticaBotResponse value) {
        return new JAXBElement<InsertLogsEstadisticaBotResponse>(_InsertLogsEstadisticaBotResponse_QNAME, InsertLogsEstadisticaBotResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpsertInstitucionEducativaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.estadistica/", name = "upsertInstitucionEducativaResponse")
    public JAXBElement<UpsertInstitucionEducativaResponse> createUpsertInstitucionEducativaResponse(UpsertInstitucionEducativaResponse value) {
        return new JAXBElement<UpsertInstitucionEducativaResponse>(_UpsertInstitucionEducativaResponse_QNAME, UpsertInstitucionEducativaResponse.class, null, value);
    }

}
