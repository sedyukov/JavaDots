import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
    int xCoord,yCoord;
    @Override
    public void mousePressed(MouseEvent e){
        xCoord = e.getX();
        yCoord = e.getY();
        System.out.println(xCoord+" "+yCoord);
    }
    @Override
    public void mouseReleased(MouseEvent e){

    }
}