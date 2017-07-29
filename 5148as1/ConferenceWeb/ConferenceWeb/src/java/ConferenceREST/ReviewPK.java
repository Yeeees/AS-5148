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
public class ReviewPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PC_MEMBER_MEM_ID")
    private BigInteger pcMemberMemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAPER_PAPER_ID")
    private BigInteger paperPaperId;

    public ReviewPK() {
    }

    public ReviewPK(BigInteger pcMemberMemId, BigInteger paperPaperId) {
        this.pcMemberMemId = pcMemberMemId;
        this.paperPaperId = paperPaperId;
    }

    public BigInteger getPcMemberMemId() {
        return pcMemberMemId;
    }

    public void setPcMemberMemId(BigInteger pcMemberMemId) {
        this.pcMemberMemId = pcMemberMemId;
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
        hash += (pcMemberMemId != null ? pcMemberMemId.hashCode() : 0);
        hash += (paperPaperId != null ? paperPaperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReviewPK)) {
            return false;
        }
        ReviewPK other = (ReviewPK) object;
        if ((this.pcMemberMemId == null && other.pcMemberMemId != null) || (this.pcMemberMemId != null && !this.pcMemberMemId.equals(other.pcMemberMemId))) {
            return false;
        }
        if ((this.paperPaperId == null && other.paperPaperId != null) || (this.paperPaperId != null && !this.paperPaperId.equals(other.paperPaperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.ReviewPK[ pcMemberMemId=" + pcMemberMemId + ", paperPaperId=" + paperPaperId + " ]";
    }
    
}
