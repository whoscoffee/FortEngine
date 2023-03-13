import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
public class FortEngine extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Group root;

    @Override
    public void start(Stage primaryStage) {
        root = new Group();

        // Create a box with a material and add it to the root group
        Box box = new Box(100, 100, 100);
        PhongMaterial material = new PhongMaterial();
        material.setDiffuseColor(Color.BLUE);
        box.setMaterial(material);
        root.getChildren().add(box);

        // Create a camera and add it to the root group
        PerspectiveCamera camera = new PerspectiveCamera(true);
        camera.setNearClip(0.1);
        camera.setFarClip(10000.0);
        camera.setTranslateZ(-500.0);
        root.getChildren().add(camera);

        // Create a scene and add it to the primary stage
        Scene scene = new Scene(root, WIDTH, HEIGHT, true);
        scene.setFill(Color.BLACK);
        scene.setCamera(camera);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Add a rotation transform to the root group to make the box spin
        Rotate rotation = new Rotate(0, 0, 0, 0, Rotate.Y_AXIS);
        root.getTransforms().add(rotation);

        // Create an animation to continuously rotate the box
        javafx.animation.Animation animation = new javafx.animation.Timeline(
                new javafx.animation.KeyFrame(
                        javafx.util.Duration.seconds(1),
                        event -> {
                            rotation.setAngle(rotation.getAngle() + 1);
                        }
                )
        );
        animation.setCycleCount(javafx.animation.Animation.INDEFINITE);
        animation.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}