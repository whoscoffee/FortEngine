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

        if (keys[KeyEvent.VK_LEFT]) {
            engine.moveLeft();
        }
        if (keys[KeyEvent.VK_RIGHT]) {
            engine.moveRight();
        }
        if (keys[KeyEvent.VK_UP]) {
            engine.moveUp();
        }
        if (keys[KeyEvent.VK_DOWN]) {
            engine.moveDown();
        }
        if (keys[KeyEvent.VK_A]) {
            engine.rotateX(false);
        }
        if (keys[KeyEvent.VK_D]) {
            engine.rotateX(true);
        }
        if (keys[KeyEvent.VK_W]) {
            engine.rotateY(true);
        }
        if (keys[KeyEvent.VK_S]) {
            engine.rotateY(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
