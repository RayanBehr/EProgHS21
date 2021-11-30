import static java.lang.Math.min;
import gui.Window;

public class SwissMap {
    
    static int BG_PIXEL_WIDTH = 3000;
    
    static int BG_MIN_EAST  = 480000;
    static int BG_MAX_EAST  = 840000;
    static int BG_MIN_NORTH =  62000;
    static int BG_MAX_NORTH = 300000;
    
    static int BG_WIDTH  = BG_MAX_EAST - BG_MIN_EAST;
    static int BG_HEIGHT = BG_MAX_NORTH - BG_MIN_NORTH;
    
    public static void main(String[] args) {
        new SwissMap().show();
    }
    
    Window window;
    
    SwissMap() {
        window = new Window("Map", 600, 400);
    }

    /**
     * Opens a {@link Window} and displays an interactive map of Switzerland
     */
    void show() {
        window.setResizable(true);
        window.open();
        
        PointOfInterest[] pois = new PointOfInterest[] {
                /* TODO: Create points of interest */};
        
        while(window.isOpen()) {
            window.drawImage("Switzerland_adm_location_map.png",
                    toGuiX(BG_MIN_EAST), toGuiY(BG_MAX_NORTH),
                    BG_WIDTH / BG_PIXEL_WIDTH * scale());
            
            // TODO: Draw points of interest
            
            window.refreshAndClear(20);
        }
    }
    
    /**
     * Computes the scaling factor of the map, based on the current size of the window.
     */
    double scale() {
        return min(window.getWidth() / BG_WIDTH, window.getHeight() / BG_HEIGHT);
    }
    
    /**
     * Converts a CH1903 east coordinate into a GUI x coordinate
     */
    double toGuiX(double east) {
        double x0 = BG_MIN_EAST - (window.getWidth()/scale() - BG_WIDTH) / 2;
        return (east - x0) * scale();
    }
    
    /**
     * Converts a CH1903 north coordinate into a GUI y coordinate
     */
    double toGuiY(double north) {
        double y0 = BG_MAX_NORTH + (window.getHeight()/scale() - BG_HEIGHT) / 2;
        return (y0 - north) * scale();
    }
}
