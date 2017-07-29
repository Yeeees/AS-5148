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
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author YLY
 */
@Embeddable
public class AwardPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TRACK_TRACK_ID")
    private BigInteger trackTrackId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAPER_PAPER_ID")
    private BigInteger paperPaperId;

    public AwardPK() {
    }

    public AwardPK(BigInteger trackTrackId, BigInteger paperPaperId) {
        this.trackTrackId = trackTrackId;
        this.paperPaperId = paperPaperId;
    }

    public BigInteger getTrackTrackId() {
        return trackTrackId;
    }

    public void setTrackTrackId(BigInteger trackTrackId) {
        this.trackTrackId = trackTrackId;
    }

    public BigInteger getPaperPaperId() {
        return paperPaperId;
    }

    public void setPaperPaperId(BigInteger paperPaperId) {
        this.paperPaperId = paperPaperId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trackTrackId != null ? trackTrackId.hashCode() : 0);
        hash += (paperPaperId != null ? paperPaperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AwardPK)) {
            return false;
        }
        AwardPK other = (AwardPK) object;
        if ((this.trackTrackId == null && other.trackTrackId != null) || (this.trackTrackId != null && !this.trackTrackId.equals(other.trackTrackId))) {
            return false;
        }
        if ((this.paperPaperId == null && other.paperPaperId != null) || (this.paperPaperId != null && !this.paperPaperId.equals(other.paperPaperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.AwardPK[ trackTrackId=" + trackTrackId + ", paperPaperId=" + paperPaperId + " ]";
    }
    
}
