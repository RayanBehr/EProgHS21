import gui.Window;

/**
 * Beispiel-Programm für ein interaktives GUI.
 */
public class Moving {
    public static void main(String[] args) {
        int width = 500, height = 300;
        Window window = new Window("Moving", width, height);
        window.open();

        int x = width / 2;
        while (window.isOpen()) {
            if (window.isKeyPressed("left")) {
                x--;
            }
            if (window.isKeyPressed("right")) {
                x++;
            }

            window.fillCircle(x, height / 2, 10);
            window.refreshAndClear(10);
        }

    }
}
