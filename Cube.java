import java.util.ArrayList;

public class Cube {
    private static final int[][] CUBE_POINTS = { { -1, -1, -1 }, { -1, -1, 1 }, { -1, 1, -1 }, { -1, 1, 1 },
            { 1, -1, -1 }, { 1, -1, 1 }, { 1, 1, -1 }, { 1, 1, 1 } };
    private static final int[][] CUBE_EDGES = { { 0, 1 }, { 0, 2 }, { 0, 4 }, { 1, 3 }, { 1, 5 }, { 2, 3 }, { 2, 6 },
            { 3, 7 }, { 4, 5 }, { 4, 6 }, { 5, 7 }, { 6, 7 } };

    private ArrayList<Line3D> edges = new ArrayList<Line3D>();

    public Cube() {
        for (int[] edge : CUBE_EDGES) {
            Point3D p1 = new Point3D(CUBE_POINTS[edge[0]][0], CUBE_POINTS[edge[0]][1], CUBE_POINTS[edge[0]][2]);
            Point3D p2 = new Point3D(CUBE_POINTS[edge[1]][0], CUBE_POINTS[edge[1]][1], CUBE_POINTS[edge[1]][2]);
            edges.add(new Line3D(p1, p2));
        }
    }

    public ArrayList<Line3D> getEdges() {
        return edges;
    }
}

