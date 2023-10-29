import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class InteractiveProcessBuilder {

    public static void main(String [] args)
    {

        try {
            ArrayList<String> commands = new ArrayList<>();
            commands.add("cmd.exe");
            commands.add("/c");
            commands.add("ping ");

            Scanner sc = new Scanner(System.in);
            System.out.println("argument :");
            String argument=sc.nextLine();
            commands.add(argument);
            sc.close();

            ProcessBuilder pb = new ProcessBuilder(commands);
            Process process=pb.start();

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String Bufferline;
            while((Bufferline =br.readLine())!=null)
            {
                System.out.println(Bufferline);
            }

            int codeSortie = process.waitFor();
            System.out.println("\nLe processus s'est terminé avec le code de sortie : " + codeSortie);

        }
        catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Exception: " + e.getMessage());
        }


    }

}
