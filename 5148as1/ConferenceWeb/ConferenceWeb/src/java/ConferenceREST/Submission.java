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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YLY
 */
@Entity
@Table(name = "SUBMISSION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Submission.findAll", query = "SELECT s FROM Submission s"),
    @NamedQuery(name = "Submission.findByPaperPaperId", query = "SELECT s FROM Submission s WHERE s.submissionPK.paperPaperId = :paperPaperId"),
    @NamedQuery(name = "Submission.findByAuthorAuthorId", query = "SELECT s FROM Submission s WHERE s.submissionPK.authorAuthorId = :authorAuthorId"),
    @NamedQuery(name = "Submission.findByAuthorOrder", query = "SELECT s FROM Submission s WHERE s.authorOrder = :authorOrder"),
    @NamedQuery(name = "Submission.findByCoAuthor", query = "SELECT s FROM Submission s WHERE s.coAuthor = :coAuthor")})
public class Submission implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubmissionPK submissionPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHOR_ORDER")
    private BigInteger authorOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CO_AUTHOR")
    private Character coAuthor;
    @JoinColumn(name = "AUTHOR_AUTHOR_ID", referencedColumnName = "AUTHOR_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Author author;
    @JoinColumn(name = "PAPER_PAPER_ID", referencedColumnName = "PAPER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paper paper;

    public Submission() {
    }

    public Submission(SubmissionPK submissionPK) {
        this.submissionPK = submissionPK;
    }

    public Submission(SubmissionPK submissionPK, BigInteger authorOrder, Character coAuthor) {
        this.submissionPK = submissionPK;
        this.authorOrder = authorOrder;
        this.coAuthor = coAuthor;
    }

    public Submission(BigInteger paperPaperId, BigInteger authorAuthorId) {
        this.submissionPK = new SubmissionPK(paperPaperId, authorAuthorId);
    }

    public SubmissionPK getSubmissionPK() {
        return submissionPK;
    }

    public void setSubmissionPK(SubmissionPK submissionPK) {
        this.submissionPK = submissionPK;
    }

    public BigInteger getAuthorOrder() {
        return authorOrder;
    }

    public void setAuthorOrder(BigInteger authorOrder) {
        this.authorOrder = authorOrder;
    }

    public Character getCoAuthor() {
        return coAuthor;
    }

    public void setCoAuthor(Character coAuthor) {
        this.coAuthor = coAuthor;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (submissionPK != null ? submissionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Submission)) {
            return false;
        }
        Submission other = (Submission) object;
        if ((this.submissionPK == null && other.submissionPK != null) || (this.submissionPK != null && !this.submissionPK.equals(other.submissionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Submission[ submissionPK=" + submissionPK + " ]";
    }
    
}
