package converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "validator")
@SessionScoped
public class Validator implements Serializable {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|co|mobi)(.[A-Z]{2})?$";

    private Collection<FacesMessage> msgList = new ArrayList<>();

    public boolean validateKonu(FacesContext fc, UIComponent uı, Object v) {

        boolean isValid = true;
        msgList.clear();

        String value = (String) v;
        if (value.equals("")) {
            msgList.add(new FacesMessage("Lütfen Konu Giriniz! "));
            isValid = false;
        } else if (value.length() < 3 || value.length() > 100) {
            msgList.add(new FacesMessage("Konu 3 karakterden az 100 den fazla Olamaz!"));
            isValid = false;
        }

        if (!isValid) {
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public boolean validateEmail(FacesContext fc, UIComponent uı, Object v) {

        msgList.clear();
        String value = (String) v;
        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        boolean isValid = pattern.matcher(value).find();

        if (!isValid) {
            msgList.add(new FacesMessage("Lütfen Geçerli E-mail Adresi Giriniz."));
            throw new ValidatorException(msgList);
        } else {
            return true;
        }

    }

    public Collection<FacesMessage> getMsgList() {
        return msgList;
    }

    public void setMsgList(Collection<FacesMessage> msgList) {
        this.msgList = msgList;
    }

}
