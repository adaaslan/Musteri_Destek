package converter;

import dao.UrunVeHizmetlerDAO;
import entity.UrunVeHizmetler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "hizmetConverter")
public class UrunVeHizmetlerConverter implements Converter {

    private UrunVeHizmetlerDAO urunHizmetdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        return this.getUrunHizmetDAO().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object u) {
        UrunVeHizmetler hizmet = (UrunVeHizmetler) u;
        return String.valueOf(hizmet.getHizmet_id());
    }

    public UrunVeHizmetlerDAO getUrunHizmetDAO() {
        if (this.urunHizmetdao == null) {
            this.urunHizmetdao = new UrunVeHizmetlerDAO();
        }
        return urunHizmetdao;
    }

    public void setUrunHizmetDAO(UrunVeHizmetlerDAO urunHizmetdao) {
        this.urunHizmetdao = urunHizmetdao;
    }

}
