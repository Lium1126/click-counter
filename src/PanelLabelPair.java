import javax.swing.*;

public class PanelLabelPair {
    private JPanel panel;
    private JLabel label;

    private PanelLabelPair() {}

    public PanelLabelPair(JPanel panel, JLabel label) {
        setPanel(panel);
        setLabel(label);
    }

    public JPanel getPanel() {
        return panel;
    }
    public JLabel getLabel() {
        return label;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    public void setLabel(JLabel label) {
        this.label = label;
    }
}
