import gui.Window;

/*
 * Author: Maximiliana Muster
 * für Einfuehrung in die Programmierung, HS 2018
 * 
 * Dieses Programm spielt das Chaos-Spiel
 */
public class ChaosGame {
    
    public static void main(String[] args) {
        int size = 800;
        int stepsPerIter = 50;
        
        double[] cornersX = {size/2, 50, size-50};
        double[] cornersY = {100, size-100, size-100};
        
        double x = Math.random() * size;
        double y = Math.random() * size;
        
        Window window = new Window("Chaos Game", size, size);
        window.open();
        while(window.isOpen()) {
            for(int i = 0; i < stepsPerIter; i++) {
                int index = (int) (Math.random() * 3);
                x = (x + cornersX[index]) / 2;
                y = (y + cornersY[index]) / 2;
                window.fillRect(x, y, 1, 1);
            }
            window.refresh();
        }
    }
}
