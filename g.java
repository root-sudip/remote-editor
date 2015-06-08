import javax.swing.*;
import java.awt.*;

public class g
{
    public static void main(String[] args)
    {
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel panel = new JPanel(); 
        panel.setLayout(gridBag);

        JButton button = new JButton("(0,0)");
        constraints.gridx       = 0;
        constraints.gridy       = 0;
        constraints.gridwidth   = 2;  
        constraints.gridheight  = 1;
        constraints.weightx     = 1.0;
        constraints.weighty     = 1.0;
        constraints.anchor      = GridBagConstraints.CENTER;
        constraints.fill        = GridBagConstraints.BOTH;
        constraints.insets      = new Insets(0, 0, 0, 0);
        constraints.ipadx       = 10;  
        constraints.ipady       = 10;
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        // the remaining constraints use the constructor
        button = new JButton("(3,0)");
        constraints = new GridBagConstraints(3, 0, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.NORTHEAST,
                                            GridBagConstraints.NONE,
                                            new Insets(0, 0, 0, 0), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        button = new JButton("(0,1)");
        constraints = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.CENTER,
                                            GridBagConstraints.NONE,
                                            new Insets(0, 0, 0, 0), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        button = new JButton("(1,1)");
        constraints = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.CENTER,
                                            GridBagConstraints.NONE,
                                            new Insets(0, 0, 0, 0), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        button = new JButton("(2,1)");
        constraints = new GridBagConstraints(2, 1, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.CENTER,
                                            GridBagConstraints.BOTH,
                                            new Insets(0, 0, 0, 0), 30, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        button = new JButton("(0,2)");
        constraints = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.SOUTH,
                                            GridBagConstraints.NONE,
                                            new Insets(0, 0, 0, 0), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        button = new JButton("(0,3)");
        constraints = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0,
                                            GridBagConstraints.SOUTH,
                                            GridBagConstraints.NONE,
                                            new Insets(0, 0, 0, 0), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);
                                        
        button = new JButton("(1,2)");
        constraints = new GridBagConstraints(1, 2, 3, 2, 1.0, 1.0,
                                            GridBagConstraints.SOUTHEAST,
                                            GridBagConstraints.BOTH,
                                            new Insets(5, 7, 0, 8), 0, 0);
        gridBag.setConstraints(button, constraints);
        panel.add(button);

        JFrame frame = new JFrame();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
