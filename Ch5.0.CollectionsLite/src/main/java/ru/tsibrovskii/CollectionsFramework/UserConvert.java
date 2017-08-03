package ru.tsibrovskii.CollectionsFramework;

import java.util.HashMap;
import java.util.List;

/**
 * Класс конвертации листа User-ов в HashMap.
 */
public class UserConvert {

    /**
     * Метод конвертации листа User-ов в HashMap.
     * @param list лист User-ов.
     * @return HashMap User-ов.
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> userMap = new HashMap<>();

        for(User user : list) {
            userMap.put(user.id, user);
        }
        return userMap;
    }
}
