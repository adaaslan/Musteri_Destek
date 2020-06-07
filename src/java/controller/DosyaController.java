package controller;

import dao.DosyaDAO;
import entity.Dosya;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.servlet.http.Part;

@ManagedBean(name = "dosyaBean")
@ViewScoped
public class DosyaController implements Serializable {

    private static final long serialVersionUID = 0L;

    private Dosya dosya;
    private List<Dosya> dosyaList;
    private DosyaDAO dosyaDAO;

    private String bul = "";
    private int page = 1;
    private int pageSize = 6;
    private int pageCount;
    private Part doc;

    private final String uploadTo = "MusteriDestek\\upload\\";

    public String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename;
            }
        }
        return "";
    }

    public void ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + getFileName(doc));
            Files.copy(input, f.toPath());

            dosya = this.getDosya();
            dosya.setDosya_yolu(f.getParent());
            dosya.setDosya_ismi(f.getName());
            dosya.setDosya_tipi(doc.getContentType());

            this.getDosyaDAO().insert(dosya);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateForm(Dosya dosya) {
        this.dosya = dosya;
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Dosya getDosya() {
        if (this.dosya == null) {
            this.dosya = new Dosya();
        }
        return dosya;
    }

    public void setDosya(Dosya dosya) {
        this.dosya = dosya;
    }

    public List<Dosya> getDosyaList() {
        return dosyaList;//**
    }

    public void setDosyaList(List<Dosya> dosyaList) {
        this.dosyaList = dosyaList;
    }

    public DosyaDAO getDosyaDAO() {
        if (this.dosyaDAO == null) {
            this.dosyaDAO = new DosyaDAO();
        }
        return dosyaDAO;
    }

    public void setDosyaDAO(DosyaDAO dosyaDAO) {
        this.dosyaDAO = dosyaDAO;
    }

    public String getBul() {
        return bul;
    }

    public void setBul(String bul) {
        this.bul = bul;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;//**
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

}
