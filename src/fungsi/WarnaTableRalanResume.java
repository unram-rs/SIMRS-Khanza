/*
  Dilarang keras memperjualbelikan/mengambil keuntungan dari Software 
  ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media).
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer tabel rawat jalan yang mewarnai baris biru jika pasien
 * sudah memiliki resume medis pada tabel resume_pasien.
 * Kolom no_rawat diasumsikan berada di index 1 (kolom ke-2).
 *
 * @author simrskhanza
 */
public class WarnaTableRalanResume extends DefaultTableCellRenderer {

    // Set berisi no_rawat yang sudah memiliki resume medis
    private Set<String> noRawatDenganResume;

    // Warna biru muda untuk baris yang memiliki resume
    private static final Color WARNA_RESUME_GANJIL  = new Color(173, 216, 230); // light blue
    private static final Color WARNA_RESUME_GENAP   = new Color(135, 206, 250); // sky blue
    // Warna default (alternating pink/white)
    private static final Color WARNA_DEFAULT_GANJIL = new Color(255, 244, 244);
    private static final Color WARNA_DEFAULT_GENAP  = new Color(255, 255, 255);

    public WarnaTableRalanResume() {
        this.noRawatDenganResume = new HashSet<>();
    }

    public WarnaTableRalanResume(Set<String> noRawatDenganResume) {
        this.noRawatDenganResume = noRawatDenganResume != null ? noRawatDenganResume : new HashSet<>();
    }

    /**
     * Update set no_rawat yang memiliki resume dan minta tabel untuk re-render.
     */
    public void setNoRawatDenganResume(Set<String> noRawatDenganResume) {
        this.noRawatDenganResume = noRawatDenganResume != null ? noRawatDenganResume : new HashSet<>();
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            // Ambil nilai no_rawat dari kolom index 1
            Object noRawatObj = table.getModel().getValueAt(row, 1);
            String noRawat = (noRawatObj != null) ? noRawatObj.toString() : "";

            if (noRawatDenganResume.contains(noRawat)) {
                // Baris dengan resume: warna biru muda
                if (row % 2 == 1) {
                    component.setBackground(WARNA_RESUME_GANJIL);
                } else {
                    component.setBackground(WARNA_RESUME_GENAP);
                }
            } else {
                // Baris tanpa resume: warna default alternating
                if (row % 2 == 1) {
                    component.setBackground(WARNA_DEFAULT_GANJIL);
                } else {
                    component.setBackground(WARNA_DEFAULT_GENAP);
                }
            }
        }

        return component;
    }
}
