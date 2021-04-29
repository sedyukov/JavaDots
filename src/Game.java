import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;

public class Game extends JFrame {
    int x,y;
    int n = 5;
    int begin = 50;
    int step = 40;
    private Image dbImage;
    private Graphics dbg;
    public Mouse mouse = new Mouse();
    Grid grid = new Grid(n);
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
        paintGrid(dbg);
        repaintBorder(dbg);
        g.drawImage(dbImage,0,0,this);
    }

    //painting Components
    public void paintGrid(Graphics g){
        for (int i = 0;i <= n;i++){
            g.drawLine(begin+i*step,begin,begin+i*step,begin+step*n);
            g.drawLine(begin,begin+i*step,begin+step*n,begin+i*step);
        }
        g.setColor(Color.YELLOW);
        g.fillRect(mouse.xCoord-5,mouse.yCoord-5,10,10);
        repaint();
    }
    public void repaintBorder(Graphics g){
        int correctedX = mouse.xCoord - begin;
        int correctedY = mouse.yCoord - begin;
        int distX, distY, distXalt, distYalt;
        boolean isX, isY;
        distX = correctedX % step;
        distY = correctedY % step;
        isX = ((distX>=0 && distX<=5)|(distX>=step-5 && distX<=step));
        isY = ((distY>=0 && distY<=5)|(distY>=step-5 && distY<=step));
        if ((isX&&isY)||(!isX&&!isY)) return;
        if (isX){
            int startY = mouse.yCoord - distY;
            g.setColor(Color.RED);
            if(distX > 5) distX -= step;
            int startX = mouse.xCoord-distX;
            grid.setElementX(startX-begin, startY-begin, step);
            g.drawLine(startX, startY, startX, startY+step);
        }else{
            int startX = mouse.xCoord - distX;
            g.setColor(Color.RED);
            if(distY > 5) distY -= step;
            g.drawLine(startX, mouse.yCoord-distY, startX+step, mouse.yCoord-distY);
        }
        //if (!isX&&!isY) System.out.print("0");
        /*int errorX, errorY;
        //checkResult with error X
        errorX = mouse.xCoord % step;
        if (errorX <= 3) correctedX = mouse.xCoord - errorX;
        else if (10 - errorX <= 3) correctedX = mouse.xCoord + (10 - errorX);
        else
        //checkResult with error Y
        errorY = mouse.yCoord % step;
        if (errorY <= 3) correctedY = mouse.yCoord - errorY;
        else if (10 - errorY <= 3) correctedY = mouse.yCoord + (10 - errorY);
        else return;
        g.drawLine(correctedX,correctedY,correctedX+step,correctedY);*/
//        int xCurrent = (mouse.xCoord - begin) / step;
//        int yCurrent = (mouse.yCoord - begin) / step;

    }
    public static void main(String[] args){
        Game game = new Game();
    }
}
