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

}