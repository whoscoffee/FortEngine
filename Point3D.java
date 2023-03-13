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
    public Vector3D vectorTo(Point3D other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double dz = other.z - this.z;
    
        return new Vector3D(dx, dy, dz);
    }
    public void translate(double dx, double dy, double dz) {
        x += dx;
        y += dy;
        z += dz;
    }

    public double distanceTo(Point3D other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }

    public void rotateX(double angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double yNew = y * cos - z * sin;
        double zNew = y * sin + z * cos;
        y = yNew;
        z = zNew;
    }
    
    public void rotateY(double angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double xNew = x * cos - z * sin;
        double zNew = x * sin + z * cos;
        x = xNew;
        z = zNew;
    }
    
    public void rotateZ(double angle) {
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        double xNew = x * cos - y * sin;
        double yNew = x * sin + y * cos;
        x = xNew;
        y = yNew;
    }
}
