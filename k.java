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
frame.setResizable(true);




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




CaretListener ctlistener = new CaretListener(){
    public void caretUpdate(CaretEvent cl){
        Highlighter highlight = textArea.getHighlighter();
        highlight.removeAllHighlights();
////////////function//////////
        String[] patern = new String[19];
        int i;
        patern[0]="main";
        patern[1]="printf";
        patern[2]="scanf";
        patern[3]="strcmp";
        patern[4]="strlen";
        patern[5]="strcpy";
        patern[6]="strncpy";
        patern[7]="strcat";
        patern[8]="strncmp";
        patern[9]="strcmpi";
        patern[10]="strncpi";
        patern[11]="int";
        patern[12]="double";
        patern[13]="float";
        patern[14]="unsigned";
        patern[15]="signed";
        patern[16]="char";
        patern[17]="strlwr";
        patern[18]="strupr";
        
        String text = textArea.getText();
        for (i=0;i<=18;i++){
        int index = text.indexOf(patern[i]);
        while(index>=0)
        {
            try{
                    highlight.addHighlight(index,index+patern[i].length(),new DefaultHighlighter.DefaultHighlightPainter(Color.green));
                    index = text.indexOf(patern[i],index+patern[i].length());
        }
        catch(BadLocationException ex){}
        }  
    }////method end

    String[] patern_1 = new String[4];
    patern_1[0]="for";
    patern_1[1]="while";
    patern_1[2]="do";
    patern_1[3]="return";
        int i_1;
       
        
        String text_1 = textArea.getText();
        for (i_1=0;i_1<=3;i_1++){
        int index_1 = text_1.indexOf(patern_1[i_1]);
        while(index_1>=0)
        {
            try{
                    highlight.addHighlight(index_1,index_1+patern_1[i_1].length(),new DefaultHighlighter.DefaultHighlightPainter(Color.red));
                    index_1 = text_1.indexOf(patern_1[i_1],index_1+patern_1[i_1].length());
        }
        catch(BadLocationException ex){}
        }    
    }////end loop

 String[] patern_2 = new String[10];
    patern_2[0]="0";
    patern_2[1]="1";
    patern_2[2]="2";
    patern_2[3]="3";
    patern_2[4]="4";
    patern_2[5]="5";
    patern_2[6]="6";
    patern_2[7]="7";
    patern_2[8]="8";
    patern_2[9]="9";

        int i_2;
       
        
        String text_2 = textArea.getText();
        for (i_2=0;i_2<=9;i_2++){
        int index_2 = text_2.indexOf(patern_2[i_2]);
        while(index_2>=0)
        {
            try{
                    highlight.addHighlight(index_2,index_2+patern_2[i_2].length(),new DefaultHighlighter.DefaultHighlightPainter(Color.magenta));
                    index_2 = text_2.indexOf(patern_2[i_2],index_2+patern_2[i_2].length());
        }
        catch(BadLocationException ex){}
        }    
    }////end int


String[] patern_3 = new String[2];
    patern_3[0]="true";
    patern_3[1]="false";
    

        int i_3;
       
        
        String text_3 = textArea.getText();
        for (i_3=0;i_3<=1;i_3++){
        int index_3 = text_2.indexOf(patern_3[i_3]);
        while(index_3>=0)
        {
            try{
                    highlight.addHighlight(index_3,index_3+patern_3[i_3].length(),new DefaultHighlighter.DefaultHighlightPainter(Color.blue));
                    index_3 = text_3.indexOf(patern_3[i_3],index_3+patern_3[i_3].length());
        }
        catch(BadLocationException ex){}
        }    
    }////end bool



////caretlistener
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