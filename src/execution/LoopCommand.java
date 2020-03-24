package execution;

import java.util.List;

/**
 * Parent class for all commands with parentheses
 * Contains helper methods for extracting parentheses/brackets
 * and the associated bodies within them
 **/
public class LoopCommand {

  /**
   * Finds the last index of the closing bracket
   * @param symbolList a list of all symbols to be parsed
   * @return the index of the last closing bracket
   */
  public int getLoopGuardEnd(List<String> symbolList){
    for ( int i = 0; i < symbolList.size(); i++) {
      if (symbolList.get(i).equals("]")){
        return i;
      }
    }
    return -1;
  }

  /**
   * Finds the index of the first opening bracket
   * @param symbolList a list of all symbols to be parsed
   * @return the index of the first opening bracket
   */
  public int getExpEnd(List<String> symbolList){
    for ( int i = 0; i < symbolList.size(); i++) {
      if (symbolList.get(i).equals("[")){
        return i;
      }
    }
    return -1;
  }

  /**
   * Returns the loop guard string and loop guard body
   * without parentheses enclosed
   * @param symbolList a list of all symbols to be parsed
   * @return the loop guard string and loop guard body
   *  without parentheses enclosed
   */
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
