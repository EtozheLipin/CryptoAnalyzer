package commands;

import enitiy.Result;

public interface Action {
    Result execute(String[] parameters);
}
