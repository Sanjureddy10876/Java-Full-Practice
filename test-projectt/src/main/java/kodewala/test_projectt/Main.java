package kodewala.test_projectt;
interface Test
{
	default	void print(){
     System.out.println("This is Test class");
 }
}
interface Test1{
	default	void print(){
     System.out.println("This is Test1 class");
 }
}
class Example implements Test, Test1{
 @Override
public void print(){
     System.out.println("This is Example class");
 }
} 
class Main {
 public static void main(String[] args) {
     System.out.println("Try programiz.pro");
     Example e1 = new Example();
     e1.print();
 }
}