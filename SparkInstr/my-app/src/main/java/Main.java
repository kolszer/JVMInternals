import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
    	System.out.println("Main.main");
    	if(args.length==0)
    		get("/hello", (req, res) -> "Hello World!");
    	else
    		get("/hello", (req, res) -> "Hello "+args[0]+"!");
    }
}