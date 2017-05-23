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


    private void reading(String ofile, String file) throws Exception {
        BufferedReader inputStream;
        BufferedWriter outputStream;

        outputStream = ofile == "" ? new BufferedWriter(new OutputStreamWriter(System.out)) : new BufferedWriter(new PrintWriter(ofile));
        inputStream = file == "" ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader(file));

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

    private String processLine(String line) {
        return lineSplinning == 'w' ?
                HandlingKt.forWord(start, end, line) :
                HandlingKt.forChar(start, end, line);
    }


}