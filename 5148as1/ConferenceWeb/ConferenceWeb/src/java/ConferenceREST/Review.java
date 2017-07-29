/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConferenceREST;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "REVIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Review.findAll", query = "SELECT r FROM Review r"),
    @NamedQuery(name = "Review.findByPcMemberMemId", query = "SELECT r FROM Review r WHERE r.reviewPK.pcMemberMemId = :pcMemberMemId"),
    @NamedQuery(name = "Review.findByPaperPaperId", query = "SELECT r FROM Review r WHERE r.reviewPK.paperPaperId = :paperPaperId"),
    @NamedQuery(name = "Review.findByReviewDate", query = "SELECT r FROM Review r WHERE r.reviewDate = :reviewDate"),
    @NamedQuery(name = "Review.findByRecommendation", query = "SELECT r FROM Review r WHERE r.recommendation = :recommendation"),
    @NamedQuery(name = "Review.findByDueDate", query = "SELECT r FROM Review r WHERE r.dueDate = :dueDate"),
    @NamedQuery(name = "Review.findByReviewComment", query = "SELECT r FROM Review r WHERE r.reviewComment = :reviewComment")})
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReviewPK reviewPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REVIEW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RECOMMENDATION")
    private String recommendation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Size(max = 100)
    @Column(name = "REVIEW_COMMENT")
    private String reviewComment;
    @JoinColumn(name = "PAPER_PAPER_ID", referencedColumnName = "PAPER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paper paper;
    @JoinColumn(name = "PC_MEMBER_MEM_ID", referencedColumnName = "MEM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PcMember pcMember;

    public Review() {
    }

    public Review(ReviewPK reviewPK) {
        this.reviewPK = reviewPK;
    }

    public Review(ReviewPK reviewPK, Date reviewDate, String recommendation, Date dueDate) {
        this.reviewPK = reviewPK;
        this.reviewDate = reviewDate;
        this.recommendation = recommendation;
        this.dueDate = dueDate;
    }

    public Review(BigInteger pcMemberMemId, BigInteger paperPaperId) {
        this.reviewPK = new ReviewPK(pcMemberMemId, paperPaperId);
    }

    public ReviewPK getReviewPK() {
        return reviewPK;
    }

    public void setReviewPK(ReviewPK reviewPK) {
        this.reviewPK = reviewPK;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public PcMember getPcMember() {
        return pcMember;
    }

    public void setPcMember(PcMember pcMember) {
        this.pcMember = pcMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewPK != null ? reviewPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Review)) {
            return false;
        }
        Review other = (Review) object;
        if ((this.reviewPK == null && other.reviewPK != null) || (this.reviewPK != null && !this.reviewPK.equals(other.reviewPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Review[ reviewPK=" + reviewPK + " ]";
    }
    
}
