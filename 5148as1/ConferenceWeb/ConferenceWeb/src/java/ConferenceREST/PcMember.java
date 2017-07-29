/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConferenceREST;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "PC_MEMBER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PcMember.findAll", query = "SELECT p FROM PcMember p"),
    @NamedQuery(name = "PcMember.findByMemId", query = "SELECT p FROM PcMember p WHERE p.memId = :memId"),
    @NamedQuery(name = "PcMember.findByMemFname", query = "SELECT p FROM PcMember p WHERE p.memFname = :memFname"),
    @NamedQuery(name = "PcMember.findByMemLname", query = "SELECT p FROM PcMember p WHERE p.memLname = :memLname"),
    @NamedQuery(name = "PcMember.findByMemTitle", query = "SELECT p FROM PcMember p WHERE p.memTitle = :memTitle"),
    @NamedQuery(name = "PcMember.findByMemPosition", query = "SELECT p FROM PcMember p WHERE p.memPosition = :memPosition"),
    @NamedQuery(name = "PcMember.findByMemAffiliation", query = "SELECT p FROM PcMember p WHERE p.memAffiliation = :memAffiliation"),
    @NamedQuery(name = "PcMember.findByMemEmail", query = "SELECT p FROM PcMember p WHERE p.memEmail = :memEmail")})
public class PcMember implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEM_ID")
    private BigDecimal memId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEM_FNAME")
    private String memFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEM_LNAME")
    private String memLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEM_TITLE")
    private String memTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEM_POSITION")
    private String memPosition;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MEM_AFFILIATION")
    private String memAffiliation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MEM_EMAIL")
    private String memEmail;
    @JoinColumn(name = "TRACK_TRACK_ID", referencedColumnName = "TRACK_ID")
    @ManyToOne(optional = false)
    private Track trackTrackId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pcMember")
    private Collection<Review> reviewCollection;

    public PcMember() {
    }

    public PcMember(BigDecimal memId) {
        this.memId = memId;
    }

    public PcMember(BigDecimal memId, String memFname, String memLname, String memTitle, String memPosition, String memAffiliation, String memEmail) {
        this.memId = memId;
        this.memFname = memFname;
        this.memLname = memLname;
        this.memTitle = memTitle;
        this.memPosition = memPosition;
        this.memAffiliation = memAffiliation;
        this.memEmail = memEmail;
    }

    public BigDecimal getMemId() {
        return memId;
    }

    public void setMemId(BigDecimal memId) {
        this.memId = memId;
    }

    public String getMemFname() {
        return memFname;
    }

    public void setMemFname(String memFname) {
        this.memFname = memFname;
    }

    public String getMemLname() {
        return memLname;
    }

    public void setMemLname(String memLname) {
        this.memLname = memLname;
    }

    public String getMemTitle() {
        return memTitle;
    }

    public void setMemTitle(String memTitle) {
        this.memTitle = memTitle;
    }

    public String getMemPosition() {
        return memPosition;
    }

    public void setMemPosition(String memPosition) {
        this.memPosition = memPosition;
    }

    public String getMemAffiliation() {
        return memAffiliation;
    }

    public void setMemAffiliation(String memAffiliation) {
        this.memAffiliation = memAffiliation;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public Track getTrackTrackId() {
        return trackTrackId;
    }

    public void setTrackTrackId(Track trackTrackId) {
        this.trackTrackId = trackTrackId;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memId != null ? memId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PcMember)) {
            return false;
        }
        PcMember other = (PcMember) object;
        if ((this.memId == null && other.memId != null) || (this.memId != null && !this.memId.equals(other.memId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.PcMember[ memId=" + memId + " ]";
    }
    
}
