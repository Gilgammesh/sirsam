
package estadistica.webservice;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para institucionEducativa complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="institucionEducativa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="area_censo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cen_edu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cen_pob" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_car" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_mod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cod_tur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codccpp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codcp_inei" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codgeo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codlocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codooii" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_cod_car" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_cod_tur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_dist" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_dpto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_dreugel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_forma" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_fte_dato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_ges_dep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_gestion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_niv_mod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_prov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_region" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_tipoprog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="d_tipssexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dareacenso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dir_cen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_act" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechareg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ges_dep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gestion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="localidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="niv_mod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nlat_ie" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="nlong_ie" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="pagweb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="talum_hom" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="talum_muj" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="talumno" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tdocente" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="telefono" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoprog" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipssexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tseccion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "institucionEducativa", propOrder = {
    "anexo",
    "areaCenso",
    "cenEdu",
    "cenPob",
    "codCar",
    "codMod",
    "codTur",
    "codccpp",
    "codcpInei",
    "codgeo",
    "codlocal",
    "codooii",
    "dCodCar",
    "dCodTur",
    "dDist",
    "dDpto",
    "dDreugel",
    "dEstado",
    "dForma",
    "dFteDato",
    "dGesDep",
    "dGestion",
    "dNivMod",
    "dProv",
    "dRegion",
    "dTipoprog",
    "dTipssexo",
    "dareacenso",
    "dirCen",
    "director",
    "email",
    "estado",
    "fechaAct",
    "fechareg",
    "gesDep",
    "gestion",
    "localidad",
    "nivMod",
    "nlatIe",
    "nlongIe",
    "pagweb",
    "referencia",
    "talumHom",
    "talumMuj",
    "talumno",
    "tdocente",
    "telefono",
    "tipoprog",
    "tipssexo",
    "tseccion"
})
public class InstitucionEducativa {

    protected String anexo;
    @XmlElement(name = "area_censo")
    protected String areaCenso;
    @XmlElement(name = "cen_edu")
    protected String cenEdu;
    @XmlElement(name = "cen_pob")
    protected String cenPob;
    @XmlElement(name = "cod_car")
    protected String codCar;
    @XmlElement(name = "cod_mod")
    protected String codMod;
    @XmlElement(name = "cod_tur")
    protected String codTur;
    protected String codccpp;
    @XmlElement(name = "codcp_inei")
    protected String codcpInei;
    protected String codgeo;
    protected String codlocal;
    protected String codooii;
    @XmlElement(name = "d_cod_car")
    protected String dCodCar;
    @XmlElement(name = "d_cod_tur")
    protected String dCodTur;
    @XmlElement(name = "d_dist")
    protected String dDist;
    @XmlElement(name = "d_dpto")
    protected String dDpto;
    @XmlElement(name = "d_dreugel")
    protected String dDreugel;
    @XmlElement(name = "d_estado")
    protected String dEstado;
    @XmlElement(name = "d_forma")
    protected String dForma;
    @XmlElement(name = "d_fte_dato")
    protected String dFteDato;
    @XmlElement(name = "d_ges_dep")
    protected String dGesDep;
    @XmlElement(name = "d_gestion")
    protected String dGestion;
    @XmlElement(name = "d_niv_mod")
    protected String dNivMod;
    @XmlElement(name = "d_prov")
    protected String dProv;
    @XmlElement(name = "d_region")
    protected String dRegion;
    @XmlElement(name = "d_tipoprog")
    protected String dTipoprog;
    @XmlElement(name = "d_tipssexo")
    protected String dTipssexo;
    protected String dareacenso;
    @XmlElement(name = "dir_cen")
    protected String dirCen;
    protected String director;
    protected String email;
    protected String estado;
    @XmlElement(name = "fecha_act")
    protected String fechaAct;
    protected String fechareg;
    @XmlElement(name = "ges_dep")
    protected String gesDep;
    protected String gestion;
    protected String localidad;
    @XmlElement(name = "niv_mod")
    protected String nivMod;
    @XmlElement(name = "nlat_ie")
    protected BigDecimal nlatIe;
    @XmlElement(name = "nlong_ie")
    protected BigDecimal nlongIe;
    protected String pagweb;
    protected String referencia;
    @XmlElement(name = "talum_hom")
    protected BigDecimal talumHom;
    @XmlElement(name = "talum_muj")
    protected BigDecimal talumMuj;
    protected BigDecimal talumno;
    protected BigDecimal tdocente;
    protected String telefono;
    protected String tipoprog;
    protected String tipssexo;
    protected BigDecimal tseccion;

    /**
     * Obtiene el valor de la propiedad anexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnexo() {
        return anexo;
    }

    /**
     * Define el valor de la propiedad anexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnexo(String value) {
        this.anexo = value;
    }

    /**
     * Obtiene el valor de la propiedad areaCenso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAreaCenso() {
        return areaCenso;
    }

    /**
     * Define el valor de la propiedad areaCenso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAreaCenso(String value) {
        this.areaCenso = value;
    }

    /**
     * Obtiene el valor de la propiedad cenEdu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCenEdu() {
        return cenEdu;
    }

    /**
     * Define el valor de la propiedad cenEdu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCenEdu(String value) {
        this.cenEdu = value;
    }

    /**
     * Obtiene el valor de la propiedad cenPob.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCenPob() {
        return cenPob;
    }

    /**
     * Define el valor de la propiedad cenPob.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCenPob(String value) {
        this.cenPob = value;
    }

    /**
     * Obtiene el valor de la propiedad codCar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodCar() {
        return codCar;
    }

    /**
     * Define el valor de la propiedad codCar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodCar(String value) {
        this.codCar = value;
    }

    /**
     * Obtiene el valor de la propiedad codMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodMod() {
        return codMod;
    }

    /**
     * Define el valor de la propiedad codMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodMod(String value) {
        this.codMod = value;
    }

    /**
     * Obtiene el valor de la propiedad codTur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodTur() {
        return codTur;
    }

    /**
     * Define el valor de la propiedad codTur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodTur(String value) {
        this.codTur = value;
    }

    /**
     * Obtiene el valor de la propiedad codccpp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodccpp() {
        return codccpp;
    }

    /**
     * Define el valor de la propiedad codccpp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodccpp(String value) {
        this.codccpp = value;
    }

    /**
     * Obtiene el valor de la propiedad codcpInei.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodcpInei() {
        return codcpInei;
    }

    /**
     * Define el valor de la propiedad codcpInei.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodcpInei(String value) {
        this.codcpInei = value;
    }

    /**
     * Obtiene el valor de la propiedad codgeo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodgeo() {
        return codgeo;
    }

    /**
     * Define el valor de la propiedad codgeo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodgeo(String value) {
        this.codgeo = value;
    }

    /**
     * Obtiene el valor de la propiedad codlocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodlocal() {
        return codlocal;
    }

    /**
     * Define el valor de la propiedad codlocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodlocal(String value) {
        this.codlocal = value;
    }

    /**
     * Obtiene el valor de la propiedad codooii.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodooii() {
        return codooii;
    }

    /**
     * Define el valor de la propiedad codooii.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodooii(String value) {
        this.codooii = value;
    }

    /**
     * Obtiene el valor de la propiedad dCodCar.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCodCar() {
        return dCodCar;
    }

    /**
     * Define el valor de la propiedad dCodCar.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCodCar(String value) {
        this.dCodCar = value;
    }

    /**
     * Obtiene el valor de la propiedad dCodTur.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCodTur() {
        return dCodTur;
    }

    /**
     * Define el valor de la propiedad dCodTur.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCodTur(String value) {
        this.dCodTur = value;
    }

    /**
     * Obtiene el valor de la propiedad dDist.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDist() {
        return dDist;
    }

    /**
     * Define el valor de la propiedad dDist.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDist(String value) {
        this.dDist = value;
    }

    /**
     * Obtiene el valor de la propiedad dDpto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDpto() {
        return dDpto;
    }

    /**
     * Define el valor de la propiedad dDpto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDpto(String value) {
        this.dDpto = value;
    }

    /**
     * Obtiene el valor de la propiedad dDreugel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDreugel() {
        return dDreugel;
    }

    /**
     * Define el valor de la propiedad dDreugel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDreugel(String value) {
        this.dDreugel = value;
    }

    /**
     * Obtiene el valor de la propiedad dEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDEstado() {
        return dEstado;
    }

    /**
     * Define el valor de la propiedad dEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDEstado(String value) {
        this.dEstado = value;
    }

    /**
     * Obtiene el valor de la propiedad dForma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDForma() {
        return dForma;
    }

    /**
     * Define el valor de la propiedad dForma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDForma(String value) {
        this.dForma = value;
    }

    /**
     * Obtiene el valor de la propiedad dFteDato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFteDato() {
        return dFteDato;
    }

    /**
     * Define el valor de la propiedad dFteDato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFteDato(String value) {
        this.dFteDato = value;
    }

    /**
     * Obtiene el valor de la propiedad dGesDep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDGesDep() {
        return dGesDep;
    }

    /**
     * Define el valor de la propiedad dGesDep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDGesDep(String value) {
        this.dGesDep = value;
    }

    /**
     * Obtiene el valor de la propiedad dGestion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDGestion() {
        return dGestion;
    }

    /**
     * Define el valor de la propiedad dGestion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDGestion(String value) {
        this.dGestion = value;
    }

    /**
     * Obtiene el valor de la propiedad dNivMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNivMod() {
        return dNivMod;
    }

    /**
     * Define el valor de la propiedad dNivMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNivMod(String value) {
        this.dNivMod = value;
    }

    /**
     * Obtiene el valor de la propiedad dProv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDProv() {
        return dProv;
    }

    /**
     * Define el valor de la propiedad dProv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDProv(String value) {
        this.dProv = value;
    }

    /**
     * Obtiene el valor de la propiedad dRegion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRegion() {
        return dRegion;
    }

    /**
     * Define el valor de la propiedad dRegion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRegion(String value) {
        this.dRegion = value;
    }

    /**
     * Obtiene el valor de la propiedad dTipoprog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTipoprog() {
        return dTipoprog;
    }

    /**
     * Define el valor de la propiedad dTipoprog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTipoprog(String value) {
        this.dTipoprog = value;
    }

    /**
     * Obtiene el valor de la propiedad dTipssexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDTipssexo() {
        return dTipssexo;
    }

    /**
     * Define el valor de la propiedad dTipssexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDTipssexo(String value) {
        this.dTipssexo = value;
    }

    /**
     * Obtiene el valor de la propiedad dareacenso.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDareacenso() {
        return dareacenso;
    }

    /**
     * Define el valor de la propiedad dareacenso.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDareacenso(String value) {
        this.dareacenso = value;
    }

    /**
     * Obtiene el valor de la propiedad dirCen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirCen() {
        return dirCen;
    }

    /**
     * Define el valor de la propiedad dirCen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirCen(String value) {
        this.dirCen = value;
    }

    /**
     * Obtiene el valor de la propiedad director.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirector() {
        return director;
    }

    /**
     * Define el valor de la propiedad director.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirector(String value) {
        this.director = value;
    }

    /**
     * Obtiene el valor de la propiedad email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define el valor de la propiedad email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaAct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaAct() {
        return fechaAct;
    }

    /**
     * Define el valor de la propiedad fechaAct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaAct(String value) {
        this.fechaAct = value;
    }

    /**
     * Obtiene el valor de la propiedad fechareg.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechareg() {
        return fechareg;
    }

    /**
     * Define el valor de la propiedad fechareg.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechareg(String value) {
        this.fechareg = value;
    }

    /**
     * Obtiene el valor de la propiedad gesDep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGesDep() {
        return gesDep;
    }

    /**
     * Define el valor de la propiedad gesDep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGesDep(String value) {
        this.gesDep = value;
    }

    /**
     * Obtiene el valor de la propiedad gestion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGestion() {
        return gestion;
    }

    /**
     * Define el valor de la propiedad gestion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGestion(String value) {
        this.gestion = value;
    }

    /**
     * Obtiene el valor de la propiedad localidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Define el valor de la propiedad localidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidad(String value) {
        this.localidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nivMod.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNivMod() {
        return nivMod;
    }

    /**
     * Define el valor de la propiedad nivMod.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNivMod(String value) {
        this.nivMod = value;
    }

    /**
     * Obtiene el valor de la propiedad nlatIe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNlatIe() {
        return nlatIe;
    }

    /**
     * Define el valor de la propiedad nlatIe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNlatIe(BigDecimal value) {
        this.nlatIe = value;
    }

    /**
     * Obtiene el valor de la propiedad nlongIe.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNlongIe() {
        return nlongIe;
    }

    /**
     * Define el valor de la propiedad nlongIe.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNlongIe(BigDecimal value) {
        this.nlongIe = value;
    }

    /**
     * Obtiene el valor de la propiedad pagweb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagweb() {
        return pagweb;
    }

    /**
     * Define el valor de la propiedad pagweb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagweb(String value) {
        this.pagweb = value;
    }

    /**
     * Obtiene el valor de la propiedad referencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Define el valor de la propiedad referencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferencia(String value) {
        this.referencia = value;
    }

    /**
     * Obtiene el valor de la propiedad talumHom.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTalumHom() {
        return talumHom;
    }

    /**
     * Define el valor de la propiedad talumHom.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTalumHom(BigDecimal value) {
        this.talumHom = value;
    }

    /**
     * Obtiene el valor de la propiedad talumMuj.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTalumMuj() {
        return talumMuj;
    }

    /**
     * Define el valor de la propiedad talumMuj.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTalumMuj(BigDecimal value) {
        this.talumMuj = value;
    }

    /**
     * Obtiene el valor de la propiedad talumno.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTalumno() {
        return talumno;
    }

    /**
     * Define el valor de la propiedad talumno.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTalumno(BigDecimal value) {
        this.talumno = value;
    }

    /**
     * Obtiene el valor de la propiedad tdocente.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTdocente() {
        return tdocente;
    }

    /**
     * Define el valor de la propiedad tdocente.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTdocente(BigDecimal value) {
        this.tdocente = value;
    }

    /**
     * Obtiene el valor de la propiedad telefono.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Define el valor de la propiedad telefono.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefono(String value) {
        this.telefono = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoprog.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoprog() {
        return tipoprog;
    }

    /**
     * Define el valor de la propiedad tipoprog.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoprog(String value) {
        this.tipoprog = value;
    }

    /**
     * Obtiene el valor de la propiedad tipssexo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipssexo() {
        return tipssexo;
    }

    /**
     * Define el valor de la propiedad tipssexo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipssexo(String value) {
        this.tipssexo = value;
    }

    /**
     * Obtiene el valor de la propiedad tseccion.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTseccion() {
        return tseccion;
    }

    /**
     * Define el valor de la propiedad tseccion.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTseccion(BigDecimal value) {
        this.tseccion = value;
    }

}
