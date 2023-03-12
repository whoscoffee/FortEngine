public class Point3D {
    private double x;
    private double y;
    private double z;

    public Point3D(double x, double y, double z) {this.x = x;this.y = y;this.z = z;}
    public double getX() {return x;}
    public double getY() {return y;}
    public double getZ() {return z;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setZ(double z) {this.z = z;}

    public Point2D toPoint2D() {
        double y2 = y * Math.cos(0) - z * Math.sin(0);
        double z2 = y * Math.sin(0) + z * Math.cos(0);

        double x3 = x * Math.cos(0) + z2 * Math.sin(0);
        double z3 = -x * Math.sin(0) + z2 * Math.cos(0);

        double scaleFactor = 1 / (1 + z3);

        double x2 = x3 * scaleFactor;
        double y3 = y2 * scaleFactor;

        return new Point2D(x2, y3);
    }
}
