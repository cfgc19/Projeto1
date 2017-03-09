//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.07 at 05:52:38 PM GMT 
//


package generated_Series;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}serie_name"/>
 *         &lt;element ref="{}type"/>
 *         &lt;element ref="{}rating" maxOccurs="unbounded"/>
 *         &lt;element ref="{}description"/>
 *         &lt;element ref="{}narrator" minOccurs="0"/>
 *         &lt;element ref="{}cast" maxOccurs="unbounded"/>
 *         &lt;element ref="{}musical_theme"/>
 *         &lt;element ref="{}writers" maxOccurs="unbounded"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{}nominations"/>
 *           &lt;element ref="{}spin_off"/>
 *           &lt;sequence>
 *             &lt;element ref="{}program_creators" maxOccurs="unbounded"/>
 *             &lt;element ref="{}awards"/>
 *           &lt;/sequence>
 *         &lt;/choice>
 *         &lt;element ref="{}network"/>
 *         &lt;element ref="{}first_episode"/>
 *         &lt;element ref="{}episode" maxOccurs="unbounded"/>
 *         &lt;element ref="{}languages" maxOccurs="unbounded"/>
 *         &lt;element ref="{}profiles" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serieName",
    "type",
    "rating",
    "description",
    "narrator",
    "cast",
    "musicalTheme",
    "writers",
    "nominations",
    "spinOff",
    "programCreators",
    "awards",
    "network",
    "firstEpisode",
    "episode",
    "languages",
    "profiles"
})
@XmlRootElement(name = "serie")
public class Serie {

    @XmlElement(name = "serie_name", required = true)
    protected String serieName;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected List<Rating> rating;
    @XmlElement(required = true)
    protected String description;
    protected String narrator;
    @XmlElement(required = true)
    protected List<Cast> cast;
    @XmlElement(name = "musical_theme", required = true)
    protected String musicalTheme;
    @XmlElement(required = true)
    protected List<String> writers;
    protected String nominations;
    @XmlElement(name = "spin_off")
    protected String spinOff;
    @XmlElement(name = "program_creators")
    protected List<String> programCreators;
    protected String awards;
    @XmlElement(required = true)
    protected String network;
    @XmlElement(name = "first_episode", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String firstEpisode;
    @XmlElement(required = true)
    protected List<Episode> episode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected List<String> languages;
    protected List<String> profiles;

    /**
     * Gets the value of the serieName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerieName() {
        return serieName;
    }

    /**
     * Sets the value of the serieName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerieName(String value) {
        this.serieName = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rating property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRating().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rating }
     * 
     * 
     */
    public List<Rating> getRating() {
        if (rating == null) {
            rating = new ArrayList<Rating>();
        }
        return this.rating;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the narrator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNarrator() {
        return narrator;
    }

    /**
     * Sets the value of the narrator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNarrator(String value) {
        this.narrator = value;
    }

    /**
     * Gets the value of the cast property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cast property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCast().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Cast }
     * 
     * 
     */
    public List<Cast> getCast() {
        if (cast == null) {
            cast = new ArrayList<Cast>();
        }
        return this.cast;
    }

    /**
     * Gets the value of the musicalTheme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMusicalTheme() {
        return musicalTheme;
    }

    /**
     * Sets the value of the musicalTheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMusicalTheme(String value) {
        this.musicalTheme = value;
    }

    /**
     * Gets the value of the writers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the writers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWriters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWriters() {
        if (writers == null) {
            writers = new ArrayList<String>();
        }
        return this.writers;
    }

    /**
     * Gets the value of the nominations property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNominations() {
        return nominations;
    }

    /**
     * Sets the value of the nominations property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNominations(String value) {
        this.nominations = value;
    }

    /**
     * Gets the value of the spinOff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpinOff() {
        return spinOff;
    }

    /**
     * Sets the value of the spinOff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpinOff(String value) {
        this.spinOff = value;
    }

    /**
     * Gets the value of the programCreators property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the programCreators property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProgramCreators().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProgramCreators() {
        if (programCreators == null) {
            programCreators = new ArrayList<String>();
        }
        return this.programCreators;
    }

    /**
     * Gets the value of the awards property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwards() {
        return awards;
    }

    /**
     * Sets the value of the awards property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwards(String value) {
        this.awards = value;
    }

    /**
     * Gets the value of the network property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNetwork() {
        return network;
    }

    /**
     * Sets the value of the network property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNetwork(String value) {
        this.network = value;
    }

    /**
     * Gets the value of the firstEpisode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstEpisode() {
        return firstEpisode;
    }

    /**
     * Sets the value of the firstEpisode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstEpisode(String value) {
        this.firstEpisode = value;
    }

    /**
     * Gets the value of the episode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the episode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEpisode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Episode }
     * 
     * 
     */
    public List<Episode> getEpisode() {
        if (episode == null) {
            episode = new ArrayList<Episode>();
        }
        return this.episode;
    }

    /**
     * Gets the value of the languages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the languages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLanguages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLanguages() {
        if (languages == null) {
            languages = new ArrayList<String>();
        }
        return this.languages;
    }

    /**
     * Gets the value of the profiles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profiles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfiles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProfiles() {
        if (profiles == null) {
            profiles = new ArrayList<String>();
        }
        return this.profiles;
    }

}