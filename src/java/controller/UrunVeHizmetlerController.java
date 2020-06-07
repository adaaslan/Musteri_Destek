package controller;

import dao.UrunVeHizmetlerDAO;
import entity.Calisanlar;
import entity.UrunVeHizmetler;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "hizmetBean")
@ViewScoped
public class UrunVeHizmetlerController implements Serializable {

    private static final long serialVersionUID = 0L;

    private List<UrunVeHizmetler> urunhizmetList;
    private UrunVeHizmetler urunhizmet;
    private UrunVeHizmetlerDAO urunhizmetdao;

    private List<Calisanlar> listCalisanlar;

    private String bul = "";
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

    public void create() {
        this.getUrunhizmetdao().insert(this.urunhizmet);
        this.clearForm();
    }

    public void delete() {
        this.getUrunhizmetdao().delete(this.urunhizmet);
        this.clearForm();
    }

    public void update() {
        this.getUrunhizmetdao().update(this.urunhizmet);
        this.clearForm();
    }

    public void updateForm(UrunVeHizmetler urunHizmet) {
        this.urunhizmet = urunHizmet;
    }

    public void clearForm() {
        this.urunhizmet = new UrunVeHizmetler();
    }

    public List<UrunVeHizmetler> getUrunhizmetList() {
        this.urunhizmetList = this.getUrunhizmetdao().findAll();
        return urunhizmetList;
    }

    public void setUrunhizmetList(List<UrunVeHizmetler> urunhizmetList) {
        this.urunhizmetList = urunhizmetList;
    }

    public UrunVeHizmetler getUrunhizmet() {
        if (this.urunhizmet == null) {
            this.urunhizmet = new UrunVeHizmetler();
        }
        return urunhizmet;
    }

    public void setUrunhizmet(UrunVeHizmetler urunhizmet) {
        this.urunhizmet = urunhizmet;
    }

    public UrunVeHizmetlerDAO getUrunhizmetdao() {
        if (this.urunhizmetdao == null) {
            this.urunhizmetdao = new UrunVeHizmetlerDAO();
        }
        return urunhizmetdao;
    }

    public void setUrunhizmetdao(UrunVeHizmetlerDAO urunhizmetdao) {
        this.urunhizmetdao = urunhizmetdao;
    }

    public List<Calisanlar> getListCalisanlar() {
        return listCalisanlar;
    }

    public void setListCalisanlar(List<Calisanlar> listCalisanlar) {
        this.listCalisanlar = listCalisanlar;
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
