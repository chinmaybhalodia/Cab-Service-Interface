import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Driver extends Map {
    public static void main(String[] args) {
        Map.graph.AssignGraph();

        JFrame frame = new JFrame("Cab Service Interface");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.setResizable(false);

        JPanel panel = new JPanel();

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Enter Source Name :");
        panel1.add(label1);

        JPanel panel2 = new JPanel();
        JTextField source = new JTextField(20);
        JButton searchsource = new JButton("Search");
        panel2.add(source);
        panel2.add(searchsource);

        JPanel panel3 = new JPanel();
        JLabel sourcesuggestion = new JLabel("");
        panel3.add(sourcesuggestion);

        searchsource.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sourcesuggestion
                        .setText("Did you mean : " + vertices[closestString.getclosestString(source.getText())]);
            }
        });

        JPanel panel4 = new JPanel();
        JButton yes1 = new JButton("Yes");
        JButton no1 = new JButton("No");
        panel4.add(yes1);
        panel4.add(no1);

        yes1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                source.setText(vertices[closestString.getclosestString(source.getText())]);
            }
        });

        no1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "We cannot find a location for the Input. Please try again by entering correct location",
                        "Cannot find source", JOptionPane.ERROR_MESSAGE);
                source.setText(null);
                sourcesuggestion.setText(null);
            }
        });

        JPanel panel5 = new JPanel();
        JLabel label2 = new JLabel("Enter Destination Name :");
        panel5.add(label2);

        JPanel panel6 = new JPanel();
        JTextField destination = new JTextField(20);
        JButton searchdestination = new JButton("Search");
        panel6.add(destination);
        panel6.add(searchdestination);

        JPanel panel7 = new JPanel();
        JLabel destinationsuggestion = new JLabel("");
        panel7.add(destinationsuggestion);

        searchdestination.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destinationsuggestion
                        .setText("Did you mean : " + vertices[closestString.getclosestString(destination.getText())]);
            }
        });

        JPanel panel8 = new JPanel();
        JButton yes2 = new JButton("Yes");
        JButton no2 = new JButton("No");
        panel8.add(yes2);
        panel8.add(no2);

        yes2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destination.setText(vertices[closestString.getclosestString(destination.getText())]);
            }
        });

        no2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "We cannot find a location for the Input. Please try again by entering correct location",
                        "Cannot find destination", JOptionPane.ERROR_MESSAGE);
                destination.setText(null);
                destinationsuggestion.setText(null);
            }
        });

        JPanel panel9 = new JPanel();
        JLabel options = new JLabel("Please select Cab type");
        panel9.add(options);

        JPanel panel10 = new JPanel();
        String[] optionarr = { "Auto", "Mini", "Macro", "Prime SUV" };
        JComboBox<String> optionbox = new JComboBox<String>(optionarr);
        panel10.add(optionbox);

        JPanel panel11 = new JPanel();
        JButton searchbydistance = new JButton("Search Minimum Path Route");
        panel11.add(searchbydistance);

        searchbydistance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Source : " + source.getText() + "\nDestination : "
                        + destination.getText() + "\nRide Fare : "
                        + minPath.findCost(minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 0)[0], optionbox.getSelectedIndex())
                        + " Rupees\nRide Distance : "
                        + minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 0)[0]
                        + " km\nEstimated Time : "
                        + minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 0)[1]+" Minutes",
                        "Fare Estimate", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel12 = new JPanel();
        JButton searchbytime = new JButton("Search Least Time Route");
        panel12.add(searchbytime);

        searchbytime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Source : " + source.getText() + "\nDestination : "
                        + destination.getText() + "\nRide Fare : "
                        + minPath.findCost((minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 1)[0]), optionbox.getSelectedIndex())
                        + " Rupees\nRide Distance : "
                        + minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 1)[0]
                        + " km\nEstimated Time : "
                        + minPath.dijkstra(Map.graph, closestString.getclosestString(source.getText()),
                                closestString.getclosestString(destination.getText()), Map.V, 1)[1]+" Minutes",
                        "Fare Estimate", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JPanel panel13 = new JPanel();
        JButton reset = new JButton("Reset");
        panel13.add(reset);

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                source.setText(null);
                destination.setText(null);
                sourcesuggestion.setText(null);
                destinationsuggestion.setText(null);
            }
        });

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);
        panel.add(panel6);
        panel.add(panel7);
        panel.add(panel8);
        panel.add(panel9);
        panel.add(panel10);
        panel.add(panel11);
        panel.add(panel12);
        panel.add(panel13);

        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setAlignmentX(Component.BOTTOM_ALIGNMENT);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}