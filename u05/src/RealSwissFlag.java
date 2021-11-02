import gui.Window;


public class RealSwissFlag {
	
    public static void main(String[] args) {
        Window window = new Window("Fahne", 400, 400);
        
        window.setColor(256, 0, 0);
        
        window.fillRect(0, 0, 150, 150);
        window.fillRect(150, 0, 100, 50);
        
        window.fillRect(250, 0, 150, 150);
        window.fillRect(0, 150, 50, 100);
        
        window.fillRect(250, 250, 150, 150);
        window.fillRect(150, 350, 100, 50);
        
        window.fillRect(0, 250, 150, 150);
        window.fillRect(350, 150, 50, 100);

        
        window.open();
        window.waitUntilClosed();
    }
    
}
