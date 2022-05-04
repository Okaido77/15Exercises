package model;

import java.util.Date;

public class Certificate {
    private String CertificatedID;
    private String CertificateName;
    private String CertificateRank;
    private Date CertificatedDate;

    public Certificate(String certificatedID, String certificateName, String certificateRank, Date certificatedDate) {
        CertificatedID = certificatedID;
        CertificateName = certificateName;
        CertificateRank = certificateRank;
        CertificatedDate = certificatedDate;
    }

    public String getCertificatedID() {
        return CertificatedID;
    }

    public void setCertificatedID(String certificatedID) {
        CertificatedID = certificatedID;
    }

    public String getCertificateName() {
        return CertificateName;
    }

    public void setCertificateName(String certificateName) {
        CertificateName = certificateName;
    }

    public String getCertificateRank() {
        return CertificateRank;
    }

    public void setCertificateRank(String certificateRank) {
        CertificateRank = certificateRank;
    }

    public Date getCertificatedDate() {
        return CertificatedDate;
    }

    public void setCertificatedDate(Date certificatedDate) {
        CertificatedDate = certificatedDate;
    }
}
