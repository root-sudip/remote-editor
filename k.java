import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.JPanel.*;
import javax.swing.JScrollPane;

public class k{
  public static void main(String[] args) {
    Runnable runner =new Runnable()
    {
      public void run(){

JFrame frame = new JFrame ("Test");
frame.setSize(500,500);
frame.setResizable(false);
//

//TEXT AREA
JTextArea textArea = new JTextArea();
textArea.setSize(400,400);   
JTextArea lines = new JTextArea(" 1"); 
Font sfont = new Font("Verdana",Font.PLAIN,16);
JMenuBar menubar = new JMenuBar();
JMenu file = new JMenu("File");
JMenuItem open = new JMenuItem("OPen");
JMenuItem save = new JMenuItem("Save");
JMenuItem exit = new JMenuItem("Exit");

DocumentListener gdocment = new DocumentListener(){

    public void changedUpdate(DocumentEvent de){
        System.out.println("\033[31;1m Chnaged\033[0m");
    }

    public void insertUpdate(DocumentEvent de){
        System.out.println("\033[31;1m inserted\033[0m");
    }

    public void removeUpdate(DocumentEvent de){
        System.out.println("\033[31;1m Removed\033[0m");
    }

};


KeyListener klistener = new KeyListener(){
    public void keyPressed(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){
        System.out.println("\033[32;1m"+ke.getKeyChar()+"\033[0m");
    }
    public void keyReleased(KeyEvent ke){}


};
    
    textArea.getDocument().addDocumentListener(gdocment);
    textArea.addKeyListener(klistener);
    textArea.setLineWrap(false);
    textArea.setEditable(true);
    textArea.setVisible(true);
    lines.setEditable(false);
    textArea.setFont(sfont);
    lines.setFont(sfont);

    JScrollPane scroll = new JScrollPane (textArea);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    scroll.setRowHeaderView(lines);
    lines.setBackground(Color.LIGHT_GRAY);
    frame.add(scroll);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


}


};
runner.run();
}
}