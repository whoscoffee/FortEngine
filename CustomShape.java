import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;

public class CustomShape {

    protected MeshView meshView;
    private float[] vertices;
    private int[] faces;

    public void setFaces   (int[]   faces){   this.faces    = faces;}
    public void setVertices(float[] vertices){this.vertices = vertices;}
    public int[]   getFaces()   {return faces;}
    public float[] getvertices(){return vertices;}
    protected MeshView getMeshView() {return meshView;}

    protected void createMeshVeiw(){
        TriangleMesh mesh = new TriangleMesh();
        mesh.getPoints().addAll(vertices);
        mesh.getTexCoords().addAll(0, 0);
        mesh.getFaces().addAll(faces);
        meshView = new MeshView(mesh);
    }

    
}
