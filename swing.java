//remote-code-editor
//Developed by Cloudroom


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;
import javax.swing.event.*;
import javax.swing.text.*;

public class swing{
  public static void main(String[] args) {
    Runnable runner =new Runnable()
    {
      public void run(){
        final JFrame frame=new JFrame("Swing");
        final JFrame frame2=new JFrame("Swing2");
        /*JButton button=new JButton("CLick");*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menubar= new JMenuBar();
        JMenu menu=new JMenu("File");
        JMenuItem open=new JMenuItem("open");
        JMenuItem save=new JMenuItem("Save");
        JMenuItem exit=new JMenuItem("EXIT");
        JLabel label = new JLabel("Label");
        JButton frame2_button=new JButton("Back");


        Font font=new Font("Verdana",Font.PLAIN, 16);
       
        /*JPanel panel=new JPanel();*/
        JScrollPane jsp = new JScrollPane();

        
        
        final JTextArea textarea=new JTextArea(30,100);
        final JTextArea lines=new JTextArea("  1");
/////////////////////////
        

        

/////////////////////////       


        ActionListener anaction=new ActionListener(){

          public void actionPerformed(ActionEvent ae){

                  frame2.setVisible(true);
                  frame.setVisible(false);
                
                  
          }

        };



        ActionListener twoaction= new ActionListener(){
          public void actionPerformed(ActionEvent ae)
          {
            frame.setVisible(true);
            frame2.setVisible(false);
          }

        };


/////////////////////////////////////////////////////////

  KeyListener keyListener = new KeyListener() {
    String str;
    char ch;
    int len;
      public void keyPressed(KeyEvent keyEvent) {
       /*printIt("Pressed", keyEvent);*/
      }

      public void keyReleased(KeyEvent keyEvent) {}      

      public void keyTyped(KeyEvent keyEvent) {

        System.out.println(keyEvent.getKeyChar()); 
      }

      /*private void printIt(String title, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        System.out.println(title + " : " + keyText+ " / " + keyEvent.getKeyChar());
      }*/
    };



    /////////////////////////////////////////////////

      textarea.getDocument().addDocumentListener(new DocumentListener(){
      public String getText(){
        int caretPosition = textarea.getDocument().getLength();
        Element root = textarea.getDocument().getDefaultRootElement();
        String text = " 1" + System.getProperty("line.separator");
        for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
          text += i + System.getProperty("line.separator");
        }
        return text;
      }
      @Override
      public void changedUpdate(DocumentEvent de) {
        lines.setText(getText());
      }
 
      @Override
      public void insertUpdate(DocumentEvent de) {
        lines.setText(getText());
      }
 
      @Override
      public void removeUpdate(DocumentEvent de) {
        lines.setText(getText());
      }
 
    });




    ////////////////////////////

////////////////////////////////////////////////////////////
///font




////button
     /*button.setBounds(150,150,80,80);*/
     frame2_button.setBounds(150,150,80,80);

///frame

     /*frame.setLayout(null);*/
     /*frame2.setLayout(null);*/


     frame.setSize(900,600);
     frame2.setSize(400,300);


     /*frame.add(button);*/
     frame2.add(frame2_button);


     frame.add(textarea);
     frame.add(lines);

     
     


     frame.setVisible(true);
     frame2.setVisible(false);
     frame.setResizable(false);

///listener

     textarea.addKeyListener(keyListener); 
     open.addActionListener(anaction);
      
        /*frame.add(label);*/
        /*label.setBounds(40,40,80,80);*/
        /*label.setVisible(false);*/
       
        
///textarea  
     /*textarea.setBounds(30,0,900,600); */
     textarea.setFont(font);
     lines.setEditable(false);
     /*lines.setBounds(0,0,60,900);*/ 
     /*lines.setLocation(0,0);*/
     /*lines.setSize(60,900);*/
     lines.setFont(font);
     lines.setBackground(Color.LIGHT_GRAY);


/// scroll bar
    jsp.getViewport().add(textarea);
    jsp.setRowHeaderView(lines);
    jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
    frame.add(jsp);
       
        
///menubar       
        
        /*button.setBackground(Color.red);*/
        menubar.add(menu);
        menu.add(open);
        menu.add(save);
        menu.add(exit);
        
        frame.setJMenuBar(menubar);
        frame2_button.addActionListener(twoaction);
        

      }
    };
    runner.run();

  }
}