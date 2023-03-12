import java.util.ArrayList;
import javax.swing.JFrame;

public class Main {
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;

    public static void main(String[] args) {
        // Create a new cube
        Cube cube = new Cube();

        // Create a new 3D engine with the cube's edges
        FortEngine engine = new FortEngine(new ArrayList<Point3D>(), cube.getEdges());

        // Create a new frame to display the 3D engine
        JFrame frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(engine);
        frame.setVisible(true);
        FortEngineKeyListener keyListener = new FortEngineKeyListener(engine);

        frame.addKeyListener(keyListener);
        engine.setFocusable(true);
        engine.requestFocus();
        // Add the points of the cube to the 3D engine
        for (Line3D line : cube.getEdges()) {
            Point3D p1 = line.getP1();
            Point3D p2 = line.getP2();
            if (!engine.getPoints().contains(p1)) {
                engine.getPoints().add(p1);
            }
            if (!engine.getPoints().contains(p2)) {
                engine.getPoints().add(p2);
            }
        }

        // Rotate the cube and repaint the 3D engine
        while (true) {
            engine.rotateX(true);
            engine.rotateY(true);
            engine.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}