import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    
    ArrayList<String> messages = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if(parameters[0].equals("s")){
                messages.add(parameters[1]);
                String output = "";
                for(int i = 0; i < messages.size(); i++){
                    output += messages.get(i) + "\n";
                }
                return output;
            }
            return "404 Not Found!";
        }
        return "404 Not Found!";
    }  
}     

public class StringServer{
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }  
}
