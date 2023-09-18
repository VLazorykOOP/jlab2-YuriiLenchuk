import java.lang.Math;
public final class Task2 {
    public static class Circle{
        double x;
        double y;
        double radius;
        Circle(double x, double y, double radius){
            this.x = x;
            this.y = y;
            this.radius =radius;
        }
        public double circuit(){
            return 2*Math.PI*this.radius;
        }
        public double area(){
            return Math.PI * Math.pow(this.radius, 2);
        }
        public boolean isInArea(double x, double y){
            return Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2)) <= this.radius;
        }
        public static int countIntersectionPoints(Circle circle1, Circle circle2) {
            double distanceBetweenCenters = Math.sqrt(
                    Math.pow(circle1.x - circle2.x, 2) + Math.pow(circle1.y - circle2.y, 2)
            );
            if (distanceBetweenCenters >= circle1.radius + circle2.radius) {
                return 0;
            } else if (distanceBetweenCenters <= Math.abs(circle1.radius - circle2.radius)) {
                return 0;
            } else if (distanceBetweenCenters == 0 && circle1.radius == circle2.radius) {
                return -1;
            } else if (distanceBetweenCenters == circle1.radius + circle2.radius) {
                return 1;
            } else {
                return 2;
            }
        }
    }
    public static void task2(){
        Circle circle1 = new Circle(0,0,2);
        Circle circle2 = new Circle(4,0,3);
        System.out.print(circle1.circuit());
        System.out.print('\n');
        System.out.print(circle2.area());
        System.out.print('\n');
        System.out.print(circle1.isInArea(1,1));
        System.out.print('\n');
        System.out.print(Circle.countIntersectionPoints(circle1, circle2));
    }
}