public class DomTest {
    public static void main(String[] args){
        print(10);
    }
    public static void print(int a){
        for(int i=0;i<a;i++){
            for(int j=0;j<a-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*i+1;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
