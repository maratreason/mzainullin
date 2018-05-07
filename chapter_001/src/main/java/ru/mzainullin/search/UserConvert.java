package ru.mzainullin.search;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Marat Zainullin
 * @version 1.0
 * @since 04.05.2018
 */
public class UserConvert {

    /**
     * Метод, который принимает в себя список пользователей
     * и конвертирует его в Map с ключом Integer id
     * и соответствующим ему User.
     * @param list - входящий параметр
     * @return - ассоциативный массив
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        User user = new User();
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            users.put(user.getId(), it.next());
        }
        return users;
    }

}
