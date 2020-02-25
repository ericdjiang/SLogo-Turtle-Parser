package execution.turtle_commands;

import execution.Command;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Forward implements Command {
    List<String> myParamList = new ArrayList<>(Arrays.asList(
        "",
        "ho"
    ));

    @Override
    public double execute() {
        System.out.println("Inside Forward::draw() method.");
        return 0;
    }

    @Override
    public List<String> getParamList() {
        return myParamList;
    }
}
