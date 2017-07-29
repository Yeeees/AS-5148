/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConferenceREST;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "AWARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Award.findAll", query = "SELECT a FROM Award a"),
    @NamedQuery(name = "Award.findByAwardPrice", query = "SELECT a FROM Award a WHERE a.awardPrice = :awardPrice"),
    @NamedQuery(name = "Award.findByTrackTrackId", query = "SELECT a FROM Award a WHERE a.awardPK.trackTrackId = :trackTrackId"),
    @NamedQuery(name = "Award.findByPaperPaperId", query = "SELECT a FROM Award a WHERE a.awardPK.paperPaperId = :paperPaperId")})
public class Award implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AwardPK awardPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AWARD_PRICE")
    private BigInteger awardPrice;
    @JoinColumn(name = "PAPER_PAPER_ID", referencedColumnName = "PAPER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Paper paper;
    @JoinColumn(name = "TRACK_TRACK_ID", referencedColumnName = "TRACK_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Track track;

    public Award() {
    }

    public Award(AwardPK awardPK) {
        this.awardPK = awardPK;
    }

    public Award(AwardPK awardPK, BigInteger awardPrice) {
        this.awardPK = awardPK;
        this.awardPrice = awardPrice;
    }

    public Award(BigInteger trackTrackId, BigInteger paperPaperId) {
        this.awardPK = new AwardPK(trackTrackId, paperPaperId);
    }

    public AwardPK getAwardPK() {
        return awardPK;
    }

    public void setAwardPK(AwardPK awardPK) {
        this.awardPK = awardPK;
    }

    public BigInteger getAwardPrice() {
        return awardPrice;
    }

    public void setAwardPrice(BigInteger awardPrice) {
        this.awardPrice = awardPrice;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (awardPK != null ? awardPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Award)) {
            return false;
        }
        Award other = (Award) object;
        if ((this.awardPK == null && other.awardPK != null) || (this.awardPK != null && !this.awardPK.equals(other.awardPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Award[ awardPK=" + awardPK + " ]";
    }
    
}
