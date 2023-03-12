import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FortEngine extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final double FOV = 1000;
    private static final int ROTATION_SPEED = 2;
    private static final int MOVE_SPEED = 5;

    private ArrayList<Point3D> points;
    private ArrayList<Line3D> lines;
    private double xRotation;
    private double yRotation;

    public FortEngine(ArrayList<Point3D> points, ArrayList<Line3D> lines) {
        this.points = points;
        this.lines = lines;
        this.xRotation = 0;
        this.yRotation = 0;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        ArrayList<Point2D> points2D = convertPointsTo2D();
        drawEdges(g, points2D);
    }

    private ArrayList<Point2D> convertPointsTo2D() {
        ArrayList<Point2D> points2D = new ArrayList<Point2D>();
        for (Point3D point : points) {
            points2D.add(point.toPoint2D());
        }
        return points2D;
    }

    private void drawEdges(Graphics g, ArrayList<Point2D> points2D) {
        g.setColor(Color.WHITE);
        for (Line3D line : lines) {
            Line2D line2D = line.toLine2D();
            Point2D p1 = line2D.getP1();
            Point2D p2 = line2D.getP2();

            double x1 = p1.getX();
            double y1 = p1.getY();
            double x2 = p2.getX();
            double y2 = p2.getY();

            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }

    public void rotateX(boolean clockwise) {
        if (clockwise) {
            xRotation += Math.toRadians(ROTATION_SPEED);
        } else {
            xRotation -= Math.toRadians(ROTATION_SPEED);
        }
        repaint();
    }

    public void rotateY(boolean clockwise) {
        if (clockwise) {
            yRotation += Math.toRadians(ROTATION_SPEED);
        } else {
            yRotation -= Math.toRadians(ROTATION_SPEED);
        }
        repaint();
    }

    public void moveLeft() {
        for (Point3D point : points) {
            point.setX(point.getX() - MOVE_SPEED);
        }
        repaint();
    }

    public void moveRight() {
        for (Point3D point : points) {
            point.setX(point.getX() + MOVE_SPEED);
        }
        repaint();
    }

    public void moveUp() {
        for (Point3D point : points) {
            point.setY(point.getY() - MOVE_SPEED);
        }
        repaint();
    }

    public void moveDown() {
        for (Point3D point : points) {
            point.setY(point.getY() + MOVE_SPEED);
        }
        repaint();
    }
    public ArrayList<Point3D> getPoints() {
        return points;
    }
}