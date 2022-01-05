/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas.assesmentdua.pws.A.assesmentdua.pws;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ACHI
 */
    @Entity
@Table(name="sepatu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sepatu {
    @Id
    private Long idsepatu;
    private String nama_sepatu;
    private String jenis_sepatu;
    private String merk_sepatu;
    private String harga_sepatu;
    private int ukuran_sepatu;
}
