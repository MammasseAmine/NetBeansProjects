
package newpackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for somme complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="somme">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbr1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbr2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "somme", propOrder = {
    "nbr1",
    "nbr2"
})
public class Somme {

    protected int nbr1;
    protected int nbr2;

    /**
     * Gets the value of the nbr1 property.
     * 
     */
    public int getNbr1() {
        return nbr1;
    }

    /**
     * Sets the value of the nbr1 property.
     * 
     */
    public void setNbr1(int value) {
        this.nbr1 = value;
    }

    /**
     * Gets the value of the nbr2 property.
     * 
     */
    public int getNbr2() {
        return nbr2;
    }

    /**
     * Sets the value of the nbr2 property.
     * 
     */
    public void setNbr2(int value) {
        this.nbr2 = value;
    }

}
