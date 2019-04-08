import javax.lang.model.util.ElementScanner6;

class ErrorMsg{
    final int OUTERR = 0;
    final int INERR = 1;
    final int DISKERR = 2;
    final int INDEXERR = 3;

    String msgs[] = {
        "Output error",
        "Input error",
        "Disk error",
        "Index out of bonds"
    };

    String getErrorMsg(int i){
        if (i >= 0 && i < msgs.length)
            return msgs[i];
        else
            return "INVALID ERROR CODE";
    }
}

class FinalD{
    public static void main(String args[]){
        ErrorMsg err = new ErrorMsg();

        System.out.println(err.getErrorMsg(err.OUTERR)); 
        System.out.println(err.getErrorMsg(err.DISKERR)); 
    }
}