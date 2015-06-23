import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.JPanel.*;
import javax.swing.JScrollPane;
import java.util.*;
import java.io.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.BadLocationException;


public class k{
  public static void main(String[] args) {
    Runnable runner =new Runnable()
    {
      public void run(){

JFrame frame = new JFrame ("Test");
frame.setSize(500,500);
frame.setResizable(false);




final JTextArea textArea = new JTextArea();
textArea.setSize(400,400);   
final JTextArea lines = new JTextArea(" 1"); 
JScrollPane scroll = new JScrollPane (textArea);
final Font sfont = new Font("Verdana",Font.PLAIN,16);
final Font ssfont = new Font("Verdana",Font.PLAIN,20);
JMenuBar menubar = new JMenuBar();
JMenu file = new JMenu("File");
JMenuItem open = new JMenuItem("Open");
JMenuItem save = new JMenuItem("Save");
JMenuItem exit = new JMenuItem("Exit");


File file = new File("read");
FileReader fileReader = new FileReader(file);
BufferedReader bufferedReader = new BufferedReader(fileReader);


CaretListener ctlistener = new CaretListener(){
    public void caretUpdate(CaretEvent cl){
        Highlighter highlight = textArea.getHighlighter();
        highlight.removeAllHighlights();
        String patern = "Hello";
        String text = textArea.getText();
        int index = text.indexOf(patern);
        while(index>=0)
        {
            try{
                    highlight.addHighlight(index,index+patern.length(),new DefaultHighlighter.DefaultHighlightPainter(Color.red));
                    index = text.indexOf(patern,index+patern.length());
        }
        catch(BadLocationException ex){}
        }
    }
};




DocumentListener gdocment = new DocumentListener(){

    public void changedUpdate(DocumentEvent de){
        System.out.println("\033[31;1m Chnaged\033[0m");
    }

    public void insertUpdate(DocumentEvent de){
///start***
        
        int countLine = textArea.getLineCount();
        System.out.println("\033[31;1m inserted and lines="+countLine+"\033[0m");
        System.out.println(de.getOffset());
        String text="1"+System.getProperty("line.separator");
        int i;
        for (i=2;i<=countLine;i++){
        text +=i+System.getProperty("line.separator");
        lines.setText(text);
    }
///end
    }

    public void removeUpdate(DocumentEvent de){
///start
        int countLine = textArea.getLineCount();
        System.out.println("\033[31;1m inserted and lines="+countLine+"\033[0m");
        String text=" 1"+System.getProperty("line.separator");
        int i;
        for (i=2;i<=countLine-1;i++){
        text +=" "+i+System.getProperty("line.separator");
        lines.setText(text);
    }
///en 
    }

};


KeyListener klistener = new KeyListener(){
    public void keyPressed(KeyEvent ke){}
    public void keyTyped(KeyEvent ke){
        
        
        if(ke.getKeyChar()==' '){
        System.out.println("\033[33;1mit was space\033[0m");
    }
    else if(ke.getKeyChar()==KeyEvent.VK_ENTER){
        System.out.println("\033[36;0m Pressed Enter \033[0m");
    }
    else{
         System.out.println("\033[32;1m"+ke.getKeyChar()+"\033[0m");
    }
    }
    public void keyReleased(KeyEvent ke){}


};
    textArea.addCaretListener(ctlistener );
    textArea.getDocument().addDocumentListener(gdocment);
    textArea.addKeyListener(klistener);
    textArea.setLineWrap(false);
    textArea.setEditable(true);
    textArea.setVisible(true);
    lines.setEditable(false);
    textArea.setFont(sfont);
    lines.setFont(sfont);

    frame.setJMenuBar(menubar);
    menubar.add(file);
    file.add(open);
    file.add(save);
    file.add(exit);


    
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