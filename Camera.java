import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.transform.Rotate;

public class Camera {
    private PerspectiveCamera camera;
    private Point3D position;
    private Rotate rotateX, rotateY;

    public Camera(double fov, double nearClip, double farClip) {
        camera = new PerspectiveCamera(true);
        camera.setFieldOfView(fov);
        camera.setNearClip(nearClip);
        camera.setFarClip(farClip);

        position = new Point3D(0, 0, 0);

        rotateX = new Rotate(0, Rotate.X_AXIS);
        rotateY = new Rotate(0, Rotate.Y_AXIS);
        camera.getTransforms().addAll(rotateX, rotateY);
    }

    public void setPosition(Point3D position) {
        this.position = position;
        camera.setTranslateX(position.getX());
        camera.setTranslateY(position.getY());
        camera.setTranslateZ(position.getZ());
    }

    public Point3D getPosition() {
        return position;
    }

    public void setRotation(double x, double y) {
        rotateX.setAngle(x);
        rotateY.setAngle(y);
    }

    public double getRotationX() {
        return rotateX.getAngle();
    }

    public double getRotationY() {
        return rotateY.getAngle();
    }

    public PerspectiveCamera getCamera() {
        return camera;
    }
}