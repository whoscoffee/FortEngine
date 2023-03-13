public class Line3D {
    private Point3D p1;
    private Point3D p2;

    public Line3D(Point3D p1, Point3D p2) {this.p1 = p1; this.p2 = p2;}
    public Point3D getP1(){return p1;}
    public Point3D getP2(){return p2;}
    public void setP1(Point3D p1){this.p1 = p1;}
    public void setP2(Point3D p2){this.p2 = p2;}

    public Line2D toLine2D() {
        Point2D p1_2D = p1.toPoint2D();
        Point2D p2_2D = p2.toPoint2D();
        return new Line2D(p1_2D, p2_2D);
    }
    public void rotateX(double angle) {
        p1.rotateX(angle);
        p2.rotateX(angle);
    }

    public void rotateY(double angle) {
        p1.rotateY(angle);
        p2.rotateY(angle);
    }

    public void rotateZ(double angle) {
        p1.rotateZ(angle);
        p2.rotateZ(angle);
    }

    public void translate(double dx, double dy, double dz) {
        p1.translate(dx, dy, dz);
        p2.translate(dx, dy, dz);
    }
    public double getLength() {
        return p1.distanceTo(p2);
    }
    
    public Point3D getMidpoint() {
        double midX = (p1.getX() + p2.getX()) / 2.0;
        double midY = (p1.getY() + p2.getY()) / 2.0;
        double midZ = (p1.getZ() + p2.getZ()) / 2.0;
        return new Point3D(midX, midY, midZ);
    }
    
    public Vector3D getDirection() {
        return p1.vectorTo(p2).normalize();
    }
    
    public double distanceToPoint(Point3D point) {
        Vector3D v1 = p1.vectorTo(point);
        Vector3D v2 = p1.vectorTo(p2);
        Vector3D cross = v1.crossProduct(v2);
        return cross.magnitude() / v2.magnitude();
    }
    
    public Point3D intersect(Line3D line) {
        Vector3D v1 = p1.vectorTo(p2);
        Vector3D v2 = line.getP1().vectorTo(line.getP2());
        Vector3D cross = v1.crossProduct(v2);

        if (cross.magnitude() == 0) {
            return null;
        }
        Vector3D v3 = line.getP1().vectorTo(p1);
        double t = v3.dotProduct(cross) / cross.magnitude();
        double x = p1.getX() + v1.getX() * t;
        double y = p1.getY() + v1.getY() * t;
        double z = p1.getZ() + v1.getZ() * t;

        return new Point3D(x, y, z);
    }
}