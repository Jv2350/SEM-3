import java.util.Scanner;

public class BankersAlgorithm {
   private int[][] max;
   private int[][] allocation;
   private int[][] need;
   private int[] available;
   private int numProcesses;
   private int numResources;

   public BankersAlgorithm(int var1, int var2) {
      this.numProcesses = var1;
      this.numResources = var2;
      this.max = new int[var1][var2];
      this.allocation = new int[var1][var2];
      this.need = new int[var1][var2];
      this.available = new int[var2];
   }

   public void setMax(int[][] var1) {
      this.max = var1;
   }

   public void setAllocation(int[][] var1) {
      this.allocation = var1;
   }

   public void calculateNeed() {
      for(int var1 = 0; var1 < this.numProcesses; ++var1) {
         for(int var2 = 0; var2 < this.numResources; ++var2) {
            this.need[var1][var2] = this.max[var1][var2] - this.allocation[var1][var2];
         }
      }

   }

   public void setAvailable(int[] var1) {
      this.available = var1;
   }

   public boolean isSafe(int var1, int[] var2) {
      int var3;
      for(var3 = 0; var3 < this.numResources; ++var3) {
         if (var2[var3] > this.need[var1][var3]) {
            return false;
         }
      }

      for(var3 = 0; var3 < this.numResources; ++var3) {
         if (var2[var3] > this.available[var3]) {
            return false;
         }
      }

      int[] var10000;
      for(var3 = 0; var3 < this.numResources; ++var3) {
         var10000 = this.available;
         var10000[var3] -= var2[var3];
         var10000 = this.allocation[var1];
         var10000[var3] += var2[var3];
         var10000 = this.need[var1];
         var10000[var3] -= var2[var3];
      }

      boolean[] var11 = new boolean[this.numProcesses];

      for(int var4 = 0; var4 < this.numProcesses; ++var4) {
         var11[var4] = false;
      }

      int[] var10 = new int[this.numResources];

      int var5;
      for(var5 = 0; var5 < this.numResources; ++var5) {
         var10[var5] = this.available[var5];
      }

      var5 = 0;

      boolean var6;
      int var7;
      do {
         if (var5 >= this.numProcesses) {
            return true;
         }

         var6 = false;

         for(var7 = 0; var7 < this.numProcesses; ++var7) {
            if (!var11[var7]) {
               int var8;
               for(var8 = 0; var8 < this.numResources && this.need[var7][var8] <= var10[var8]; ++var8) {
               }

               if (var8 == this.numResources) {
                  for(int var9 = 0; var9 < this.numResources; ++var9) {
                     var10[var9] += this.allocation[var7][var9];
                  }

                  var11[var7] = true;
                  var6 = true;
                  ++var5;
               }
            }
         }
      } while(var6);

      for(var7 = 0; var7 < this.numResources; ++var7) {
         var10000 = this.available;
         var10000[var7] += var2[var7];
         var10000 = this.allocation[var1];
         var10000[var7] -= var2[var7];
         var10000 = this.need[var1];
         var10000[var7] += var2[var7];
      }

      return false;
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter the number of processes: ");
      int var2 = var1.nextInt();
      System.out.print("Enter the number of resources: ");
      int var3 = var1.nextInt();
      BankersAlgorithm var4 = new BankersAlgorithm(var2, var3);
      int[][] var5 = new int[var2][var3];
      int[][] var6 = new int[var2][var3];
      int[] var7 = new int[var3];
      System.out.println("Enter the maximum demand matrix:");

      int var8;
      int var9;
      for(var8 = 0; var8 < var2; ++var8) {
         for(var9 = 0; var9 < var3; ++var9) {
            var5[var8][var9] = var1.nextInt();
         }
      }

      System.out.println("Enter the allocation matrix:");

      for(var8 = 0; var8 < var2; ++var8) {
         for(var9 = 0; var9 < var3; ++var9) {
            var6[var8][var9] = var1.nextInt();
         }
      }

      System.out.println("Enter the available resources:");

      for(var8 = 0; var8 < var3; ++var8) {
         var7[var8] = var1.nextInt();
      }

      var4.setMax(var5);
      var4.setAllocation(var6);
      var4.calculateNeed();
      var4.setAvailable(var7);
      System.out.print("Enter the process requesting resources: ");
      var8 = var1.nextInt();
      System.out.println("Enter the request for resources:");
      int[] var11 = new int[var3];

      for(int var10 = 0; var10 < var3; ++var10) {
         var11[var10] = var1.nextInt();
      }

      if (var4.isSafe(var8, var11)) {
         System.out.println("Request can be granted. System is in a safe state.");
      } else {
         System.out.println("Request cannot be granted. System would be in an unsafe state.");
      }

      var1.close();
   }
}
