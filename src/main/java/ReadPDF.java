import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReadPDF {


    public void Read() throws IOException {

        int amountOfWords = 0;
        int amountOfChars = 0;
        String allAlphabate = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        try {
            PDDocument doc = PDDocument.load(new File("C:\\Users\\ccw\\Desktop\\articles\\RECYCLING-BEHAVIOUR-AMONG-MALAYSIAN-TERTIARY-STUDENTS.pdf"));
            String text = new PDFTextStripper().getText(doc);


            String[] words = text.split(" ");
            amountOfWords = amountOfWords + words.length;
            StringBuilder builder = new StringBuilder();

            for (String word : words) {
                amountOfChars = amountOfChars + word.length();

                Pattern pattern = Pattern.compile("[a-zA-Z]");
                Matcher matcher = pattern.matcher(word);

                while (matcher.find()) {
                    builder.append(matcher.group());

                }

            }

            String allData = builder.toString();
            int total = 0;

            for (int i=0;i<allAlphabate.length();i++)
            {
                int alphabateCount = 0;
                Pattern pattern = Pattern.compile(Character.toString(allAlphabate.charAt(i)));
                Matcher matcher = pattern.matcher(allData);
                while (matcher.find()) {
                    alphabateCount++;
                }
                total+=alphabateCount;
                System.out.println("Alphabate : "+ allAlphabate.charAt(i) +" -> Count is "+alphabateCount);
            }
            if(total == builder.toString().length())
            {
                System.out.println("\nTotal number of character is : "+ total);
            }


            System.out.println("Amount of Words is " + (amountOfWords + 1));
            System.out.println("Average Word Length is "+ (total/amountOfWords));

        }catch (IOException e) {
        }

    }



}