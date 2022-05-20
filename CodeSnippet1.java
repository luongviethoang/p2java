package Thread;

public class CodeSnippet1 extends Thread {
    String name;
    public void run() {
        while (true){
            name = Thread.currentThread().getName();
            System.out.println(name);
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    break;
                }
        }
    }
    public static void main (String args[]){
        CodeSnippet1 t1 = new CodeSnippet1();
        CodeSnippet1 t2 = new CodeSnippet1();
        t1.setName("Thread2");
        t2.setName("Thread3");
        t1.start();//phải có câu lệnh start thì luồng mới chạy đc
        t2.start();
        System.out.println("Number of threads running:"+ Thread.activeCount());

    }
}
