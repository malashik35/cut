import java.io.*;

public class Cut {

    public static void main(String[] args) throws Exception {
        CmdLine cmdLine = new CmdLine(args);
        try {
            new Cut(cmdLine).reading(cmdLine.getOutputFileName(), cmdLine.getInputFileName());
        } catch (Exception e) {

        }
    }

    private char lineSplinning;
    private int start;
    private int end;

    public Cut(CmdLine cmdLine) {
        lineSplinning = cmdLine.getLineSplitting();
        start = cmdLine.getStartPosition();
        end = cmdLine.getEndPosition();
    }


    private void reading(String ofile, String file) throws Exception { //ЧТЕНИЕ ФАЙЛА
        BufferedReader inputStream;
        BufferedWriter outputStream;

        if (ofile == "") outputStream = new BufferedWriter(new OutputStreamWriter(System.out));
        else outputStream = new BufferedWriter(new PrintWriter(ofile));
        if (file == "") inputStream = new BufferedReader(new InputStreamReader(System.in));
        else inputStream = new BufferedReader(new FileReader(file));

        StringBuilder builder = new StringBuilder();
        int data = inputStream.read();
        char content;
        while (data != -1) {
            content = (char) data;
            builder.append(content);
            if (content == '\n') {
                printing(outputStream, builder);
                builder.delete(0, builder.length());
            }

            data = inputStream.read();
            if (data == -1) {
                printing(outputStream, builder);
            }
        }

        outputStream.close();
        inputStream.close();
    }

    private void printing(BufferedWriter outputStream, StringBuilder result) {
        String line = processLine(result.toString());
        line += '\n';
        try {
            for (int i = 0; i < line.length(); i++) {
                int byt = (byte) line.charAt(i);
                outputStream.write(byt);
            }
        } catch (IOException e) {
        }
    }

    private String processLine(String line) {   //делаем
        if (lineSplinning == 'w') return HandlingKt.forWord(start, end, line);
        else return HandlingKt.forChar(start, end, line);
    }


}