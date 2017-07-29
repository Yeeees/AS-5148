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
@Table(name = "AUTHOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a"),
    @NamedQuery(name = "Author.findByAuthorId", query = "SELECT a FROM Author a WHERE a.authorId = :authorId"),
    @NamedQuery(name = "Author.findByAuthorFname", query = "SELECT a FROM Author a WHERE a.authorFname = :authorFname"),
    @NamedQuery(name = "Author.findByAuthorLname", query = "SELECT a FROM Author a WHERE a.authorLname = :authorLname"),
    @NamedQuery(name = "Author.findByAuthorAffiliation", query = "SELECT a FROM Author a WHERE a.authorAffiliation = :authorAffiliation"),
    @NamedQuery(name = "Author.findByAuthorCountry", query = "SELECT a FROM Author a WHERE a.authorCountry = :authorCountry"),
    @NamedQuery(name = "Author.findByAuthorEmail", query = "SELECT a FROM Author a WHERE a.authorEmail = :authorEmail"),
    @NamedQuery(name = "Author.findByAuthorNumber", query = "SELECT a FROM Author a WHERE a.authorNumber = :authorNumber")})
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHOR_ID")
    private BigDecimal authorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AUTHOR_FNAME")
    private String authorFname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AUTHOR_LNAME")
    private String authorLname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AUTHOR_AFFILIATION")
    private String authorAffiliation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "AUTHOR_COUNTRY")
    private String authorCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "AUTHOR_EMAIL")
    private String authorEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AUTHOR_NUMBER")
    private BigInteger authorNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private Collection<Submission> submissionCollection;

    public Author() {
    }

    public Author(BigDecimal authorId) {
        this.authorId = authorId;
    }

    public Author(BigDecimal authorId, String authorFname, String authorLname, String authorAffiliation, String authorCountry, String authorEmail, BigInteger authorNumber) {
        this.authorId = authorId;
        this.authorFname = authorFname;
        this.authorLname = authorLname;
        this.authorAffiliation = authorAffiliation;
        this.authorCountry = authorCountry;
        this.authorEmail = authorEmail;
        this.authorNumber = authorNumber;
    }

    public BigDecimal getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BigDecimal authorId) {
        this.authorId = authorId;
    }

    public String getAuthorFname() {
        return authorFname;
    }

    public void setAuthorFname(String authorFname) {
        this.authorFname = authorFname;
    }

    public String getAuthorLname() {
        return authorLname;
    }

    public void setAuthorLname(String authorLname) {
        this.authorLname = authorLname;
    }

    public String getAuthorAffiliation() {
        return authorAffiliation;
    }

    public void setAuthorAffiliation(String authorAffiliation) {
        this.authorAffiliation = authorAffiliation;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String authorCountry) {
        this.authorCountry = authorCountry;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public BigInteger getAuthorNumber() {
        return authorNumber;
    }

    public void setAuthorNumber(BigInteger authorNumber) {
        this.authorNumber = authorNumber;
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
        hash += (authorId != null ? authorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.authorId == null && other.authorId != null) || (this.authorId != null && !this.authorId.equals(other.authorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ConferenceREST.Author[ authorId=" + authorId + " ]";
    }
    
}
