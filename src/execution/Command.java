package execution;

import java.util.List;

public interface Command {
    double execute();

    List<String> getParamList();
}
