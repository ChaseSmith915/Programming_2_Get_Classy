import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
public class Product_Model {
    public static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);

        boolean done = false;
        ArrayList<Product> productList= new ArrayList<Product>();




        do {
            Product newProduct = new Product(
                    SafeInput.getNonZeroLenString(pipe, "What is the ID?"),
                    SafeInput.getNonZeroLenString(pipe, "What is the name?"),
                    SafeInput.getNonZeroLenString(pipe, "Please write a short description"),
                    SafeInput.getDouble(pipe, "what is the cost")
            );
            productList.add(newProduct);
            done = SafeInput.getYNConfirm(pipe, "Are you finished? [Y/N]");

        }while(!done);


        File workDir = new File(System.getProperty("user.dir"));
        String fileName = SafeInput.getNonZeroLenString(pipe, "What would you like the file to be called? DO NOT TYPE .txt");
        Path file = Paths.get(workDir.getPath() + "\\src\\" + fileName + ".txt");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Product rec : productList)
            {
                writer.write(rec.toCSVDataRecord(), 0, rec.toCSVDataRecord().length());
                writer.newLine();
            }
            writer.close();
            System.out.println("data file written");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
