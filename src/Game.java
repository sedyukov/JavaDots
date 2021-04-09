import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Game extends JFrame {
    int x,y;
    private Image dbImage;
    private Graphics dbg;
    public Mouse mouse = new Mouse();
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT){
                x-=5;
            }
            if (keyCode == e.VK_RIGHT){
                x+=5;
            }
            if (keyCode == e.VK_UP){
                y-=5;
            }
            if (keyCode == e.VK_DOWN){
                y+=5;
            }
        }
        public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
        }
    }

    public Game(){
        setTitle("Dots");
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        start();
    }
    public void start(){
        addMouseListener(mouse);
        addKeyListener(new AL());

    }

    //for double buffering
    public void paint(Graphics g){
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
    }

    //painting Components
    public void paintComponent(Graphics g){
        for ()
        g.drawLine();
        g.fillOval(mouse.xCoord,mouse.yCoord,15,15);
        repaint();
    }
    public static void main(String[] args){
        Game game = new Game();
    }
}
