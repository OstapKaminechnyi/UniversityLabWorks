public class Main {

    public static void main(String[] args) {
        Main obj = new Main();
        int[] height = {1,1,1,1};
        System.out.println(obj.maxLength(height, 100));
    }

    public double maxLength(int[] height, int distance) {
        int heightLength = height.length;
        double[][] array = new double[heightLength + 1][101];
        for (int i = 2; i <= heightLength; i++) /*we're checking every pillar height[i]*/
            {
            for (int j = 1; j <= height[i - 1]; j++) /*now we'll check every pillar height[i-1]*/
                {
                for (int k = 1; k <= height[i - 2]; k++)  /*then checking every pillar height[i-2]*/
                    {
                    array[i][j] = Math.max(array[i][j], array[i - 1][k] + Math.sqrt(distance * distance + (j - k) * (j - k)));
                }
            }
        }
        double wire = 0;
        for (int i = 1; i <= height[heightLength - 1]; i++)
        {
            wire = (array[heightLength][i]); /*count wire length*/
        }
        return wire;
    }
}