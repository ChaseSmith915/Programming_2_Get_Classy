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


public class PersonGenerator {
    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);

        boolean done = false;
        ArrayList<Person> personList= new ArrayList<Person>();




        do {

                Person newPerson = new Person(
                        SafeInput.getNonZeroLenString(pipe, "what is the ID number?"),
                        SafeInput.getNonZeroLenString(pipe, "what is the first name?"),
                        SafeInput.getNonZeroLenString(pipe, "what is the last name?"),
                        SafeInput.getNonZeroLenString(pipe, "what is the title?"),
                        SafeInput.getRangedInt(pipe, "what is the year of birth?", 1940, 2000)
                        );
                personList.add(newPerson);

                done = SafeInput.getYNConfirm(pipe, "Are you finished? [Y/N]");

        }while(!done);


        File workDir = new File(System.getProperty("user.dir"));
        String fileName = SafeInput.getNonZeroLenString(pipe, "What would you like the file to be called? DO NOT TYPE .txt");
        Path file = Paths.get(workDir.getPath() + "\\src\\" + fileName + ".txt");

        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(Person rec : personList)
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


