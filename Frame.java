import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Frame extends JFrame implements ActionListener {
    private Random r = new Random();
    private JPanel contentPanel;
    JButton start = new JButton("Start");
    JButton cancel = new JButton("Cancel");

    public void run() {

        contentPanel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPanel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.setTitle("Przycisk");
        this.setSize(250, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        contentPanel.add(create());
        this.add(contentPanel);

        contentPanel.setLayout(null);
        start.setBounds(20, 110, 80, 26);
        start.addActionListener(this);
        cancel.setBounds(120, 110, 80, 25);
        cancel.addActionListener(this);
        contentPanel.add(start);
        contentPanel.add(cancel);


        this.setVisible(true);

    }

    private JButton create() {
        start.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {

                super.mouseEntered(e);
                float x = r.nextFloat();
                float y = r.nextFloat();
                float z = r.nextFloat();

                start.setBackground(new Color(x, y, z));
                int a = r.nextInt(150);
                int b = r.nextInt(150);
                start.setLocation(a, b);

                int w = start.getWidth();
                if(e.getX() < w/4){
                    start.setBackground(null);
                    System.out.println("Safe zone. Nothing happened");
                }

            }
        });
        return start;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String clickedButton = e.getActionCommand();
        System.out.println("Button " + clickedButton + " clicked");
        if (e.getSource() == cancel) {
            start.setBackground(null);
            start.setBounds(20, 110, 80, 26);
        }

    }
}
