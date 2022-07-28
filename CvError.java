/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author trida
 */
public class CvError {
    String jobError;
    String introError;
    String profesError;
    String prointroError;
    String frameError;
    String serviceError;
    String servicedesError;
    String AchiveError;

    public CvError() {
        this.jobError ="";
        this.introError ="";
        this.profesError ="";
        this.prointroError ="";
        this.frameError ="";
        this.serviceError ="";
        this.servicedesError ="";
        this.AchiveError ="";
    }

    public CvError(String jobError, String introError, String profesError, String prointroError, String frameError, String serviceError, String servicedesError, String AchiveError) {
        this.jobError = jobError;
        this.introError = introError;
        this.profesError = profesError;
        this.prointroError = prointroError;
        this.frameError = frameError;
        this.serviceError = serviceError;
        this.servicedesError = servicedesError;
        this.AchiveError = AchiveError;
    }

    public String getJobError() {
        return jobError;
    }

    public void setJobError(String jobError) {
        this.jobError = jobError;
    }

    public String getIntroError() {
        return introError;
    }

    public void setIntroError(String introError) {
        this.introError = introError;
    }

    public String getProfesError() {
        return profesError;
    }

    public void setProfesError(String profesError) {
        this.profesError = profesError;
    }

    public String getProintroError() {
        return prointroError;
    }

    public void setProintroError(String prointroError) {
        this.prointroError = prointroError;
    }

    public String getFrameError() {
        return frameError;
    }

    public void setFrameError(String frameError) {
        this.frameError = frameError;
    }

    public String getServiceError() {
        return serviceError;
    }

    public void setServiceError(String serviceError) {
        this.serviceError = serviceError;
    }

    public String getServicedesError() {
        return servicedesError;
    }

    public void setServicedesError(String servicedesError) {
        this.servicedesError = servicedesError;
    }

    public String getAchiveError() {
        return AchiveError;
    }

    public void setAchiveError(String AchiveError) {
        this.AchiveError = AchiveError;
    }
    
    
}
