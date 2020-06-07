package converter;

import dao.MusterilerDAO;
import entity.Musteriler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "musterilerConverter")
public class MusterilerConverter implements Converter {

    private MusterilerDAO musterilerdao;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String string) {
        return this.getMusterilerdao().find(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object u) {
        Musteriler musteri = (Musteriler) u;
        return String.valueOf(musteri.getMusteri_id());
    }

    public MusterilerDAO getMusterilerdao() {
        if (this.musterilerdao == null) {
            this.musterilerdao = new MusterilerDAO();
        }
        return musterilerdao;
    }

    public void setMusterilerdao(MusterilerDAO musterilerdao) {
        this.musterilerdao = musterilerdao;
    }

}
