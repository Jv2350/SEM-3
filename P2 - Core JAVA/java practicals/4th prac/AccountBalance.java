//write a java program to create a package MyPack with the class Balance to chekc the account balance of user. If it is less than 0 then show message

package MyPack;

class Balance{
    String name;
    double bal;

    Balance(String n, double b){
        name = n;
        bal = b;
    }

    void show(){
        if (bal < 0 )
            System.out.println("-->");
        System.out.println(name+" :Rs"+bal);
    }
}

public class AccountBalance{
    public static void main(String[] args){
        Balance[] cur = new Balance[3];
        cur[0] = new Balance("Jayesh", 123.123);
        cur[1] = new Balance("Yash", 6234.6234);
        cur[2] = new Balance("Jay", -2856.25);

        for(int i=0;i<3;i++) 
            cur[i].show();
    }
}   