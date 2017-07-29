/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConferenceREST;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "PAPER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paper.findAll", query = "SELECT p FROM Paper p"),
    @NamedQuery(name = "Paper.findByPaperId", query = "SELECT p FROM Paper p WHERE p.paperId = :paperId"),
    @NamedQuery(name = "Paper.findByPaperTitle", query = "SELECT p FROM Paper p WHERE p.paperTitle = :paperTitle"),
    @NamedQuery(name = "Paper.findByPaperAbstract", query = "SELECT p FROM Paper p WHERE p.paperAbstract = :paperAbstract"),
    @NamedQuery(name = "Paper.findByPaperType", query = "SELECT p FROM Paper p WHERE p.paperType = :paperType"),
    @NamedQuery(name = "Paper.findBySubmitDate", query = "SELECT p FROM Paper p WHERE p.submitDate = :submitDate")})
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAPER_ID")
    private BigDecimal paperId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PAPER_TITLE")
    private String paperTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "PAPER_ABSTRACT")
    private String paperAbstract;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PAPER_TYPE")
    private String paperType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUBMIT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submitDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "paper")
    private Award award;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paper")
    private Collection<Review> reviewCollection;
    @JoinColumn(name = "TRACK_TRACK_ID", referencedColumnName = "TRACK_ID")
    @ManyToOne(optional = false)
    private Track trackTrackId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paper")
    private Collection<Submission> submissionCollection;

    public Paper() {
    }

    public Paper(BigDecimal paperId) {
        this.paperId = paperId;
    }

    public Paper(BigDecimal paperId, String paperTitle, String paperAbstract, String paperType, Date submitDate) {
        this.paperId = paperId;
        this.paperTitle = paperTitle;
        this.paperAbstract = paperAbstract;
        this.paperType = paperType;
        this.submitDate = submitDate;
    }

    public BigDecimal getPaperId() {
        return paperId;
    }

    public void setPaperId(BigDecimal paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Award getAward() {
        return award;
    }

    public void setAward(Award award) {
        this.award = award;
    }

    @XmlTransient
    public Collection<Review> getReviewCollection() {
        return reviewCollection;
    }

    public void setReviewCollection(Collection<Review> reviewCollection) {
        this.reviewCollection = reviewCollection;
    }

    public Track getTrackTrackId() {
        return trackTrackId;
    }

    public void setTrackTrackId(Track trackTrackId) {
        this.trackTrackId = trackTrackId;
    }

    @XmlTransient
    public Collection<Submission> getSubmissionCollection() {
        return submissionCollection;
    }

    public void setSubmissionCollection(Collection<Submission> submissionCollection) {
        this.submissionCollection = submissionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paperId != null ? paperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paper)) {
            return false;
        }
        Paper other = (Paper) object;
        if ((this.paperId == null && other.paperId != null) || (this.paperId != null && !this.paperId.equals(other.paperId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Paper[ paperId=" + paperId + " ]";
    }
    
}
