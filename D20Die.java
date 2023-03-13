public class D20Die extends CustomShape {
    public D20Die() { 
        float r = 50f; // radius of the die
        float h = 25f; // height of the pyramid
        float[] vertices = {
                0, h, 0, // Top vertex (index 0)
                // Bottom vertices (indices 1-20)
                r * (float) Math.cos(0), 0, r * (float) Math.sin(0),
                r * (float) Math.cos(Math.PI / 5), 0, r * (float) Math.sin(Math.PI / 5),
                r * (float) Math.cos(2 * Math.PI / 5), 0, r * (float) Math.sin(2 * Math.PI / 5),
                r * (float) Math.cos(3 * Math.PI / 5), 0, r * (float) Math.sin(3 * Math.PI / 5),
                r * (float) Math.cos(4 * Math.PI / 5), 0, r * (float) Math.sin(4 * Math.PI / 5),
                r * (float) Math.cos(Math.PI), 0, r * (float) Math.sin(Math.PI),
                r * (float) Math.cos(6 * Math.PI / 5), 0, r * (float) Math.sin(6 * Math.PI / 5),
                r * (float) Math.cos(7 * Math.PI / 5), 0, r * (float) Math.sin(7 * Math.PI / 5),
                r * (float) Math.cos(8 * Math.PI / 5), 0, r * (float) Math.sin(8 * Math.PI / 5),
                r * (float) Math.cos(9 * Math.PI / 5), 0, r * (float) Math.sin(9 * Math.PI / 5)
        };

        int[] faces = {
                // Top faces
                1, 0, 2, 0, 0, 0,
                2, 0, 3, 0, 0, 0,
                3, 0, 4, 0, 0, 0,
                4, 0, 5, 0, 0, 0,
                5, 0, 1, 0, 0, 0,
                // Bottom faces
                6, 0, 8, 0, 7, 0,
                6, 0, 9, 0, 8, 0,
                6, 0, 5, 0, 9, 0,
                6, 0, 4, 0, 5, 0,
                6, 0, 3, 0, 4, 0,
                6, 0, 2, 0, 3, 0,
                6, 0, 1, 0, 2, 0,
                6, 0, 7, 0, 1, 0,
                7, 0, 8, 0, 9, 0,
                7, 0, 5, 0, 6, 0
            };
    
            createMeshVeiw();
        }
    }