package converter;

import controller.TalepDetayController;
import dao.DosyaDAO;
import entity.Dosya;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dosyaConverter")
public class DosyaConverter implements Converter {

    private DosyaDAO dosyadao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return this.getDosyadao().find(Integer.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object arg2) {
        Dosya y = (Dosya) arg2;
        return String.valueOf(y.getDosya_id());
    }

    public DosyaDAO getDosyadao() {
        if (this.dosyadao == null) {
            this.dosyadao = new DosyaDAO();
        }
        return dosyadao;
    }

    public void setDosyadao(DosyaDAO dosyadao) {
        this.dosyadao = dosyadao;
    }

}
