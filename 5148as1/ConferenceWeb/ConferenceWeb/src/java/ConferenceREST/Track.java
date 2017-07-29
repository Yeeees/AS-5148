/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConferenceREST;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "TRACK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Track.findAll", query = "SELECT t FROM Track t"),
    @NamedQuery(name = "Track.findByTrackId", query = "SELECT t FROM Track t WHERE t.trackId = :trackId"),
    @NamedQuery(name = "Track.findByConferenceConId", query = "SELECT t FROM Track t WHERE t.conferenceConId = :conferenceConId"),
    @NamedQuery(name = "Track.findByTrackDescription", query = "SELECT t FROM Track t WHERE t.trackDescription = :trackDescription")})
public class Track implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRACK_ID")
    private BigDecimal trackId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFERENCE_CON_ID")
    private BigInteger conferenceConId;
    @Size(max = 100)
    @Column(name = "TRACK_DESCRIPTION")
    private String trackDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackTrackId")
    private Collection<PcMember> pcMemberCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "track")
    private Award award;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trackTrackId")
    private Collection<Paper> paperCollection;

    public Track() {
    }

    public Track(BigDecimal trackId) {
        this.trackId = trackId;
    }

    public Track(BigDecimal trackId, BigInteger conferenceConId) {
        this.trackId = trackId;
        this.conferenceConId = conferenceConId;
    }

    public BigDecimal getTrackId() {
        return trackId;
    }

    public void setTrackId(BigDecimal trackId) {
        this.trackId = trackId;
    }

    public BigInteger getConferenceConId() {
        return conferenceConId;
    }

    public void setConferenceConId(BigInteger conferenceConId) {
        this.conferenceConId = conferenceConId;
    }

    public String getTrackDescription() {
        return trackDescription;
    }

    public void setTrackDescription(String trackDescription) {
        this.trackDescription = trackDescription;
    }

    @XmlTransient
    public Collection<PcMember> getPcMemberCollection() {
        return pcMemberCollection;
    }

    public void setPcMemberCollection(Collection<PcMember> pcMemberCollection) {
        this.pcMemberCollection = pcMemberCollection;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    @XmlTransient
    public Collection<Paper> getPaperCollection() {
        return paperCollection;
    }

    public void setPaperCollection(Collection<Paper> paperCollection) {
        this.paperCollection = paperCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackId != null ? trackId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Track)) {
            return false;
        }
        Track other = (Track) object;
        if ((this.trackId == null && other.trackId != null) || (this.trackId != null && !this.trackId.equals(other.trackId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Track[ trackId=" + trackId + " ]";
    }
    
}
