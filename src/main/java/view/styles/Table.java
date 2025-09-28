/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.styles;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author Cortez, Manuel;
 */

public class Table extends JTable {
    private int currentPage = 1;
    private int rowsPerPage = 10;
    private TableModel fullModel;

    public Table() {
        setFillsViewportHeight(true);
        setRowHeight(36);
        setShowGrid(false);
        setSelectionBackground(new Color(36, 110, 185));
        setSelectionForeground(Color.WHITE);
        setFont(Style.INPUT_FONT);
        setIntercellSpacing(new Dimension(0, 0));

        JTableHeader header = getTableHeader();
        header.setBackground(new Color(8, 58, 96));
        header.setForeground(Color.WHITE);
        header.setFont(Style.TITLE_FONT);
        header.setReorderingAllowed(false);

        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            Color evenColor = new Color(225, 225, 225);
            Color oddColor = Color.WHITE;

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setHorizontalAlignment(SwingConstants.CENTER);
                c.setOpaque(true);

                if (isSelected) {
                    c.setBackground(new Color(36, 110, 185));
                    c.setForeground(Color.WHITE);
                } else {
                    c.setBackground(row % 2 == 0 ? evenColor : oddColor);
                    c.setForeground(Color.BLACK);
                }
                return c;
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                super.paintComponent(g2);
            }
        });
        setRowMargin(10);
    }

    public void setFullModel(TableModel model) {
        this.fullModel = model;
        updatePage(1);
    }

    public void updatePage(int page) {
        if (fullModel == null) return;

        this.currentPage = page;
        int start = (page - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, fullModel.getRowCount());
        DefaultTableModel pageModel = new DefaultTableModel();
        for (int i = 0; i < fullModel.getColumnCount(); i++) {
            pageModel.addColumn(fullModel.getColumnName(i));
        }
        for (int i = start; i < end; i++) {
            Object[] row = new Object[fullModel.getColumnCount()];
            for (int j = 0; j < fullModel.getColumnCount(); j++) {
                row[j] = fullModel.getValueAt(i, j);
            }
            pageModel.addRow(row);
        }
        setModel(pageModel);
    }

    public Object getSelectedId() {
        int row = getSelectedRow();
        if (row >= 0) return getValueAt(row, 0);
        return null;
    }

    public void nextPage() {
        int maxPage = (int) Math.ceil(fullModel.getRowCount() / (double) rowsPerPage);
        if (currentPage < maxPage) updatePage(currentPage + 1);
    }

    public void previousPage() {
        if (currentPage > 1) updatePage(currentPage - 1);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
        updatePage(1);
    }
}

