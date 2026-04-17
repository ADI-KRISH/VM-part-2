

import java.util.Arrays;
import java.util.List;


public class translator {

    public static String Static(String m) {
        return "@Foo."+m+"\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"
                +"\n";
    }

    public static String popLocal(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@LCL\n" +
                "A=M\n" +
                "A=A+"+m+"\n" +
                "M=D"
                +"\n";
    }

    public static String popArgument(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@ARG\n" +
                "A=M+"+m+"\n" +
                "M=D"+"\n";
    }

    public static String popThis(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@THIS\n" +
                "A=M+"+m+"\n" +
                "M=D"+"\n";
    }

    public static String popThat(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@THAT\n" +
                "A=M+"+m+"\n" +
                "M=D"+"\n";
    }

    public static String popPointer(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@" + (m.equals("0") ? "THIS" : "THAT") + "\n" +
                "M=D"+"\n";
    }

    public static String popStatic(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@Foo." + m + "\n" +
                "M=D"+"\n";
    }

    public static String popTemp(String m) {
        return "@SP\n" +
                "AM=M-1\n" +
                "D=M\n" +
                "@R5\n" +
                "A=M+" + m + "\n" +
                "M=D"+"\n";
    }

    public static List<String> convertStringToList(String input) {
        return Arrays.asList(input.split("\\s+"));
    }
    public  static String local(String input){
        return "@LCL\n" +
                "D=M\n" +
                "@"+input + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String constant(String input){
        return "@"+input+"\n" +
                "D=A\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String Argument(String input){
        return "@ARG\n" +
                "D=M\n" +
                "@"+input+"\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String That(String input){
        return "@THAT\n" +
                "D=M\n" +
                "@"+input+"\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String This(String input){
        return "@THIS\n" +
                "D=M\n" +
                "@"+input+"\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String temp(String input) {
        return "@5\n" +
                "D=A\n" +
                "@" + input + "\n" +
                "A=D+A\n" +
                "D=M\n" +
                "@SP\n" +
                "A=M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String pointer(String input){
        return " ";
    }
    public static String add(){
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=M+D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String neg() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=-M\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String sub() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=M-D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String eq( ) {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M-D\n" +
                "@TRUE\n" +
                "D;JEQ\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@CONTINUE\n" +
                "0;JMP\n" +
                "(TRUE)\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(CONTINUE)\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String not() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=!M\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String or() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=M|D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String and() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "M=M&D\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    public static String lt() {
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M-D\n" +
                "@TRUE\n" +
                "D;JLT\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@CONTINUE\n" +
                "0;JMP\n" +
                "(TRUE)\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(CONTINUE)\n" +
                "@SP\n" +
                "M=M"+"\n";
    }
    public static String gt(){
        return "@SP\n" +
                "M=M-1\n" +
                "A=M\n" +
                "D=M\n" +
                "@SP\n" +
                "AM=M-1\n" +
                "D=M-D\n" +
                "@TRUE\n" +
                "D;JGT\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@CONTINUE\n" +
                "0;JMP\n" +
                "(TRUE)\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(CONTINUE)\n" +
                "@SP\n" +
                "M=M+1"+"\n";
    }
    private static String Not(){
        String notASM =
                "\n// not\n"+
                        "@SP\n" +
                        "A=M-1\n" +
                        "M=!M\n"+"\n";
        return notASM;
    }
    private static String And(){
        String andASM =
                "\n// and\n"+
                        "@SP\n" +
                        "AM=M-1\n" +
                        "D=M\n" +
                        "@SP\n" +
                        "A=M-1\n" +
                        "M=D&M\n"+"\n";
        return andASM;
    }
    private static String Or(){
        String orASM =
                "\n// or\n"+
                        "@SP\n" +
                        "AM=M-1\n" +
                        "D=M\n" +
                        "@SP\n" +
                        "A=M-1\n" +
                        "M=D|M\n"+"\n";
        return orASM;
    }
    public static String labelCode(String vmCode){   // generate label
        String[] label = vmCode.split(" ");
        String labelASM = "\n label " + label[1] + "\n" +
                "(" + label[1] + ")\n";
        return labelASM;
    }

    public static String gotoCode(String vmCode){  // unconditional branching
        String[] label = vmCode.split(" ");
        String gotoASM = "\ngoto "+ label[1] + "\n"+
                "@"+label[1]+"\n"+
                "0;JMP\n";
        return gotoASM;
    }

    public static String ifGotoCode(String vmCode){  // conditional branching
        String[] label = vmCode.split(" ");
        String ifGotoASM = "\n if-goto "+ label[1] + "\n"+
                "@SP\n"+
                "M=M-1\n"+
                "A=M\n"+
                "D=M\n"+
                "@"+label[1]+"\n"+
                "D;JNE\n";
        return ifGotoASM;
    }
    public static String functionCode(String vmCode){      // generating fucntion code
        String[] func = vmCode.split(" ");
        String funcName = func[1];
        String nArgs = func[2];
        String funcASM = "\n function " + funcName + " " + nArgs + "\n" +
                "("+funcName+")\n"+
                "@SP\n"+
                "A=M\n";
        for (int i = 0; i < Integer.parseInt(func[2]); i += 1)
        {
            funcASM+=
                    "M=0\n" + "A=A+1\n";
        }
        funcASM = funcASM +
                "D=A\n"+
                "@SP\n"+
                "M=D\n";
        return funcASM;
    }
    public static String callerCode(String vmCode){           // generating caller code
        String[] func = vmCode.split(" ");
        String funcName = func[1];

        String nArgs = func[2];
        int labelCnt=0;
        String callerASM =
                "\n call " +funcName+ " " +nArgs+ "\n" +
                        "@"+funcName+"$ret."+(++labelCnt)+"\n" +
                        "D=A\n"+
                        "@SP\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "M=M+1\n"+
                        "@LCL\n"+
                        "D=M\n"+
                        "@SP\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "M=M+1\n"+
                        "@ARG\n"+
                        "D=M\n"+
                        "@SP\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "M=M+1\n"+
                        "@THIS\n"+
                        "D=M\n"+
                        "@SP\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "M=M+1\n"+
                        "@THAT\n"+
                        "D=M\n"+
                        "@SP\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "M=M+1\n"+
                        "@5\n"+
                        "D=A\n"+
                        "@"+nArgs+"\n"+
                        "D=D+A\n"+
                        "@SP\n"+
                        "D=M-D\n"+
                        "@ARG\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "D=M\n"+
                        "@LCL\n"+
                        "M=D\n"+

                        "@"+funcName+"\n" +
                        "0;JMP\n" +

                        "("+funcName+"$ret."+(labelCnt)+")"+"\n";
        return callerASM;
    }
    public static String returnCode(){                         // generating return code
        String returnASM =
                "\n" +
                        "@LCL\n"+
                        "D=M\n"+
                        "@R13\n"+
                        "M=D\n"+
                        "@5\n"+
                        "D=D-A\n"+
                        "A=D\n"+
                        "D=M\n"+
                        "@R14\n"+
                        "M=D\n"+
                        "@SP\n"+
                        "AM=M-1\n"+
                        "D=M\n"+
                        "M=0\n"+
                        "@ARG\n"+
                        "A=M\n"+
                        "M=D\n"+
                        "D=A+1\n"+
                        "@SP\n"+
                        "M=D\n"+
                        "@R13\n"+
                        "A=M-1\n"+
                        "D=M\n"+
                        "@THAT\n"+
                        "M=D\n"+
                        "@2\n"+
                        "D=A\n"+
                        "@R13\n"+
                        "D=M-D\n"+
                        "A=D\n"+
                        "D=M\n"+
                        "@THIS\n"+
                        "M=D\n"+
                        "@3\n"+
                        "D=A\n"+
                        "@R13\n"+
                        "D=M-D\n"+
                        "A=D\n"+
                        "D=M\n"+
                        "@ARG\n"+
                        "M=D\n"+
                        "@4\n"+
                        "D=A\n"+
                        "@R13\n"+
                        "D=M-D\n"+
                        "A=D\n"+
                        "D=M\n"+
                        "@LCL\n"+
                        "M=D\n"+
                        "@R14\n"+
                        "A=M\n"+
                        "0;JMP\n"+"\n";
        return returnASM;
    }

}
