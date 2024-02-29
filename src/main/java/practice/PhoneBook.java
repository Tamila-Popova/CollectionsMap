package practice;

import com.puppycrawl.tools.checkstyle.grammar.javadoc.JavadocParser;

import java.util.*;


public class PhoneBook {
    Map<String, String> phoneBook = new HashMap<>();

    public boolean getNumFormat(String phone) {
        return phone.matches("[7]{1}[0-9]{10}");
    }

    public boolean getNameFormat(String name) {
        return name.matches("[А-я]+");
    }

    public void addContact(String phone, String name) {
        if (getNameFormat(name) && getNumFormat(phone)) {
            if (phoneBook.containsKey(phone)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (key.equals(phone)) {
                        phoneBook.put(phone, name);
                    }
                }
            } else if (phoneBook.containsValue(name)) {
                for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (value.equals(name)) {
                        phoneBook.remove(key);
                        phoneBook.put(key + ", " + phone, name);
                    }
                }
            } else {
                phoneBook.put(phone, name);
            }
        } else {
            System.out.println("Неверный формат ввода");
        }
    }


    public String getContactByPhone(String phone) {
        if (phoneBook.containsKey(phone)) {
            return phoneBook.get(phone) + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contactsName = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == name) {
                contactsName.add(value + " - " + key);
            }
        }
        return contactsName;
    }

    public Set<String> getAllContacts() {
        Set<String> allContacts = new HashSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.isEmpty() || value.isEmpty()) {
                continue;
            } else {
                allContacts.add(value + " - " + key);
            }
        }
        return allContacts;
    }
}