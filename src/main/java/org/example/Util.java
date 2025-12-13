package org.example;

    public class Util {
        public static String toTitleCase(String str) {
            if (str == null) {
                return null;
            }
            str = str.trim();
            if (str.isEmpty()) {
                return str;
            }
            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                if (word.isEmpty()) {
                    continue;
                }
                String lower = word.toLowerCase();
                char firstChar = Character.toUpperCase(lower.charAt(0));
                String rest = lower.substring(1);
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(firstChar).append(rest);
            }
            return result.toString();
        }
    }

}
