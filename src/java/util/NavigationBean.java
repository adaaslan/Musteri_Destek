package util;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

public class NavigationBean implements Serializable {

    public String page(String p) {
        return "/back_end/" + p + "/" + p + "?faces-redirct=true";
    }

    public static void redirectToWelcome() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        String originalURL = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
        originalURL = externalContext.getRequestContextPath() + "/view/talepler.xhtml";
        try {
            externalContext.redirect(originalURL);
        } catch (IOException ex) {
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void toLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        String originalURL = (String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
        originalURL = externalContext.getRequestContextPath() + "/login.xhtml";
        try {
            externalContext.redirect(originalURL);
        } catch (IOException ex) {
            Logger.getLogger(NavigationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
//        return originalURL;
    }

}
