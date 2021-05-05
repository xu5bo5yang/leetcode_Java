/**
 * https://leetcode.com/problems/generate-random-point-in-a-circle/submissions/
 */
class Solution {

    private double radius;
    private double x_center;
    private double y_center;
    
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        double r = radius * Math.sqrt(Math.random());
        double d = 2 * Math.PI * Math.random();
        
        double x = x_center + r * Math.cos(d);
        double y = y_center + r * Math.sin(d);
        
        return new double[]{x,y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */