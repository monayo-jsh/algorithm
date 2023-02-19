package codility.Lesson7;

import java.util.Stack;

public class Nesting {
    public static void main(String[] args) {
        Nesting template = new Nesting();
        System.out.println(template.solution("(()(())())"));
        System.out.println(template.solution("())"));
        System.out.println(template.solution(")()"));
        System.out.println(template.solution("))"));
        System.out.println(template.solution("(("));
        System.out.println(template.solution(""));
    }

    public int solution(String S) {
        Stack<Character> characterStack = new Stack<>();

        for(Character character : S.toCharArray()) {
            switch(character) {
                case '(':
                    characterStack.push(character);
                    break;
                case ')':
                    if (characterStack.size() == 0) return 0;
                    if (')' == characterStack.pop()) return 0;
                    break;
            }
        }

        return characterStack.size() == 0 ? 1 : 0;
    }
}
