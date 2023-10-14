class DemoOverride {
    int i;

    DemoOverride() {
        i = 10;
    }

    public void display() {
        System.out.println("i " + i);
    }
}

class DemoChildOverride extends DemoOverride {
    int j;

    DemoChildOverride() {
        j = 20;
    }

    public void display() {
        System.out.println("j : " + j);
    }
}

class MOverride {
    public static void main(String args[]) {
        DemoChildOverride dco = new DemoChildOverride();
        dco.i = 40;
        dco.j = 60;
        dco.display();
    }
}