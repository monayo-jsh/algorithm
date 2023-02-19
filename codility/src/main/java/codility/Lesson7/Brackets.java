package codility.Lesson7;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        Brackets template = new Brackets();
        System.out.println(template.solution("{[()()]}"));
        System.out.println(template.solution("([)()]"));
        System.out.println(template.solution(")()]"));
        System.out.println(template.solution("{{{[((()))]}}}"));
        System.out.println(template.solution("{{{{"));
    }

    public int solution(String S) {
        if (S.length() == 0) return 1;

        Stack<Character> bracketStack = new Stack<>();
        for(Character character : S.toCharArray()) {
            switch(character) {
                case '{':
                case '[':
                case '(':
                    bracketStack.push(character);
                    break;
                case '}':
                    if (bracketStack.size() == 0) return 0;
                    if (bracketStack.pop() != '{') return 0;
                    break;
                case ']':
                    if (bracketStack.size() == 0) return 0;
                    if (bracketStack.pop() != '[') return 0;
                    break;
                case ')':
                    if (bracketStack.size() == 0) return 0;
                    if (bracketStack.pop() != '(') return 0;
                    break;
            }
        }

        if (bracketStack.size() > 0) return 0;

        return 1;
    }
}
