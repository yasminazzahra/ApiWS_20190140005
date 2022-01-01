/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.assesmentdua.pws.A.assesmentdua.pws;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ACHI
 */
@Entity
@Table(name = "sepatu")
@NamedQueries({
    @NamedQuery(name = "Sepatu.findAll", query = "SELECT s FROM Sepatu s"),
    @NamedQuery(name = "Sepatu.findByIdsepatu", query = "SELECT s FROM Sepatu s WHERE s.idsepatu = :idsepatu"),
    @NamedQuery(name = "Sepatu.findByNamaSepatu", query = "SELECT s FROM Sepatu s WHERE s.namaSepatu = :namaSepatu"),
    @NamedQuery(name = "Sepatu.findByJenisSepatu", query = "SELECT s FROM Sepatu s WHERE s.jenisSepatu = :jenisSepatu"),
    @NamedQuery(name = "Sepatu.findByMerkSepatu", query = "SELECT s FROM Sepatu s WHERE s.merkSepatu = :merkSepatu"),
    @NamedQuery(name = "Sepatu.findByHargaSepatu", query = "SELECT s FROM Sepatu s WHERE s.hargaSepatu = :hargaSepatu"),
    @NamedQuery(name = "Sepatu.findByUkuranSepatu", query = "SELECT s FROM Sepatu s WHERE s.ukuranSepatu = :ukuranSepatu")})
public class Sepatu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idsepatu")
    private Integer idsepatu;
    @Column(name = "nama_sepatu")
    private String namaSepatu;
    @Column(name = "jenis_sepatu")
    private String jenisSepatu;
    @Column(name = "merk_sepatu")
    private String merkSepatu;
    @Column(name = "harga_sepatu")
    private String hargaSepatu;
    @Column(name = "ukuran_sepatu")
    private Integer ukuranSepatu;

    public Sepatu() {
    }

    public Sepatu(Integer idsepatu) {
        this.idsepatu = idsepatu;
    }

    public Integer getIdsepatu() {
        return idsepatu;
    }

    public void setIdsepatu(Integer idsepatu) {
        this.idsepatu = idsepatu;
    }

    public String getNamaSepatu() {
        return namaSepatu;
    }

    public void setNamaSepatu(String namaSepatu) {
        this.namaSepatu = namaSepatu;
    }

    public String getJenisSepatu() {
        return jenisSepatu;
    }

    public void setJenisSepatu(String jenisSepatu) {
        this.jenisSepatu = jenisSepatu;
    }

    public String getMerkSepatu() {
        return merkSepatu;
    }

    public void setMerkSepatu(String merkSepatu) {
        this.merkSepatu = merkSepatu;
    }

    public String getHargaSepatu() {
        return hargaSepatu;
    }

    public void setHargaSepatu(String hargaSepatu) {
        this.hargaSepatu = hargaSepatu;
    }

    public Integer getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(Integer ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsepatu != null ? idsepatu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sepatu)) {
            return false;
        }
        Sepatu other = (Sepatu) object;
        if ((this.idsepatu == null && other.idsepatu != null) || (this.idsepatu != null && !this.idsepatu.equals(other.idsepatu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tugas.assesmentdua.pws.A.assesmentdua.pws.Sepatu[ idsepatu=" + idsepatu + " ]";
    }
    
}
