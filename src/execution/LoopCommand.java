package execution;

import java.util.List;

public class LoopCommand {
  public int getLoopGuardEnd(List<String> symbolList){
    for ( int i = 0; i < symbolList.size(); i++) {
      if (symbolList.get(i).equals("]")){
        return i;
      }
    }
    return -1;
  }
}
