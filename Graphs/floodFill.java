import java.util.*;

public class floodFill {
    public void helper(int[][] image, int sr, int sc, int color, int orgColor, boolean vis[][]) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc]
                || image[sr][sc] != orgColor) {
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        //left
        helper(image, sr, sc - 1, color, orgColor, vis);
        //right
        helper(image, sr, sc + 1, color, orgColor, vis);
        //up
        helper(image, sr - 1, sc, color, orgColor, vis);
        //down
        helper(image, sr + 1, sc, color, orgColor, vis);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        // m * n
        helper(image, sr, sc, color, image[sr][sc], vis);

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };
        floodFill ff = new floodFill(); // create object
        int sr = 1, sc = 1, newColor = 2; // start row, start col, new color
        int[][] result = ff.floodFill(image, sr, sc, newColor);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
