package entity;

import java.io.InputStream;
import java.util.Objects;
import org.primefaces.model.DefaultStreamedContent;

public class Dosya {

    private int dosya_id;
    private String dosya_yolu;
    private String dosya_ismi;
    private String dosya_tipi;
    private int dosya_size;
    private byte[]  dosya_value;
    private DefaultStreamedContent streamedContent;
    private String base64;

    public Dosya() {
    }

    public Dosya(int dosya_id, String dosya_yolu, String dosya_ismi, String dosya_tipi) {
        this.dosya_id = dosya_id;
        this.dosya_yolu = dosya_yolu;
        this.dosya_ismi = dosya_ismi;
        this.dosya_tipi = dosya_tipi;
    }

    public int getDosya_id() {
        return dosya_id;
    }

    public void setDosya_id(int dosya_id) {
        this.dosya_id = dosya_id;
    }

    public String getDosya_yolu() {
        return dosya_yolu;
    }

    public void setDosya_yolu(String dosya_yolu) {
        this.dosya_yolu = dosya_yolu;
    }

    public String getDosya_ismi() {
        return dosya_ismi;
    }

    public void setDosya_ismi(String dosya_ismi) {
        this.dosya_ismi = dosya_ismi;
    }

    public String getDosya_tipi() {
        return dosya_tipi;
    }

    public void setDosya_tipi(String dosya_tipi) {
        this.dosya_tipi = dosya_tipi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.dosya_id;
        hash = 47 * hash + Objects.hashCode(this.dosya_yolu);
        hash = 47 * hash + Objects.hashCode(this.dosya_ismi);
        hash = 47 * hash + Objects.hashCode(this.dosya_tipi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dosya other = (Dosya) obj;
        if (this.dosya_id != other.dosya_id) {
            return false;
        }
        if (!Objects.equals(this.dosya_yolu, other.dosya_yolu)) {
            return false;
        }
        if (!Objects.equals(this.dosya_ismi, other.dosya_ismi)) {
            return false;
        }
        if (!Objects.equals(this.dosya_tipi, other.dosya_tipi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dosya{" + "dosya_id=" + dosya_id + ", dosya_yolu=" + dosya_yolu + ", dosya_ismi=" + dosya_ismi + ", dosya_tipi=" + dosya_tipi + '}';
    }

    public DefaultStreamedContent getStreamedContent() {
        return streamedContent;
    }

    public void setStreamedContent(DefaultStreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public byte[]  getDosya_value() {
        return dosya_value;
    }

    public void setDosya_value(byte[]  dosya_value) {
        this.dosya_value = dosya_value;
    }

    public int getDosya_size() {
        return dosya_size;
    }

    public void setDosya_size(int dosya_size) {
        this.dosya_size = dosya_size;
    }

}
