import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FortEngineKeyListener implements KeyListener {
    private FortEngine engine;
    private boolean[] keys;

    public FortEngineKeyListener(FortEngine engine) {
        this.engine = engine;
        this.keys = new boolean[256];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;

        if (keys[KeyEvent.VK_LEFT]) engine.moveHorizontally(1);
        if (keys[KeyEvent.VK_RIGHT])engine.moveHorizontally(-1);
        if (keys[KeyEvent.VK_UP])   engine.moveVertically(1);
        if (keys[KeyEvent.VK_DOWN]) engine.moveVertically(-1);
        if (keys[KeyEvent.VK_A])    engine.rotateX(false);
        if (keys[KeyEvent.VK_D])    engine.rotateX(true);
        if (keys[KeyEvent.VK_W])    engine.rotateY(true);
        if (keys[KeyEvent.VK_S])    engine.rotateY(false);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
