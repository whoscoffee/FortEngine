import java.util.ArrayList;

public class Cube {
    
    private ArrayList<Line3D> edges = new ArrayList<Line3D>();

    public Cube() {
        double[][] points = { {-1, -1, -1}, {-1, -1, 1}, {-1, 1, -1}, {-1, 1, 1},
                              { 1, -1, -1}, { 1, -1, 1}, { 1, 1, -1}, { 1, 1, 1} };
        int[][] edges = { {0, 1}, {0, 2}, {0, 4}, {1, 3}, {1, 5}, {2, 3},
                          {2, 6}, {3, 7}, {4, 5}, {4, 6}, {5, 7}, {6, 7} };

        for (int[] edge : edges) {
            double[] p1 = points[edge[0]];
            double[] p2 = points[edge[1]];
            addEdge(p1[0], p1[1], p1[2], p2[0], p2[1], p2[2]);
        }
    }
    
    private void addEdge(double x1, double y1, double z1, double x2, double y2, double z2) {
        edges.add(new Line3D(new Point3D(x1, y1, z1), new Point3D(x2, y2, z2)));
    }

    public ArrayList<Line3D> getEdges() {
        return edges;
    }

    public ArrayList<Line2D> getEdges2D() {
        ArrayList<Line2D> edges2D = new ArrayList<Line2D>();
        for (Line3D edge : edges) {
            edges2D.add(edge.toLine2D());
        }
        return edges2D;
    }
    
    public void rotateX(double angle) {
        for (Line3D edge : edges) {
            edge.rotateX(angle);
        }
    }
    
    public void rotateY(double angle) {
        for (Line3D edge : edges) {
            edge.rotateY(angle);
        }
    }
    
    public void rotateZ(double angle) {
        for (Line3D edge : edges) {
            edge.rotateZ(angle);
        }
    }
    
    public void translate(double dx, double dy, double dz) {
        for (Line3D edge : edges) {
            edge.translate(dx, dy, dz);
        }
    }
}
