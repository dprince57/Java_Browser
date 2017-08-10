import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


public class ReadFile extends JFrame{

    private JTextField addressBar;
    private JEditorPane display;

    public ReadFile(){
        super("My Browser");

        addressBar = new JTextField("Enter a URL hoss");

        addressBar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        loadStuff(event.getActionCommand());
                    }
                }
        );
        add(addressBar, BorderLayout.NORTH);

        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
                new HyperlinkListener() {
                    @Override
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                    if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
                        loadStuff(event.getURL().toString());
                    }
                    }
                }
        );
        add(new JScrollPane(display),BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }

    private void loadStuff(String userText){
        try{
            display.setPage(userText);
            addressBar.setText(userText);
        }catch(Exception e){
            System.out.println("NOOOO!!!");
        }
    }

}