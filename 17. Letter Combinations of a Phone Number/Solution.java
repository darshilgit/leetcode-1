/***
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.equals("")) {
            return result;
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        backtrack(result, map, 0, digits, "");

        return result;
    }

    private static void backtrack(List<String> result, HashMap<String, String> map, int index, String digits, String substate) {

        if(index == digits.length()) {
            result.add(substate);
            return;
        }

        for(char c : (map.get(""+digits.charAt(index))).toCharArray()) {
            backtrack(result, map, index+1, digits, substate+c);
        }
    }
}
