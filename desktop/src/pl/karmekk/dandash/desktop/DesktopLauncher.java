package pl.karmekk.dandash.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import pl.karmekk.dandash.DanDashGame;

public class DesktopLauncher {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void main(String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

        config.setTitle("DanDash");
        config.setWindowedMode(WIDTH, HEIGHT);
        config.setResizable(false);

        new Lwjgl3Application(new DanDashGame(), config);
    }
}
