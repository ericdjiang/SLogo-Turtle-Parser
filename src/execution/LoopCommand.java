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

  public int getExpEnd(List<String> symbolList){
    for ( int i = 0; i < symbolList.size(); i++) {
      if (symbolList.get(i).equals("[")){
        return i;
      }
    }
    return -1;
  }

  public String[] getLoopBodies(List <String> symbolList) {
    String[] loopBodies = new String[2];

    int openBracketCount =  0;
    int closeBracketCount = 0;

    int cursor = 0;
    while (openBracketCount > closeBracketCount || closeBracketCount < 1) {
      cursor += 1;
      if (symbolList.get(cursor).equals("[")){
        openBracketCount+=1;
      } else if (symbolList.get(cursor).equals("]")){
        closeBracketCount+=1;
      }
    }

    loopBodies[0] = String.join(" ", symbolList.subList(getExpEnd(symbolList)+1, cursor));
    loopBodies[1] = String.join(" ", symbolList.subList(cursor+2, symbolList.size()));

    return loopBodies;
  }
}
