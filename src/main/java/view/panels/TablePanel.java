package view.panels;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import view.styles.Style;
import view.styles.Table;

public class TablePanel extends JPanel {
    private Table table;
    private JButton btnPrev;
    private JButton btnNext;
    private JLabel lblPage;

    public TablePanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 30));
        setBackground(Color.WHITE);
        table = new Table();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        add(scrollPane, BorderLayout.CENTER);


        JPanel paginationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        paginationPanel.setBackground(Color.WHITE);
        btnPrev = createStyledButton("Anterior");
        btnNext = createStyledButton("Siguiente");
        lblPage = new JLabel("Pagina 1");
        paginationPanel.add(btnPrev);
        paginationPanel.add(lblPage);
        paginationPanel.add(btnNext);
        add(paginationPanel, BorderLayout.SOUTH);

        btnPrev.addActionListener(e -> {
            table.previousPage();
            updatePageLabel();
        });

        btnNext.addActionListener(e -> {
            table.nextPage();
            updatePageLabel();
        });

        setPreferredSize(new Dimension(800, 400));
    }

    public void setFullModel(TableModel model) {
        table.setFullModel(model);
        updatePageLabel();
    }

    private void updatePageLabel() {
        lblPage.setText("Pagina " + table.getCurrentPage());
    }

    public Object getSelectedId() {
        return table.getSelectedId();
    }

    public Table getTable() {
        return table;
    }


    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(110, 32));
        button.setFocusPainted(false);
        button.setBackground(Style.INPUT_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SansSerif", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder());
        return button;
    }


    private static class CustomScrollBarUI extends BasicScrollBarUI {
        private final int thickness = 1;

        @Override
        protected void configureScrollBarColors() {
            thumbColor = Style.INPUT_COLOR;
            trackColor = new Color(220, 220, 220);
        }

        @Override
        protected Dimension getMinimumThumbSize() {
            return new Dimension(thickness, thickness);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(thumbColor);
            g2.fillRoundRect(thumbBounds.x, thumbBounds.y,
                    thumbBounds.width, thumbBounds.height, 8, 8);
            g2.dispose();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(trackColor);
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            g2.dispose();
        }
    }
}
