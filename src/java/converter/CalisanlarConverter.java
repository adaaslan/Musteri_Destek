package converter;

import controller.LoginBean;
import dao.CalisanlarDAO;
import entity.UrunVeHizmetler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "calisanlarConverter")
public class CalisanlarConverter implements Converter {

    private CalisanlarDAO calisandao;
//calisan id alıp onun hizmetini döndürür
    @Inject
    LoginBean bean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        return this.getCalisandao().find(Integer.valueOf(string)).getHizmet();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object u) {
        UrunVeHizmetler hizmet = (UrunVeHizmetler) u;
////        if (LoginBean.kullanici.getRol().equals("D")) {
//            return String.valueOf(LoginBean.kullanici.getCalisan().getHizmet().getHizmet_id());
////        }
        return String.valueOf(hizmet.getHizmet_id());
    }

    public CalisanlarDAO getCalisandao() {
        if (this.calisandao == null) {
            this.calisandao = new CalisanlarDAO();
        }
        return calisandao;
    }

    public void setCalisandao(CalisanlarDAO calisandao) {
        this.calisandao = calisandao;
    }

}
