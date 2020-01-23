package com.gamecodeschool.nineone1;

public class patient_credentials {
    String dId,dEmail,dPhn,dName,duid;

    public patient_credentials(String dId, String dEmail, String dPhn, String dName, String duid) {
        this.dId = dId;
        this.dEmail = dEmail;
        this.dPhn = dPhn;
        this.dName = dName;
        this.duid = duid;
    }

    public String getdId() {
        return dId;
    }

    public String getdEmail() {
        return dEmail;
    }

    public String getdPhn() {
        return dPhn;
    }

    public String getdName() {
        return dName;
    }

    public String getDuid() {
        return duid;
    }
}
