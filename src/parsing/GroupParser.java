package parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GroupParser {
  private String myLanguage;
  private Stack<String> argStack = new Stack<>();

  public GroupParser (String myLanguage) {
    this.myLanguage = myLanguage;
  }
  public int handleGroup(List<String> symbolList, int cursor, String symbol){
    int groupEndIndex = getGroupEndIndex(symbolList, cursor);

    List<String> argsWithLanguage = new ArrayList<>(
        symbolList.subList(cursor + 1, groupEndIndex));
    argsWithLanguage.add(0, myLanguage);
    argStack.push(String.join(" ", argsWithLanguage));

    return groupEndIndex;
  }

  private int getGroupEndIndex (List<String> symbolList, int loopStartIndex) {
    int cursor = loopStartIndex;
    while (!symbolList.get(cursor).equals(")")) cursor += 1;
    return cursor;
  }
}
