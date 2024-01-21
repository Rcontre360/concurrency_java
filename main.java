import utils.*;

public class main {
    public static void main(String[] args) {
        Cmd cmd = new Cmd();
        Reader reader = new Reader(cmd.getFilePath());
        Sha[] shaList = new Sha[cmd.getShaIds()];
        String line;
        
        while ((line = reader.readLine()) != "eot-ok"){
            try {
                int shaId = NumExtractor.getNum(line); 

                //shaList[shaId]
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}

