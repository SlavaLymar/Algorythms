package leetcode.hard;

public class RemoveInvalidParentheses {
    
    static class Parentheses {
        String str;
        int opened;
        int closed;
        
        Parentheses(String str, int opened, int closed) {
            this.str = str;
            this.opened = opened;
            this.closed = closed;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + str.hashCode();
            result = prime * result + opened;
            result = prime * result + closed;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (this == obj) return true;
            if ( obj.getClass() != Parentheses.class ) return false;

            Parentheses other = (Parentheses)obj;
            return this.str.equals(other.str) 
                && (this.opened == other.opened) 
                && (this.closed == other.closed);
        }
        
        @Override
        public String toString() {
            return String.format("{ 'str': '%s', 'opened': '%d', 'closed': '%d' }", this.str, this.opened, this.closed);
        }
    }
               
    //
    //
    //             i 
    // ) ) ( ) ) ( )
    //
    // 0                             ""
    // 1                             ""
    // 2                      "("         ""
    // 3                  "()" "("        "" 
    // 4                  "()"  "("
    // 5                  "()(" "()" "((" "(" ""
    // 6                 "()()" "()(" "()" "(()" "()"
    //
    //
    // t: O (N * 2 ^ N)
    // space: O (N * 2 ^ N)
    //
    public List<String> removeInvalidParentheses(String s) {
        int maxLength = Integer.MIN_VALUE;
        Set<Parentheses> set = new HashSet<>();
        set.add(new Parentheses("", 0, 0));
        for (char ch : s.toCharArray()) {
            Iterator<Parentheses> it = set.iterator();
            Set<Parentheses> inner = new HashSet<>();
            while (it.hasNext()) {
                Parentheses p = it.next();
                inner.add(new Parentheses(p.str, p.opened, p.closed));
                Parentheses newP = new Parentheses(p.str, p.opened, p.closed);
                if (ch == '(') {
                    newP.str = newP.str + ch;
                    newP.opened++;
                } else if (ch == ')' && newP.closed + 1 <= newP.opened) {
                    newP.str = newP.str + ch;
                    newP.closed++;
                } else if (ch != '(' && ch != ')') {
                    newP.str = newP.str + ch;
                }
                if (newP.opened == newP.closed) {
                    maxLength = Math.max(maxLength, newP.str.length());
                }
                inner.add(newP);
            }
            set = inner;
        }
        
        List<String> result = new ArrayList<>();
        Iterator<Parentheses> it = set.iterator();
        while (it.hasNext()) {
            Parentheses p = it.next();
            if (p.opened == p.closed && maxLength == p.str.length()) {
                result.add(p.str);
            }
        }
        return result.isEmpty() ? Arrays.asList("") : result;
    }
  
  
}
