import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    List<String> str = new ArrayList<>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return "Strings" + str.toString();
        } 
        if else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/add")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    str.add(parameters[1]);
                    return String.format("String %s added! THe list is now %s", str.toString());
                }
            }
        }
        else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    List<String> answers = new ArrayList<>();
                    for (int i = 0; i < str.length; i++) {
                        if (str.get(i) == parameters[1]) {
                            answers.add(str.get(i));
                        }
                    }
                    return String.format("Strings %s found!", answers.toString());
                }
            }
            return "404 Not Found!";
        }
    }
}



class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
