package controller;

import dao.KullaniciDAO;
import entity.Kullanici;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.servlet.http.HttpServletRequest;
import util.NavigationBean;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 7499456568301754701L;
    protected static final String BEAN_NAME = "loginBean";
    private String kullaniciAdi;
    private String password;
    private String originalURL;
    private String wsUrl;
    public static Kullanici kullanici;
    String token;
    private boolean loggedIn;
    private KullaniciDAO kullaniciDao;

    public void doLogin() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        request.getSession().setAttribute("loginBean", this);
        this.kullanici = getKullaniciDao().find(kullaniciAdi);

        if (kullanici != null && kullanici.getSifre().equals(password)) {
//            request.login(kullaniciAdi, password);
            externalContext.getSessionMap().put("user", this.kullanici);
            externalContext.getSessionMap().put("bildirimler", " ");
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            externalContext.getSessionMap().put("tarih", df.format(Calendar.getInstance().getTime()));
            loggedIn = true;
            NavigationBean.redirectToWelcome();
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Giriş başarısız!", "Muhtemel sebepler: 1. E-posta adresiniz kayıtlı değil. 2. Şifreniz hatalı. 3. Şifreniz kilitli.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void doLogout() {
        //Oturum kapandığını bildiriyoruz.
        loggedIn = false;

        // Çıkış mesajı veriyoruz.
        FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
        msg.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, msg);

        NavigationBean.toLogin();
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public static String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public KullaniciDAO getKullaniciDao() {
        if (this.kullaniciDao == null) {
            this.kullaniciDao = new KullaniciDAO();
        }
        return kullaniciDao;
    }

    public void setkullaniciDao(KullaniciDAO kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

}
