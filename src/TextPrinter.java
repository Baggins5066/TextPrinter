public class TextPrinter {
    public static void main(String[] args) throws Exception {

        String text = "The quick brown fox jumps over the lazy dog.";
        
        System.out.println();
        System.out.print("\033[32m");
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.substring(i,i+1));
            Thread.sleep(25);
        }
        System.out.print("\033[0m");
        System.out.println();
        System.out.println();
    }
}
