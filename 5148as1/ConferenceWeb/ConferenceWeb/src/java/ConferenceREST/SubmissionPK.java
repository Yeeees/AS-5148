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
public class SubmissionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PAPER_PAPER_ID")
    private BigInteger paperPaperId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHOR_AUTHOR_ID")
    private BigInteger authorAuthorId;

    public SubmissionPK() {
    }

    public SubmissionPK(BigInteger paperPaperId, BigInteger authorAuthorId) {
        this.paperPaperId = paperPaperId;
        this.authorAuthorId = authorAuthorId;
    }

    public BigInteger getPaperPaperId() {
        return paperPaperId;
    }

    public void setPaperPaperId(BigInteger paperPaperId) {
        this.paperPaperId = paperPaperId;
    }

    public BigInteger getAuthorAuthorId() {
        return authorAuthorId;
    }

    public void setAuthorAuthorId(BigInteger authorAuthorId) {
        this.authorAuthorId = authorAuthorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paperPaperId != null ? paperPaperId.hashCode() : 0);
        hash += (authorAuthorId != null ? authorAuthorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubmissionPK)) {
            return false;
        }
        SubmissionPK other = (SubmissionPK) object;
        if ((this.paperPaperId == null && other.paperPaperId != null) || (this.paperPaperId != null && !this.paperPaperId.equals(other.paperPaperId))) {
            return false;
        }
        if ((this.authorAuthorId == null && other.authorAuthorId != null) || (this.authorAuthorId != null && !this.authorAuthorId.equals(other.authorAuthorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.SubmissionPK[ paperPaperId=" + paperPaperId + ", authorAuthorId=" + authorAuthorId + " ]";
    }
    
}
