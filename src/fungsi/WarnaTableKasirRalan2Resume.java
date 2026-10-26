/*
  Dilarang keras memperjualbelikan/mengambil keuntungan dari Software 
  ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media).
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Renderer untuk tabel Kasir Ralan tab Rujukan Internal.
 * Mewarnai baris biru jika pasien sudah memiliki resume medis
 * pada tabel resume_pasien (kolom 16 = ada_resume).
 *
 * @author simrskhanza
 */
public class WarnaTableKasirRalan2Resume extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            // Warna default alternating
            if (row % 2 == 1) {
                component.setBackground(new Color(255, 244, 244));
                component.setForeground(new Color(50, 50, 50));
            } else {
                component.setBackground(new Color(255, 255, 255));
                component.setForeground(new Color(50, 50, 50));
            }

            // Warna biru jika pasien sudah memiliki resume medis (kolom 16 = ada_resume)
            try {
                Object resumeVal = table.getModel().getValueAt(row, 16);
                if (resumeVal != null && "1".equals(resumeVal.toString())) {
                    if (row % 2 == 1) {
                        component.setBackground(new Color(173, 216, 230));
                    } else {
                        component.setBackground(new Color(135, 206, 250));
                    }
                    component.setForeground(new Color(0, 50, 100));
                }
            } catch (Exception ignored) {}
        }

        return component;
    }
}
