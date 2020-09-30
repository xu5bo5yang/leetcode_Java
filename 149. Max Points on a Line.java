/**
 * https://leetcode.com/problems/max-points-on-a-line/submissions/
 */
class Solution {
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class Line {
        int a;
        int b;
        
        public Line(Point p1, Point p2) {
            int diffX = p1.x - p2.x;
            int diffY = p1.y - p2.y;
            int gcd = generateGCD(diffX, diffY);

            this.a = diffX / gcd;
            this.b = diffY / gcd;
        }
        
        @Override
        public int hashCode() {
            int hash = this.a + this.b;
            return hash;
        }
        
        @Override
        public boolean equals(Object o) { 
            if (o == this) { 
                return true; 
            } 
            
            if (!(o instanceof Line)) { 
                return false; 
            } 

            Line c = (Line) o; 

            return Double.compare(a, c.a) == 0
                    && Double.compare(b, c.b) == 0; 
        } 
    }
    
    public int maxPoints(int[][] points) {
        int len = points.length;
        
        if (len < 3) {
            return len;
        }
        
        Map<Line, Integer> pointsOnLine = new HashMap();
        int result = 0;
        int samePoint = 0;
        int sameLine = 0;
        
        for (int i = 0; i < len; i++) {
            Point pI = new Point(points[i][0], points[i][1]);
            samePoint = 0;
            sameLine = 1;
            pointsOnLine.clear();
            
            for (int j = i + 1; j < len; j++) {
                Point pJ = new Point(points[j][0], points[j][1]);
                
                if (pI.x == pJ.x && pI.y == pJ.y) {
                    samePoint++;
                    continue;
                }
                
                Line line = new Line(pI, pJ);
                
                Integer prevPoints = pointsOnLine.get(line);
                if (prevPoints == null) {
                    prevPoints = 2;
                } else {
                    prevPoints++;
                }
                pointsOnLine.put(line, prevPoints);
                
                sameLine = Math.max(sameLine, prevPoints);
            }
            
            result = Math.max(result, samePoint + sameLine);
        }
        
        return result;
    }
    
    int generateGCD(int a, int b) {
        int r = 0;
        
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        
        return a;
    }
}