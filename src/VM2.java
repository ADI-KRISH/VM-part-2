
import java.io.*;
import java.util.List;



public class VM2 {
    public static final String INPUT = "Input file path";
    public static final String OUTPUT = "Output file path";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter op = new BufferedWriter(new FileWriter(OUTPUT))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("//")) {
                    continue;
                }
                if (line.trim().startsWith("push")) {
                    op.write(line);
                    op.newLine();
                    processPush(line, op);
                    op.newLine();
                } else if (line.trim().startsWith("pop")) {
                    op.write(line);
                    op.newLine();
                    processPop(line, op);
                    op.newLine();
                } else if (line.trim().startsWith("add")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.add());
                    op.newLine();
                } else if (line.trim().startsWith("sub")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.sub());
                    op.newLine();
                } else if (line.trim().startsWith("neg")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.neg());
                    op.newLine();
                } else if (line.trim().startsWith("eq")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.eq());
                    op.newLine();
                } else if (line.trim().startsWith("not")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.not());
                    op.newLine();
                } else if (line.trim().startsWith("or")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.or());
                    op.newLine();
                } else if (line.trim().startsWith("and")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.and());
                    op.newLine();
                } else if (line.startsWith("lt")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.lt());
                    op.newLine();
                } else if (line.startsWith("gt")) {
                    op.newLine();
                    op.write(line);
                    op.newLine();
                    op.write(translator.gt());
                    op.newLine();
                }
                else if (line.startsWith("label")) {
                    op.write(translator.labelCode(line));
                    op.newLine();
                } else if (line.startsWith("if-goto")) {
                    op.write(translator.ifGotoCode(line));
                    op.newLine();
                } else if (line.startsWith("goto")) {
                    op.newLine();
                    op.write(translator.gotoCode(line));
                    op.newLine();

                } else if (line.startsWith("function")) {
                    op.write(translator.functionCode(line));
                    op.newLine();

                } else if (line.startsWith("call")) {

                    op.write(translator.callerCode(line));
                    op.newLine();
                } else if (line.startsWith("return")) {
                    op.write(line);
                    op.write(translator.returnCode());
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processPush(String line, BufferedWriter writer) throws IOException {
        List<String> parts = translator.convertStringToList(line);
        String segment = parts.get(1);
        String index = parts.get(2);

        if (segment.equals("constant")) {
            writer.write(translator.constant(index));
        } else if (segment.equals("argument")) {
            writer.write(translator.Argument(index));

        } else if (segment.equals("local")) {
            writer.write(translator.local(index));

        } else if (segment.equals("this")) {
            writer.write(translator.This(index));

        } else if (segment.equals("that")) {
            writer.write(translator.That(index));

        } else if (segment.equals("temp")) {
            writer.write(translator.temp(index));

        } else if (segment.equals("static")) {
            writer.write(translator.Static(index));

        } else if (segment.equals("pointer")) {
            writer.write(translator.pointer(index));

        }
    }

    private static void processPop(String line, BufferedWriter writer) throws IOException {
        List<String> partsPop = translator.convertStringToList(line);
        String SegmentPop = partsPop.get(1);
        String indexPop = partsPop.get(2);

        if (SegmentPop.equals("constant")) {
            writer.write(translator.constant(indexPop));


        } else if (SegmentPop.equals("argument")) {
            writer.write(translator.popArgument(indexPop));

        } else if (SegmentPop.equals("local")) {
            writer.write(translator.popLocal(indexPop));

        } else if (SegmentPop.equals("this")) {
            writer.write(translator.popThis(indexPop));

        } else if (SegmentPop.equals("that")) {
            writer.write(translator.popThat(indexPop));

        } else if (SegmentPop.equals("temp")) {
            writer.write(translator.popTemp(indexPop));

        } else if (SegmentPop.equals("static")) {
            writer.write(translator.popStatic(indexPop));

        } else if (SegmentPop.equals("pointer")) {
            writer.write(translator.popPointer(indexPop));
            writer.newLine();
        }
    }
}





