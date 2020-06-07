package controller;

import dao.MusterilerDAO;
import entity.Musteriler;
import entity.UrunVeHizmetler;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@ManagedBean(name = "musteriBean")
@ViewScoped
public class MusterilerController implements Serializable {

    private static final long serialVersionUID = 0L;

    private List<Musteriler> musterilerList;
    private Musteriler musteriler;
    private MusterilerDAO musterilerdao;

    private List<UrunVeHizmetler> listUrunHizmet;

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

    public void updateForm(Musteriler musteriler) {
        this.musteriler = musteriler;

    }

    public void clearForm() {
        this.musteriler = new Musteriler();
    }

    public void create() {
        this.getMusterilerdao().insert(this.musteriler);
        this.clearForm();
    }

    public void delete() {
        this.getMusterilerdao().delete(this.musteriler);
        this.clearForm();
    }

    public void update() {
        this.getMusterilerdao().update(this.musteriler);
        this.clearForm();
    }

    public List<Musteriler> getMusterilerList() {
        this.musterilerList = this.getMusterilerdao().findAll();
        return musterilerList;
    }

    public void setMusterilerList(List<Musteriler> musterilerList) {
        this.musterilerList = musterilerList;
    }

    public Musteriler getMusteriler() {
        if (this.musteriler == null) {
            this.musteriler = new Musteriler();
        }
        return musteriler;
    }

    public void setMusteriler(Musteriler musteriler) {
        this.musteriler = musteriler;
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

    public List<UrunVeHizmetler> getListUrunHizmet() {
        return listUrunHizmet;
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
