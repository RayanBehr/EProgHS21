import gui.Window;

/**
 * Beispiel-Programm für animiertes Zeichnen mit der
 * Window-Klasse.
 */
public class Plotter {

    public static void main(String[] args) {
        int width = 500, height = 300;
        Window window = new Window("Plotter", width, height);
        window.open();

        for (int i = 0; i < width; i++) {
            double x = 0.05 * i;
            double y = Math.sin(x);
            window.fillRect(i, y * height / 4 + height / 2, 1, 1);
            window.refresh(10);
        }

        window.waitUntilClosed();
    }
}
