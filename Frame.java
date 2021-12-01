import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Frame extends JFrame implements ActionListener {
    private Random r = new Random();
    private JPanel contentPanel;
    int a = r.nextInt(150);
    int b = r.nextInt(150);
    JButton start = new JButton("Start");
    JButton cancel = new JButton("Cancel");
    public void run() {

        contentPanel = new JPanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Przycisk");
        this.setSize(250, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        contentPanel.add(create());
        this.add(contentPanel);

        contentPanel.setLayout(null);
        start.setBounds(20, 110, 80, 20);
        start.addActionListener(this);
        cancel.setBounds(120, 110, 80, 22);
        cancel.addActionListener(this);
        contentPanel.add(start);
        contentPanel.add(cancel);


        this.setVisible(true);

    } private JButton create(){start.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            Point p = MouseInfo.getPointerInfo().getLocation();
            int x = p.x;
            int y = p.y;
            int x1 = start.getBounds().x;
            int y1 = start.getBounds().y;

            boolean widthX = x >= x1 && x <= x1+start.getBounds().width;
            boolean widthY = y >= y1 && y <= y1+start.getBounds().height;
            super.mouseEntered(e);
            if(widthY && widthX){
                start.setBackground(Color.YELLOW);
                start.setLocation(a,b);

            }}});
        return start;}





    @Override
    public void actionPerformed(ActionEvent e) {
    String clickedButton = e.getActionCommand();
        System.out.println("Button " + clickedButton + " clicked");
        if(e.getSource() == cancel){
            start.setBackground(null);
            start.setBounds(20, 110, 80, 20);
        }
    }
}
