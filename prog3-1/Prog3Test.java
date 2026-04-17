public class Prog3Test {


   public static void main(String[] args) {

   MyObj c[] = new MyObj[10];

   for (int i = 0; i < 10; i++) {
	c[i] = new MyObj();
	c[i].print();
	}


   int res = Prog3.Prog3(c);

   System.out.println("\nResult : " + res);
   }

}
    

