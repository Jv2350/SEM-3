class Area {

    int width, height;

    Area(int w, int h) {
        width = w;
        height = h;
    }

    public void showArea() {
        int A;
        System.out.println("Height : " + height + " and width is " + width);
        A = width * height;
        System.out.println("\nArea is " + A);
    }
}

class Rectangle extends Area {
    Rectangle(int w, int h) {
        super(w, h);
    }

    public static void main(String args[]) {
        Rectangle R = new Rectangle(10, 20);
        R.showArea();
    }
}