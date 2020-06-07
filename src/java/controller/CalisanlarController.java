package controller;

import dao.CalisanlarDAO;
import entity.Calisanlar;
import entity.UrunVeHizmetler;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "calisanlarBean")
@ViewScoped
public class CalisanlarController implements Serializable {

    private static final long serialVersionUID = 1L;

    public CalisanlarController() {
    }

    private List<Calisanlar> calisanlarList;
    private Calisanlar calisanlar;
    private CalisanlarDAO calisanlardao;

    private List<UrunVeHizmetler> listUrunHizmet;

    private String bul = "55555";
    private int page = 1;
    private int pageSize = 6;
    private int pageCount;

    public void ileri() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
        this.clearForm();
    }

    public void geri() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
        this.clearForm();
    }

    public void updateForm(Calisanlar calisanlar) {
        this.calisanlar = calisanlar;
    }

    public void clearForm() {
        this.calisanlar = new Calisanlar();
    }

    public void create() {
        this.getCalisanlardao().insert(this.calisanlar);
        this.clearForm();
    }

    public void delete() {
        this.getCalisanlardao().delete(this.calisanlar);
        this.clearForm();
    }

    public void update() {
        this.getCalisanlardao().update(this.calisanlar);
        this.clearForm();
    }

    public List<Calisanlar> getCalisanlarList() {
        this.calisanlarList = this.getCalisanlardao().findAll();
        return calisanlarList;
    }

    public void setCalisanlarList(List<Calisanlar> calisanlarList) {
        this.calisanlarList = calisanlarList;
    }

    public Calisanlar getCalisanlar() {
        if (this.calisanlar == null) {
            this.calisanlar = new Calisanlar();
        }
        return calisanlar;
    }

    public void setCalisanlar(Calisanlar calisanlar) {
        this.calisanlar = calisanlar;
    }

    public CalisanlarDAO getCalisanlardao() {
        if (this.calisanlardao == null) {
            this.calisanlardao = new CalisanlarDAO();
        }
        return calisanlardao;
    }

    public void setCalisanlardao(CalisanlarDAO calisanlardao) {
        this.calisanlardao = calisanlardao;
    }

    public List<UrunVeHizmetler> getListUrunHizmet() {
        return listUrunHizmet;//***
    }

    public void setListUrunHizmet(List<UrunVeHizmetler> listUrunHizmet) {
        this.listUrunHizmet = listUrunHizmet;
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
        this.pageCount = pageCount;
    }

}
