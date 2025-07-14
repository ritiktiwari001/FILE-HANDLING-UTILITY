import java.io.*;
import java.util.Scanner;

/**
 * FileOperationsDemo
 *
 * A simple Java program demonstrating file operations:
 * - Writing text to a file
 * - Reading text from a file
 * - Modifying (overwriting) file content
 *
 * This is designed as a clear, easy-to-understand example
 * with well-documented methods.
 */
public class FileOperationsDemo {

    /**
     * Writes the given content to the specified file.
     * If the file exists, it will be overwritten.
     *
     * @param filename the name of the file to write to
     * @param content the text content to write into the file
     */
    public static void writeFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Reads the content of the specified file and prints it to the console.
     *
     * @param filename the name of the file to read
     */
    public static void readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader br = new BufferedReader(reader);
            String line;

            System.out.println("\nFile contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();
        }
    }

    /**
     * Modifies (overwrites) the entire content of the specified file.
     *
     * @param filename the name of the file to modify
     * @param newContent the new content to overwrite the file with
     */
    public static void modifyFile(String filename, String newContent) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(newContent);
            writer.close();
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file.");
            e.printStackTrace();
        }
    }

    /**
     * Main method to demonstrate file operations:
     * - Write to a file
     * - Read from the file
     * - Modify (overwrite) the file
     * - Read the modified file
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "sample.txt";

        System.out.println("====== File Operations Demo ======\n");

        // Step 1: Write to file
        System.out.print("Enter text to write to the file: ");
        String content = scanner.nextLine();
        writeFile(filename, content);

        // Step 2: Read file
        readFile(filename);

        // Step 3: Modify file
        System.out.print("\nEnter new text to overwrite the file: ");
        String newContent = scanner.nextLine();
        modifyFile(filename, newContent);

        // Step 4: Read modified file
        readFile(filename);

        System.out.println("\nAll file operations completed.");
        scanner.close();
    }
}
