public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalize() {
        double mag = magnitude();
        return new Vector3D(x / mag, y / mag, z / mag);
    }

    public Vector3D add(Vector3D v) {
        return new Vector3D(x + v.x, y + v.y, z + v.z);
    }

    public Vector3D subtract(Vector3D v) {
        return new Vector3D(x - v.x, y - v.y, z - v.z);
    }

    public Vector3D scalarMultiply(double s) {
        return new Vector3D(x * s, y * s, z * s);
    }

    public double dotProduct(Vector3D v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vector3D crossProduct(Vector3D v) {
        double x = this.y * v.z - this.z * v.y;
        double y = this.z * v.x - this.x * v.z;
        double z = this.x * v.y - this.y * v.x;
        return new Vector3D(x, y, z);
    }

    public double angleBetween(Vector3D v) {
        double mag1 = magnitude();
        double mag2 = v.magnitude();
        double dot = dotProduct(v);
        return Math.acos(dot / (mag1 * mag2));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}